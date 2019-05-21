package com.jn.hr.train.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class TbManpowerTrainManagement implements Serializable {
    private String id;

    private String courseTitle;

    private String trainTeacher;

    private String trainVenue;

    private Date trainStartTime;

    private Date trainEndTime;

    private Byte status;

    private Byte recordStatus;

    private String creatorAccount;

    private Date createdTime;

    private String modifierAccount;

    private Date modifiedTime;

    private byte[] trainInfo;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle == null ? null : courseTitle.trim();
    }

    public String getTrainTeacher() {
        return trainTeacher;
    }

    public void setTrainTeacher(String trainTeacher) {
        this.trainTeacher = trainTeacher == null ? null : trainTeacher.trim();
    }

    public String getTrainVenue() {
        return trainVenue;
    }

    public void setTrainVenue(String trainVenue) {
        this.trainVenue = trainVenue == null ? null : trainVenue.trim();
    }

    public Date getTrainStartTime() {
        return trainStartTime;
    }

    public void setTrainStartTime(Date trainStartTime) {
        this.trainStartTime = trainStartTime;
    }

    public Date getTrainEndTime() {
        return trainEndTime;
    }

    public void setTrainEndTime(Date trainEndTime) {
        this.trainEndTime = trainEndTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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

    public byte[] getTrainInfo() {
        return trainInfo;
    }

    public void setTrainInfo(byte[] trainInfo) {
        this.trainInfo = trainInfo;
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
        TbManpowerTrainManagement other = (TbManpowerTrainManagement) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCourseTitle() == null ? other.getCourseTitle() == null : this.getCourseTitle().equals(other.getCourseTitle()))
            && (this.getTrainTeacher() == null ? other.getTrainTeacher() == null : this.getTrainTeacher().equals(other.getTrainTeacher()))
            && (this.getTrainVenue() == null ? other.getTrainVenue() == null : this.getTrainVenue().equals(other.getTrainVenue()))
            && (this.getTrainStartTime() == null ? other.getTrainStartTime() == null : this.getTrainStartTime().equals(other.getTrainStartTime()))
            && (this.getTrainEndTime() == null ? other.getTrainEndTime() == null : this.getTrainEndTime().equals(other.getTrainEndTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (Arrays.equals(this.getTrainInfo(), other.getTrainInfo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCourseTitle() == null) ? 0 : getCourseTitle().hashCode());
        result = prime * result + ((getTrainTeacher() == null) ? 0 : getTrainTeacher().hashCode());
        result = prime * result + ((getTrainVenue() == null) ? 0 : getTrainVenue().hashCode());
        result = prime * result + ((getTrainStartTime() == null) ? 0 : getTrainStartTime().hashCode());
        result = prime * result + ((getTrainEndTime() == null) ? 0 : getTrainEndTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + (Arrays.hashCode(getTrainInfo()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", courseTitle=").append(courseTitle);
        sb.append(", trainTeacher=").append(trainTeacher);
        sb.append(", trainVenue=").append(trainVenue);
        sb.append(", trainStartTime=").append(trainStartTime);
        sb.append(", trainEndTime=").append(trainEndTime);
        sb.append(", status=").append(status);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", trainInfo=").append(trainInfo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}