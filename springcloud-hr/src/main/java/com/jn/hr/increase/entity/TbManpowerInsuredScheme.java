package com.jn.hr.increase.entity;

import java.io.Serializable;
import java.util.Date;

public class TbManpowerInsuredScheme implements Serializable {
    private String schemeId;

    private String schemeName;

    private String insuredCityId;

    private String insuredCityName;

    private String socialSecurityId;

    private String accumulationFundId;

    private Byte recordStatus;

    private String creatorAccount;

    private Date createdTime;

    private String modifierAccount;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public String getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(String schemeId) {
        this.schemeId = schemeId == null ? null : schemeId.trim();
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName == null ? null : schemeName.trim();
    }

    public String getInsuredCityId() {
        return insuredCityId;
    }

    public void setInsuredCityId(String insuredCityId) {
        this.insuredCityId = insuredCityId == null ? null : insuredCityId.trim();
    }

    public String getInsuredCityName() {
        return insuredCityName;
    }

    public void setInsuredCityName(String insuredCityName) {
        this.insuredCityName = insuredCityName == null ? null : insuredCityName.trim();
    }

    public String getSocialSecurityId() {
        return socialSecurityId;
    }

    public void setSocialSecurityId(String socialSecurityId) {
        this.socialSecurityId = socialSecurityId == null ? null : socialSecurityId.trim();
    }

    public String getAccumulationFundId() {
        return accumulationFundId;
    }

    public void setAccumulationFundId(String accumulationFundId) {
        this.accumulationFundId = accumulationFundId == null ? null : accumulationFundId.trim();
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
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
        TbManpowerInsuredScheme other = (TbManpowerInsuredScheme) that;
        return (this.getSchemeId() == null ? other.getSchemeId() == null : this.getSchemeId().equals(other.getSchemeId()))
            && (this.getSchemeName() == null ? other.getSchemeName() == null : this.getSchemeName().equals(other.getSchemeName()))
            && (this.getInsuredCityId() == null ? other.getInsuredCityId() == null : this.getInsuredCityId().equals(other.getInsuredCityId()))
            && (this.getInsuredCityName() == null ? other.getInsuredCityName() == null : this.getInsuredCityName().equals(other.getInsuredCityName()))
            && (this.getSocialSecurityId() == null ? other.getSocialSecurityId() == null : this.getSocialSecurityId().equals(other.getSocialSecurityId()))
            && (this.getAccumulationFundId() == null ? other.getAccumulationFundId() == null : this.getAccumulationFundId().equals(other.getAccumulationFundId()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSchemeId() == null) ? 0 : getSchemeId().hashCode());
        result = prime * result + ((getSchemeName() == null) ? 0 : getSchemeName().hashCode());
        result = prime * result + ((getInsuredCityId() == null) ? 0 : getInsuredCityId().hashCode());
        result = prime * result + ((getInsuredCityName() == null) ? 0 : getInsuredCityName().hashCode());
        result = prime * result + ((getSocialSecurityId() == null) ? 0 : getSocialSecurityId().hashCode());
        result = prime * result + ((getAccumulationFundId() == null) ? 0 : getAccumulationFundId().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", schemeId=").append(schemeId);
        sb.append(", schemeName=").append(schemeName);
        sb.append(", insuredCityId=").append(insuredCityId);
        sb.append(", insuredCityName=").append(insuredCityName);
        sb.append(", socialSecurityId=").append(socialSecurityId);
        sb.append(", accumulationFundId=").append(accumulationFundId);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}