package com.gxc.common.command;

public class Invoker {
	
	// 执行命令
	public String exec(String commandStr){
		// 定义返回值
		String result = "";
		// 首先解析命令
		CommandVO vo = new CommandVO(commandStr);
		if(CommandEnum.getNames().contains(vo.getCommondName())){
			String className = CommandEnum.valueOf(vo.getCommondName()).getValue();
			Command command;
			try {
				command = (Command) Class.forName(className).newInstance();
				result = command.execute(vo);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		} else {
			result = "无法执行命令，请检查命令格式";
		}
		return result;
	}

}
