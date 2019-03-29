package com.jn.user.address.entity;

import java.io.Serializable;
import java.util.Date;

public class TbUserAddress implements Serializable {
    private String addressId;

    private String userAccount;

    private String receiverName;

    private String reveiverPhone;

    private String reveiverTel;

    private String addressProvince;

    private String addressCity;

    private String addressArea;

    private String addressStreet;

    private String addressDetail;

    private String addressStatus;

    private String isDefault;

    private Date createdTime;

    private String creatorAccount;

    private Date modifiedTime;

    private String modifierAccount;

    private Byte recordStatus;

    private static final long serialVersionUID = 1L;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId == null ? null : addressId.trim();
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    public String getReveiverPhone() {
        return reveiverPhone;
    }

    public void setReveiverPhone(String reveiverPhone) {
        this.reveiverPhone = reveiverPhone == null ? null : reveiverPhone.trim();
    }

    public String getReveiverTel() {
        return reveiverTel;
    }

    public void setReveiverTel(String reveiverTel) {
        this.reveiverTel = reveiverTel == null ? null : reveiverTel.trim();
    }

    public String getAddressProvince() {
        return addressProvince;
    }

    public void setAddressProvince(String addressProvince) {
        this.addressProvince = addressProvince == null ? null : addressProvince.trim();
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity == null ? null : addressCity.trim();
    }

    public String getAddressArea() {
        return addressArea;
    }

    public void setAddressArea(String addressArea) {
        this.addressArea = addressArea == null ? null : addressArea.trim();
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet == null ? null : addressStreet.trim();
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail == null ? null : addressDetail.trim();
    }

    public String getAddressStatus() {
        return addressStatus;
    }

    public void setAddressStatus(String addressStatus) {
        this.addressStatus = addressStatus == null ? null : addressStatus.trim();
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault == null ? null : isDefault.trim();
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
        TbUserAddress other = (TbUserAddress) that;
        return (this.getAddressId() == null ? other.getAddressId() == null : this.getAddressId().equals(other.getAddressId()))
            && (this.getUserAccount() == null ? other.getUserAccount() == null : this.getUserAccount().equals(other.getUserAccount()))
            && (this.getReceiverName() == null ? other.getReceiverName() == null : this.getReceiverName().equals(other.getReceiverName()))
            && (this.getReveiverPhone() == null ? other.getReveiverPhone() == null : this.getReveiverPhone().equals(other.getReveiverPhone()))
            && (this.getReveiverTel() == null ? other.getReveiverTel() == null : this.getReveiverTel().equals(other.getReveiverTel()))
            && (this.getAddressProvince() == null ? other.getAddressProvince() == null : this.getAddressProvince().equals(other.getAddressProvince()))
            && (this.getAddressCity() == null ? other.getAddressCity() == null : this.getAddressCity().equals(other.getAddressCity()))
            && (this.getAddressArea() == null ? other.getAddressArea() == null : this.getAddressArea().equals(other.getAddressArea()))
            && (this.getAddressStreet() == null ? other.getAddressStreet() == null : this.getAddressStreet().equals(other.getAddressStreet()))
            && (this.getAddressDetail() == null ? other.getAddressDetail() == null : this.getAddressDetail().equals(other.getAddressDetail()))
            && (this.getAddressStatus() == null ? other.getAddressStatus() == null : this.getAddressStatus().equals(other.getAddressStatus()))
            && (this.getIsDefault() == null ? other.getIsDefault() == null : this.getIsDefault().equals(other.getIsDefault()))
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
        result = prime * result + ((getAddressId() == null) ? 0 : getAddressId().hashCode());
        result = prime * result + ((getUserAccount() == null) ? 0 : getUserAccount().hashCode());
        result = prime * result + ((getReceiverName() == null) ? 0 : getReceiverName().hashCode());
        result = prime * result + ((getReveiverPhone() == null) ? 0 : getReveiverPhone().hashCode());
        result = prime * result + ((getReveiverTel() == null) ? 0 : getReveiverTel().hashCode());
        result = prime * result + ((getAddressProvince() == null) ? 0 : getAddressProvince().hashCode());
        result = prime * result + ((getAddressCity() == null) ? 0 : getAddressCity().hashCode());
        result = prime * result + ((getAddressArea() == null) ? 0 : getAddressArea().hashCode());
        result = prime * result + ((getAddressStreet() == null) ? 0 : getAddressStreet().hashCode());
        result = prime * result + ((getAddressDetail() == null) ? 0 : getAddressDetail().hashCode());
        result = prime * result + ((getAddressStatus() == null) ? 0 : getAddressStatus().hashCode());
        result = prime * result + ((getIsDefault() == null) ? 0 : getIsDefault().hashCode());
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
        sb.append(", addressId=").append(addressId);
        sb.append(", userAccount=").append(userAccount);
        sb.append(", receiverName=").append(receiverName);
        sb.append(", reveiverPhone=").append(reveiverPhone);
        sb.append(", reveiverTel=").append(reveiverTel);
        sb.append(", addressProvince=").append(addressProvince);
        sb.append(", addressCity=").append(addressCity);
        sb.append(", addressArea=").append(addressArea);
        sb.append(", addressStreet=").append(addressStreet);
        sb.append(", addressDetail=").append(addressDetail);
        sb.append(", addressStatus=").append(addressStatus);
        sb.append(", isDefault=").append(isDefault);
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