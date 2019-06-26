package com.jn.pay.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 查询账单对象组合实体类
 *
 * @author： wzy
 * @date： Created on 2019/5/15 20:24
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayBillReturnParamVo" ,description = "查询账单对象组合实体类")
public class PayBillReturnParamVo implements Serializable {
    private static final long serialVersionUID = 4723387225209565240L;

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

    @ApiModelProperty(value="对象ID")
    private String objId;

    @ApiModelProperty(value="对象名称")
    private String objName;

    @ApiModelProperty(value="支付状态（如 1:已支付、2:待支付、2:已撤销）")
    private String paymentState;

    @ApiModelProperty(value="账本类型ID")
    private String acBookType;

    @ApiModelProperty(value="缴费类型")
    private String payType;

    @ApiModelProperty(value="创建时间")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    @ApiModelProperty(value="创建人")
    private String creatorAccount;

    @ApiModelProperty(value="最迟缴费时间")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date latePayment;

    @ApiModelProperty(value="记录状态   0标记删除，1正常")
    private String recordStatus;

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

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
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

    public Date getLatePayment() {
        return latePayment;
    }

    public void setLatePayment(Date latePayment) {
        this.latePayment = latePayment;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }
}
