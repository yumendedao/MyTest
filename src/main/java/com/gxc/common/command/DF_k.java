package com.gxc.common.command;

import com.gxc.common.utils.DiskManager;

public class DF_k extends AbstractDF{

	@Override
	public String getOperateParam() {
		return K_PARAM;
	}

	@Override
	public String echo(CommandVO vo) {
		return DiskManager.df_k();
	}

}
