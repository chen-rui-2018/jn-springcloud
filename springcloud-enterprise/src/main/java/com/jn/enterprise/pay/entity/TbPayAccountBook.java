package com.jn.enterprise.pay.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbPayAccountBook implements Serializable {
    private String acBookId;

    private String accountId;

    private String acBookName;

    private String acBookType;

    private BigDecimal balance;

    private String automaticDeductions;

    private String canRecharge;

    private String isShow;

    private Date createdTime;

    private String creatorAccount;

    private Date modifiedTime;

    private String modifierAccount;

    private String recordStatus;

    private String entId;

    private static final long serialVersionUID = 1L;

    public String getAcBookId() {
        return acBookId;
    }

    public void setAcBookId(String acBookId) {
        this.acBookId = acBookId == null ? null : acBookId.trim();
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    public String getAcBookName() {
        return acBookName;
    }

    public void setAcBookName(String acBookName) {
        this.acBookName = acBookName == null ? null : acBookName.trim();
    }

    public String getAcBookType() {
        return acBookType;
    }

    public void setAcBookType(String acBookType) {
        this.acBookType = acBookType == null ? null : acBookType.trim();
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAutomaticDeductions() {
        return automaticDeductions;
    }

    public void setAutomaticDeductions(String automaticDeductions) {
        this.automaticDeductions = automaticDeductions == null ? null : automaticDeductions.trim();
    }

    public String getCanRecharge() {
        return canRecharge;
    }

    public void setCanRecharge(String canRecharge) {
        this.canRecharge = canRecharge == null ? null : canRecharge.trim();
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow == null ? null : isShow.trim();
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

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    public String getEntId() {
        return entId;
    }

    public void setEntId(String entId) {
        this.entId = entId == null ? null : entId.trim();
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
        TbPayAccountBook other = (TbPayAccountBook) that;
        return (this.getAcBookId() == null ? other.getAcBookId() == null : this.getAcBookId().equals(other.getAcBookId()))
            && (this.getAccountId() == null ? other.getAccountId() == null : this.getAccountId().equals(other.getAccountId()))
            && (this.getAcBookName() == null ? other.getAcBookName() == null : this.getAcBookName().equals(other.getAcBookName()))
            && (this.getAcBookType() == null ? other.getAcBookType() == null : this.getAcBookType().equals(other.getAcBookType()))
            && (this.getBalance() == null ? other.getBalance() == null : this.getBalance().equals(other.getBalance()))
            && (this.getAutomaticDeductions() == null ? other.getAutomaticDeductions() == null : this.getAutomaticDeductions().equals(other.getAutomaticDeductions()))
            && (this.getCanRecharge() == null ? other.getCanRecharge() == null : this.getCanRecharge().equals(other.getCanRecharge()))
            && (this.getIsShow() == null ? other.getIsShow() == null : this.getIsShow().equals(other.getIsShow()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getEntId() == null ? other.getEntId() == null : this.getEntId().equals(other.getEntId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAcBookId() == null) ? 0 : getAcBookId().hashCode());
        result = prime * result + ((getAccountId() == null) ? 0 : getAccountId().hashCode());
        result = prime * result + ((getAcBookName() == null) ? 0 : getAcBookName().hashCode());
        result = prime * result + ((getAcBookType() == null) ? 0 : getAcBookType().hashCode());
        result = prime * result + ((getBalance() == null) ? 0 : getBalance().hashCode());
        result = prime * result + ((getAutomaticDeductions() == null) ? 0 : getAutomaticDeductions().hashCode());
        result = prime * result + ((getCanRecharge() == null) ? 0 : getCanRecharge().hashCode());
        result = prime * result + ((getIsShow() == null) ? 0 : getIsShow().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getEntId() == null) ? 0 : getEntId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", acBookId=").append(acBookId);
        sb.append(", accountId=").append(accountId);
        sb.append(", acBookName=").append(acBookName);
        sb.append(", acBookType=").append(acBookType);
        sb.append(", balance=").append(balance);
        sb.append(", automaticDeductions=").append(automaticDeductions);
        sb.append(", canRecharge=").append(canRecharge);
        sb.append(", isShow=").append(isShow);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", entId=").append(entId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}