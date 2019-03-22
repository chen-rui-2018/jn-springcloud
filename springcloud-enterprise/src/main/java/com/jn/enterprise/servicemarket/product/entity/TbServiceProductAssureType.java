package com.jn.enterprise.servicemarket.product.entity;

import java.io.Serializable;
import java.util.Date;

public class TbServiceProductAssureType implements Serializable {
    private String assureCode;

    private String assureName;

    private Date createdTime;

    private String creatorAccount;

    private Date modifiedTime;

    private String modifierAccount;

    private Byte recordStatus;

    private static final long serialVersionUID = 1L;

    public String getAssureCode() {
        return assureCode;
    }

    public void setAssureCode(String assureCode) {
        this.assureCode = assureCode == null ? null : assureCode.trim();
    }

    public String getAssureName() {
        return assureName;
    }

    public void setAssureName(String assureName) {
        this.assureName = assureName == null ? null : assureName.trim();
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
        TbServiceProductAssureType other = (TbServiceProductAssureType) that;
        return (this.getAssureCode() == null ? other.getAssureCode() == null : this.getAssureCode().equals(other.getAssureCode()))
            && (this.getAssureName() == null ? other.getAssureName() == null : this.getAssureName().equals(other.getAssureName()))
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
        result = prime * result + ((getAssureCode() == null) ? 0 : getAssureCode().hashCode());
        result = prime * result + ((getAssureName() == null) ? 0 : getAssureName().hashCode());
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
        sb.append(", assureCode=").append(assureCode);
        sb.append(", assureName=").append(assureName);
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