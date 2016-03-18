package com.gxc.common.productmanage;

public enum EventCustomerType {

	NEW(1), DEL(2), EDIT(3), CLONE(4);

	private int value = 0;

	EventCustomerType(int _value) {
		this.value = _value;
	}

	public int getValue() {
		return this.value;
	}

}
