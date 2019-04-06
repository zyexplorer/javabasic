package com.zhuyin.designmode.factorypattern.factorymethod;

/**
 * <p>Title: Driver.java</p>
 * <p>Description: 将工厂类抽象成工厂方法(接口，也可以用抽象类，其他类继承该类实现抽象方法)</p>
 * <p>Company: </p>
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2018-5-1  下午08:09:25 
 * @version v1.0
 */
public interface Driver {
	Car driveCar();
}
