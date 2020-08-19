package com.lic.rpc;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ZerlindaLi create at 2020/8/18 13:51
 * @version 1.0.0
 * @description Order
 */
@Data
@AllArgsConstructor
public class Order implements Serializable {
    private Long id;

    private String orderNo;

    private Date tradeTime;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", tradeTime=" + tradeTime +
                '}';
    }
}
