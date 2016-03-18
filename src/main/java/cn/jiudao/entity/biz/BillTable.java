package cn.jiudao.entity.biz;

import javax.swing.JTable;

import com.yumendedao.commons.paging.AbstractMulItemPaging;
import com.yumendedao.commons.paging.IPaging;

public class BillTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public IPaging<BillItem> paging;
	protected Bill bill = null;

	public BillTable() {
		super();
		initialize();
	}

	private void initialize() {

		paging = new AbstractMulItemPaging<BillItem>(10) {

			@Override
			public void updateUI() {
				// TODO paging中的数据对应table的数据
				BillTable.this.updateUI();
			}

			@Override
			public int getLastIndex() {
				return getLastIndex();
			}

			@Override
			public BillItem getBlank() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int margeItem(BillItem item) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public boolean isBlank(BillItem item) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isEquals(BillItem obj1, BillItem Obj2) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public BillItem createItem(Object... objects) {
				// TODO Auto-generated method stub
				return null;
			}

		};

	}

}
