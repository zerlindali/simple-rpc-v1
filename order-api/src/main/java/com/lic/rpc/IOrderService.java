package com.lic.rpc;

/**
 * @author ZerlindaLi create at 2020/8/18 13:50
 * @version 1.0.0
 * @description IOrderService
 */
public interface IOrderService {

    String queryOrderList();

    Order queryOrderDetail();
}
