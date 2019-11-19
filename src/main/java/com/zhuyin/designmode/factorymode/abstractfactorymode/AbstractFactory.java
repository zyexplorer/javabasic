package com.zhuyin.designmode.factorymode.abstractfactorymode;

/**
 * <p>Title: AbstractFactory</p>
 * <p>Description: 抽象工厂：与工厂方法模式不同之处在于 工厂方法模式每个工厂只生产一种产品，抽象工厂生产多种产品</p>
 * <p>Company: </p>
 *
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2019年11月19日  16:09
 */
public abstract class AbstractFactory {

    public abstract Vehicle createVehicle();
    public abstract Weapon createWeapon();
    public abstract Food createFood();

}
