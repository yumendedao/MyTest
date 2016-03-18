package com.gxc.common.minibusiness;

public enum StrategyMan {
	
	SteadyDeduction("com.gxc.common.minibusiness.SteadyDeduction"),
	FreeDeduction("com.gxc.common.minibusiness.FreeDeduction");

	String value = "";
	
	StrategyMan(String _value){
		this.value = _value;
	}

	public String getValue() {
		return this.value;
	}

}
