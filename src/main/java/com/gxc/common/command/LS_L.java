package com.gxc.common.command;

import com.gxc.common.utils.FileManage;

public class LS_L extends AbstractLS{

	@Override
	public String getOperateParam() {
		return L_PARAM;
	}

	@Override
	public String echo(CommandVO vo) {
		return FileManage.ls_l(vo.formatData());
	}

}
