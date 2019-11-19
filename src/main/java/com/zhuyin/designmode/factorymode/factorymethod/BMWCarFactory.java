package com.zhuyin.designmode.factorymode.factorymethod;

public class BMWCarFactory implements CarFactory {

	@Override
	public Car builCar() {
		return new Bmw();
	}

}
