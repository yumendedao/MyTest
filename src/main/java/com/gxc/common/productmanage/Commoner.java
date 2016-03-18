package com.gxc.common.productmanage;

public class Commoner extends EventCustomer {

	// 定义贫民能够处理的事件的级别
	public Commoner() {
		super(EventCustomerType.NEW);
	}

	@Override
	public void exec(ProductEvent event) {
		// 事件的源头
		Product product = event.getSource();
		// 事件类型
		ProductEventType type = event.getEventType();
		System.out.println("平民处理事件：" + product.getName() + "诞生，事件类型=" + type);
	}

}
