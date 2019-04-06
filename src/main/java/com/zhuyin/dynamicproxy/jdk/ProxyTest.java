package com.zhuyin.dynamicProxy.jdk;

import java.lang.reflect.Proxy;

public class ProxyTest {
	public static void main(String[] args) {
		
		UserDao userDao=new UserDaoImpl();
		
		userDao.add();
		userDao.del();
		userDao.update();
		userDao.find();
		
		System.out.println("----------------------");
		
		MyHandler myHandler=new MyHandler(userDao);
		UserDao userDaoProxy = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), myHandler);
		userDaoProxy.add();
		userDaoProxy.del();
		userDaoProxy.update();
		userDaoProxy.find();
		
		System.out.println("----------------------");
		
		StudentDao studentDao=new StudentDaoImpl();
		studentDao.login();
		studentDao.regist();
		
		System.out.println("----------------------");
		
		MyHandler myHandler2=new MyHandler(studentDao);
		StudentDao studentDaoProxy = (StudentDao) Proxy.newProxyInstance(studentDao.getClass().getClassLoader(), studentDao.getClass().getInterfaces(), myHandler2);
		studentDaoProxy.login();
		studentDaoProxy.regist();
		
		System.out.println("----------------------");
	}
}
