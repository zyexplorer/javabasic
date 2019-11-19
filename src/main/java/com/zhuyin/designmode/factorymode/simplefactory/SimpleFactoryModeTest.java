package com.zhuyin.designmode.factorymode.simplefactory;

public class SimpleFactoryModeTest {
	
	public static void main(String[] args) throws Exception {
		
		Car car1 = CarFactory.buildCar("Benz");
		Car car2 = CarFactory.buildCar("BMW");
		car1.run();
		car2.run();
		car1.stop();
		car2.stop();
	}
	
}
