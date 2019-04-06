package com.zhuyin.socketprogram.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Receiver1 {

	public static void main(String[] args) throws IOException {
		
		//创建Socket对象(直接对着指定端口)
		DatagramSocket socket=new DatagramSocket(10086, InetAddress.getByName("192.168.126.1"));
		
		//创建一个数据包（容器）对着指定IP端口准备接收数据
		byte[] bys=new byte[1024];
		DatagramPacket packet=new DatagramPacket(bys, bys.length);
		
		socket.receive(packet);
		String msg=new String(packet.getData(), 0, packet.getData().length);
		
		System.out.println("接收到的消息："+msg);
		socket.close();
	}
}
