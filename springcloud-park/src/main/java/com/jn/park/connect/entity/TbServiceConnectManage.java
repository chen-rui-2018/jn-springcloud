package com.jn.park.connect.entity;

import java.io.Serializable;
import java.util.Date;

public class TbServiceConnectManage implements Serializable {
    private String id;

    private String entranceName;

    private String entranceNameCode;

    private String serviceConnect;

    private String connectAddress;

    private String showImg;

    private String sort;

    private Byte isValid;

    private String creatorAccountId;

    private String creatorAccount;

    private Byte recordStatus;

    private Date createdTime;

    private String modifierAccount;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEntranceName() {
        return entranceName;
    }

    public void setEntranceName(String entranceName) {
        this.entranceName = entranceName == null ? null : entranceName.trim();
    }

    public String getEntranceNameCode() {
        return entranceNameCode;
    }

    public void setEntranceNameCode(String entranceNameCode) {
        this.entranceNameCode = entranceNameCode == null ? null : entranceNameCode.trim();
    }

    public String getServiceConnect() {
        return serviceConnect;
    }

    public void setServiceConnect(String serviceConnect) {
        this.serviceConnect = serviceConnect == null ? null : serviceConnect.trim();
    }

    public String getConnectAddress() {
        return connectAddress;
    }

    public void setConnectAddress(String connectAddress) {
        this.connectAddress = connectAddress == null ? null : connectAddress.trim();
    }

    public String getShowImg() {
        return showImg;
    }

    public void setShowImg(String showImg) {
        this.showImg = showImg == null ? null : showImg.trim();
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    public Byte getIsValid() {
        return isValid;
    }

    public void setIsValid(Byte isValid) {
        this.isValid = isValid;
    }

    public String getCreatorAccountId() {
        return creatorAccountId;
    }

    public void setCreatorAccountId(String creatorAccountId) {
        this.creatorAccountId = creatorAccountId == null ? null : creatorAccountId.trim();
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount == null ? null : creatorAccount.trim();
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
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
        TbServiceConnectManage other = (TbServiceConnectManage) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEntranceName() == null ? other.getEntranceName() == null : this.getEntranceName().equals(other.getEntranceName()))
            && (this.getEntranceNameCode() == null ? other.getEntranceNameCode() == null : this.getEntranceNameCode().equals(other.getEntranceNameCode()))
            && (this.getServiceConnect() == null ? other.getServiceConnect() == null : this.getServiceConnect().equals(other.getServiceConnect()))
            && (this.getConnectAddress() == null ? other.getConnectAddress() == null : this.getConnectAddress().equals(other.getConnectAddress()))
            && (this.getShowImg() == null ? other.getShowImg() == null : this.getShowImg().equals(other.getShowImg()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getIsValid() == null ? other.getIsValid() == null : this.getIsValid().equals(other.getIsValid()))
            && (this.getCreatorAccountId() == null ? other.getCreatorAccountId() == null : this.getCreatorAccountId().equals(other.getCreatorAccountId()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEntranceName() == null) ? 0 : getEntranceName().hashCode());
        result = prime * result + ((getEntranceNameCode() == null) ? 0 : getEntranceNameCode().hashCode());
        result = prime * result + ((getServiceConnect() == null) ? 0 : getServiceConnect().hashCode());
        result = prime * result + ((getConnectAddress() == null) ? 0 : getConnectAddress().hashCode());
        result = prime * result + ((getShowImg() == null) ? 0 : getShowImg().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getIsValid() == null) ? 0 : getIsValid().hashCode());
        result = prime * result + ((getCreatorAccountId() == null) ? 0 : getCreatorAccountId().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
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
        sb.append(", id=").append(id);
        sb.append(", entranceName=").append(entranceName);
        sb.append(", entranceNameCode=").append(entranceNameCode);
        sb.append(", serviceConnect=").append(serviceConnect);
        sb.append(", connectAddress=").append(connectAddress);
        sb.append(", showImg=").append(showImg);
        sb.append(", sort=").append(sort);
        sb.append(", isValid=").append(isValid);
        sb.append(", creatorAccountId=").append(creatorAccountId);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}