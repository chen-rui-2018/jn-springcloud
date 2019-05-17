package com.jn.pay.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 统一支付下单返回实体类
 *
 * @author： hey
 * @date： Created on 2019/05/17 15:52
 * @version： v1.0
 * @modified By:
 **/
public class PayOrderRsp implements Serializable  {

    private static final long serialVersionUID = 1L;


    /**
     * 支付系统订单ID
     */
    @ApiModelProperty("支付系统订单ID")
    private String payOrderId;

    /**
     * 渠道ID
     * 根据ChannelIdEnum枚举类
     */
    @ApiModelProperty("渠道ID,根据ChannelIdEnum枚举类查看")
    private String channelId;

    /**
     * 支付系统响应签名
     */
    @ApiModelProperty("支付系统响应签名")
    private String sign;

    /**
     * 发起支付需要的参数(JSON格式)
     * 具体参数可以查看支付文档
     */
    @ApiModelProperty("发起支付需要的参数(JSON格式)")
    private String orderInfo;


    public String getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    @Override
    public String toString() {
        return "PayOrderRsp{" +
                "payOrderId='" + payOrderId + '\'' +
                ", channelId='" + channelId + '\'' +
                ", sign='" + sign + '\'' +
                ", orderInfo='" + orderInfo + '\'' +
                '}';
    }
}