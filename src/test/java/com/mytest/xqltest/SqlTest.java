package com.mytest.xqltest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cn.jiudao.commons.Logging;

public class SqlTest {
//	private SqlSession session;
//	private UserMapper mapper;
	private int countUser;

	@Test(dataProvider = "dp")
	public void sessionTest(Integer n, String s) {

//		Logging.debug("get session");
//		User user = mapper.select(1);
//		System.out.println(user.getAccount());
//		session.commit();
	}

	@BeforeTest(description = "count(user)")
	public void queryTest() {
//		countUser = mapper.count(new UserCriteria().idIsNotNull().Q());
		Logging.debug("count(user) = " + countUser);
	}

//	@Test(dataProvider = "user_dp", enabled = false)
//	public void insertTest(User user) {
//		Logging.debug("test insert on tb_user");
//		mapper.insert(user);
//		session.commit();
//	}
	
//	@Test(dataProvider = "delete_ids", enabled = false)
//	public void deleteTest(Integer id){
//		Logging.debug("test delete, userid = " + id);
//		if(id != null){
//			mapper.deleteByQ(new UserCriteria().idEQ(id).Q());
//			session.commit();
//		}
//	}
	
//	@DataProvider(name = "delete_ids")
//	public Object[][] delete_ids(){
//		return new Object[][] { new Object[]{ countUser } };
//	}
//
//	@BeforeTest(description = "设置session，设置userMapper")
//	public void beforeMethod() {
//		try {
//			session = SessionUtil.getSession();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		mapper = session.getMapper(UserMapper.class);
//	}
//
//	@AfterTest
//	public void afterMethod() {
//		Logging.debug("test end");
//		if (session != null) {
//			session.close();
//			Logging.info("session close");
//		}
//	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" } };
	}

//	@DataProvider(name = "user_dp")
//	public Object[][] user_dp() {
//		int length1 = 1;
//		int length2 = 1;
//		Object[][] objectArray = new Object[length1][];
//
//		countUser++;
//		User[] users = new User[length2];
//		User user = new User();
//		Logging.debug("user id = " + countUser);
//		user.setId(countUser);
//		user.setAccount("account" + countUser);
//		user.setName("name" + countUser);
//		user.setLogindate(new Date());
//		user.setPassword("password" + countUser);
//		user.setRole(1);
//
//		users[0] = user;
//
//		objectArray[0] = users;
//
//		return objectArray;
//	}
}
