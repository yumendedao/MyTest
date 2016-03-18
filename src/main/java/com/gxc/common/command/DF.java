package com.gxc.common.command;

import com.gxc.common.utils.DiskManager;

public class DF extends AbstractDF{

	@Override
	public String getOperateParam() {
		return DEFAULT_PARAM;
	}

	@Override
	public String echo(CommandVO vo) {
		return DiskManager.df();
	}

}
