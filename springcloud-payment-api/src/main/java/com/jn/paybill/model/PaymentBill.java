package com.jn.paybill.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
    private Date billCreateTime;
    @ApiModelProperty(value = "最晚缴费时间")
    private Date payEndTime;
    @ApiModelProperty(value = "生成操作人")
    private String billCreateAccount;
    @ApiModelProperty(value = "账单说明")
    private String billRemark;
    @ApiModelProperty(value = "账单状态[0未审核1待支付2已支付待审核3确认支付]")
    private String billStatus;
    @ApiModelProperty(value = "是否已催付[0否1是]")
    private String isUrge;
    @ApiModelProperty(value = "最后一次催付时间")
    private Date urgeTime;
    @ApiModelProperty(value = "催付次数")
    private Integer urgeNum;
    @ApiModelProperty(value = "是否提醒审核 0否1是")
    private String isRemind;
    @ApiModelProperty(value = "提醒审核时间")
    private Date remindTime;
    @ApiModelProperty(value = "提醒审核ID")
    private String remindId;
    @ApiModelProperty(value = "创建时间")
    private Date createdTime;
    @ApiModelProperty(value = "创建人")
    private String creatorAccount;
    @ApiModelProperty(value = "最新更新时间")
    private Date modifiedTime;
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

    private static final long serialVersionUID = 1L;

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId == null ? null : billId.trim();
    }

    public String getBillNum() {
        return billNum;
    }

    public void setBillNum(String billNum) {
        this.billNum = billNum == null ? null : billNum.trim();
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName == null ? null : billName.trim();
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType == null ? null : billType.trim();
    }

    public String getBillObjType() {
        return billObjType;
    }

    public void setBillObjType(String billObjType) {
        this.billObjType = billObjType == null ? null : billObjType.trim();
    }

    public String getBillObjId() {
        return billObjId;
    }

    public void setBillObjId(String billObjId) {
        this.billObjId = billObjId == null ? null : billObjId.trim();
    }

    public String getBillObjName() {
        return billObjName;
    }

    public void setBillObjName(String billObjName) {
        this.billObjName = billObjName == null ? null : billObjName.trim();
    }

    public Double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
    }

    public Date getBillCreateTime() {
        return billCreateTime;
    }

    public void setBillCreateTime(Date billCreateTime) {
        this.billCreateTime = billCreateTime;
    }

    public Date getPayEndTime() {
        return payEndTime;
    }

    public void setPayEndTime(Date payEndTime) {
        this.payEndTime = payEndTime;
    }

    public String getBillCreateAccount() {
        return billCreateAccount;
    }

    public void setBillCreateAccount(String billCreateAccount) {
        this.billCreateAccount = billCreateAccount == null ? null : billCreateAccount.trim();
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
        this.isUrge = isUrge == null ? null : isUrge.trim();
    }

    public Date getUrgeTime() {
        return urgeTime;
    }

    public void setUrgeTime(Date urgeTime) {
        this.urgeTime = urgeTime;
    }

    public Integer getUrgeNum() {
        return urgeNum;
    }

    public void setUrgeNum(Integer urgeNum) {
        this.urgeNum = urgeNum;
    }

    public String getIsRemind() {
        return isRemind;
    }

    public void setIsRemind(String isRemind) {
        this.isRemind = isRemind == null ? null : isRemind.trim();
    }

    public Date getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(Date remindTime) {
        this.remindTime = remindTime;
    }

    public String getRemindId() {
        return remindId;
    }

    public void setRemindId(String remindId) {
        this.remindId = remindId == null ? null : remindId.trim();
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
        this.creatorAccount = creatorAccount == null ? null : creatorAccount.trim();
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
        this.modifierAccount = modifierAccount == null ? null : modifierAccount.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PaymentBill other = (PaymentBill) that;
        return (this.getBillId() == null ? other.getBillId() == null : this.getBillId().equals(other.getBillId()))
            && (this.getBillNum() == null ? other.getBillNum() == null : this.getBillNum().equals(other.getBillNum()))
            && (this.getBillName() == null ? other.getBillName() == null : this.getBillName().equals(other.getBillName()))
            && (this.getBillType() == null ? other.getBillType() == null : this.getBillType().equals(other.getBillType()))
            && (this.getBillObjType() == null ? other.getBillObjType() == null : this.getBillObjType().equals(other.getBillObjType()))
            && (this.getBillObjId() == null ? other.getBillObjId() == null : this.getBillObjId().equals(other.getBillObjId()))
            && (this.getBillObjName() == null ? other.getBillObjName() == null : this.getBillObjName().equals(other.getBillObjName()))
            && (this.getBillAmount() == null ? other.getBillAmount() == null : this.getBillAmount().equals(other.getBillAmount()))
            && (this.getBillCreateTime() == null ? other.getBillCreateTime() == null : this.getBillCreateTime().equals(other.getBillCreateTime()))
            && (this.getPayEndTime() == null ? other.getPayEndTime() == null : this.getPayEndTime().equals(other.getPayEndTime()))
            && (this.getBillCreateAccount() == null ? other.getBillCreateAccount() == null : this.getBillCreateAccount().equals(other.getBillCreateAccount()))
            && (this.getBillRemark() == null ? other.getBillRemark() == null : this.getBillRemark().equals(other.getBillRemark()))
            && (this.getBillStatus() == null ? other.getBillStatus() == null : this.getBillStatus().equals(other.getBillStatus()))
            && (this.getIsUrge() == null ? other.getIsUrge() == null : this.getIsUrge().equals(other.getIsUrge()))
            && (this.getUrgeTime() == null ? other.getUrgeTime() == null : this.getUrgeTime().equals(other.getUrgeTime()))
            && (this.getUrgeNum() == null ? other.getUrgeNum() == null : this.getUrgeNum().equals(other.getUrgeNum()))
            && (this.getIsRemind() == null ? other.getIsRemind() == null : this.getIsRemind().equals(other.getIsRemind()))
            && (this.getRemindTime() == null ? other.getRemindTime() == null : this.getRemindTime().equals(other.getRemindTime()))
            && (this.getRemindId() == null ? other.getRemindId() == null : this.getRemindId().equals(other.getRemindId()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBillId() == null) ? 0 : getBillId().hashCode());
        result = prime * result + ((getBillNum() == null) ? 0 : getBillNum().hashCode());
        result = prime * result + ((getBillName() == null) ? 0 : getBillName().hashCode());
        result = prime * result + ((getBillType() == null) ? 0 : getBillType().hashCode());
        result = prime * result + ((getBillObjType() == null) ? 0 : getBillObjType().hashCode());
        result = prime * result + ((getBillObjId() == null) ? 0 : getBillObjId().hashCode());
        result = prime * result + ((getBillObjName() == null) ? 0 : getBillObjName().hashCode());
        result = prime * result + ((getBillAmount() == null) ? 0 : getBillAmount().hashCode());
        result = prime * result + ((getBillCreateTime() == null) ? 0 : getBillCreateTime().hashCode());
        result = prime * result + ((getPayEndTime() == null) ? 0 : getPayEndTime().hashCode());
        result = prime * result + ((getBillCreateAccount() == null) ? 0 : getBillCreateAccount().hashCode());
        result = prime * result + ((getBillRemark() == null) ? 0 : getBillRemark().hashCode());
        result = prime * result + ((getBillStatus() == null) ? 0 : getBillStatus().hashCode());
        result = prime * result + ((getIsUrge() == null) ? 0 : getIsUrge().hashCode());
        result = prime * result + ((getUrgeTime() == null) ? 0 : getUrgeTime().hashCode());
        result = prime * result + ((getUrgeNum() == null) ? 0 : getUrgeNum().hashCode());
        result = prime * result + ((getIsRemind() == null) ? 0 : getIsRemind().hashCode());
        result = prime * result + ((getRemindTime() == null) ? 0 : getRemindTime().hashCode());
        result = prime * result + ((getRemindId() == null) ? 0 : getRemindId().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", billId=").append(billId);
        sb.append(", billNum=").append(billNum);
        sb.append(", billName=").append(billName);
        sb.append(", billType=").append(billType);
        sb.append(", billObjType=").append(billObjType);
        sb.append(", billObjId=").append(billObjId);
        sb.append(", billObjName=").append(billObjName);
        sb.append(", billAmount=").append(billAmount);
        sb.append(", billCreateTime=").append(billCreateTime);
        sb.append(", payEndTime=").append(payEndTime);
        sb.append(", billCreateAccount=").append(billCreateAccount);
        sb.append(", billRemark=").append(billRemark);
        sb.append(", billStatus=").append(billStatus);
        sb.append(", isUrge=").append(isUrge);
        sb.append(", urgeTime=").append(urgeTime);
        sb.append(", urgeNum=").append(urgeNum);
        sb.append(", isRemind=").append(isRemind);
        sb.append(", remindTime=").append(remindTime);
        sb.append(", remindId=").append(remindId);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}