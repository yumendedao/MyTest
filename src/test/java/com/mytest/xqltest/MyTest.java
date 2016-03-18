package com.mytest.xqltest;

import java.util.ArrayList;
import java.util.List;

public class MyTest {

	public static void main(String[] args) {

		
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			list.add(i+"");
		}
		System.out.println(list.size());
		System.out.println(list.subList(0, 6));
		System.out.println(list.subList(7, 9));
		System.out.println(list.get(list.size()));
		
		
//		Book book=selectbyid(1);
//		
//		System.out.println(book.getName());
//		
//	}
//
//	static Book selectbyid(int id) {
//		SqlSessionFactory sqlsessionfactory = null;
//		try {
//			sqlsessionfactory = new SqlSessionFactoryBuilder()
//					.build(Resources.getResourceAsReader("database-config.xml"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		SqlSession sqlsession = sqlsessionfactory.openSession();
//
//		try {
//			Book book = sqlsession.getMapper(BookMapper.class).select(id);
//			return book;
//		} finally {
//			sqlsession.close();
//		}
	}
}
