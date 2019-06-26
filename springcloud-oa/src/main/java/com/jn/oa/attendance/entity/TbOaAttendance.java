package com.jn.oa.attendance.entity;

import java.io.Serializable;
import java.util.Date;

public class TbOaAttendance implements Serializable {
    private String id;

    private String groupId;

    private String planId;

    private String recordId;

    private Date workDate;

    private String userId;

    private String userName;

    private String checkType;

    private String timeResult;

    private String locationResult;

    private String approveId;

    private String procInstId;

    private Date baseCheckTime;

    private Date userCheckTime;

    private String sourceType;

    private String corpId;

    private String departmentId;

    private String departmentName;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId == null ? null : planId.trim();
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId == null ? null : recordId.trim();
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType == null ? null : checkType.trim();
    }

    public String getTimeResult() {
        return timeResult;
    }

    public void setTimeResult(String timeResult) {
        this.timeResult = timeResult == null ? null : timeResult.trim();
    }

    public String getLocationResult() {
        return locationResult;
    }

    public void setLocationResult(String locationResult) {
        this.locationResult = locationResult == null ? null : locationResult.trim();
    }

    public String getApproveId() {
        return approveId;
    }

    public void setApproveId(String approveId) {
        this.approveId = approveId == null ? null : approveId.trim();
    }

    public String getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId == null ? null : procInstId.trim();
    }

    public Date getBaseCheckTime() {
        return baseCheckTime;
    }

    public void setBaseCheckTime(Date baseCheckTime) {
        this.baseCheckTime = baseCheckTime;
    }

    public Date getUserCheckTime() {
        return userCheckTime;
    }

    public void setUserCheckTime(Date userCheckTime) {
        this.userCheckTime = userCheckTime;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType == null ? null : sourceType.trim();
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId == null ? null : corpId.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
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
        TbOaAttendance other = (TbOaAttendance) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGroupId() == null ? other.getGroupId() == null : this.getGroupId().equals(other.getGroupId()))
            && (this.getPlanId() == null ? other.getPlanId() == null : this.getPlanId().equals(other.getPlanId()))
            && (this.getRecordId() == null ? other.getRecordId() == null : this.getRecordId().equals(other.getRecordId()))
            && (this.getWorkDate() == null ? other.getWorkDate() == null : this.getWorkDate().equals(other.getWorkDate()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getCheckType() == null ? other.getCheckType() == null : this.getCheckType().equals(other.getCheckType()))
            && (this.getTimeResult() == null ? other.getTimeResult() == null : this.getTimeResult().equals(other.getTimeResult()))
            && (this.getLocationResult() == null ? other.getLocationResult() == null : this.getLocationResult().equals(other.getLocationResult()))
            && (this.getApproveId() == null ? other.getApproveId() == null : this.getApproveId().equals(other.getApproveId()))
            && (this.getProcInstId() == null ? other.getProcInstId() == null : this.getProcInstId().equals(other.getProcInstId()))
            && (this.getBaseCheckTime() == null ? other.getBaseCheckTime() == null : this.getBaseCheckTime().equals(other.getBaseCheckTime()))
            && (this.getUserCheckTime() == null ? other.getUserCheckTime() == null : this.getUserCheckTime().equals(other.getUserCheckTime()))
            && (this.getSourceType() == null ? other.getSourceType() == null : this.getSourceType().equals(other.getSourceType()))
            && (this.getCorpId() == null ? other.getCorpId() == null : this.getCorpId().equals(other.getCorpId()))
            && (this.getDepartmentId() == null ? other.getDepartmentId() == null : this.getDepartmentId().equals(other.getDepartmentId()))
            && (this.getDepartmentName() == null ? other.getDepartmentName() == null : this.getDepartmentName().equals(other.getDepartmentName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGroupId() == null) ? 0 : getGroupId().hashCode());
        result = prime * result + ((getPlanId() == null) ? 0 : getPlanId().hashCode());
        result = prime * result + ((getRecordId() == null) ? 0 : getRecordId().hashCode());
        result = prime * result + ((getWorkDate() == null) ? 0 : getWorkDate().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getCheckType() == null) ? 0 : getCheckType().hashCode());
        result = prime * result + ((getTimeResult() == null) ? 0 : getTimeResult().hashCode());
        result = prime * result + ((getLocationResult() == null) ? 0 : getLocationResult().hashCode());
        result = prime * result + ((getApproveId() == null) ? 0 : getApproveId().hashCode());
        result = prime * result + ((getProcInstId() == null) ? 0 : getProcInstId().hashCode());
        result = prime * result + ((getBaseCheckTime() == null) ? 0 : getBaseCheckTime().hashCode());
        result = prime * result + ((getUserCheckTime() == null) ? 0 : getUserCheckTime().hashCode());
        result = prime * result + ((getSourceType() == null) ? 0 : getSourceType().hashCode());
        result = prime * result + ((getCorpId() == null) ? 0 : getCorpId().hashCode());
        result = prime * result + ((getDepartmentId() == null) ? 0 : getDepartmentId().hashCode());
        result = prime * result + ((getDepartmentName() == null) ? 0 : getDepartmentName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", groupId=").append(groupId);
        sb.append(", planId=").append(planId);
        sb.append(", recordId=").append(recordId);
        sb.append(", workDate=").append(workDate);
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", checkType=").append(checkType);
        sb.append(", timeResult=").append(timeResult);
        sb.append(", locationResult=").append(locationResult);
        sb.append(", approveId=").append(approveId);
        sb.append(", procInstId=").append(procInstId);
        sb.append(", baseCheckTime=").append(baseCheckTime);
        sb.append(", userCheckTime=").append(userCheckTime);
        sb.append(", sourceType=").append(sourceType);
        sb.append(", corpId=").append(corpId);
        sb.append(", departmentId=").append(departmentId);
        sb.append(", departmentName=").append(departmentName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}