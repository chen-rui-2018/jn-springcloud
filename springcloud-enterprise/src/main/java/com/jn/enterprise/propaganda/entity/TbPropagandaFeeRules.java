package com.jn.enterprise.propaganda.entity;

import java.io.Serializable;
import java.util.Date;

public class TbPropagandaFeeRules implements Serializable {
    private String proFeeRuleCode;

    private Double propagandaFee;

    private Date createdTime;

    private String creatorAccount;

    private Date modifiedTime;

    private String modifierAccount;

    private Byte recordStatus;

    private String proFeeRuleDetails;

    private static final long serialVersionUID = 1L;

    public String getProFeeRuleCode() {
        return proFeeRuleCode;
    }

    public void setProFeeRuleCode(String proFeeRuleCode) {
        this.proFeeRuleCode = proFeeRuleCode == null ? null : proFeeRuleCode.trim();
    }

    public Double getPropagandaFee() {
        return propagandaFee;
    }

    public void setPropagandaFee(Double propagandaFee) {
        this.propagandaFee = propagandaFee;
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

    public String getProFeeRuleDetails() {
        return proFeeRuleDetails;
    }

    public void setProFeeRuleDetails(String proFeeRuleDetails) {
        this.proFeeRuleDetails = proFeeRuleDetails == null ? null : proFeeRuleDetails.trim();
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
        TbPropagandaFeeRules other = (TbPropagandaFeeRules) that;
        return (this.getProFeeRuleCode() == null ? other.getProFeeRuleCode() == null : this.getProFeeRuleCode().equals(other.getProFeeRuleCode()))
            && (this.getPropagandaFee() == null ? other.getPropagandaFee() == null : this.getPropagandaFee().equals(other.getPropagandaFee()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getProFeeRuleDetails() == null ? other.getProFeeRuleDetails() == null : this.getProFeeRuleDetails().equals(other.getProFeeRuleDetails()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProFeeRuleCode() == null) ? 0 : getProFeeRuleCode().hashCode());
        result = prime * result + ((getPropagandaFee() == null) ? 0 : getPropagandaFee().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getProFeeRuleDetails() == null) ? 0 : getProFeeRuleDetails().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", proFeeRuleCode=").append(proFeeRuleCode);
        sb.append(", propagandaFee=").append(propagandaFee);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", proFeeRuleDetails=").append(proFeeRuleDetails);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}