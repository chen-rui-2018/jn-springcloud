package com.jn.paybill.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 缴费账单回调
 * @author： jiangyl
 * @date： Created on 2019/5/21 15:22
 * @version： v1.0
 * @modified By:
 */
public class PaymentBillCallBack implements Serializable {

    @ApiModelProperty(value = "渠道ID")
    private String channelId;
    @ApiModelProperty(value = "支付系统生成的订单号")
    private String payOrderId;
    @ApiModelProperty(value = "第三方支付渠道订单号")
    private String channelOrderNo;
    @ApiModelProperty(value = "支付成功时间（精确到毫秒）")
    private Long paySuccTime;
    @ApiModelProperty(value = "支付金额,单位分")
    private Long amount;
    @ApiModelProperty(value = "支付状态,0-订单生成,1-支付中,2-支付成功,3-业务处理完成")
    private Integer status;
    @ApiModelProperty(value = "账单Id")
    private String billId;
    @ApiModelProperty(value = "账单类型")
    private String billType;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId;
    }

    public String getChannelOrderNo() {
        return channelOrderNo;
    }

    public void setChannelOrderNo(String channelOrderNo) {
        this.channelOrderNo = channelOrderNo;
    }

    public Long getPaySuccTime() {
        return paySuccTime;
    }

    public void setPaySuccTime(Long paySuccTime) {
        this.paySuccTime = paySuccTime;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    @Override
    public String toString() {
        return "PaymentBillCallBack{" +
                "channelId='" + channelId + '\'' +
                ", payOrderId='" + payOrderId + '\'' +
                ", channelOrderNo='" + channelOrderNo + '\'' +
                ", paySuccTime=" + paySuccTime +
                ", amount=" + amount +
                ", status=" + status +
                ", billId='" + billId + '\'' +
                ", billType='" + billType + '\'' +
                '}';
    }
}