package com.jn.enterprise.pay.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbPayAccountBookMoneyRecord implements Serializable {
    private String deductionId;

    private String billId;

    private String acBookId;

    private String remark;

    private String paymentMethod;

    private String paymentAction;

    private String natureCode;

    private BigDecimal money;

    private BigDecimal balance;

    private Date createdTime;

    private String creatorAccount;

    private String recordStatus;

    private Date modifiedTime;

    private String modifierAccount;

    private static final long serialVersionUID = 1L;

    public String getDeductionId() {
        return deductionId;
    }

    public void setDeductionId(String deductionId) {
        this.deductionId = deductionId == null ? null : deductionId.trim();
    }

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod == null ? null : paymentMethod.trim();
    }

    public String getPaymentAction() {
        return paymentAction;
    }

    public void setPaymentAction(String paymentAction) {
        this.paymentAction = paymentAction == null ? null : paymentAction.trim();
    }

    public String getNatureCode() {
        return natureCode;
    }

    public void setNatureCode(String natureCode) {
        this.natureCode = natureCode == null ? null : natureCode.trim();
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
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
        TbPayAccountBookMoneyRecord other = (TbPayAccountBookMoneyRecord) that;
        return (this.getDeductionId() == null ? other.getDeductionId() == null : this.getDeductionId().equals(other.getDeductionId()))
            && (this.getBillId() == null ? other.getBillId() == null : this.getBillId().equals(other.getBillId()))
            && (this.getAcBookId() == null ? other.getAcBookId() == null : this.getAcBookId().equals(other.getAcBookId()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getPaymentMethod() == null ? other.getPaymentMethod() == null : this.getPaymentMethod().equals(other.getPaymentMethod()))
            && (this.getPaymentAction() == null ? other.getPaymentAction() == null : this.getPaymentAction().equals(other.getPaymentAction()))
            && (this.getNatureCode() == null ? other.getNatureCode() == null : this.getNatureCode().equals(other.getNatureCode()))
            && (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()))
            && (this.getBalance() == null ? other.getBalance() == null : this.getBalance().equals(other.getBalance()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDeductionId() == null) ? 0 : getDeductionId().hashCode());
        result = prime * result + ((getBillId() == null) ? 0 : getBillId().hashCode());
        result = prime * result + ((getAcBookId() == null) ? 0 : getAcBookId().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getPaymentMethod() == null) ? 0 : getPaymentMethod().hashCode());
        result = prime * result + ((getPaymentAction() == null) ? 0 : getPaymentAction().hashCode());
        result = prime * result + ((getNatureCode() == null) ? 0 : getNatureCode().hashCode());
        result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
        result = prime * result + ((getBalance() == null) ? 0 : getBalance().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
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
        sb.append(", deductionId=").append(deductionId);
        sb.append(", billId=").append(billId);
        sb.append(", acBookId=").append(acBookId);
        sb.append(", remark=").append(remark);
        sb.append(", paymentMethod=").append(paymentMethod);
        sb.append(", paymentAction=").append(paymentAction);
        sb.append(", natureCode=").append(natureCode);
        sb.append(", money=").append(money);
        sb.append(", balance=").append(balance);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}