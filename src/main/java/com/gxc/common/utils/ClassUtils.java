package com.gxc.common.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;

public class ClassUtils {

	// 根据父类查找到所有的子类，默认情况是子类和父类都在同一包名下
	public static List<Class<?>> getSonClass(Class<?> fatherClass) {
		List<Class<?>> returnClassList = new ArrayList<Class<?>>();
		// 获得包名称
		String packageName = fatherClass.getPackage().getName();
		// 获得包中所有类
		List<Class<?>> packClasses = getClass(packageName);
		// 判定是否是子类
		for (Class<?> c : packClasses) {
			if (fatherClass.isAssignableFrom(c) && !fatherClass.equals(c)) {
				returnClassList.add(c);
			}
		}
		return returnClassList;
	}

	// 从一个包中查找所有类，在jar包中不能查找
	private static List<Class<?>> getClass(String packageName) {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		String path = packageName.replace(".", "/");
		Enumeration<URL> resources = null;
		try {
			resources = classLoader.getResources(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<File> dirs = new ArrayList<File>();
		while (resources.hasMoreElements()) {
			URL resource = (URL) resources.nextElement();
			dirs.add(new File(resource.getFile()));
		}
		ArrayList<Class<?>> classes = new ArrayList<Class<?>>();

		for (File directory : dirs) {
			classes.addAll(findClasses(directory, packageName));
		}
		return classes;
	}

	private static Collection<? extends Class<?>> findClasses(File directory, String packageName) {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		if (!directory.exists()) {
			return classes;
		}
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				assert !file.getName().contains(".");
				classes.addAll(findClasses(file, packageName + "." + file.getName()));
			} else if (file.getName().endsWith(".class")) {
				try {
					classes.add(
							Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}

		}
		return classes;
	}

}
