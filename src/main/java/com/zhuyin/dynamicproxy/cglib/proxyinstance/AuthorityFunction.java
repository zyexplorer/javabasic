package com.zhuyin.dynamicproxy.cglib.proxyinstance;


import com.zhuyin.dynamicproxy.cglib.proxychain.ProxyChain;
import com.zhuyin.dynamicproxy.cglib.pxoyInterface.ProxyInterface;

public class AuthorityFunction implements ProxyInterface {

	@Override
	public void doProxy(ProxyChain proxyChain) {
		System.out.println("权限校验功能开始...");
		proxyChain.doProxy();
		System.out.println("权限校验功能结束...");
	}

}
