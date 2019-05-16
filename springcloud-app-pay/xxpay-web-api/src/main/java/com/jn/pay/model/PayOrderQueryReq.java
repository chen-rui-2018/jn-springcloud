package com.jn.pay.model;

import io.swagger.annotations.ApiModelProperty;
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
     * 支付系统生成的订单号
     * */
    private String payOrderId;
    /**
     * 是否执行回调，如果为true，则支付中心会再次向商户发起一次回调
     * 如果为false则不发起,默认为false
    * */
    private Boolean executeNotify = false;
    /**
     * 签名
     */
    @ApiModelProperty("签名,可以通过API提供的工具生成")
    @NotBlank(message = "签名不能为空！")
    private String sign;



    @Override
    public String toString() {
        return "PayOrderQueryReq{" +
                "payOrderId='" + payOrderId + '\'' +
                ", executeNotify=" + executeNotify +
                ", sign='" + sign + '\'' +
                '}';
    }

    public String getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId;
    }

    public Boolean getExecuteNotify() {
        return executeNotify;
    }

    public void setExecuteNotify(Boolean executeNotify) {
        this.executeNotify = executeNotify;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}