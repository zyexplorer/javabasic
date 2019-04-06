package com.zhuyin.socketprogram.TCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client1 {
	public static void main(String[] args) throws IOException {
		
		Socket socket=new Socket("192.168.31.206", 6666);
		
		BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		
		String msg=null;
		
		while((msg=bufferedReader.readLine())!=null){
			bufferedWriter.write(msg);
			bufferedWriter.newLine();
			bufferedWriter.flush();
			if ("886".equals(msg.trim())) {
				break;
			}
		}
		socket.close();
	}
}
