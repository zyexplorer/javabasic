package com.zhuyin.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 定长线程池
 * @author Administrator
 *
 */
public class FixedThreadPoolDemo {

	public static void main(String[] args) {
		// 不推荐使用这种方式创建线程
		// ExecutorService pool = Executors.newFixedThreadPool(3);
		// 推荐手动的方式创建线程(指定线程工厂的创建线程命名格式，方便出问题时回溯)
		ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("demo-thread-%d").build();
		ExecutorService pool = new ThreadPoolExecutor(1, 5,
				60L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), threadFactory);

//		Runnable task = new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("这里调用业务方法处理逻辑");
//			}
//		};

		Runnable task = () -> System.out.println("这里调用业务方法处理逻辑");
		
		pool.submit(task);
		System.out.println(pool.isShutdown());
		pool.shutdown();
		System.out.println(pool.isShutdown());
	}
}
