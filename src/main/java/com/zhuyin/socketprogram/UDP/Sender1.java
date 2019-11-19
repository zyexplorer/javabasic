package com.zhuyin.socketprogram.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Sender1 {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("您说：");
        String msg = scanner.nextLine();

        //创建Socket对象
        DatagramSocket socket = new DatagramSocket();

        //创建数据包
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, InetAddress.getByName("192.168.126.1"), 10086);

        //通过Socket对象来发送数据包
        socket.send(packet);

        //释放资源
        socket.close();
        if (scanner != null) {
            scanner.close();
        }

    }

}
