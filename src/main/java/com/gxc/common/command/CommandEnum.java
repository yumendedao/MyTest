package com.gxc.common.command;

import java.util.ArrayList;
import java.util.List;

public enum CommandEnum {

	ls("com.gxc.common.command.LSCommand"),
	df("com.gxc.common.command.DFCommand");

	private String value = "";
	
	// 定义构造函数，目的是Data（value）类型的相匹配
	private CommandEnum(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	
	// 返回所有的enum对象
	public static List<String> getNames(){
		CommandEnum[] commandEnum = CommandEnum.values();
		List<String> names = new ArrayList<String>();
		for (CommandEnum c : commandEnum) {
			names.add(c.name());
		}
		return names;
	}
}
