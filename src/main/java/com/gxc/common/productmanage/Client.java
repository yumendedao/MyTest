package com.gxc.common.productmanage;

public class Client {

	public static void main(String[] args) {
		// 获得事件分发中心
		EventDispath dispath = EventDispath.getEventDispath();
		// 接受乞丐对事件的处理
		dispath.regiserCustomer(new Begger());
		// 接受乞丐对事件的处理
		dispath.regiserCustomer(new Commoner());
		// 接受乞丐对事件的处理
		dispath.regiserCustomer(new Nobleman());

		// 建立一个原子弹生产工厂
		ProductManager factory = ProductManager.getInstance();
		// 制造一个产品
		System.out.println("====模拟产品生产====");
		System.out.println("创建产品");
		Product p = factory.createProduct("小男孩原子弹");

		// 修改产品
		System.out.println("======模拟修改产品=====");
		System.out.println("\n修改名称");
		factory.editProduct(p, "小胖子原子弹");
		// 克隆产品
		System.out.println("======模拟克隆产品=====");
		System.out.println("\n克隆产品");
		factory.clone(p);
		// 遗弃产品
		System.out.println("======模拟遗弃产品=====");
		System.out.println("\n遗弃产品");
		factory.abandonProudct(p);

	}

}
