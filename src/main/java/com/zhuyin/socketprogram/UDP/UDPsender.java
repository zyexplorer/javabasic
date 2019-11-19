package com.zhuyin.socketprogram.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP协议网络编程发送端
 *
 * @author ZY
 * A.创建Socket发送端对象
 * B.创建数据，并把数据打包
 * C.调用Socket对象的发送方法发送数据包
 * D.释放资源
 */
public class UDPsender {


    public static void main(String[] args) throws IOException {

        //创建Socket发送端对象
        DatagramSocket socket = new DatagramSocket();

        //创建数据，并把数据打包
        byte[] bys = "你好，UDP，我来啦！".getBytes();
        int length = bys.length;
        InetAddress address = InetAddress.getByName("192.168.191.1");
        int port = 10086;
        DatagramPacket packet = new DatagramPacket(bys, length, address, port);

        //调用Socket对象的发送方法发送数据包
        socket.send(packet);

        //释放资源
        socket.close();
    }

}
