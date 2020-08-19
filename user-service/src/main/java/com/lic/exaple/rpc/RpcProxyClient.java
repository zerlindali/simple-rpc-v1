package com.lic.exaple.rpc;

import java.lang.reflect.Proxy;

/**
 * @author ZerlindaLi create at 2020/8/18 14:56
 * @version 1.0.0
 * @description RpcProxyClient
 */
public class RpcProxyClient {


    public <T> T proxyClient(final Class<T> interfaceCls, final String host, final int port){
        T object = (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(),
                // 这里是要代理的接口类，不是方法，也不是实现类，是接口类
                new Class<?> [] {interfaceCls},
                new MyInvocationHandler(host, port));
        return object;
    }

}
