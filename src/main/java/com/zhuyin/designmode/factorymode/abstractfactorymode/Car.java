package com.zhuyin.designmode.factorymode.abstractfactorymode;

/**
 * <p>Title: Car</p>
 * <p>Description: 具体交通工具类</p>
 * <p>Company: </p>
 *
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2019年11月19日  16:15
 */
public class Car extends Vehicle {

    @Override
    void run() {
        System.out.println("小汽车开始启动了...");
    }

    @Override
    void stop() {
        System.out.println("小汽车停下了...");
    }
}
