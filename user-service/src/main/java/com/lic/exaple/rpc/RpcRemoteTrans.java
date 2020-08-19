package com.lic.exaple.rpc;

import com.lic.rpc.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author ZerlindaLi create at 2020/8/18 16:50
 * @version 1.0.0
 * @description RpcRemoteTrans
 */
public class RpcRemoteTrans {

    private String host;

    private int port;

    public RpcRemoteTrans(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Socket newSocket() throws Exception {
        Socket socket = new Socket(host, port);
        return socket;
    }

    public Object send(RpcRequest request){
        ObjectOutputStream objectOutputStream= null;
        ObjectInputStream objectInputStream = null;
        try {
            Socket socket = newSocket();
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(request);
            objectOutputStream.flush();
            // 客户端收到返回结果
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object rs = objectInputStream.readObject();
            System.out.println("客户端收到返回结果："+rs.toString());
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(objectOutputStream!=null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "Hello~ 我是甲方爸爸~";
    }

}
