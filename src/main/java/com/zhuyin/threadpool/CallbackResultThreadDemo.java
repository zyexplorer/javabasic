package com.zhuyin.threadpool;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.zhuyin.threadpool.callable.MyCallable;

/**
 * 带返回值的线程
 * @author Administrator
 *
 */
public class CallbackResultThreadDemo {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// 不推荐使用这种方式创建线程
		// ExecutorService executor = Executors.newCachedThreadPool();
		// 推荐使用手动方式创建线程(指定线程工厂的创建线程命名格式，方便出问题时回溯)
		ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("demo-thread-%d").build();
		ExecutorService executor = new ThreadPoolExecutor(0, 5,
				60L, TimeUnit.SECONDS, new SynchronousQueue<>(), threadFactory);
		
		Callable<Map<String, Object>> c = new MyCallable();
		
		Future<Map<String, Object>> future = executor.submit(c);
		
		Map<String, Object> map = future.get();
		System.out.println(executor.isShutdown());
		executor.shutdown();
		System.out.println(executor.isShutdown());
		System.out.println(map.get("stt"));
		System.out.println(map.get("msg"));
	}
}
