package com.zhuyin.thread.implementrunnable;

public class MyRunnable implements Runnable {
	private static int ticket=1000;

	@Override
	public void run() {
		boolean flag=true;
		while (flag) {
			/*if (ticket>0) {
				System.out.println(Thread.currentThread().getName()+"正在出售第"+(ticket--)+"张票");
			}else {
				flag=false;
			}*/
			synchronized (this.getClass()) {
				if (ticket>0) {
					Thread.yield();
					System.out.println(Thread.currentThread().getName()+"正在出售第"+(ticket--)+"张票");
				}else {
					flag=false;
				}
			}
		}
	}
}
