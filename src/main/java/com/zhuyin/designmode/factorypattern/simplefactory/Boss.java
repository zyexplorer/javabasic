package com.zhuyin.designmode.factorypattern.simplefactory;

public class Boss {
	
	public static void main(String[] args) throws Exception {
		
		Car car1 = Driver.driveCar("Benz");
		Car car2 = Driver.driveCar("BMW");
		car1.drive();
		car2.drive();
		
	}
	
}
