package com.jn.pay.model;

import java.io.Serializable;

/**
 * 支付订单查询实体类
 *
 * @author： hey
 * @date： Created on 2019/05/06 16:52
 * @version： v1.0
 * @modified By:
 **/
public class PayOrderQueryReq implements Serializable  {

    private static final long serialVersionUID = 1L;

    /**
     * 缴费类型
     * （详情请查看 MchPayTypeEnum 枚举类）
     * */
    private String payType;
    /**
     * 支付中心生成的订单号，与mchOrderNo二者传一即可
     * */
    private String payOrderId;
    /**
     * 商户订单号,与payOrderId二者传一即可
     */
    private String mchOrderNo;
    /**
     * 是否执行回调，如果为true，则支付中心会再次向商户发起一次回调，如果为false则不发起
    * */
    private boolean executeNotify;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId;
    }

    public String getMchOrderNo() {
        return mchOrderNo;
    }

    public void setMchOrderNo(String mchOrderNo) {
        this.mchOrderNo = mchOrderNo;
    }

    public boolean isExecuteNotify() {
        return executeNotify;
    }

    public void setExecuteNotify(boolean executeNotify) {
        this.executeNotify = executeNotify;
    }

    @Override
    public String toString() {
        return "PayOrderQuery{" +
                "payType='" + payType + '\'' +
                ", payOrderId='" + payOrderId + '\'' +
                ", mchOrderNo='" + mchOrderNo + '\'' +
                ", executeNotify=" + executeNotify +
                '}';
    }
}