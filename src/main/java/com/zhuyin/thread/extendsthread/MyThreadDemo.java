package com.zhuyin.thread.extendsthread;

public class MyThreadDemo {
	public static void main(String[] args) {
		//创建线程对象
		MyThread my1=new MyThread();
		MyThread my2=new MyThread();
		MyThread my3=new MyThread();
		
		//为线程取名字
		my1.setName("窗口1");
		my2.setName("窗口2");
		my3.setName("窗口3");
		
		//启动线程
		my1.start();
		my2.start();
		my3.start();
	}
}
