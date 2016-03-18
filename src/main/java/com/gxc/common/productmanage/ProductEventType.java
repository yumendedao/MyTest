package com.gxc.common.productmanage;

public enum ProductEventType {
	// 新建一个产品
	NEW_PRODUCTED(1),
	// 删除一个产品
	DELETE_PRODUCTED(2),
	// 修改一个产品
	EIDT_PRODUCTED(3),
	// 克隆一个产品
	CLONE_PRODUCTED(4);
	
	private int value = 0;
	
	ProductEventType(int _value){
		this.value = _value;
	}
	
	public int getValue(){
		return this.value;
	}
}
