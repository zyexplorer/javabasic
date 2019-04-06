package com.zhuyin.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 单线程化线程池
 * @author Administrator
 *
 */
public class SingleThreadExecutorDemo {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		Runnable task = new Runnable() {
			public void run() {
				System.out.println("这里调用业务方法处理逻辑");
			}
		};
		
		Future<?> future = executor.submit(task);
		System.out.println(future.get());
		System.out.println(executor.isShutdown());
		executor.shutdown();
		System.out.println(executor.isShutdown());
	}
}
