package com.jn.paybill.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/3 11:32
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayOrderModel", description = "支付订单Model")
public class PayOrderModel implements Serializable {
    @ApiModelProperty(value = "订单ID")
    private String id;
    @ApiModelProperty(value = "订单号")
    private String orderNum;
    @ApiModelProperty(value = "账单集合")
    private String billIds;
    @ApiModelProperty(value = "订单名称")
    private String orderName;
    @ApiModelProperty(value = "订单对象类型[1企业2个人]")
    private String orderObjType;
    @ApiModelProperty(value = "订单对象ID")
    private String orderObjId;
    @ApiModelProperty(value = "订单对象名称")
    private String orderObjName;
    @ApiModelProperty(value = "订单金额")
    private Double orderAmount;
    @ApiModelProperty(value = "支付时间")
    private String payTime;
    @ApiModelProperty(value = "订单状态")
    private String orderStatus;
    @ApiModelProperty(value = "支付平台订单号")
    private String payId;
    @ApiModelProperty(value = "实际支付金额")
    private Double payAmount;
    @ApiModelProperty(value = "支付方式 0微信1支付宝2银联")
    private String payType;
    @ApiModelProperty(value = "支付备注")
    private String payRemark;
    @ApiModelProperty(value = "订单创建时间")
    private Date createdTime;
    @ApiModelProperty(value = "订单创建人")
    private String creatorAccount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getBillIds() {
        return billIds;
    }

    public void setBillIds(String billIds) {
        this.billIds = billIds;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderObjType() {
        return orderObjType;
    }

    public void setOrderObjType(String orderObjType) {
        this.orderObjType = orderObjType;
    }

    public String getOrderObjId() {
        return orderObjId;
    }

    public void setOrderObjId(String orderObjId) {
        this.orderObjId = orderObjId;
    }

    public String getOrderObjName() {
        return orderObjName;
    }

    public void setOrderObjName(String orderObjName) {
        this.orderObjName = orderObjName;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayRemark() {
        return payRemark;
    }

    public void setPayRemark(String payRemark) {
        this.payRemark = payRemark;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    @Override
    public String toString() {
        return "PayOrderModel{" +
                "id='" + id + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", billIds='" + billIds + '\'' +
                ", orderName='" + orderName + '\'' +
                ", orderObjType='" + orderObjType + '\'' +
                ", orderObjId='" + orderObjId + '\'' +
                ", orderObjName='" + orderObjName + '\'' +
                ", orderAmount=" + orderAmount +
                ", payTime='" + payTime + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", payId='" + payId + '\'' +
                ", payAmount=" + payAmount +
                ", payType='" + payType + '\'' +
                ", payRemark='" + payRemark + '\'' +
                ", createdTime=" + createdTime +
                ", creatorAccount='" + creatorAccount + '\'' +
                '}';
    }
}
