package com.jn.hr.exam.entity;

import java.io.Serializable;
import java.util.Date;

public class TbManpowerExaminaResultInfo implements Serializable {
    private String id;

    private String examinaId;

    private String jobNumber;

    private String name;

    private Integer useTime;

    private Integer achievement;

    private Byte isAdopt;

    private Byte examinaMethod;

    private Integer rank;

    private Byte recordStatus;

    private Date examinaStartTime;

    private Date examinaEndTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getExaminaId() {
        return examinaId;
    }

    public void setExaminaId(String examinaId) {
        this.examinaId = examinaId == null ? null : examinaId.trim();
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

    public Integer getUseTime() {
        return useTime;
    }

    public void setUseTime(Integer useTime) {
        this.useTime = useTime;
    }

    public Integer getAchievement() {
        return achievement;
    }

    public void setAchievement(Integer achievement) {
        this.achievement = achievement;
    }

    public Byte getIsAdopt() {
        return isAdopt;
    }

    public void setIsAdopt(Byte isAdopt) {
        this.isAdopt = isAdopt;
    }

    public Byte getExaminaMethod() {
        return examinaMethod;
    }

    public void setExaminaMethod(Byte examinaMethod) {
        this.examinaMethod = examinaMethod;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Date getExaminaStartTime() {
        return examinaStartTime;
    }

    public void setExaminaStartTime(Date examinaStartTime) {
        this.examinaStartTime = examinaStartTime;
    }

    public Date getExaminaEndTime() {
        return examinaEndTime;
    }

    public void setExaminaEndTime(Date examinaEndTime) {
        this.examinaEndTime = examinaEndTime;
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
        TbManpowerExaminaResultInfo other = (TbManpowerExaminaResultInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getExaminaId() == null ? other.getExaminaId() == null : this.getExaminaId().equals(other.getExaminaId()))
            && (this.getJobNumber() == null ? other.getJobNumber() == null : this.getJobNumber().equals(other.getJobNumber()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getUseTime() == null ? other.getUseTime() == null : this.getUseTime().equals(other.getUseTime()))
            && (this.getAchievement() == null ? other.getAchievement() == null : this.getAchievement().equals(other.getAchievement()))
            && (this.getIsAdopt() == null ? other.getIsAdopt() == null : this.getIsAdopt().equals(other.getIsAdopt()))
            && (this.getExaminaMethod() == null ? other.getExaminaMethod() == null : this.getExaminaMethod().equals(other.getExaminaMethod()))
            && (this.getRank() == null ? other.getRank() == null : this.getRank().equals(other.getRank()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getExaminaStartTime() == null ? other.getExaminaStartTime() == null : this.getExaminaStartTime().equals(other.getExaminaStartTime()))
            && (this.getExaminaEndTime() == null ? other.getExaminaEndTime() == null : this.getExaminaEndTime().equals(other.getExaminaEndTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getExaminaId() == null) ? 0 : getExaminaId().hashCode());
        result = prime * result + ((getJobNumber() == null) ? 0 : getJobNumber().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getUseTime() == null) ? 0 : getUseTime().hashCode());
        result = prime * result + ((getAchievement() == null) ? 0 : getAchievement().hashCode());
        result = prime * result + ((getIsAdopt() == null) ? 0 : getIsAdopt().hashCode());
        result = prime * result + ((getExaminaMethod() == null) ? 0 : getExaminaMethod().hashCode());
        result = prime * result + ((getRank() == null) ? 0 : getRank().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getExaminaStartTime() == null) ? 0 : getExaminaStartTime().hashCode());
        result = prime * result + ((getExaminaEndTime() == null) ? 0 : getExaminaEndTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", examinaId=").append(examinaId);
        sb.append(", jobNumber=").append(jobNumber);
        sb.append(", name=").append(name);
        sb.append(", useTime=").append(useTime);
        sb.append(", achievement=").append(achievement);
        sb.append(", isAdopt=").append(isAdopt);
        sb.append(", examinaMethod=").append(examinaMethod);
        sb.append(", rank=").append(rank);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", examinaStartTime=").append(examinaStartTime);
        sb.append(", examinaEndTime=").append(examinaEndTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}