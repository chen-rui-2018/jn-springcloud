package com.jn.enterprise.servicemarket.org.model;

import java.io.Serializable;

public class TbServiceOrgElementCopy implements Serializable {
    private String id;

    private String orgId;

    private Integer staffCount;

    private Integer professionNum;

    private Integer bachelorNum;

    private Integer masterNum;

    private Integer doctorNum;

    private Integer returneeNum;

    private String createdTime;

    private String creatorAccount;

    private String modifiedTime;

    private String modifierAccount;

    private String recordStatus;

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

    public Integer getStaffCount() {
        return staffCount;
    }

    public void setStaffCount(Integer staffCount) {
        this.staffCount = staffCount;
    }

    public Integer getProfessionNum() {
        return professionNum;
    }

    public void setProfessionNum(Integer professionNum) {
        this.professionNum = professionNum;
    }

    public Integer getBachelorNum() {
        return bachelorNum;
    }

    public void setBachelorNum(Integer bachelorNum) {
        this.bachelorNum = bachelorNum;
    }

    public Integer getMasterNum() {
        return masterNum;
    }

    public void setMasterNum(Integer masterNum) {
        this.masterNum = masterNum;
    }

    public Integer getDoctorNum() {
        return doctorNum;
    }

    public void setDoctorNum(Integer doctorNum) {
        this.doctorNum = doctorNum;
    }

    public Integer getReturneeNum() {
        return returneeNum;
    }

    public void setReturneeNum(Integer returneeNum) {
        this.returneeNum = returneeNum;
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

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
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
        TbServiceOrgElementCopy other = (TbServiceOrgElementCopy) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
            && (this.getStaffCount() == null ? other.getStaffCount() == null : this.getStaffCount().equals(other.getStaffCount()))
            && (this.getProfessionNum() == null ? other.getProfessionNum() == null : this.getProfessionNum().equals(other.getProfessionNum()))
            && (this.getBachelorNum() == null ? other.getBachelorNum() == null : this.getBachelorNum().equals(other.getBachelorNum()))
            && (this.getMasterNum() == null ? other.getMasterNum() == null : this.getMasterNum().equals(other.getMasterNum()))
            && (this.getDoctorNum() == null ? other.getDoctorNum() == null : this.getDoctorNum().equals(other.getDoctorNum()))
            && (this.getReturneeNum() == null ? other.getReturneeNum() == null : this.getReturneeNum().equals(other.getReturneeNum()))
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
        result = prime * result + ((getStaffCount() == null) ? 0 : getStaffCount().hashCode());
        result = prime * result + ((getProfessionNum() == null) ? 0 : getProfessionNum().hashCode());
        result = prime * result + ((getBachelorNum() == null) ? 0 : getBachelorNum().hashCode());
        result = prime * result + ((getMasterNum() == null) ? 0 : getMasterNum().hashCode());
        result = prime * result + ((getDoctorNum() == null) ? 0 : getDoctorNum().hashCode());
        result = prime * result + ((getReturneeNum() == null) ? 0 : getReturneeNum().hashCode());
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
        sb.append(", staffCount=").append(staffCount);
        sb.append(", professionNum=").append(professionNum);
        sb.append(", bachelorNum=").append(bachelorNum);
        sb.append(", masterNum=").append(masterNum);
        sb.append(", doctorNum=").append(doctorNum);
        sb.append(", returneeNum=").append(returneeNum);
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