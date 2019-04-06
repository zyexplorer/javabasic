package com.zhuyin.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 定时线程池
 * @author Administrator
 *
 */
public class ScheduledThreadPoolDemo {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);
		
		Runnable task = new Runnable() {
			public void run() {
				System.out.println("这里调用业务方法处理逻辑");
			}
		};
		
		Future<?> future = pool.submit(task);
		
		System.out.println(future.get());
		
		System.out.println(pool.isShutdown());
		pool.shutdown();
		System.out.println(pool.isShutdown());
	}
}
