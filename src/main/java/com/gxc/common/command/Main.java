package com.gxc.common.command;

public class Main {

	public static void main(String[] args) {
		Invoker invoker = new Invoker();
		
		String commandStr = "df -k";
		System.out.println(invoker.exec(commandStr ));
	}
}
