package com.jn.pay.model;

import java.io.Serializable;

/**
 * 退款接口响应实体类
 *
 * @author： hey
 * @date： Created on 2019/05/07 10:52
 * @version： v1.0
 * @modified By:
 **/
public class RefundOrderRsp  implements Serializable  {

    /**
     * 退款订单ID(支付系统生成的ID)
    * */
    private String refundOrderId;

    public String getRefundOrderId() {
        return refundOrderId;
    }

    public void setRefundOrderId(String refundOrderId) {
        this.refundOrderId = refundOrderId;
    }
}