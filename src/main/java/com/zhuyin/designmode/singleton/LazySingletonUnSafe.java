package com.zhuyin.designmode.singleton;

/**
 * <p>Title: LazySingleton.java</p>
 * <p>Description: 懒汉式单例——线程不安全（多线程下单例不唯一）
 * 	     用到时才初始化实例
 * 	     存在的问题：多线程情况下，线程不安全。
 * </p>
 * <p>Company: </p>
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2018-4-30  下午03:11:35 
 * @version v1.0
 */
public class LazySingletonUnSafe {
	
	//1.提供静态类实例
	private static LazySingletonUnSafe instance;
	
	//2.私有化构造方法
	private LazySingletonUnSafe(){}
	
	//3.提供公共的静态方法返回该类的实例
	public static LazySingletonUnSafe getInstance(){
		if (instance == null) {
			instance = new LazySingletonUnSafe();
		}
		return instance;
	}
	
}
