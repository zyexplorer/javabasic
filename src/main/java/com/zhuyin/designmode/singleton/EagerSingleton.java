package com.zhuyin.designmode.singleton;


/**
 * <p>Title: EagerSingleton.java</p>
 * <p>Description: 饿汉式单例——线程安全
 * 	     在初始化时已经自行实例化
 * </p>
 * <p>Company: </p>
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2018-5-1  下午06:59:56 
 * @version v1.0
 */
public class EagerSingleton {
	//1.私有化构造方法
	private EagerSingleton(){}
	
	//2.提供静态成员变量
	private static final EagerSingleton EAGERSINGLETON = new EagerSingleton();
	
	//3.提供公有的静态方法返回该类实例
	public static EagerSingleton getInstance(){
		return EAGERSINGLETON;
	}
}
