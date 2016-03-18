package cn.jiudao.entity.biz;


import com.yumendedao.commons.paging.item.AbstractPageItem;

public abstract class BillItem extends AbstractPageItem<BillItem>{

	protected String name = "";
	protected Object entity = null;
	protected String id;

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@SuppressWarnings("unchecked")
	public <T> T getEntity() {
		return (T)entity;
	}
	public void setEntity(Object entity) {
		this.entity = entity;
	}
	
}
