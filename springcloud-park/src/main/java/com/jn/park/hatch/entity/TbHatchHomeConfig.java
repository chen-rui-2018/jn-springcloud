package com.jn.park.hatch.entity;

import java.io.Serializable;
import java.util.Date;

public class TbHatchHomeConfig implements Serializable {
    private String id;

    private String incubatorId;

    private String incubatorName;

    private String incubatorAbb;

    private String advantageIntroduct;

    private String spatialCharacter;

    private String entryCriteria;

    private String phone;

    private String status;

    private String recordStatus;

    private String creatorAccount;

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

    public String getIncubatorId() {
        return incubatorId;
    }

    public void setIncubatorId(String incubatorId) {
        this.incubatorId = incubatorId == null ? null : incubatorId.trim();
    }

    public String getIncubatorName() {
        return incubatorName;
    }

    public void setIncubatorName(String incubatorName) {
        this.incubatorName = incubatorName == null ? null : incubatorName.trim();
    }

    public String getIncubatorAbb() {
        return incubatorAbb;
    }

    public void setIncubatorAbb(String incubatorAbb) {
        this.incubatorAbb = incubatorAbb == null ? null : incubatorAbb.trim();
    }

    public String getAdvantageIntroduct() {
        return advantageIntroduct;
    }

    public void setAdvantageIntroduct(String advantageIntroduct) {
        this.advantageIntroduct = advantageIntroduct == null ? null : advantageIntroduct.trim();
    }

    public String getSpatialCharacter() {
        return spatialCharacter;
    }

    public void setSpatialCharacter(String spatialCharacter) {
        this.spatialCharacter = spatialCharacter == null ? null : spatialCharacter.trim();
    }

    public String getEntryCriteria() {
        return entryCriteria;
    }

    public void setEntryCriteria(String entryCriteria) {
        this.entryCriteria = entryCriteria == null ? null : entryCriteria.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
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
        TbHatchHomeConfig other = (TbHatchHomeConfig) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIncubatorId() == null ? other.getIncubatorId() == null : this.getIncubatorId().equals(other.getIncubatorId()))
            && (this.getIncubatorName() == null ? other.getIncubatorName() == null : this.getIncubatorName().equals(other.getIncubatorName()))
            && (this.getIncubatorAbb() == null ? other.getIncubatorAbb() == null : this.getIncubatorAbb().equals(other.getIncubatorAbb()))
            && (this.getAdvantageIntroduct() == null ? other.getAdvantageIntroduct() == null : this.getAdvantageIntroduct().equals(other.getAdvantageIntroduct()))
            && (this.getSpatialCharacter() == null ? other.getSpatialCharacter() == null : this.getSpatialCharacter().equals(other.getSpatialCharacter()))
            && (this.getEntryCriteria() == null ? other.getEntryCriteria() == null : this.getEntryCriteria().equals(other.getEntryCriteria()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
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
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIncubatorId() == null) ? 0 : getIncubatorId().hashCode());
        result = prime * result + ((getIncubatorName() == null) ? 0 : getIncubatorName().hashCode());
        result = prime * result + ((getIncubatorAbb() == null) ? 0 : getIncubatorAbb().hashCode());
        result = prime * result + ((getAdvantageIntroduct() == null) ? 0 : getAdvantageIntroduct().hashCode());
        result = prime * result + ((getSpatialCharacter() == null) ? 0 : getSpatialCharacter().hashCode());
        result = prime * result + ((getEntryCriteria() == null) ? 0 : getEntryCriteria().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
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
        sb.append(", id=").append(id);
        sb.append(", incubatorId=").append(incubatorId);
        sb.append(", incubatorName=").append(incubatorName);
        sb.append(", incubatorAbb=").append(incubatorAbb);
        sb.append(", advantageIntroduct=").append(advantageIntroduct);
        sb.append(", spatialCharacter=").append(spatialCharacter);
        sb.append(", entryCriteria=").append(entryCriteria);
        sb.append(", phone=").append(phone);
        sb.append(", status=").append(status);
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