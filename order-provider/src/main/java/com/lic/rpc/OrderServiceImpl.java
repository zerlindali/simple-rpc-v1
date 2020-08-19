package com.lic.rpc;

import java.util.Date;

/**
 * @author ZerlindaLi create at 2020/8/18 13:58
 * @version 1.0.0
 * @description OrderServiceImpl
 */
public class OrderServiceImpl implements IOrderService {
    @Override
    public String queryOrderList() {
        return "EXECUTE QUERYORDERLIST METHOD";
    }

    @Override
    public Order queryOrderDetail() {
        return new Order(111L, "No2222", new Date());
    }
}
