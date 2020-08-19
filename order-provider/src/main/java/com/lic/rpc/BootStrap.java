package com.lic.rpc;

/**
 * Hello world!
 *
 */
public class BootStrap
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        IOrderService orderService = new OrderServiceImpl();

        try {
            // 发布服务
            RpcProxyServer rpcProxyServer = new RpcProxyServer(orderService, 8080);
            rpcProxyServer.publish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
