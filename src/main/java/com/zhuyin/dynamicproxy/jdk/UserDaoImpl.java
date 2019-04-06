package com.zhuyin.dynamicProxy.jdk;

public class UserDaoImpl implements UserDao {

	public void add() {
		System.out.println("新增功能");
	}

	public void del() {
		System.out.println("删除功能");
	}

	public void update() {
		System.out.println("修改功能");
	}

	public void find() {
		System.out.println("查找功能");
	}

}
