package com.gxc.common.productmanage;

public class Nobleman extends EventCustomer {

	// 定义贫民能够处理的事件的级别
	public Nobleman() {
		super(EventCustomerType.EDIT);
		super.addCustomerType(EventCustomerType.CLONE);
	}

	@Override
	public void exec(ProductEvent event) {
		// 事件的源头
		Product product = event.getSource();
		// 事件类型
		ProductEventType type = event.getEventType();
		if(type.getValue() == EventCustomerType.CLONE.getValue()){
			System.out.println("贵族处理事件：" + product.getName() + "克隆，事件类型=" + type);
		} else if(type.getValue() == EventCustomerType.EDIT.getValue()){
			System.out.println("贵族处理事件：" + product.getName() + "修改，事件类型=" + type);
		} else {
			System.out.println("不能处理");
		}
	}

}
