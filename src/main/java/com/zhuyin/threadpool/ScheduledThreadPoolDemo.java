package com.zhuyin.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 定时线程池
 * @author Administrator
 *
 */
public class ScheduledThreadPoolDemo {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// 不推荐这种方式创建线程
		// ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);
		// 推荐手动的方式创建线程
		ScheduledExecutorService pool = new ScheduledThreadPoolExecutor(3,
				new ThreadFactoryBuilder().setNameFormat("demo-thread-%d").setDaemon(true).build());
//		ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("demo-thread-%d").build();
//		ExecutorService pool = new ThreadPoolExecutor(3, 10, 30L,
//				TimeUnit.SECONDS, new LinkedBlockingDeque<>(20), threadFactory);
//		Runnable task = new Runnable() {
//			public void run() {
//				System.out.println("这里调用业务方法处理逻辑");
//			}
//		};

		Runnable task = () -> System.out.println("这里调用业务方法处理逻辑");
		
		Future<?> future = pool.submit(task);
		
		System.out.println(future.get());
		
		System.out.println(pool.isShutdown());
		pool.shutdown();
		System.out.println(pool.isShutdown());
	}
}
