package cn.jiudao.entity.biz;

import java.util.LinkedList;
import java.util.List;

public abstract class Bill {
	
	protected String id;
	protected boolean checked;
	protected boolean printed;
	protected final List<BillItem> items = new LinkedList<BillItem>();

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
