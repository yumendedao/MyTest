package com.gxc.common.minibusiness;

public class DeductionContext {
	// 扣款策略
	private IDeduction deduction = null;
	
	public DeductionContext(IDeduction _deduction){
		this.deduction = _deduction;
	}
	
	public boolean exec(Card card, Trade trade){
		return this.deduction.exec(card, trade);
	}

}
