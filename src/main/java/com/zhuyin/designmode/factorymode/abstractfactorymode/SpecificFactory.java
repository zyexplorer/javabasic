package com.zhuyin.designmode.factorymode.abstractfactorymode;

/**
 * <p>Title: SpecificFactory</p>
 * <p>Description: 具体工厂类</p>
 * <p>Company: </p>
 *
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2019年11月19日  16:14
 */
public class SpecificFactory extends AbstractFactory {

    @Override
    public Vehicle createVehicle() {
        return new Car();
    }

    @Override
    public Weapon createWeapon() {
        return new AK47();
    }

    @Override
    public Food createFood() {
        return new Apple();
    }
}
