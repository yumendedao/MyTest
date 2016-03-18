package com.gxc.common.command;

import com.gxc.common.utils.FileManage;

public class LS extends AbstractLS{

	@Override
	public String getOperateParam() {
		return DEFAULT_PARAM;
	}

	@Override
	public String echo(CommandVO vo) {
		return FileManage.ls(vo.formatData());
	}

}
