package com.gxc.common.minibusiness;

public class SteadyDeduction implements IDeduction {

	@Override
	public boolean exec(Card card, Trade trade) {
		int halfMoney = (int) Math.rint(trade.getAmount() / 2.0);
		card.setFreeMoney(card.getFreeMoney() - halfMoney);
		card.setSteadMoney(card.getSteadMoney() - halfMoney);
		return true;
	}

}
