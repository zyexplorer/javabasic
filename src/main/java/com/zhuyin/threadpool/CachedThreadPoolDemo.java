package com.zhuyin.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 可缓存线程池
 * @author Administrator
 *
 */
public class CachedThreadPoolDemo {   
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService pool = Executors.newCachedThreadPool();
		
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
