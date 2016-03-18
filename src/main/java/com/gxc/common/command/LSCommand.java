package com.gxc.common.command;

public class LSCommand extends Command {

	@Override
	public String execute(CommandVO vo) {
		CommandName firstNode = super.buildChina(AbstractLS.class).get(0);
		return firstNode.handleMessage(vo);
	}

}
