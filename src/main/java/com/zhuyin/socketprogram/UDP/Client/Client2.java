package com.zhuyin.socketprogram.UDP.Client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client2 {

    public static void main(String[] args) {
        try {
            receiveMsg();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void receiveMsg() throws IOException, UnknownHostException {
        //创建Socket对象(直接对着指定端口)
        DatagramSocket socket = new DatagramSocket(10086, InetAddress.getByName("192.168.191.1"));

        //创建一个数据包（容器）对着指定IP端口准备接收数据
        byte[] bys = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bys, bys.length);

        socket.receive(packet);
        String msg = new String(packet.getData(), 0, packet.getData().length);

        System.out.println("接收到的消息：" + msg);
        socket.close();
    }

    public static void sendMsg() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("您说：");
        String msg = scanner.nextLine();

        //创建Socket对象
        DatagramSocket socket = new DatagramSocket();

        //创建数据包
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, InetAddress.getByName("192.168.191.1"), 10086);

        //通过Socket对象来发送数据包
        socket.send(packet);

        //释放资源
        socket.close();
        if (scanner != null) {
            scanner.close();
        }
    }

}
