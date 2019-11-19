package com.zhuyin.designmode.factorymode.factorymethod;

public class FactoryMethodModeTest {
	
	public static void main(String[] args) {
		CarFactory carFactory1 = new BenzCarFactory();
		Car car1 = carFactory1.builCar();
		car1.run();
		car1.stop();
		
		System.out.println("========");
		
		CarFactory carFactory2 = new BMWCarFactory();
		Car car2 = carFactory2.builCar();
		car2.run();
		car2.stop();
	}
	
}
