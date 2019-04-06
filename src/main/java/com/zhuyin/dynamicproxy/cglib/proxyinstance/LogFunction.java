package com.zhuyin.dynamicproxy.cglib.proxyinstance;

import com.zhuyin.dynamicproxy.cglib.proxychain.ProxyChain;
import com.zhuyin.dynamicproxy.cglib.pxoyInterface.ProxyInterface;


public class LogFunction implements ProxyInterface {

	public void doProxy(ProxyChain proxyChain) {
		System.out.println("日志记录功能开始...");
		proxyChain.doProxy();
		System.out.println("日志记录功能结束...");
	}

}
