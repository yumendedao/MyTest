package com.gxc.common.command;

import java.util.ArrayList;
import java.util.HashSet;

public class CommandVO {
	
	public final static String DIVIDE_FLAG = " ";
	public final static String PREFIX = "-";
	
	private String commandName = "";
	
	// 参数列表
	private ArrayList<String> paramList = new ArrayList<String>();
	// 操作数列表
	private ArrayList<String> dataList = new ArrayList<String>();
	
	// 通过构造函数传递命令
	public CommandVO(String commandStr){
		
		if(commandStr != null && commandStr.trim().length() > 0){
			
			String[] complexStr = commandStr.split(DIVIDE_FLAG);
			this.commandName = complexStr[0];
			
			for (String str : complexStr) {
				if(str.startsWith(PREFIX)){
//					str = str.replace(CommondVO.PREFIX, "").trim();
//					if(!this.paramList.contains(str))
					this.paramList.add(str.replace(CommandVO.PREFIX, "").trim());
				}
				else {
					this.dataList.add(str);
				}
			}
			// 去除重复参数
			this.paramList = new ArrayList<String>(new HashSet<String>(this.paramList));
			// 为了方便处理空参数
			if(this.paramList.size() == 0)
				this.paramList.add("");
		} else {
			System.out.println("命令解析失败，必须传递一个命令才能执行");
		}
	}
	
	public String getCommondName(){
		return this.commandName;
	}
	
	public ArrayList<String> getParam(){
		return this.paramList;
	}
	
	public ArrayList<String> getdata(){
		return this.dataList;
	}
	
	public String formatData(){
		StringBuffer str = new StringBuffer();
		for (String string : dataList) {
			str.append(string);
			str.append(" ");
		}
		return str.toString();
	}
}
