package com.jn.paybill.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 账单详情VO
 * @author： jiangyl
 * @date： Created on 2019/3/12 15:49
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayBillVO", description = "账单详情VO")
public class PayBillVO implements Serializable {
    @ApiModelProperty(value = "账单ID")
    private String billId;
    @ApiModelProperty(value = "账单编号")
    private String billNum;
    @ApiModelProperty(value = "账单名称")
    private String billName;
    @ApiModelProperty(value = "账单类型ID")
    private String billType;
    @ApiModelProperty(value = "账单类型名称")
    private String billTypeName;
    @ApiModelProperty(value = "账单对象ID")
    private String billObjId;
    @ApiModelProperty(value = "账单金额")
    private Double billAmount;
    @ApiModelProperty(value = "账单生成时间[yyyy-MM-dd HH:mm:ss]")
    private String billCreateTime;
    @ApiModelProperty(value = "最晚缴费时间[yyyy-MM-dd HH:mm:ss]")
    private String payEndTime;
    @ApiModelProperty(value = "生成操作人")
    private String billCreateAccount;
    @ApiModelProperty(value = "账单说明")
    private String billRemark;
    @ApiModelProperty(value = "账单状态[0未审核1待支付2已支付待审核3确认支付]")
    private String billStatus;
    @ApiModelProperty(value = "是否已催付[0否1是]")
    private String isUrge;
    @ApiModelProperty(value = "支付订单标识")
    private String orderId;
    @ApiModelProperty(value = "支付订单编号")
    private String orderNum;
    @ApiModelProperty(value = "支付订单名称")
    private String orderName;
    @ApiModelProperty(value = "订单支付总金额")
    private Double orderAmount;
    @ApiModelProperty(value = "订单支付时间")
    private Date payTime;
    @ApiModelProperty(value = "订单支付状态[0未支付1已支付]")
    private String orderStatus;
    @ApiModelProperty(value = "支付平台订单编号")
    private String payId;
    @ApiModelProperty(value = "实际支付总金额")
    private Double payAmount;
    @ApiModelProperty(value = "支付方式[0微信1支付宝2银联]")
    private String payType;
    @ApiModelProperty(value = "订单支付说明")
    private String payRemark;

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getBillNum() {
        return billNum;
    }

    public void setBillNum(String billNum) {
        this.billNum = billNum;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getBillObjId() {
        return billObjId;
    }

    public void setBillObjId(String billObjId) {
        this.billObjId = billObjId;
    }

    public Double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
    }

    public String getBillCreateTime() {
        return billCreateTime;
    }

    public void setBillCreateTime(String billCreateTime) {
        this.billCreateTime = billCreateTime;
    }

    public String getPayEndTime() {
        return payEndTime;
    }

    public void setPayEndTime(String payEndTime) {
        this.payEndTime = payEndTime;
    }

    public String getBillCreateAccount() {
        return billCreateAccount;
    }

    public void setBillCreateAccount(String billCreateAccount) {
        this.billCreateAccount = billCreateAccount;
    }

    public String getBillRemark() {
        return billRemark;
    }

    public void setBillRemark(String billRemark) {
        this.billRemark = billRemark;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }

    public String getIsUrge() {
        return isUrge;
    }

    public void setIsUrge(String isUrge) {
        this.isUrge = isUrge;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
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

    public String getBillTypeName() {
        return billTypeName;
    }

    public void setBillTypeName(String billTypeName) {
        this.billTypeName = billTypeName;
    }
}
