package com.jn.pay.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 账单实体类
 *
 * @author： wzy
 * @date： Created on 2019/4/29 20:59
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayBill" ,description = "账单实体类")
public class PayBill extends Page implements Serializable {
    private static final long serialVersionUID = -3611813821244989233L;

    @ApiModelProperty(value="账单编号")
    private String billId;

    @ApiModelProperty(value="账本ID")
    private String acBookId;

    @ApiModelProperty(value="账单名称")
    private String billName;

    @ApiModelProperty(value="账单来源")
    private String billSource;

    @ApiModelProperty(value="账单费用")
    private BigDecimal billExpense;

    @ApiModelProperty(value="催缴次数")
    private Integer reminderNumber;

    @ApiModelProperty(value="对象类型")
    private String objType;

    @ApiModelProperty(value="对象名称",example = "wangsong")
    @NotNull(message = "对象名称不能为空")
    private String objName;

    @ApiModelProperty(value="支付状态（如 1：已支付、2：待支付）")
    private String paymentState;

    @ApiModelProperty(value="支付平台类型（1：线上或2：线下）")
    private String paymentType;

    @ApiModelProperty(value="账本类型ID")
    private String acBookType;

    @ApiModelProperty(value="统一下单号")
    private String orderNumber;

    @ApiModelProperty(value="账单接收者")
    private String billReceiver;

    @ApiModelProperty(value="创建时间")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    @ApiModelProperty(value="创建人")
    private String creatorAccount;

    @ApiModelProperty(value="修改时间")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;

    @ApiModelProperty(value="修改人")
    private String modifierAccount;

    @ApiModelProperty(value="最迟缴费时间")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date latePayment;

    @ApiModelProperty(value="确认结果（财务部缴费确认）")
    private String paymentAffirm;

    @ApiModelProperty(value="确认操作员")
    private String affirmPart;

    @ApiModelProperty(value="确认时间")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date affirmTime;

    @ApiModelProperty(value="记录状态   0标记删除，1正常")
    private String recordStatus;


    public String getBillReceiver() {
        return billReceiver;
    }

    public void setBillReceiver(String billReceiver) {
        this.billReceiver = billReceiver;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getAcBookId() {
        return acBookId;
    }

    public void setAcBookId(String acBookId) {
        this.acBookId = acBookId;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public String getBillSource() {
        return billSource;
    }

    public void setBillSource(String billSource) {
        this.billSource = billSource;
    }

    public BigDecimal getBillExpense() {
        return billExpense;
    }

    public void setBillExpense(BigDecimal billExpense) {
        this.billExpense = billExpense;
    }

    public Integer getReminderNumber() {
        return reminderNumber;
    }

    public void setReminderNumber(Integer reminderNumber) {
        this.reminderNumber = reminderNumber;
    }

    public String getObjType() {
        return objType;
    }

    public void setObjType(String objType) {
        this.objType = objType;
    }

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public String getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(String paymentState) {
        this.paymentState = paymentState;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getAcBookType() {
        return acBookType;
    }

    public void setAcBookType(String acBookType) {
        this.acBookType = acBookType;
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

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount;
    }

    public Date getLatePayment() {
        return latePayment;
    }

    public void setLatePayment(Date latePayment) {
        this.latePayment = latePayment;
    }

    public String getPaymentAffirm() {
        return paymentAffirm;
    }

    public void setPaymentAffirm(String paymentAffirm) {
        this.paymentAffirm = paymentAffirm;
    }

    public String getAffirmPart() {
        return affirmPart;
    }

    public void setAffirmPart(String affirmPart) {
        this.affirmPart = affirmPart;
    }

    public Date getAffirmTime() {
        return affirmTime;
    }

    public void setAffirmTime(Date affirmTime) {
        this.affirmTime = affirmTime;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }
}
