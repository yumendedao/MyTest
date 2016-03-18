package com.gxc.common.command;

public abstract class CommandName {
	
	private CommandName nextOperator;
	public final String handleMessage(CommandVO vo){
		// 处理结果
		String result = "";
		if(vo.getParam().size() == 0 || vo.getParam().contains(this.getOperateParam())){
			result = this.echo(vo);
		} else {
			if(this.nextOperator != null)
				result = nextOperator.echo(vo);
			else
				System.out.println("命令无法执行");
		}
		
		return result;
	}
	
	public void setNext(CommandName operator){
		this.nextOperator = operator;
	}
	
	public abstract String getOperateParam();
	
	public abstract String echo(CommandVO vo);
}
