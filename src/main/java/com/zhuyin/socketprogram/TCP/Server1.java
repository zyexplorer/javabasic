package com.zhuyin.socketprogram.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket=new ServerSocket(6666);
		
		Socket socket = serverSocket.accept();
		
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		String msg=null;
		while((msg=bufferedReader.readLine())!=null){
			System.out.println(msg);
			if ("886".equals(msg.trim())) {
				break;
			}
		}
		serverSocket.close();
	}
}
