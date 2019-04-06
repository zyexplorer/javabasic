package com.zhuyin.socketprogram.TCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server4 {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket=new ServerSocket(8888);
		
		Socket socket = serverSocket.accept();
		
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("copy.java"))));
		
		String str=null;
		while((str=bufferedReader.readLine())!=null){
			bufferedWriter.write(str);
			bufferedWriter.newLine();
			bufferedWriter.flush();
		}
		
		bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		bufferedWriter.write("上传成功!!!");
		//bufferedWriter.newLine();
		bufferedWriter.flush();
		
		bufferedWriter.close();
		socket.close();
	}
}
