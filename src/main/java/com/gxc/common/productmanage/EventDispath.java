package com.gxc.common.productmanage;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public class EventDispath implements Observer {

	// 单例模式
	private static final EventDispath dispath = new EventDispath();
	// 事件消费者
	private Vector<EventCustomer> customer = new Vector<EventCustomer>();

	// 不允许生成新的实例
	private EventDispath() {
	}

	// 获单例对象
	public static EventDispath getEventDispath() {
		return dispath;
	}

	// 事件触发
	@Override
	public void update(Observable o, Object arg) {
		
		// 事件源头
		@SuppressWarnings("unused")
		Product product = (Product) arg;
		// 事件
		ProductEvent event = (ProductEvent) o;
		// 处理者处理，这是中介者模式的核心，可以是很复杂的业务逻辑
		for (EventCustomer eventCustomer : customer) {
			// 处理能力是否匹配
			for (EventCustomerType t : eventCustomer.getCustomerType()) {
				if(t.getValue() == event.getEventType().getValue()){
					eventCustomer.exec(event);
				}
			}
		}
	}
	
	// 注册事件处理者
	public void regiserCustomer(EventCustomer _customer){
		customer.add(_customer);
	}
}
