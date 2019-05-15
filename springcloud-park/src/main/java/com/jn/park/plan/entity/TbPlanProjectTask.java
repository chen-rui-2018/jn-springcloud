package com.jn.park.plan.entity;

import java.io.Serializable;
import java.util.Date;

public class TbPlanProjectTask implements Serializable {
    private String id;

    private String projectId;

    private String projectNumber;

    private String projectName;

    private String taskName;

    private String taskNumber;

    private Date planStartTime;

    private Date planStopTime;

    private Integer limitTime;

    private Long nowadaysProgress;

    private Integer taskState;

    private String expectDifferTime;

    private Integer appraise;

    private Date actualBeginTime;

    private Date actualEndTime;

    private Integer recordStatus;

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

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber == null ? null : projectNumber.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public String getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(String taskNumber) {
        this.taskNumber = taskNumber == null ? null : taskNumber.trim();
    }

    public Date getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    public Date getPlanStopTime() {
        return planStopTime;
    }

    public void setPlanStopTime(Date planStopTime) {
        this.planStopTime = planStopTime;
    }

    public Integer getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(Integer limitTime) {
        this.limitTime = limitTime;
    }

    public Long getNowadaysProgress() {
        return nowadaysProgress;
    }

    public void setNowadaysProgress(Long nowadaysProgress) {
        this.nowadaysProgress = nowadaysProgress;
    }

    public Integer getTaskState() {
        return taskState;
    }

    public void setTaskState(Integer taskState) {
        this.taskState = taskState;
    }

    public String getExpectDifferTime() {
        return expectDifferTime;
    }

    public void setExpectDifferTime(String expectDifferTime) {
        this.expectDifferTime = expectDifferTime == null ? null : expectDifferTime.trim();
    }

    public Integer getAppraise() {
        return appraise;
    }

    public void setAppraise(Integer appraise) {
        this.appraise = appraise;
    }

    public Date getActualBeginTime() {
        return actualBeginTime;
    }

    public void setActualBeginTime(Date actualBeginTime) {
        this.actualBeginTime = actualBeginTime;
    }

    public Date getActualEndTime() {
        return actualEndTime;
    }

    public void setActualEndTime(Date actualEndTime) {
        this.actualEndTime = actualEndTime;
    }

    public Integer getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Integer recordStatus) {
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
        TbPlanProjectTask other = (TbPlanProjectTask) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getProjectNumber() == null ? other.getProjectNumber() == null : this.getProjectNumber().equals(other.getProjectNumber()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getTaskName() == null ? other.getTaskName() == null : this.getTaskName().equals(other.getTaskName()))
            && (this.getTaskNumber() == null ? other.getTaskNumber() == null : this.getTaskNumber().equals(other.getTaskNumber()))
            && (this.getPlanStartTime() == null ? other.getPlanStartTime() == null : this.getPlanStartTime().equals(other.getPlanStartTime()))
            && (this.getPlanStopTime() == null ? other.getPlanStopTime() == null : this.getPlanStopTime().equals(other.getPlanStopTime()))
            && (this.getLimitTime() == null ? other.getLimitTime() == null : this.getLimitTime().equals(other.getLimitTime()))
            && (this.getNowadaysProgress() == null ? other.getNowadaysProgress() == null : this.getNowadaysProgress().equals(other.getNowadaysProgress()))
            && (this.getTaskState() == null ? other.getTaskState() == null : this.getTaskState().equals(other.getTaskState()))
            && (this.getExpectDifferTime() == null ? other.getExpectDifferTime() == null : this.getExpectDifferTime().equals(other.getExpectDifferTime()))
            && (this.getAppraise() == null ? other.getAppraise() == null : this.getAppraise().equals(other.getAppraise()))
            && (this.getActualBeginTime() == null ? other.getActualBeginTime() == null : this.getActualBeginTime().equals(other.getActualBeginTime()))
            && (this.getActualEndTime() == null ? other.getActualEndTime() == null : this.getActualEndTime().equals(other.getActualEndTime()))
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
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getProjectNumber() == null) ? 0 : getProjectNumber().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getTaskName() == null) ? 0 : getTaskName().hashCode());
        result = prime * result + ((getTaskNumber() == null) ? 0 : getTaskNumber().hashCode());
        result = prime * result + ((getPlanStartTime() == null) ? 0 : getPlanStartTime().hashCode());
        result = prime * result + ((getPlanStopTime() == null) ? 0 : getPlanStopTime().hashCode());
        result = prime * result + ((getLimitTime() == null) ? 0 : getLimitTime().hashCode());
        result = prime * result + ((getNowadaysProgress() == null) ? 0 : getNowadaysProgress().hashCode());
        result = prime * result + ((getTaskState() == null) ? 0 : getTaskState().hashCode());
        result = prime * result + ((getExpectDifferTime() == null) ? 0 : getExpectDifferTime().hashCode());
        result = prime * result + ((getAppraise() == null) ? 0 : getAppraise().hashCode());
        result = prime * result + ((getActualBeginTime() == null) ? 0 : getActualBeginTime().hashCode());
        result = prime * result + ((getActualEndTime() == null) ? 0 : getActualEndTime().hashCode());
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
        sb.append(", projectId=").append(projectId);
        sb.append(", projectNumber=").append(projectNumber);
        sb.append(", projectName=").append(projectName);
        sb.append(", taskName=").append(taskName);
        sb.append(", taskNumber=").append(taskNumber);
        sb.append(", planStartTime=").append(planStartTime);
        sb.append(", planStopTime=").append(planStopTime);
        sb.append(", limitTime=").append(limitTime);
        sb.append(", nowadaysProgress=").append(nowadaysProgress);
        sb.append(", taskState=").append(taskState);
        sb.append(", expectDifferTime=").append(expectDifferTime);
        sb.append(", appraise=").append(appraise);
        sb.append(", actualBeginTime=").append(actualBeginTime);
        sb.append(", actualEndTime=").append(actualEndTime);
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