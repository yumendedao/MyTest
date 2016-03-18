package com.gxc.common.minibusiness;

public class Card {
	
	// IC卡号
	private String cardNo = "";
	// 卡内的固定金额
	private int steadMoney = 0;
	// 卡内的自由交易金额
	private int freeMoney = 0;
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public int getSteadMoney() {
		return steadMoney;
	}
	public void setSteadMoney(int steadMoney) {
		this.steadMoney = steadMoney;
	}
	public int getFreeMoney() {
		return freeMoney;
	}
	public void setFreeMoney(int freeMoney) {
		this.freeMoney = freeMoney;
	}
	
	

}
