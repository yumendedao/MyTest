package com.gxc.common.minibusiness;

public class FreeDeduction implements IDeduction {

	@Override
	public boolean exec(Card card, Trade trade) {
		// 直接从自由金额里扣
		card.setFreeMoney(card.getFreeMoney() - trade.getAmount());
		return true;
	}

}
