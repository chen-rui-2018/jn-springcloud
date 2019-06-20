package com.jn.enterprise.pay.entity;

import java.io.Serializable;
import java.util.Date;

public class TbPayAccountBookType implements Serializable {
    private String acBookType;

    private String acBookDesc;

    private String acBookScope;

    private String creatorAccount;

    private Date createdTime;

    private String modifierAccount;

    private Date modifiedTime;

    private String recordStatus;

    private static final long serialVersionUID = 1L;

    public String getAcBookType() {
        return acBookType;
    }

    public void setAcBookType(String acBookType) {
        this.acBookType = acBookType == null ? null : acBookType.trim();
    }

    public String getAcBookDesc() {
        return acBookDesc;
    }

    public void setAcBookDesc(String acBookDesc) {
        this.acBookDesc = acBookDesc == null ? null : acBookDesc.trim();
    }

    public String getAcBookScope() {
        return acBookScope;
    }

    public void setAcBookScope(String acBookScope) {
        this.acBookScope = acBookScope == null ? null : acBookScope.trim();
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount == null ? null : creatorAccount.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount == null ? null : modifierAccount.trim();
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
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
        TbPayAccountBookType other = (TbPayAccountBookType) that;
        return (this.getAcBookType() == null ? other.getAcBookType() == null : this.getAcBookType().equals(other.getAcBookType()))
            && (this.getAcBookDesc() == null ? other.getAcBookDesc() == null : this.getAcBookDesc().equals(other.getAcBookDesc()))
            && (this.getAcBookScope() == null ? other.getAcBookScope() == null : this.getAcBookScope().equals(other.getAcBookScope()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAcBookType() == null) ? 0 : getAcBookType().hashCode());
        result = prime * result + ((getAcBookDesc() == null) ? 0 : getAcBookDesc().hashCode());
        result = prime * result + ((getAcBookScope() == null) ? 0 : getAcBookScope().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", acBookType=").append(acBookType);
        sb.append(", acBookDesc=").append(acBookDesc);
        sb.append(", acBookScope=").append(acBookScope);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}