package com.jn.user.point.entity;

import java.io.Serializable;
import java.util.Date;

public class TbUserPointDetail implements Serializable {
    private String id;

    private String userAccount;

    private String ruleTypeName;

    private String ruleTypeId;

    private String pointtype;

    private Double pointNum;

    private Double pointBalance;

    private Date createdTime;

    private String creatorAccount;

    private Date modifiedTime;

    private String modifierAccount;

    private Byte recordStatus;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getRuleTypeName() {
        return ruleTypeName;
    }

    public void setRuleTypeName(String ruleTypeName) {
        this.ruleTypeName = ruleTypeName == null ? null : ruleTypeName.trim();
    }

    public String getRuleTypeId() {
        return ruleTypeId;
    }

    public void setRuleTypeId(String ruleTypeId) {
        this.ruleTypeId = ruleTypeId == null ? null : ruleTypeId.trim();
    }

    public String getPointtype() {
        return pointtype;
    }

    public void setPointtype(String pointtype) {
        this.pointtype = pointtype == null ? null : pointtype.trim();
    }

    public Double getPointNum() {
        return pointNum;
    }

    public void setPointNum(Double pointNum) {
        this.pointNum = pointNum;
    }

    public Double getPointBalance() {
        return pointBalance;
    }

    public void setPointBalance(Double pointBalance) {
        this.pointBalance = pointBalance;
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
        TbUserPointDetail other = (TbUserPointDetail) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserAccount() == null ? other.getUserAccount() == null : this.getUserAccount().equals(other.getUserAccount()))
            && (this.getRuleTypeName() == null ? other.getRuleTypeName() == null : this.getRuleTypeName().equals(other.getRuleTypeName()))
            && (this.getRuleTypeId() == null ? other.getRuleTypeId() == null : this.getRuleTypeId().equals(other.getRuleTypeId()))
            && (this.getPointtype() == null ? other.getPointtype() == null : this.getPointtype().equals(other.getPointtype()))
            && (this.getPointNum() == null ? other.getPointNum() == null : this.getPointNum().equals(other.getPointNum()))
            && (this.getPointBalance() == null ? other.getPointBalance() == null : this.getPointBalance().equals(other.getPointBalance()))
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
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserAccount() == null) ? 0 : getUserAccount().hashCode());
        result = prime * result + ((getRuleTypeName() == null) ? 0 : getRuleTypeName().hashCode());
        result = prime * result + ((getRuleTypeId() == null) ? 0 : getRuleTypeId().hashCode());
        result = prime * result + ((getPointtype() == null) ? 0 : getPointtype().hashCode());
        result = prime * result + ((getPointNum() == null) ? 0 : getPointNum().hashCode());
        result = prime * result + ((getPointBalance() == null) ? 0 : getPointBalance().hashCode());
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
        sb.append(", id=").append(id);
        sb.append(", userAccount=").append(userAccount);
        sb.append(", ruleTypeName=").append(ruleTypeName);
        sb.append(", ruleTypeId=").append(ruleTypeId);
        sb.append(", pointtype=").append(pointtype);
        sb.append(", pointNum=").append(pointNum);
        sb.append(", pointBalance=").append(pointBalance);
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