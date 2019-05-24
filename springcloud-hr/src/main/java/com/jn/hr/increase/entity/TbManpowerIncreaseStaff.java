package com.jn.hr.increase.entity;

import java.io.Serializable;
import java.util.Date;

public class TbManpowerIncreaseStaff implements Serializable {
    private String id;

    private String planType;

    private String insuredMonth;

    private String jobNumber;

    private String name;

    private String department;

    private String insuredCityId;

    private String insuredCityName;

    private String insuredProgrammeId;

    private String insuredProgrammeName;

    private Byte isEffective;

    private Byte recordStatus;

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

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType == null ? null : planType.trim();
    }

    public String getInsuredMonth() {
        return insuredMonth;
    }

    public void setInsuredMonth(String insuredMonth) {
        this.insuredMonth = insuredMonth == null ? null : insuredMonth.trim();
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber == null ? null : jobNumber.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
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

    public String getInsuredProgrammeId() {
        return insuredProgrammeId;
    }

    public void setInsuredProgrammeId(String insuredProgrammeId) {
        this.insuredProgrammeId = insuredProgrammeId == null ? null : insuredProgrammeId.trim();
    }

    public String getInsuredProgrammeName() {
        return insuredProgrammeName;
    }

    public void setInsuredProgrammeName(String insuredProgrammeName) {
        this.insuredProgrammeName = insuredProgrammeName == null ? null : insuredProgrammeName.trim();
    }

    public Byte getIsEffective() {
        return isEffective;
    }

    public void setIsEffective(Byte isEffective) {
        this.isEffective = isEffective;
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
        TbManpowerIncreaseStaff other = (TbManpowerIncreaseStaff) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPlanType() == null ? other.getPlanType() == null : this.getPlanType().equals(other.getPlanType()))
            && (this.getInsuredMonth() == null ? other.getInsuredMonth() == null : this.getInsuredMonth().equals(other.getInsuredMonth()))
            && (this.getJobNumber() == null ? other.getJobNumber() == null : this.getJobNumber().equals(other.getJobNumber()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getDepartment() == null ? other.getDepartment() == null : this.getDepartment().equals(other.getDepartment()))
            && (this.getInsuredCityId() == null ? other.getInsuredCityId() == null : this.getInsuredCityId().equals(other.getInsuredCityId()))
            && (this.getInsuredCityName() == null ? other.getInsuredCityName() == null : this.getInsuredCityName().equals(other.getInsuredCityName()))
            && (this.getInsuredProgrammeId() == null ? other.getInsuredProgrammeId() == null : this.getInsuredProgrammeId().equals(other.getInsuredProgrammeId()))
            && (this.getInsuredProgrammeName() == null ? other.getInsuredProgrammeName() == null : this.getInsuredProgrammeName().equals(other.getInsuredProgrammeName()))
            && (this.getIsEffective() == null ? other.getIsEffective() == null : this.getIsEffective().equals(other.getIsEffective()))
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
        result = prime * result + ((getPlanType() == null) ? 0 : getPlanType().hashCode());
        result = prime * result + ((getInsuredMonth() == null) ? 0 : getInsuredMonth().hashCode());
        result = prime * result + ((getJobNumber() == null) ? 0 : getJobNumber().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDepartment() == null) ? 0 : getDepartment().hashCode());
        result = prime * result + ((getInsuredCityId() == null) ? 0 : getInsuredCityId().hashCode());
        result = prime * result + ((getInsuredCityName() == null) ? 0 : getInsuredCityName().hashCode());
        result = prime * result + ((getInsuredProgrammeId() == null) ? 0 : getInsuredProgrammeId().hashCode());
        result = prime * result + ((getInsuredProgrammeName() == null) ? 0 : getInsuredProgrammeName().hashCode());
        result = prime * result + ((getIsEffective() == null) ? 0 : getIsEffective().hashCode());
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
        sb.append(", planType=").append(planType);
        sb.append(", insuredMonth=").append(insuredMonth);
        sb.append(", jobNumber=").append(jobNumber);
        sb.append(", name=").append(name);
        sb.append(", department=").append(department);
        sb.append(", insuredCityId=").append(insuredCityId);
        sb.append(", insuredCityName=").append(insuredCityName);
        sb.append(", insuredProgrammeId=").append(insuredProgrammeId);
        sb.append(", insuredProgrammeName=").append(insuredProgrammeName);
        sb.append(", isEffective=").append(isEffective);
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