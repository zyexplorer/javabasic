package com.zhuyin.designmode.proxymode.statics;

/**
 * <p>Title: ProxyDemo1</p>
 * <p>Description: </p>
 * <p>Company: </p>
 *
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2019年11月19日  16:34
 */
/**
 * 静态代理
 * @author 16437
 *
 */
public class StaticProxyDemo {

    public static void main(String[] args) {
        AdminProxy1 ap1 = new AdminProxy1(new Admin());
        ap1.doSomething();

        AdminProxy2 ap2 = new AdminProxy2();
        ap2.doSomething();
    }
}

interface Manager {
    void doSomething();
}

// 被代理的对象
class Admin implements Manager{

    @Override
    public void doSomething() {
        System.out.println("来自Admin方法doSomething！");
    }

}

class AdminProxy1 implements Manager{

    Admin admin;

    public AdminProxy1(Admin admin){
        this.admin = admin;
    }

    @Override
    public void doSomething() {
        System.out.println("----1开始了----");
        admin.doSomething();
        System.out.println("----1结束了----");
    }

}

class AdminProxy2 extends Admin{
    @Override
    public void doSomething() {
        System.out.println("----2开始了----");
        super.doSomething();
        System.out.println("----2结束了----");
    }

}
