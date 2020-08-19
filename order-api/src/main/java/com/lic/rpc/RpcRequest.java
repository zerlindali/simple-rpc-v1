package com.lic.rpc;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ZerlindaLi create at 2020/8/18 17:55
 * @version 1.0.0
 * @description RpcRequest
 */
@Data
public class RpcRequest implements Serializable {

    private String methodName;

    private String interfaceCls;

    private Class<?> [] paramTypes;

    private Object [] params;
}
