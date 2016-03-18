package com.gxc.common.command;

public class DFCommand extends Command {

	@Override
	public String execute(CommandVO vo) {
		CommandName firstNode = super.buildChina(AbstractDF.class).get(0);
		return firstNode.handleMessage(vo);
	}

}
