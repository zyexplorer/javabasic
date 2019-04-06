package com.zhuyin.designmode.factorypattern.factorymethod;

public class Boss {
	
	public static void main(String[] args) {
		Driver driver1 = new BenzDriver();
		Car car1 = driver1.driveCar();
		car1.drive();
		
		System.out.println("========");
		
		Driver driver2 = new BMWDriver();
		Car car2 = driver2.driveCar();
		car2.drive();
	}
	
}
