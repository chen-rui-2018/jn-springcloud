package com.jn.enterprise.servicemarket.org.model;

import java.io.Serializable;

public class TbServiceOrgInfoCopy implements Serializable {
    private String orgId;

    private String orgProvince;

    private String orgCity;

    private String orgArea;

    private String orgAddress;

    private String orgPhone;

    private String conName;

    private String orgWeb;

    private String conPhone;

    private String conEmail;

    private String createdTime;

    private String creatorAccount;

    private String modifiedTime;

    private String modifierAccount;

    private Byte recordStatus;

    private static final long serialVersionUID = 1L;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getOrgProvince() {
        return orgProvince;
    }

    public void setOrgProvince(String orgProvince) {
        this.orgProvince = orgProvince == null ? null : orgProvince.trim();
    }

    public String getOrgCity() {
        return orgCity;
    }

    public void setOrgCity(String orgCity) {
        this.orgCity = orgCity == null ? null : orgCity.trim();
    }

    public String getOrgArea() {
        return orgArea;
    }

    public void setOrgArea(String orgArea) {
        this.orgArea = orgArea == null ? null : orgArea.trim();
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress == null ? null : orgAddress.trim();
    }

    public String getOrgPhone() {
        return orgPhone;
    }

    public void setOrgPhone(String orgPhone) {
        this.orgPhone = orgPhone == null ? null : orgPhone.trim();
    }

    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName == null ? null : conName.trim();
    }

    public String getOrgWeb() {
        return orgWeb;
    }

    public void setOrgWeb(String orgWeb) {
        this.orgWeb = orgWeb == null ? null : orgWeb.trim();
    }

    public String getConPhone() {
        return conPhone;
    }

    public void setConPhone(String conPhone) {
        this.conPhone = conPhone == null ? null : conPhone.trim();
    }

    public String getConEmail() {
        return conEmail;
    }

    public void setConEmail(String conEmail) {
        this.conEmail = conEmail == null ? null : conEmail.trim();
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount == null ? null : creatorAccount.trim();
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
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
        TbServiceOrgInfoCopy other = (TbServiceOrgInfoCopy) that;
        return (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
            && (this.getOrgProvince() == null ? other.getOrgProvince() == null : this.getOrgProvince().equals(other.getOrgProvince()))
            && (this.getOrgCity() == null ? other.getOrgCity() == null : this.getOrgCity().equals(other.getOrgCity()))
            && (this.getOrgArea() == null ? other.getOrgArea() == null : this.getOrgArea().equals(other.getOrgArea()))
            && (this.getOrgAddress() == null ? other.getOrgAddress() == null : this.getOrgAddress().equals(other.getOrgAddress()))
            && (this.getOrgPhone() == null ? other.getOrgPhone() == null : this.getOrgPhone().equals(other.getOrgPhone()))
            && (this.getConName() == null ? other.getConName() == null : this.getConName().equals(other.getConName()))
            && (this.getOrgWeb() == null ? other.getOrgWeb() == null : this.getOrgWeb().equals(other.getOrgWeb()))
            && (this.getConPhone() == null ? other.getConPhone() == null : this.getConPhone().equals(other.getConPhone()))
            && (this.getConEmail() == null ? other.getConEmail() == null : this.getConEmail().equals(other.getConEmail()))
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
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getOrgProvince() == null) ? 0 : getOrgProvince().hashCode());
        result = prime * result + ((getOrgCity() == null) ? 0 : getOrgCity().hashCode());
        result = prime * result + ((getOrgArea() == null) ? 0 : getOrgArea().hashCode());
        result = prime * result + ((getOrgAddress() == null) ? 0 : getOrgAddress().hashCode());
        result = prime * result + ((getOrgPhone() == null) ? 0 : getOrgPhone().hashCode());
        result = prime * result + ((getConName() == null) ? 0 : getConName().hashCode());
        result = prime * result + ((getOrgWeb() == null) ? 0 : getOrgWeb().hashCode());
        result = prime * result + ((getConPhone() == null) ? 0 : getConPhone().hashCode());
        result = prime * result + ((getConEmail() == null) ? 0 : getConEmail().hashCode());
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
        sb.append(", orgId=").append(orgId);
        sb.append(", orgProvince=").append(orgProvince);
        sb.append(", orgCity=").append(orgCity);
        sb.append(", orgArea=").append(orgArea);
        sb.append(", orgAddress=").append(orgAddress);
        sb.append(", orgPhone=").append(orgPhone);
        sb.append(", conName=").append(conName);
        sb.append(", orgWeb=").append(orgWeb);
        sb.append(", conPhone=").append(conPhone);
        sb.append(", conEmail=").append(conEmail);
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