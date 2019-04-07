package com.zhuyin.dynamicproxy.jdk;

public class StudentDaoImpl implements StudentDao {

	@Override
	public void login() {
		System.out.println("登陆功能");
	}

	@Override
	public void register() {
		System.out.println("注册功能");
	}

}
