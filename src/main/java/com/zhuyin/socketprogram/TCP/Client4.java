package com.zhuyin.socketprogram.TCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client4 {
	public static void main(String[] args) throws IOException {
		
		Socket socket=new Socket("192.168.31.206", 8888);
		
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("E://JavaWeb//SSM_T//Test//src//com//test//TestSimpleDateFormat.java"))));
		
		BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		String str=null;
		while((str=bufferedReader.readLine())!=null){
			bufferedWriter.write(str);
			bufferedWriter.newLine();
			bufferedWriter.flush();
		}
		socket.shutdownOutput();
		
		bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String msg = bufferedReader.readLine();
		System.out.println(msg);
		
		bufferedReader.close();
		socket.close();
	}
}
