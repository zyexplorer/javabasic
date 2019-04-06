package com.zhuyin.designmode.singleton;


/**
 * <p>Title: LazySingletonSafe.java</p>
 * <p>Description: 懒汉式单例——线程安全（多线程下单例唯一）
 * 	  用到时才实例化单例对象
 * 	  对线程不安全的单例模式进行改造，实现线程安全
 * </p>
 * <p>Company: </p>
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2018-4-30  下午03:19:08 
 * @version v1.0
 */
public class LazySingletonSafe {
	
	//1.提供静态类实例
	private static LazySingletonSafe instance;
	
	//2.私有化构造方法
	private LazySingletonSafe(){}
	
	//3.1提供公共的静态方法返回该类的实例(方法实现同步，解决多线程不安全问题)
	public static synchronized LazySingletonSafe getInstance1(){
		if (instance == null) {
			instance = new LazySingletonSafe();
		}
		return instance;
	}
	
	//3.2提供公共的静态方法返回该类的实例(双重检查锁定)
	public static LazySingletonSafe getInstance2(){
		if (instance == null) {
			synchronized (LazySingletonSafe.class) {
				if (instance == null) {
					instance = new LazySingletonSafe();
				}
			}
		}
		return instance;
	}
	
	//3.3静态内部类方式返回该类实例(线程安全)
	private static class SingletonHolder{
		private static final LazySingletonSafe INSTANCE = new LazySingletonSafe();
	}
	public static final LazySingletonSafe getInstance3(){
		return SingletonHolder.INSTANCE;
	}
}
