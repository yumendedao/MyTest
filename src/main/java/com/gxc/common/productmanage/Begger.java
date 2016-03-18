package com.gxc.common.productmanage;

public class Begger extends EventCustomer {

	// 只能处理被人遗弃的东西
	public Begger() {
		super(EventCustomerType.DEL);
	}

	@Override
	public void exec(ProductEvent event) {
		// 事件的源头
		Product product = event.getSource();
		// 事件类型
		ProductEventType type = event.getEventType();
		System.out.println("乞丐处理事件：" + product.getName() + "销毁，事件类型=" + type);
	}

}
