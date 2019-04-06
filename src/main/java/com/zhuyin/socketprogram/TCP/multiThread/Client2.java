package com.zhuyin.socketprogram.TCP.multiThread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client2 {

	public static void main(String[] args) throws IOException {
		
		Socket socket=new Socket("127.0.0.1", 9999);
		
		BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("F:\\Personal\\Desktop\\aaa.txt"))));
		String str=null;
		while((str=bufferedReader.readLine())!=null){
			bufferedWriter.write(str);
			bufferedWriter.newLine();
			bufferedWriter.flush();
		}
		socket.shutdownOutput();
		
		bufferedReader.close();
		socket.close();
	}
}
