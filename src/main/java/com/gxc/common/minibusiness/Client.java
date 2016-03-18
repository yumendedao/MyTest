package com.gxc.common.minibusiness;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {

	// 模拟交易
	public static void main(String[] args) {
		// 初始化一张IC卡
		Card card = initIC();
		// 显示卡内的信息
		System.out.println("========初始化卡信息：==========");
		showCard(card);
		boolean flag = true;
		Trade trade;
		while(flag){
			trade = createTrade();
			DeductionFacade.deduct(card, trade);
			// 交易成功，打印处理消息
			System.out.println("\n=========交易凭证===========");
			System.out.println(trade.getTradeNo()+ "  交易成功！");
			System.out.println("本次发生的交易金额为： " + trade.getAmount() / 100.0 + "元");
			// 展示卡内信息
			showCard(card);
			System.out.println("\n是否需要退出？（Y/N）");
			if(getInput().equalsIgnoreCase("Y")){
				flag = false;	// 退出
			}
		}
	}

	private static String getInput() {
		String str = "";
		try {
			str = (new BufferedReader(new InputStreamReader(System.in))).readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return str;
	}

	private static Trade createTrade() {
		Trade trade = new Trade();
		System.out.println("请输入交易编号：");
		trade.setTradeNo(getInput());
		System.out.println("请输入交易金额：");
		trade.setAmount(Integer.parseInt(getInput()));
		return trade;
	}

	// 打印卡内信息
	private static void showCard(Card card) {
		System.out.println("IC卡编号：" + card.getCardNo());
		System.out.println("固定金额：" + card.getSteadMoney() / 100.0);
		System.out.println("自由金额：" + card.getFreeMoney() / 100.0);
	}

	private static Card initIC() {
		Card card = new Card();
		card.setCardNo("1101000100100");
		card.setFreeMoney(100000);
		card.setSteadMoney(80000);
		return card;
	}
}
