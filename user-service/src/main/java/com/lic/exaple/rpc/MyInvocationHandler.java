package com.lic.exaple.rpc;

import com.lic.rpc.RpcRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ZerlindaLi create at 2020/8/18 15:28
 * @version 1.0.0
 * @description MyInvocationHandler
 */
public class MyInvocationHandler implements InvocationHandler {

    private String host;
    private int port;


    public MyInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        RpcRemoteTrans rpcRemoteTrans = new RpcRemoteTrans(host, port);

        // 传输数据
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setInterfaceCls(method.getDeclaringClass().getName());
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setParamTypes(method.getParameterTypes());
        rpcRequest.setParams(args);
        return rpcRemoteTrans.send(rpcRequest);
    }
}
