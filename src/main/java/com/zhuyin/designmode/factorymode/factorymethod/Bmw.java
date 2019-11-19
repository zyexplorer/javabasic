package com.zhuyin.designmode.factorymode.factorymethod;

public class Bmw implements Car {

	@Override
	public void run() {
		System.out.println("BMW car is driving……");
	}

	@Override
	public void stop() {
		System.out.println("BMW car stopped……");
	}

}
