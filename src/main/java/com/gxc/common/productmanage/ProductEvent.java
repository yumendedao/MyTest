package com.gxc.common.productmanage;

import java.util.Observable;

public class ProductEvent extends Observable {

	// 事件起源
	private Product source = null;
	// 事件类型
	private ProductEventType type;
	// 传入事件源头，默认为新建类型

	public ProductEvent(Product p) {
		this(p, ProductEventType.NEW_PRODUCTED);
	}

	// 事件源头以及事件类型
	public ProductEvent(Product p, ProductEventType _type) {
		this.source = p;
		this.type = _type;
		// 事件触发
		notifyEventDispath();
	}

	// 获得事件源
	public Product getSource() {
		return this.source;
	}

	// 获得事件源
	public ProductEventType getEventType(){
		return this.type;
	}
	
	// 通知事务处理中心
	private void notifyEventDispath() {
		super.addObserver(EventDispath.getEventDispath());
		super.setChanged();
		super.notifyObservers(source);
	}
}
