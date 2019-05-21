package com.jn.park.property.model;

import java.io.Serializable;

/**
 * 创建账单回调通知实体类
 *
 * @author： wzy
 * @date： Created on 2019/05/06 16:52
 * @version： v1.0
 * @modified By:
 **/
public class PayCallBackNotify implements Serializable  {

    private static final long serialVersionUID = 1L;

    /**
     * 账单编号
     * */
    private String billId;

    /**
     * 账单状态
     * */
    private String paymentState;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(String paymentState) {
        this.paymentState = paymentState;
    }

    @Override
    public String toString() {
        return "PayCallBackNotify{" +
                "billId='" + billId + '\'' +
                ", paymentState='" + paymentState + '\'' +
                '}';
    }
}