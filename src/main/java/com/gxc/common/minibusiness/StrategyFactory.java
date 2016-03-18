package com.gxc.common.minibusiness;

public class StrategyFactory {

	// 策略工厂
	public static IDeduction  getDeduction(StrategyMan strategy){
		IDeduction deduction = null;
		try {
			deduction = (IDeduction) Class.forName(strategy.getValue()).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}	
		return deduction;
	}
}
