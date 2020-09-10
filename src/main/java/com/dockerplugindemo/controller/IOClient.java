package com.dockerplugindemo.controller;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @author: zsg
 * @create: 2020/9/8 18:22
 * @description:
 */
public class IOClient {
    /**
     * Client客户端连接服务端8000端口每隔2秒向服务端写带有时间戳的 "hello world"
     */

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8000);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                        Thread.sleep(2000);
                    } catch (Exception e) {
                    }
                }
            } catch (IOException e) {
            }
        }).start();
    }
}
