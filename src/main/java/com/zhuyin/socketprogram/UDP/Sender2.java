package com.zhuyin.socketprogram.UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender2 {
    public static void main(String[] args) throws IOException {

        //创建Socket对象
        DatagramSocket socket = new DatagramSocket();

        //创建数据包
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String msg = null;
        boolean flag = true;
        while (flag) {
            System.out.print("您说：");
            msg = bufferedReader.readLine();
            DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, InetAddress.getByName("192.168.191.1"), 10086);
            //通过Socket对象调用发送方法发送数据包
            socket.send(packet);
            if ("886".equals(msg.trim())) {
                flag = false;
            }
        }
        //释放资源
        socket.close();
    }
}
