package com.zhuyin.dynamicproxy.cglib.client;


import com.zhuyin.dynamicproxy.cglib.proxyinstance.AuthorityFunction;
import com.zhuyin.dynamicproxy.cglib.proxyinstance.LogFunction;
import com.zhuyin.dynamicproxy.cglib.proxymanager.ProxyManager;
import com.zhuyin.dynamicproxy.cglib.pxoyInterface.ProxyInterface;
import com.zhuyin.dynamicproxy.cglib.targetobj.UserService;

import java.util.ArrayList;
import java.util.List;

public class Client {

	public static void main(String[] args) {
		List<ProxyInterface> functions=new ArrayList<ProxyInterface>();
		//增加权限校验功能
		functions.add(new AuthorityFunction());
		//增加日志记录功能
		functions.add(new LogFunction());
		
		ProxyManager proxyManager=new ProxyManager(UserService.class, functions);
		UserService userService = (UserService) proxyManager.newProxyInstance();
		userService.service();
	}

}
