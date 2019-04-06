package com.zhuyin.socketprogram.TCP.multiThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket=new ServerSocket(9999);
		
		//1.使用普通线程
		/*while(true){
			Socket socket = serverSocket.accept();
			new Thread(new MyRunnable(socket)).start();;
		}*/
		
		
		//2.使用线程池
		ExecutorService pool = Executors.newCachedThreadPool();
		while(true){
			Socket socket = serverSocket.accept() ;
			MyRunnable runnable = new MyRunnable(socket);
			pool.submit(runnable);
			//pool.shutdown();
		}
	}
}
