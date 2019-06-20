package com.jn.park.gamtopic.entity;

import java.io.Serializable;
import java.util.Date;

public class TbPersonCare implements Serializable {
    private String careId;

    private String careAccount;

    private String receiveAccount;

    private String receiveType;

    private Date createdTime;

    private String creatorAccount;

    private Date modifiedTime;

    private String modifierAccount;

    private Byte recordStatus;

    private static final long serialVersionUID = 1L;

    public String getCareId() {
        return careId;
    }

    public void setCareId(String careId) {
        this.careId = careId == null ? null : careId.trim();
    }

    public String getCareAccount() {
        return careAccount;
    }

    public void setCareAccount(String careAccount) {
        this.careAccount = careAccount == null ? null : careAccount.trim();
    }

    public String getReceiveAccount() {
        return receiveAccount;
    }

    public void setReceiveAccount(String receiveAccount) {
        this.receiveAccount = receiveAccount == null ? null : receiveAccount.trim();
    }

    public String getReceiveType() {
        return receiveType;
    }

    public void setReceiveType(String receiveType) {
        this.receiveType = receiveType == null ? null : receiveType.trim();
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
        TbPersonCare other = (TbPersonCare) that;
        return (this.getCareId() == null ? other.getCareId() == null : this.getCareId().equals(other.getCareId()))
            && (this.getCareAccount() == null ? other.getCareAccount() == null : this.getCareAccount().equals(other.getCareAccount()))
            && (this.getReceiveAccount() == null ? other.getReceiveAccount() == null : this.getReceiveAccount().equals(other.getReceiveAccount()))
            && (this.getReceiveType() == null ? other.getReceiveType() == null : this.getReceiveType().equals(other.getReceiveType()))
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
        result = prime * result + ((getCareId() == null) ? 0 : getCareId().hashCode());
        result = prime * result + ((getCareAccount() == null) ? 0 : getCareAccount().hashCode());
        result = prime * result + ((getReceiveAccount() == null) ? 0 : getReceiveAccount().hashCode());
        result = prime * result + ((getReceiveType() == null) ? 0 : getReceiveType().hashCode());
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
        sb.append(", careId=").append(careId);
        sb.append(", careAccount=").append(careAccount);
        sb.append(", receiveAccount=").append(receiveAccount);
        sb.append(", receiveType=").append(receiveType);
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