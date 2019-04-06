package com.zhuyin.designmode.factorypattern.factorymethod;

public class BenzDriver implements Driver {

	@Override
	public Car driveCar() {
		return new Benz();
	}

}
