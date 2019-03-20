package com.jn.unionpay.paybill.entity;

import java.io.Serializable;
import java.util.Date;

public class TbPaymentBill implements Serializable {
    private String billId;

    private String billNum;

    private String billName;

    private String billType;

    private String billObjType;

    private String billObjId;

    private String billObjName;

    private Double billAmount;

    private Date billCreateTime;

    private Date payEndTime;

    private String billCreateAccount;

    private String billRemark;

    private String billStatus;

    private String billPayType;

    private String orderId;

    private String isUrge;

    private Date urgeTime;

    private Integer urgeNum;

    private String isRemind;

    private Date remindTime;

    private String remindId;

    private String checkAccount;

    private Date checkTime;

    private String checkRemark;

    private Date createdTime;

    private String creatorAccount;

    private Date modifiedTime;

    private String modifierAccount;

    private Byte recordStatus;

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
        this.billRemark = billRemark == null ? null : billRemark.trim();
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus == null ? null : billStatus.trim();
    }

    public String getBillPayType() {
        return billPayType;
    }

    public void setBillPayType(String billPayType) {
        this.billPayType = billPayType == null ? null : billPayType.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
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

    public String getCheckAccount() {
        return checkAccount;
    }

    public void setCheckAccount(String checkAccount) {
        this.checkAccount = checkAccount == null ? null : checkAccount.trim();
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getCheckRemark() {
        return checkRemark;
    }

    public void setCheckRemark(String checkRemark) {
        this.checkRemark = checkRemark == null ? null : checkRemark.trim();
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

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
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
        TbPaymentBill other = (TbPaymentBill) that;
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
            && (this.getBillPayType() == null ? other.getBillPayType() == null : this.getBillPayType().equals(other.getBillPayType()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getIsUrge() == null ? other.getIsUrge() == null : this.getIsUrge().equals(other.getIsUrge()))
            && (this.getUrgeTime() == null ? other.getUrgeTime() == null : this.getUrgeTime().equals(other.getUrgeTime()))
            && (this.getUrgeNum() == null ? other.getUrgeNum() == null : this.getUrgeNum().equals(other.getUrgeNum()))
            && (this.getIsRemind() == null ? other.getIsRemind() == null : this.getIsRemind().equals(other.getIsRemind()))
            && (this.getRemindTime() == null ? other.getRemindTime() == null : this.getRemindTime().equals(other.getRemindTime()))
            && (this.getRemindId() == null ? other.getRemindId() == null : this.getRemindId().equals(other.getRemindId()))
            && (this.getCheckAccount() == null ? other.getCheckAccount() == null : this.getCheckAccount().equals(other.getCheckAccount()))
            && (this.getCheckTime() == null ? other.getCheckTime() == null : this.getCheckTime().equals(other.getCheckTime()))
            && (this.getCheckRemark() == null ? other.getCheckRemark() == null : this.getCheckRemark().equals(other.getCheckRemark()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()));
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
        result = prime * result + ((getBillPayType() == null) ? 0 : getBillPayType().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getIsUrge() == null) ? 0 : getIsUrge().hashCode());
        result = prime * result + ((getUrgeTime() == null) ? 0 : getUrgeTime().hashCode());
        result = prime * result + ((getUrgeNum() == null) ? 0 : getUrgeNum().hashCode());
        result = prime * result + ((getIsRemind() == null) ? 0 : getIsRemind().hashCode());
        result = prime * result + ((getRemindTime() == null) ? 0 : getRemindTime().hashCode());
        result = prime * result + ((getRemindId() == null) ? 0 : getRemindId().hashCode());
        result = prime * result + ((getCheckAccount() == null) ? 0 : getCheckAccount().hashCode());
        result = prime * result + ((getCheckTime() == null) ? 0 : getCheckTime().hashCode());
        result = prime * result + ((getCheckRemark() == null) ? 0 : getCheckRemark().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
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
        sb.append(", billPayType=").append(billPayType);
        sb.append(", orderId=").append(orderId);
        sb.append(", isUrge=").append(isUrge);
        sb.append(", urgeTime=").append(urgeTime);
        sb.append(", urgeNum=").append(urgeNum);
        sb.append(", isRemind=").append(isRemind);
        sb.append(", remindTime=").append(remindTime);
        sb.append(", remindId=").append(remindId);
        sb.append(", checkAccount=").append(checkAccount);
        sb.append(", checkTime=").append(checkTime);
        sb.append(", checkRemark=").append(checkRemark);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}