package com.zhuyin.socketprogram.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Receiver2 {
    public static void main(String[] args) throws IOException {

        //创建Socket对象
        DatagramSocket socket = new DatagramSocket(10086, InetAddress.getByName("192.168.191.1"));

        boolean flag = true;
        while (flag) {
            //创建数据包（容器）准备接收数据
            byte[] bs = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bs, bs.length);
            //通过Socket对象调用接收方法来接收数据包
            socket.receive(packet);

            //通过容器来解析数据包，并将数据显示到控制台
            String ip = packet.getAddress().getHostAddress();

            String msg = new String(packet.getData(), 0, packet.getData().length);
            System.out.println("来自" + ip + "的消息：" + msg);
            if ("886".equals(msg.trim())) {
                flag = false;
            }
        }
        socket.close();
        System.exit(0);
    }
}
