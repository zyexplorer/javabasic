package com.zhuyin.designmode.proxymode.dynamic;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <p>Title: CglibDynamicProxyDemo</p>
 * <p>Description: cglib动态代理生成类的子类</p>
 * <p>Company: </p>
 *
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2019年11月19日  16:41
 */

//1.具体主题
class Train{
    public void move(){
        System.out.println("火车行驶中…");
    }
}
//2.生成代理
class CGLibProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();
    public Object getProxy(Class<?> clazz){
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }
    /**
     * 拦截所有目标类方法的调用
     * 参数：
     * obj  目标实例对象
     * method 目标方法的反射对象
     * args 方法的参数
     * proxy 代理类的实例
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {
        //代理类调用父类的方法
        System.out.println("日志开始");
        proxy.invokeSuper(obj, args);
        System.out.println("日志结束");
        return null;
    }
}
//3.测试
public class CglibDynamicProxyDemo {
    public static void main(String[] args) {
        CGLibProxy proxy = new CGLibProxy();
        Train t = (Train) proxy.getProxy(Train.class);
        t.move();
    }
}
