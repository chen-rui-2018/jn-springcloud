package com.jn.paybill.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * 缴费账单
 * @author： jiangyl
 * @date： Created on 2019/3/12 11:22
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PaymentBill", description = "缴费账单")
public class PaymentBill implements Serializable {
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
    @ApiModelProperty(value = "账单对象类型")
    private String billObjType;
    @ApiModelProperty(value = "账单对象ID")
    private String billObjId;
    @ApiModelProperty(value = "账单对象名")
    private String billObjName;
    @ApiModelProperty(value = "账单金额")
    private Double billAmount;
    @ApiModelProperty(value = "账单生成时间")
    private String billCreateTime;
    @ApiModelProperty(value = "最晚缴费时间")
    private String payEndTime;
    @ApiModelProperty(value = "生成操作人")
    private String billCreateAccount;
    @ApiModelProperty(value = "账单说明")
    private String billRemark;
    @ApiModelProperty(value = "账单状态[0未审核1待支付2已支付待审核3支付失败4确认支付5支付审核不通过]")
    private String billStatus;
    @ApiModelProperty(value = "是否已催付[0否1是]")
    private String isUrge;
    @ApiModelProperty(value = "最后一次催付时间")
    private String urgeTime;
    @ApiModelProperty(value = "催付次数")
    private Integer urgeNum;
    @ApiModelProperty(value = "支付方式(10线上 11线下)")
    private String billPayType;
    @ApiModelProperty(value = "是否提醒审核 0否1是")
    private String isRemind;
    @ApiModelProperty(value = "提醒审核时间")
    private String remindTime;
    @ApiModelProperty(value = "提醒审核ID")
    private String remindId;
    @ApiModelProperty(value = "创建时间")
    private String createdTime;
    @ApiModelProperty(value = "创建人")
    private String creatorAccount;
    @ApiModelProperty(value = "最新更新时间")
    private String modifiedTime;
    @ApiModelProperty(value = "最新更新者账号")
    private String modifierAccount;

    @ApiModelProperty(value = "支付订单标识")
    private String orderId;
    @ApiModelProperty(value = "支付订单编号")
    private String orderNum;
    @ApiModelProperty(value = "支付订单名称")
    private String orderName;
    @ApiModelProperty(value = "订单支付总金额")
    private Double orderAmount;
    @ApiModelProperty(value = "订单支付时间")
    private String payTime;
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

    private static final long serialVersionUID = 1L;


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

    public String getBillTypeName() {
        return billTypeName;
    }

    public void setBillTypeName(String billTypeName) {
        this.billTypeName = billTypeName;
    }

    public String getBillObjType() {
        return billObjType;
    }

    public void setBillObjType(String billObjType) {
        this.billObjType = billObjType;
    }

    public String getBillObjId() {
        return billObjId;
    }

    public void setBillObjId(String billObjId) {
        this.billObjId = billObjId;
    }

    public String getBillObjName() {
        return billObjName;
    }

    public void setBillObjName(String billObjName) {
        this.billObjName = billObjName;
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

    public String getUrgeTime() {
        return urgeTime;
    }

    public void setUrgeTime(String urgeTime) {
        this.urgeTime = urgeTime;
    }

    public Integer getUrgeNum() {
        return urgeNum;
    }

    public void setUrgeNum(Integer urgeNum) {
        this.urgeNum = urgeNum;
    }

    public String getBillPayType() {
        return billPayType;
    }

    public void setBillPayType(String billPayType) {
        this.billPayType = billPayType;
    }

    public String getIsRemind() {
        return isRemind;
    }

    public void setIsRemind(String isRemind) {
        this.isRemind = isRemind;
    }

    public String getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(String remindTime) {
        this.remindTime = remindTime;
    }

    public String getRemindId() {
        return remindId;
    }

    public void setRemindId(String remindId) {
        this.remindId = remindId;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount;
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
}