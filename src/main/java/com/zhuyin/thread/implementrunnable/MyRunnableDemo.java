package com.zhuyin.thread.implementrunnable;

public class MyRunnableDemo {
	public static void main(String[] args) {
		//创建线程对象
		Thread thread1=new Thread(new MyRunnable());
		Thread thread2=new Thread(new MyRunnable());
		Thread thread3=new Thread(new MyRunnable());
		
		//为线程取名字
		thread1.setName("窗口1");
		thread2.setName("窗口2");
		thread3.setName("窗口3");
		
		//设置线程的优先级
		//thread2.setPriority(Thread.MAX_PRIORITY);
		
		//启动线程
		thread1.start();
		thread2.start();
		thread3.start();
		
	}
}
