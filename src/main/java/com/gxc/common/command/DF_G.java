package com.gxc.common.command;

import com.gxc.common.utils.DiskManager;

public class DF_G extends AbstractDF{

	@Override
	public String getOperateParam() {
		return G_PARAM;
	}

	@Override
	public String echo(CommandVO vo) {
		return DiskManager.df_g();
	}

}
