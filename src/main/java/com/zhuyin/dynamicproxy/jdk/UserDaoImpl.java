package com.zhuyin.dynamicproxy.jdk;

public class UserDaoImpl implements UserDao {

	@Override
	public void add() {
		System.out.println("新增功能");
	}

	@Override
	public void del() {
		System.out.println("删除功能");
	}

	@Override
	public void update() {
		System.out.println("修改功能");
	}

	@Override
	public void find() {
		System.out.println("查找功能");
	}

}
