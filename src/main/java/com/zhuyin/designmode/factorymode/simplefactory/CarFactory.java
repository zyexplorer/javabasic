package com.zhuyin.designmode.factorymode.simplefactory;

/**
 * <p>Title: CarFactory.java</p>
 * <p>Description: 简单工厂类</p>
 * <p>Company: </p>
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2018-5-1  下午07:59:14 
 * @version v1.0
 */
public class CarFactory {
	
	public static Car buildCar(String s) throws Exception{
		
		if ("BMW".equalsIgnoreCase(s)) {
			return new Bmw();
		} else if ("Benz".equalsIgnoreCase(s)) {
			return new Benz();
		}else {
			throw new Exception("暂不生产该名称的车");
		}
	}
	
}
