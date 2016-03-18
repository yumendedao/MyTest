package com.mytest.eap;

import org.testng.annotations.Test;

import cn.jiudao.utils.PasswordUtils;

public class EapUtilTest {

	@Test
	public void passwordTest() {
		String password = PasswordUtils.encode("123456");
		System.out.println(password);
		int strength = PasswordUtils.strength("1", password);
		String secret = "123456";
		// password = "55L/7C2RfrUdcyKwtdeVggNnrT5QOpq52hC+tm6X6PE=";
		// String password2 = "7c4a8d09ca3762af61e59520943dc26494f8941b";
		boolean verify = PasswordUtils.verify(null, password);

		System.out.println(password);
		System.out.println(strength);
		System.out.println(verify);
	}


}
