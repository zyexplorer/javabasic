package com.zhuyin.designmode.factorypattern.factorymethod;

public class BMWDriver implements Driver {

	@Override
	public Car driveCar() {
		return new Bmw();
	}

}
