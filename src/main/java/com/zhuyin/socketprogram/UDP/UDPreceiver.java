package com.zhuyin.socketprogram.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP协议网络编程接收端
 *
 * @author ZY
 * A.创建Socket接收端对象
 * B.创建一个数据包（接收容器）准备接收数据包
 * C.调用Socket对象的接收方法接收数据包
 * D.解析数据包，并将数据显示在控制台上
 * E.释放资源
 */
public class UDPreceiver {

    public static void main(String[] args) throws IOException {

        //创建Socket接收端对象(接收端要指定端口，需与发送端端口一致)
        //public DatagramSocket(int port){}
        DatagramSocket socket = new DatagramSocket(10086);

        //创建一个数据包（接收容器），准备接收数据包
        byte[] bys = new byte[1024];
        int length = bys.length;
        DatagramPacket packet = new DatagramPacket(bys, length);

        //调用Socket对象的接收方法来接收数据包
        socket.receive(packet);    //阻塞

        //获取IP来源
        InetAddress address = packet.getAddress();
        String ip = address.getHostAddress();

        //解析数据包，并将数据显示在控制台上
        byte[] bytes = packet.getData();
        int len = bytes.length;
        String msg = new String(bytes, 0, len);
        System.out.println(ip + "发来的信息是：" + msg);

        //释放资源
        socket.close();
    }
}
