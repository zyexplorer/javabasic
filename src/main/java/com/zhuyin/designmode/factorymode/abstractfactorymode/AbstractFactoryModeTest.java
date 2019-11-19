package com.zhuyin.designmode.factorymode.abstractfactorymode;

/**
 * <p>Title: AbstractFactoryModeTest</p>
 * <p>Description: </p>
 * <p>Company: </p>
 *
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2019年11月19日  16:18
 */
public class AbstractFactoryModeTest {

    public static void main(String[] args) {
        AbstractFactory factory = new SpecificFactory();
        Vehicle vehicle = factory.createVehicle();
        vehicle.run();
        vehicle.stop();

        Weapon weapon = factory.createWeapon();
        weapon.shoot();

        Food food = factory.createFood();
        food.taste();
    }

}
