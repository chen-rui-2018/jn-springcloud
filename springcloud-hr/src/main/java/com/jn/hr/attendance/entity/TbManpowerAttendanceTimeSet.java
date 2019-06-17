package com.jn.hr.attendance.entity;

import java.io.Serializable;
import java.util.Date;

public class TbManpowerAttendanceTimeSet implements Serializable {
    private String id;

    private String shift;

    private String attendanceType;

    private String workAttendanceTime;

    private String dutyAttendanceTime;

    private String remark;

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

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift == null ? null : shift.trim();
    }

    public String getAttendanceType() {
        return attendanceType;
    }

    public void setAttendanceType(String attendanceType) {
        this.attendanceType = attendanceType == null ? null : attendanceType.trim();
    }

    public String getWorkAttendanceTime() {
        return workAttendanceTime;
    }

    public void setWorkAttendanceTime(String workAttendanceTime) {
        this.workAttendanceTime = workAttendanceTime == null ? null : workAttendanceTime.trim();
    }

    public String getDutyAttendanceTime() {
        return dutyAttendanceTime;
    }

    public void setDutyAttendanceTime(String dutyAttendanceTime) {
        this.dutyAttendanceTime = dutyAttendanceTime == null ? null : dutyAttendanceTime.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
        TbManpowerAttendanceTimeSet other = (TbManpowerAttendanceTimeSet) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getShift() == null ? other.getShift() == null : this.getShift().equals(other.getShift()))
            && (this.getAttendanceType() == null ? other.getAttendanceType() == null : this.getAttendanceType().equals(other.getAttendanceType()))
            && (this.getWorkAttendanceTime() == null ? other.getWorkAttendanceTime() == null : this.getWorkAttendanceTime().equals(other.getWorkAttendanceTime()))
            && (this.getDutyAttendanceTime() == null ? other.getDutyAttendanceTime() == null : this.getDutyAttendanceTime().equals(other.getDutyAttendanceTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
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
        result = prime * result + ((getShift() == null) ? 0 : getShift().hashCode());
        result = prime * result + ((getAttendanceType() == null) ? 0 : getAttendanceType().hashCode());
        result = prime * result + ((getWorkAttendanceTime() == null) ? 0 : getWorkAttendanceTime().hashCode());
        result = prime * result + ((getDutyAttendanceTime() == null) ? 0 : getDutyAttendanceTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
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
        sb.append(", shift=").append(shift);
        sb.append(", attendanceType=").append(attendanceType);
        sb.append(", workAttendanceTime=").append(workAttendanceTime);
        sb.append(", dutyAttendanceTime=").append(dutyAttendanceTime);
        sb.append(", remark=").append(remark);
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