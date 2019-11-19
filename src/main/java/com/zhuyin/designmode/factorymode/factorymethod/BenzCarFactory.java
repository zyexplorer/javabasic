package com.zhuyin.designmode.factorymode.factorymethod;

public class BenzCarFactory implements CarFactory {

	@Override
	public Car builCar() {
		return new Benz();
	}

}
