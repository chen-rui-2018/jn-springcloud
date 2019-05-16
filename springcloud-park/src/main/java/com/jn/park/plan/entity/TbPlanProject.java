package com.jn.park.plan.entity;

import java.io.Serializable;
import java.util.Date;

public class TbPlanProject implements Serializable {
    private String id;

    private String projectName;

    private String projectNo;

    private String owner;

    private String ownerDepartment;

    private Date planStartTime;

    private Date planStopTime;

    private Integer limitTime;

    private Integer surplusTime;

    private Integer projectState;

    private Date actualBeginTime;

    private Date actualEndTime;

    private Long progress;

    private Integer projectSurplusTask;

    private Integer materialIsEntering;

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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo == null ? null : projectNo.trim();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    public String getOwnerDepartment() {
        return ownerDepartment;
    }

    public void setOwnerDepartment(String ownerDepartment) {
        this.ownerDepartment = ownerDepartment == null ? null : ownerDepartment.trim();
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

    public Integer getSurplusTime() {
        return surplusTime;
    }

    public void setSurplusTime(Integer surplusTime) {
        this.surplusTime = surplusTime;
    }

    public Integer getProjectState() {
        return projectState;
    }

    public void setProjectState(Integer projectState) {
        this.projectState = projectState;
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

    public Long getProgress() {
        return progress;
    }

    public void setProgress(Long progress) {
        this.progress = progress;
    }

    public Integer getProjectSurplusTask() {
        return projectSurplusTask;
    }

    public void setProjectSurplusTask(Integer projectSurplusTask) {
        this.projectSurplusTask = projectSurplusTask;
    }

    public Integer getMaterialIsEntering() {
        return materialIsEntering;
    }

    public void setMaterialIsEntering(Integer materialIsEntering) {
        this.materialIsEntering = materialIsEntering;
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
        TbPlanProject other = (TbPlanProject) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getProjectNo() == null ? other.getProjectNo() == null : this.getProjectNo().equals(other.getProjectNo()))
            && (this.getOwner() == null ? other.getOwner() == null : this.getOwner().equals(other.getOwner()))
            && (this.getOwnerDepartment() == null ? other.getOwnerDepartment() == null : this.getOwnerDepartment().equals(other.getOwnerDepartment()))
            && (this.getPlanStartTime() == null ? other.getPlanStartTime() == null : this.getPlanStartTime().equals(other.getPlanStartTime()))
            && (this.getPlanStopTime() == null ? other.getPlanStopTime() == null : this.getPlanStopTime().equals(other.getPlanStopTime()))
            && (this.getLimitTime() == null ? other.getLimitTime() == null : this.getLimitTime().equals(other.getLimitTime()))
            && (this.getSurplusTime() == null ? other.getSurplusTime() == null : this.getSurplusTime().equals(other.getSurplusTime()))
            && (this.getProjectState() == null ? other.getProjectState() == null : this.getProjectState().equals(other.getProjectState()))
            && (this.getActualBeginTime() == null ? other.getActualBeginTime() == null : this.getActualBeginTime().equals(other.getActualBeginTime()))
            && (this.getActualEndTime() == null ? other.getActualEndTime() == null : this.getActualEndTime().equals(other.getActualEndTime()))
            && (this.getProgress() == null ? other.getProgress() == null : this.getProgress().equals(other.getProgress()))
            && (this.getProjectSurplusTask() == null ? other.getProjectSurplusTask() == null : this.getProjectSurplusTask().equals(other.getProjectSurplusTask()))
            && (this.getMaterialIsEntering() == null ? other.getMaterialIsEntering() == null : this.getMaterialIsEntering().equals(other.getMaterialIsEntering()))
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
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getProjectNo() == null) ? 0 : getProjectNo().hashCode());
        result = prime * result + ((getOwner() == null) ? 0 : getOwner().hashCode());
        result = prime * result + ((getOwnerDepartment() == null) ? 0 : getOwnerDepartment().hashCode());
        result = prime * result + ((getPlanStartTime() == null) ? 0 : getPlanStartTime().hashCode());
        result = prime * result + ((getPlanStopTime() == null) ? 0 : getPlanStopTime().hashCode());
        result = prime * result + ((getLimitTime() == null) ? 0 : getLimitTime().hashCode());
        result = prime * result + ((getSurplusTime() == null) ? 0 : getSurplusTime().hashCode());
        result = prime * result + ((getProjectState() == null) ? 0 : getProjectState().hashCode());
        result = prime * result + ((getActualBeginTime() == null) ? 0 : getActualBeginTime().hashCode());
        result = prime * result + ((getActualEndTime() == null) ? 0 : getActualEndTime().hashCode());
        result = prime * result + ((getProgress() == null) ? 0 : getProgress().hashCode());
        result = prime * result + ((getProjectSurplusTask() == null) ? 0 : getProjectSurplusTask().hashCode());
        result = prime * result + ((getMaterialIsEntering() == null) ? 0 : getMaterialIsEntering().hashCode());
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
        sb.append(", projectName=").append(projectName);
        sb.append(", projectNo=").append(projectNo);
        sb.append(", owner=").append(owner);
        sb.append(", ownerDepartment=").append(ownerDepartment);
        sb.append(", planStartTime=").append(planStartTime);
        sb.append(", planStopTime=").append(planStopTime);
        sb.append(", limitTime=").append(limitTime);
        sb.append(", surplusTime=").append(surplusTime);
        sb.append(", projectState=").append(projectState);
        sb.append(", actualBeginTime=").append(actualBeginTime);
        sb.append(", actualEndTime=").append(actualEndTime);
        sb.append(", progress=").append(progress);
        sb.append(", projectSurplusTask=").append(projectSurplusTask);
        sb.append(", materialIsEntering=").append(materialIsEntering);
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