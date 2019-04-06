package com.zhuyin.dynamicproxy.cglib.proxychain;

import com.zhuyin.dynamicproxy.cglib.pxoyInterface.ProxyInterface;
import net.sf.cglib.proxy.MethodProxy;

import java.util.List;

public class ProxyChain {
	
	private int index;
	private List<ProxyInterface>functions;
	private Object target;
	private Object[] args;
	private MethodProxy methodProxy;
	
	public ProxyChain(List<ProxyInterface> functions, Object object, Object[] args, MethodProxy methodProxy) {
		this.functions=functions;
		this.target=object;
		this.args=args;
		this.methodProxy=methodProxy;
	}

	public void doProxy(){
		if (index<functions.size()) {
			functions.get(index++).doProxy(this);
		}else {
			try {
				methodProxy.invokeSuper(target, args);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}
}
