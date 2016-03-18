package com.gxc.common.command;

import java.util.ArrayList;
import java.util.List;

import com.gxc.common.utils.ClassUtils;

public abstract class Command {

	public abstract String execute(CommandVO vo);
	
	protected final List<? extends CommandName> buildChina(Class<? extends CommandName> abstractClass){
		// 取出所有的命令名下的子类
		List<Class<?>> calsses = ClassUtils.getSonClass(abstractClass);
		// 存放命令的实例，并建立链表关系
		List<CommandName> commandNameList = new ArrayList<CommandName>();
		for (Class<?> c : calsses) {
			CommandName commandName = null;
			try {
				commandName = (CommandName) Class.forName(c.getName()).newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			if(commandNameList.size() > 0){
				commandNameList.get(commandNameList.size() -1).setNext(commandName);
			}
			commandNameList.add(commandName);
		}
		return commandNameList;
	}
}
