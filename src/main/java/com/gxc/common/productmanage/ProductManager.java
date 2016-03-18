package com.gxc.common.productmanage;

public class ProductManager {
	
	// 是否可以创建一个产品
	private boolean isPermittedCreate = false;
//	private static ProductManager manager = new ProductManager();
	
	private ProductManager(){
		
	}
	
	private static class ProductManagerHolder {
		private static final ProductManager manager = new ProductManager();
	}
	
	public synchronized static ProductManager getInstance(){
		return ProductManagerHolder.manager;
//		return manager;
	}
	
	// 建立一个产品
	public Product createProduct(String name){
		// 首先修改权限，允许创建
		isPermittedCreate = true;
		Product p = new Product(this, name);
		// 产生一个创建实例
		new ProductEvent(p, ProductEventType.NEW_PRODUCTED);
		return p;
	}
	//废弃一个产品
	public void abandonProudct(Product product){
		// 销毁一个产品，例如删除数据库记录
		// 产生删除事件
		new ProductEvent(product, ProductEventType.DELETE_PRODUCTED);
		product = null;
	}
	// 修改一个产品
	public void editProduct(Product product, String name){
		// 修改后的产品
		product.setName(name);
		// 产生修改事件
		new ProductEvent(product, ProductEventType.EIDT_PRODUCTED);
	}
	// 获得是否可以创建一个产品
	public boolean isCreateProduct(){
		return isPermittedCreate;
	}
	// 克隆一个产品
	public Product clone(Product product){
		// 产生克隆事件
		new ProductEvent(product, ProductEventType.CLONE_PRODUCTED);
		return product.clone();
	}

}
