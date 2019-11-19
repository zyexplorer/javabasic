package com.zhuyin.socketprogram.TCP.multiThread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {

	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket=new ServerSocket(9999);
		
		//1.使用普通线程
		/*while(true){
			Socket socket = serverSocket.accept();
			new Thread(new MyRunnable(socket)).start();;
		}*/
		
		
		//2.使用线程池
		//ExecutorService pool = Executors.newCachedThreadPool();
		ExecutorService pool = new ThreadPoolExecutor(3, 10, 60L, TimeUnit.SECONDS,
				new SynchronousQueue<>(), new ThreadFactoryBuilder().setNameFormat("server-thread-%d").setDaemon(true).build());
		while(true){
			Socket socket = serverSocket.accept() ;
			MyRunnable runnable = new MyRunnable(socket);
			pool.submit(runnable);
			//pool.shutdown();
		}
	}
}
