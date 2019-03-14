package com.jn.oa.meeting.entity;

import java.io.Serializable;
import java.util.Date;

public class TbOaMeeting implements Serializable {
    private String id;

    private String workOrderNum;

    private Date startTime;

    private Date endTime;

    private String meetingRoomId;

    private String approvalStatus;

    private Byte recordStatus;

    private String creatorAccount;

    private Date createdTime;

    private String modifierAccount;

    private Date modifiedTime;

    private String userIdStr;

    private String applicant;

    private Date applicationTime;

    private String signInQr;

    private String wechatRemind;

    private String messageRemind;

    private String pcRemind;

    private String appRemind;

    private String isRemind;

    private String title;

    private String approvalRole;

    private String approvalUser;

    private String approvalOpinion;

    private String meetingStatus;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getWorkOrderNum() {
        return workOrderNum;
    }

    public void setWorkOrderNum(String workOrderNum) {
        this.workOrderNum = workOrderNum == null ? null : workOrderNum.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getMeetingRoomId() {
        return meetingRoomId;
    }

    public void setMeetingRoomId(String meetingRoomId) {
        this.meetingRoomId = meetingRoomId == null ? null : meetingRoomId.trim();
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus == null ? null : approvalStatus.trim();
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

    public String getUserIdStr() {
        return userIdStr;
    }

    public void setUserIdStr(String userIdStr) {
        this.userIdStr = userIdStr == null ? null : userIdStr.trim();
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant == null ? null : applicant.trim();
    }

    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    public String getSignInQr() {
        return signInQr;
    }

    public void setSignInQr(String signInQr) {
        this.signInQr = signInQr == null ? null : signInQr.trim();
    }

    public String getWechatRemind() {
        return wechatRemind;
    }

    public void setWechatRemind(String wechatRemind) {
        this.wechatRemind = wechatRemind == null ? null : wechatRemind.trim();
    }

    public String getMessageRemind() {
        return messageRemind;
    }

    public void setMessageRemind(String messageRemind) {
        this.messageRemind = messageRemind == null ? null : messageRemind.trim();
    }

    public String getPcRemind() {
        return pcRemind;
    }

    public void setPcRemind(String pcRemind) {
        this.pcRemind = pcRemind == null ? null : pcRemind.trim();
    }

    public String getAppRemind() {
        return appRemind;
    }

    public void setAppRemind(String appRemind) {
        this.appRemind = appRemind == null ? null : appRemind.trim();
    }

    public String getIsRemind() {
        return isRemind;
    }

    public void setIsRemind(String isRemind) {
        this.isRemind = isRemind == null ? null : isRemind.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getApprovalRole() {
        return approvalRole;
    }

    public void setApprovalRole(String approvalRole) {
        this.approvalRole = approvalRole == null ? null : approvalRole.trim();
    }

    public String getApprovalUser() {
        return approvalUser;
    }

    public void setApprovalUser(String approvalUser) {
        this.approvalUser = approvalUser == null ? null : approvalUser.trim();
    }

    public String getApprovalOpinion() {
        return approvalOpinion;
    }

    public void setApprovalOpinion(String approvalOpinion) {
        this.approvalOpinion = approvalOpinion == null ? null : approvalOpinion.trim();
    }

    public String getMeetingStatus() {
        return meetingStatus;
    }

    public void setMeetingStatus(String meetingStatus) {
        this.meetingStatus = meetingStatus == null ? null : meetingStatus.trim();
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
        TbOaMeeting other = (TbOaMeeting) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getWorkOrderNum() == null ? other.getWorkOrderNum() == null : this.getWorkOrderNum().equals(other.getWorkOrderNum()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getMeetingRoomId() == null ? other.getMeetingRoomId() == null : this.getMeetingRoomId().equals(other.getMeetingRoomId()))
            && (this.getApprovalStatus() == null ? other.getApprovalStatus() == null : this.getApprovalStatus().equals(other.getApprovalStatus()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getUserIdStr() == null ? other.getUserIdStr() == null : this.getUserIdStr().equals(other.getUserIdStr()))
            && (this.getApplicant() == null ? other.getApplicant() == null : this.getApplicant().equals(other.getApplicant()))
            && (this.getApplicationTime() == null ? other.getApplicationTime() == null : this.getApplicationTime().equals(other.getApplicationTime()))
            && (this.getSignInQr() == null ? other.getSignInQr() == null : this.getSignInQr().equals(other.getSignInQr()))
            && (this.getWechatRemind() == null ? other.getWechatRemind() == null : this.getWechatRemind().equals(other.getWechatRemind()))
            && (this.getMessageRemind() == null ? other.getMessageRemind() == null : this.getMessageRemind().equals(other.getMessageRemind()))
            && (this.getPcRemind() == null ? other.getPcRemind() == null : this.getPcRemind().equals(other.getPcRemind()))
            && (this.getAppRemind() == null ? other.getAppRemind() == null : this.getAppRemind().equals(other.getAppRemind()))
            && (this.getIsRemind() == null ? other.getIsRemind() == null : this.getIsRemind().equals(other.getIsRemind()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getApprovalRole() == null ? other.getApprovalRole() == null : this.getApprovalRole().equals(other.getApprovalRole()))
            && (this.getApprovalUser() == null ? other.getApprovalUser() == null : this.getApprovalUser().equals(other.getApprovalUser()))
            && (this.getApprovalOpinion() == null ? other.getApprovalOpinion() == null : this.getApprovalOpinion().equals(other.getApprovalOpinion()))
            && (this.getMeetingStatus() == null ? other.getMeetingStatus() == null : this.getMeetingStatus().equals(other.getMeetingStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getWorkOrderNum() == null) ? 0 : getWorkOrderNum().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getMeetingRoomId() == null) ? 0 : getMeetingRoomId().hashCode());
        result = prime * result + ((getApprovalStatus() == null) ? 0 : getApprovalStatus().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getUserIdStr() == null) ? 0 : getUserIdStr().hashCode());
        result = prime * result + ((getApplicant() == null) ? 0 : getApplicant().hashCode());
        result = prime * result + ((getApplicationTime() == null) ? 0 : getApplicationTime().hashCode());
        result = prime * result + ((getSignInQr() == null) ? 0 : getSignInQr().hashCode());
        result = prime * result + ((getWechatRemind() == null) ? 0 : getWechatRemind().hashCode());
        result = prime * result + ((getMessageRemind() == null) ? 0 : getMessageRemind().hashCode());
        result = prime * result + ((getPcRemind() == null) ? 0 : getPcRemind().hashCode());
        result = prime * result + ((getAppRemind() == null) ? 0 : getAppRemind().hashCode());
        result = prime * result + ((getIsRemind() == null) ? 0 : getIsRemind().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getApprovalRole() == null) ? 0 : getApprovalRole().hashCode());
        result = prime * result + ((getApprovalUser() == null) ? 0 : getApprovalUser().hashCode());
        result = prime * result + ((getApprovalOpinion() == null) ? 0 : getApprovalOpinion().hashCode());
        result = prime * result + ((getMeetingStatus() == null) ? 0 : getMeetingStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", workOrderNum=").append(workOrderNum);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", meetingRoomId=").append(meetingRoomId);
        sb.append(", approvalStatus=").append(approvalStatus);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", userIdStr=").append(userIdStr);
        sb.append(", applicant=").append(applicant);
        sb.append(", applicationTime=").append(applicationTime);
        sb.append(", signInQr=").append(signInQr);
        sb.append(", wechatRemind=").append(wechatRemind);
        sb.append(", messageRemind=").append(messageRemind);
        sb.append(", pcRemind=").append(pcRemind);
        sb.append(", appRemind=").append(appRemind);
        sb.append(", isRemind=").append(isRemind);
        sb.append(", title=").append(title);
        sb.append(", approvalRole=").append(approvalRole);
        sb.append(", approvalUser=").append(approvalUser);
        sb.append(", approvalOpinion=").append(approvalOpinion);
        sb.append(", meetingStatus=").append(meetingStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}