package com.zhuyin.threadpool;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.zhuyin.threadpool.callable.MyCallable;

/**
 * 带返回值的线程
 * @author Administrator
 *
 */
public class CallbackResultThreadDemo {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
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
