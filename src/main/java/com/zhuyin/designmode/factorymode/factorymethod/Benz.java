package com.zhuyin.designmode.factorymode.factorymethod;

public class Benz implements Car {

	@Override
	public void run() {
		System.out.println("Benz car is driving……");
	}

	@Override
	public void stop() {
		System.out.println("Benz car stopped……");
	}

}
