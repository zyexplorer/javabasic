package com.zhuyin.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 定长线程池
 * @author Administrator
 *
 */
public class FixedThreadPoolDemo {

	public static void main(String[] args) {
		
		ExecutorService pool = Executors.newFixedThreadPool(3);
		
		Runnable task = new Runnable() {
			
			public void run() {
				System.out.println("这里调用业务方法处理逻辑");
			}
		};
		
		pool.submit(task);
		System.out.println(pool.isShutdown());
		pool.shutdown();
		System.out.println(pool.isShutdown());
	}
}
