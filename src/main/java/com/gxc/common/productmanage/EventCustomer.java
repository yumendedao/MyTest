package com.gxc.common.productmanage;

import java.util.Vector;

public abstract class EventCustomer {

	// 容纳每个消费者能够处理的级别
	private Vector<EventCustomerType> customerType = new Vector<EventCustomerType>();

	// 每个消费者都要声明自己处理哪一类别的事件
	public EventCustomer(EventCustomerType _type) {
		addCustomerType(_type);
	}

	// 每个消费者可以消费多个事件
	public void addCustomerType(EventCustomerType _type) {
		customerType.add(_type);
	}
	
	public Vector<EventCustomerType> getCustomerType(){
		return this.customerType;
	}
	
	public abstract void exec(ProductEvent event);
}
