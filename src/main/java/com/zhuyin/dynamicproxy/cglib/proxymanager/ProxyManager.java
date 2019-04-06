package com.zhuyin.dynamicproxy.cglib.proxymanager;

import com.zhuyin.dynamicproxy.cglib.proxychain.ProxyChain;
import com.zhuyin.dynamicproxy.cglib.pxoyInterface.ProxyInterface;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

public class ProxyManager {
	
	private Class<?> targetClass;
	private List<ProxyInterface> functions;
	
	public ProxyManager(Class<?> targetClass, List<ProxyInterface> functions) {
		this.targetClass = targetClass;
		this.functions = functions;
	}
	
	public Object newProxyInstance(){
		
		return Enhancer.create(targetClass, new MethodInterceptor() {

			@Override
			public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
				ProxyChain proxyChain=new ProxyChain(functions,object,args,methodProxy);
				proxyChain.doProxy();
				return null;
			}
		});
	}
	
	
	
}
