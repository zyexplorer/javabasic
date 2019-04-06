package com.zhuyin.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyHandler implements InvocationHandler {
	
	private Object target;
	
	public MyHandler(Object target) {
		this.target = target;
	}

	//向外界提供一个获取该代理对象实例的方法
	public Object getProxyInstance(){
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("权限校验功能");
		Object result = method.invoke(target, args);
		System.out.println("日志记录功能");
		return result;
	}

}
