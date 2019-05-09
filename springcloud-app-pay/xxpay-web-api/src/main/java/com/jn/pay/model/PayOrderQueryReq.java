package com.jn.pay.model;

import org.hibernate.validator.constraints.NotBlank;

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
     * 商户ID
     * （详情请查看 MchIdEnum 枚举类）
     * */
    @NotBlank(message = "商户ID不能为空！")
    private String mchId;
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

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
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
        return "PayOrderQueryReq{" +
                "mchId='" + mchId + '\'' +
                ", payOrderId='" + payOrderId + '\'' +
                ", mchOrderNo='" + mchOrderNo + '\'' +
                ", executeNotify=" + executeNotify +
                '}';
    }
}