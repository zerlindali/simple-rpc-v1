package com.lic.exaple.rpc;

import com.lic.rpc.IOrderService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        // 通过动态代理得到一个服务的实现
        RpcProxyClient rpcProxyClient = new RpcProxyClient();
        IOrderService orderService = rpcProxyClient.proxyClient(IOrderService.class , "localhost" , 8080);
        System.out.println(orderService.queryOrderList());
        System.out.println(orderService.queryOrderDetail().toString());
    }
}
