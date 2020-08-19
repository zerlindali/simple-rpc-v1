package com.lic.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @author ZerlindaLi create at 2020/8/19 9:31
 * @version 1.0.0
 * @description ProcessorHander
 */
public class ProcessorHander implements Runnable {

    private Socket socket;
    private Object service;

    public ProcessorHander(Object service, Socket socket){
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());

            RpcRequest request = (RpcRequest) objectInputStream.readObject(); // 反序列化
            Object object = invoke(request); // 路由调用
            System.out.println("服务端调用结果："+object.toString());
            // 服务端将执行结果写回给客户端
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Object invoke(RpcRequest request) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 知道是哪个类

        Class clazz = Class.forName(request.getInterfaceCls());

        // 找到目标方法（方法名和参数类型）
        Method method = clazz.getMethod(request.getMethodName(),request.getParamTypes());
        // 方法调用
        return method.invoke(service, request.getParams());
    }
}
