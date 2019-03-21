package com.jn.enterprise.joinpark.company.entity;

import java.io.Serializable;
import java.util.Date;

public class TbServiceCompanyStaff implements Serializable {
    private String id;

    private String comId;

    private String comName;

    private String account;

    private String checkStatus;

    private String checkAccount;

    private Date checkTime;

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

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId == null ? null : comId.trim();
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName == null ? null : comName.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus == null ? null : checkStatus.trim();
    }

    public String getCheckAccount() {
        return checkAccount;
    }

    public void setCheckAccount(String checkAccount) {
        this.checkAccount = checkAccount == null ? null : checkAccount.trim();
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
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
        TbServiceCompanyStaff other = (TbServiceCompanyStaff) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getComId() == null ? other.getComId() == null : this.getComId().equals(other.getComId()))
            && (this.getComName() == null ? other.getComName() == null : this.getComName().equals(other.getComName()))
            && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()))
            && (this.getCheckStatus() == null ? other.getCheckStatus() == null : this.getCheckStatus().equals(other.getCheckStatus()))
            && (this.getCheckAccount() == null ? other.getCheckAccount() == null : this.getCheckAccount().equals(other.getCheckAccount()))
            && (this.getCheckTime() == null ? other.getCheckTime() == null : this.getCheckTime().equals(other.getCheckTime()))
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
        result = prime * result + ((getComId() == null) ? 0 : getComId().hashCode());
        result = prime * result + ((getComName() == null) ? 0 : getComName().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getCheckStatus() == null) ? 0 : getCheckStatus().hashCode());
        result = prime * result + ((getCheckAccount() == null) ? 0 : getCheckAccount().hashCode());
        result = prime * result + ((getCheckTime() == null) ? 0 : getCheckTime().hashCode());
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
        sb.append(", comId=").append(comId);
        sb.append(", comName=").append(comName);
        sb.append(", account=").append(account);
        sb.append(", checkStatus=").append(checkStatus);
        sb.append(", checkAccount=").append(checkAccount);
        sb.append(", checkTime=").append(checkTime);
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