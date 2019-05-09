package com.jn.enterprise.servicemarket.org.model;

import java.io.Serializable;

public class TbServiceOrgTeamCopy implements Serializable {
    private String id;

    private String orgId;

    private String conName;

    private String conPosition;

    private String conQuali;

    private String conTime;

    private String conSpeciality;

    private String createdTime;

    private String creatorAccount;

    private String modifiedTime;

    private String modifierAccount;

    private Byte recordStatus;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName == null ? null : conName.trim();
    }

    public String getConPosition() {
        return conPosition;
    }

    public void setConPosition(String conPosition) {
        this.conPosition = conPosition == null ? null : conPosition.trim();
    }

    public String getConQuali() {
        return conQuali;
    }

    public void setConQuali(String conQuali) {
        this.conQuali = conQuali == null ? null : conQuali.trim();
    }

    public String getConTime() {
        return conTime;
    }

    public void setConTime(String conTime) {
        this.conTime = conTime == null ? null : conTime.trim();
    }

    public String getConSpeciality() {
        return conSpeciality;
    }

    public void setConSpeciality(String conSpeciality) {
        this.conSpeciality = conSpeciality == null ? null : conSpeciality.trim();
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
        TbServiceOrgTeamCopy other = (TbServiceOrgTeamCopy) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
            && (this.getConName() == null ? other.getConName() == null : this.getConName().equals(other.getConName()))
            && (this.getConPosition() == null ? other.getConPosition() == null : this.getConPosition().equals(other.getConPosition()))
            && (this.getConQuali() == null ? other.getConQuali() == null : this.getConQuali().equals(other.getConQuali()))
            && (this.getConTime() == null ? other.getConTime() == null : this.getConTime().equals(other.getConTime()))
            && (this.getConSpeciality() == null ? other.getConSpeciality() == null : this.getConSpeciality().equals(other.getConSpeciality()))
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
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getConName() == null) ? 0 : getConName().hashCode());
        result = prime * result + ((getConPosition() == null) ? 0 : getConPosition().hashCode());
        result = prime * result + ((getConQuali() == null) ? 0 : getConQuali().hashCode());
        result = prime * result + ((getConTime() == null) ? 0 : getConTime().hashCode());
        result = prime * result + ((getConSpeciality() == null) ? 0 : getConSpeciality().hashCode());
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
        sb.append(", orgId=").append(orgId);
        sb.append(", conName=").append(conName);
        sb.append(", conPosition=").append(conPosition);
        sb.append(", conQuali=").append(conQuali);
        sb.append(", conTime=").append(conTime);
        sb.append(", conSpeciality=").append(conSpeciality);
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