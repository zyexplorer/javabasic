package com.zhuyin.socketprogram.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //创建服务端Socket对象
        ServerSocket serverSocket = new ServerSocket(6666);
        Socket socket;
        while (true) {
            socket = serverSocket.accept();
            //开启监听
            System.out.println("来自客户端：" + socket.getInetAddress().getHostAddress() + "的请求");

            //通过该返回的socket获得通道内的InputStream对象（考虑装饰模式）再包装
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            //通过包装后的InputStream来解析客户端的请求内容  显示在控制台
            String msg = bufferedReader.readLine();
            System.out.println(msg);
            if ("886".equals(msg.trim())) {
                break;
            }
        }
        socket.close();
    }
}
