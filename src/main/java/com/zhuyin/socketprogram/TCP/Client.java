package com.zhuyin.socketprogram.TCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws IOException {
		method2();
	}

	public static void method3() throws UnknownHostException, IOException {
		//创建客户端Socket对象
		Socket socket=new Socket("localhost", 6666);
		
		//键盘录入数据
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		//把通道里的输出流包装一下
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		String msg=null;
		while((msg=br.readLine())!=null){
			bw.write(msg);
			bw.newLine();
			bw.flush();
			if ("886".equals(msg.trim())) {
				break;
			}
		}
		socket.close();
	}

	public static void method2() throws UnknownHostException, IOException {
		//创建客户端Socket对象
		Socket socket=new Socket("localhost", 6666);
		
		//通过该对象获取通道中的输出流(进行包装)
		OutputStream outputStream = socket.getOutputStream();
		BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream));
		
		//从键盘录入
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		String msg;
		while(true){
			msg=bufferedReader.readLine();
			bufferedWriter.write(msg);
			bufferedWriter.newLine();
			bufferedWriter.flush();
			if ("886".equals(msg.trim())) {
				break;
			}
		}
		socket.close();
	}

	public static void method1() throws UnknownHostException, IOException {
		//创建客户端Socket对象(对准服务器相应端口)
		Socket socket=new Socket("192.168.31.206", 6666);
		
		//通过该Socket对象拿到通道中的OutputStream对象(考虑装饰模式)，再进行包装    貌似装饰模式不行
		OutputStream outputStream = socket.getOutputStream();
		OutputStreamWriter outputStreamWriter=new OutputStreamWriter(outputStream);
		BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
		bufferedWriter.write("Hello,TCP,我来啦!!!");
		bufferedWriter.flush();
		socket.close();
	}
}
