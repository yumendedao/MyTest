package com.gxc.common.utils;

public class DiskManager {
	
	// 默认的计算大小
	public static String df(){
		return "/\t10485780\n/user\t1048572034\n/home\t104875376600\n";
	}
	// 按照kb来计算
	public static String df_k(){
		return "/\t10480\n/user\t104800\n/home\t10480000\n";
	}
	// 按照gb来计算
	public static String df_g(){
		return "/\t10\n/user\t100\n/home\t1000\n";
	}

}
