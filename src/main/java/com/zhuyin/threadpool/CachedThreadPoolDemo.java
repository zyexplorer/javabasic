package com.zhuyin.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 可缓存线程池
 * @author Administrator
 *
 */
public class CachedThreadPoolDemo {   
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// 不推荐使用这种方式创建线程
		// ExecutorService pool = Executors.newCachedThreadPool();
		// 推荐手动设置参数的方式创建线程(指定线程工厂的创建线程命名格式，方便出问题时回溯)
		ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("demo-thread-%d").build();
		ExecutorService pool = new ThreadPoolExecutor(3, 10, 60L,
				TimeUnit.SECONDS, new SynchronousQueue<>(), threadFactory);
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
