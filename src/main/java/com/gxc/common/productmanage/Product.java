package com.gxc.common.productmanage;

public class Product implements Cloneable {

	// 产品名称
	private String name;
	// 是否可以改变属性
	private boolean canChange = false;

	// 产生一个新的产品
	public Product(ProductManager manage, String _name) {
		// 允许创建产品
		if(manage.isCreateProduct()){
			canChange = true;
			this.name = _name;
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(canChange){
			this.name = name;
		}
	}

	@Override
	protected Product clone(){
		Product product = null;
		try{
			product = (Product) super.clone();
		} catch (CloneNotSupportedException e){
			e.printStackTrace();
		}
		return product;
	}

}
