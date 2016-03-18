package com.gxc.common.command;

import com.gxc.common.utils.FileManage;

public class LS_A extends AbstractLS{

	@Override
	public String getOperateParam() {
		return A_PARAM;
	}

	@Override
	public String echo(CommandVO vo) {
		return FileManage.ls_a(vo.formatData());
	}

}
