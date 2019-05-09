package com.jn.enterprise.pay.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbPayBill implements Serializable {
    private String billId;

    private String acBookId;

    private String billName;

    private String billSource;

    private BigDecimal billExpense;

    private Integer reminderNumber;

    private String objType;

    private String objName;

    private String paymentState;

    private String paymentType;

    private String acBookType;

    private Date createdTime;

    private String creatorAccount;

    private Date modifiedTime;

    private String modifierAccount;

    private Date latePayment;

    private String paymentAffirm;

    private String affirmPart;

    private Date affirmTime;

    private String recordStatus;

    private static final long serialVersionUID = 1L;

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId == null ? null : billId.trim();
    }

    public String getAcBookId() {
        return acBookId;
    }

    public void setAcBookId(String acBookId) {
        this.acBookId = acBookId == null ? null : acBookId.trim();
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName == null ? null : billName.trim();
    }

    public String getBillSource() {
        return billSource;
    }

    public void setBillSource(String billSource) {
        this.billSource = billSource == null ? null : billSource.trim();
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
        this.objType = objType == null ? null : objType.trim();
    }

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName == null ? null : objName.trim();
    }

    public String getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(String paymentState) {
        this.paymentState = paymentState == null ? null : paymentState.trim();
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType == null ? null : paymentType.trim();
    }

    public String getAcBookType() {
        return acBookType;
    }

    public void setAcBookType(String acBookType) {
        this.acBookType = acBookType == null ? null : acBookType.trim();
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
        this.paymentAffirm = paymentAffirm == null ? null : paymentAffirm.trim();
    }

    public String getAffirmPart() {
        return affirmPart;
    }

    public void setAffirmPart(String affirmPart) {
        this.affirmPart = affirmPart == null ? null : affirmPart.trim();
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
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
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
        TbPayBill other = (TbPayBill) that;
        return (this.getBillId() == null ? other.getBillId() == null : this.getBillId().equals(other.getBillId()))
            && (this.getAcBookId() == null ? other.getAcBookId() == null : this.getAcBookId().equals(other.getAcBookId()))
            && (this.getBillName() == null ? other.getBillName() == null : this.getBillName().equals(other.getBillName()))
            && (this.getBillSource() == null ? other.getBillSource() == null : this.getBillSource().equals(other.getBillSource()))
            && (this.getBillExpense() == null ? other.getBillExpense() == null : this.getBillExpense().equals(other.getBillExpense()))
            && (this.getReminderNumber() == null ? other.getReminderNumber() == null : this.getReminderNumber().equals(other.getReminderNumber()))
            && (this.getObjType() == null ? other.getObjType() == null : this.getObjType().equals(other.getObjType()))
            && (this.getObjName() == null ? other.getObjName() == null : this.getObjName().equals(other.getObjName()))
            && (this.getPaymentState() == null ? other.getPaymentState() == null : this.getPaymentState().equals(other.getPaymentState()))
            && (this.getPaymentType() == null ? other.getPaymentType() == null : this.getPaymentType().equals(other.getPaymentType()))
            && (this.getAcBookType() == null ? other.getAcBookType() == null : this.getAcBookType().equals(other.getAcBookType()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getLatePayment() == null ? other.getLatePayment() == null : this.getLatePayment().equals(other.getLatePayment()))
            && (this.getPaymentAffirm() == null ? other.getPaymentAffirm() == null : this.getPaymentAffirm().equals(other.getPaymentAffirm()))
            && (this.getAffirmPart() == null ? other.getAffirmPart() == null : this.getAffirmPart().equals(other.getAffirmPart()))
            && (this.getAffirmTime() == null ? other.getAffirmTime() == null : this.getAffirmTime().equals(other.getAffirmTime()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBillId() == null) ? 0 : getBillId().hashCode());
        result = prime * result + ((getAcBookId() == null) ? 0 : getAcBookId().hashCode());
        result = prime * result + ((getBillName() == null) ? 0 : getBillName().hashCode());
        result = prime * result + ((getBillSource() == null) ? 0 : getBillSource().hashCode());
        result = prime * result + ((getBillExpense() == null) ? 0 : getBillExpense().hashCode());
        result = prime * result + ((getReminderNumber() == null) ? 0 : getReminderNumber().hashCode());
        result = prime * result + ((getObjType() == null) ? 0 : getObjType().hashCode());
        result = prime * result + ((getObjName() == null) ? 0 : getObjName().hashCode());
        result = prime * result + ((getPaymentState() == null) ? 0 : getPaymentState().hashCode());
        result = prime * result + ((getPaymentType() == null) ? 0 : getPaymentType().hashCode());
        result = prime * result + ((getAcBookType() == null) ? 0 : getAcBookType().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getLatePayment() == null) ? 0 : getLatePayment().hashCode());
        result = prime * result + ((getPaymentAffirm() == null) ? 0 : getPaymentAffirm().hashCode());
        result = prime * result + ((getAffirmPart() == null) ? 0 : getAffirmPart().hashCode());
        result = prime * result + ((getAffirmTime() == null) ? 0 : getAffirmTime().hashCode());
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
        sb.append(", acBookId=").append(acBookId);
        sb.append(", billName=").append(billName);
        sb.append(", billSource=").append(billSource);
        sb.append(", billExpense=").append(billExpense);
        sb.append(", reminderNumber=").append(reminderNumber);
        sb.append(", objType=").append(objType);
        sb.append(", objName=").append(objName);
        sb.append(", paymentState=").append(paymentState);
        sb.append(", paymentType=").append(paymentType);
        sb.append(", acBookType=").append(acBookType);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", latePayment=").append(latePayment);
        sb.append(", paymentAffirm=").append(paymentAffirm);
        sb.append(", affirmPart=").append(affirmPart);
        sb.append(", affirmTime=").append(affirmTime);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}