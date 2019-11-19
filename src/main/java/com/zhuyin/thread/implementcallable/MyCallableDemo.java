package com.zhuyin.thread.implementcallable;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ZY
 *	实现多线程的第3中方式，基于线程池
 *	A.创建线程池对象
 *	B.通过线程池对象提交带返回结果的线程任务，得到一个未决结果的任务Future对象
 *	C.通过该Future对象获得具体信息
 */
public class MyCallableDemo {
	public static void main(String[] args) throws Exception {
		//创建线程池对象
		//ExecutorService service = Executors.newFixedThreadPool(3);
		ExecutorService service = new ThreadPoolExecutor(3, 10, 60L, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>(), new ThreadFactoryBuilder().setNameFormat("call-thread-%d").build());
		
		//通过线程池执行线程(提交线程任务)
		Future<Integer> future1 = service.submit(new MyCallable(1, 100));
		Future<Integer> future2 = service.submit(new MyCallable(1, 10));
		Future<Integer> future3 = service.submit(new MyCallable(100, 200));
		
		System.out.println(future1.get());
		System.out.println(future2.get());
		System.out.println(future3.get());
		service.shutdown();
	}
}
