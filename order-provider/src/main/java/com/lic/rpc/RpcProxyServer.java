package com.lic.rpc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZerlindaLi create at 2020/8/19 9:24
 * @version 1.0.0
 * @description RpcProxyServer
 */
public class RpcProxyServer {
    private int port;
    private Object service;

    public RpcProxyServer(Object service, int port){
        this.port = port;
        this.service = service;
    }
    // 使用线程池
    private ExecutorService executorService = Executors.newFixedThreadPool (10);
    public void publish() {
        try {
            ServerSocket serverSocket = new ServerSocket( port);
            while (true){
                Socket socket = serverSocket.accept(); // 监听客户端请求
                // 将socket传到线程池，解决I/O流阻塞问题，但是会受限于线程的资源。
                // 所以可以使用多路复用的机制，一个线程处理多个连接
                executorService.submit(new ProcessorHander(service, socket));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
