package com.jn.oa.meeting.entity;

import java.io.Serializable;
import java.util.Date;

public class TbOaMeeting implements Serializable {
    private String id;

    private Date startTime;

    private Date endTime;

    private String meetingRoomId;

    private String meetingStatus;

    private Byte recordStatus;

    private String creatorAccount;

    private Date createdTime;

    private String modifierAccount;

    private Date modifiedTime;

    private String participantsStr;

    private String applicant;

    private Date applicationTime;

    private String signInQr;

    private String wechatRemind;

    private String messageRemind;

    private String pcRemind;

    private String appRemind;

    private String isRemind;

    private String title;

    private String organizationalUser;

    private String fileUrl;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public String getMeetingStatus() {
        return meetingStatus;
    }

    public void setMeetingStatus(String meetingStatus) {
        this.meetingStatus = meetingStatus == null ? null : meetingStatus.trim();
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

    public String getParticipantsStr() {
        return participantsStr;
    }

    public void setParticipantsStr(String participantsStr) {
        this.participantsStr = participantsStr == null ? null : participantsStr.trim();
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

    public String getOrganizationalUser() {
        return organizationalUser;
    }

    public void setOrganizationalUser(String organizationalUser) {
        this.organizationalUser = organizationalUser == null ? null : organizationalUser.trim();
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
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
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getMeetingRoomId() == null ? other.getMeetingRoomId() == null : this.getMeetingRoomId().equals(other.getMeetingRoomId()))
            && (this.getMeetingStatus() == null ? other.getMeetingStatus() == null : this.getMeetingStatus().equals(other.getMeetingStatus()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getParticipantsStr() == null ? other.getParticipantsStr() == null : this.getParticipantsStr().equals(other.getParticipantsStr()))
            && (this.getApplicant() == null ? other.getApplicant() == null : this.getApplicant().equals(other.getApplicant()))
            && (this.getApplicationTime() == null ? other.getApplicationTime() == null : this.getApplicationTime().equals(other.getApplicationTime()))
            && (this.getSignInQr() == null ? other.getSignInQr() == null : this.getSignInQr().equals(other.getSignInQr()))
            && (this.getWechatRemind() == null ? other.getWechatRemind() == null : this.getWechatRemind().equals(other.getWechatRemind()))
            && (this.getMessageRemind() == null ? other.getMessageRemind() == null : this.getMessageRemind().equals(other.getMessageRemind()))
            && (this.getPcRemind() == null ? other.getPcRemind() == null : this.getPcRemind().equals(other.getPcRemind()))
            && (this.getAppRemind() == null ? other.getAppRemind() == null : this.getAppRemind().equals(other.getAppRemind()))
            && (this.getIsRemind() == null ? other.getIsRemind() == null : this.getIsRemind().equals(other.getIsRemind()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getOrganizationalUser() == null ? other.getOrganizationalUser() == null : this.getOrganizationalUser().equals(other.getOrganizationalUser()))
            && (this.getFileUrl() == null ? other.getFileUrl() == null : this.getFileUrl().equals(other.getFileUrl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getMeetingRoomId() == null) ? 0 : getMeetingRoomId().hashCode());
        result = prime * result + ((getMeetingStatus() == null) ? 0 : getMeetingStatus().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getParticipantsStr() == null) ? 0 : getParticipantsStr().hashCode());
        result = prime * result + ((getApplicant() == null) ? 0 : getApplicant().hashCode());
        result = prime * result + ((getApplicationTime() == null) ? 0 : getApplicationTime().hashCode());
        result = prime * result + ((getSignInQr() == null) ? 0 : getSignInQr().hashCode());
        result = prime * result + ((getWechatRemind() == null) ? 0 : getWechatRemind().hashCode());
        result = prime * result + ((getMessageRemind() == null) ? 0 : getMessageRemind().hashCode());
        result = prime * result + ((getPcRemind() == null) ? 0 : getPcRemind().hashCode());
        result = prime * result + ((getAppRemind() == null) ? 0 : getAppRemind().hashCode());
        result = prime * result + ((getIsRemind() == null) ? 0 : getIsRemind().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getOrganizationalUser() == null) ? 0 : getOrganizationalUser().hashCode());
        result = prime * result + ((getFileUrl() == null) ? 0 : getFileUrl().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", meetingRoomId=").append(meetingRoomId);
        sb.append(", meetingStatus=").append(meetingStatus);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", participantsStr=").append(participantsStr);
        sb.append(", applicant=").append(applicant);
        sb.append(", applicationTime=").append(applicationTime);
        sb.append(", signInQr=").append(signInQr);
        sb.append(", wechatRemind=").append(wechatRemind);
        sb.append(", messageRemind=").append(messageRemind);
        sb.append(", pcRemind=").append(pcRemind);
        sb.append(", appRemind=").append(appRemind);
        sb.append(", isRemind=").append(isRemind);
        sb.append(", title=").append(title);
        sb.append(", organizationalUser=").append(organizationalUser);
        sb.append(", fileUrl=").append(fileUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}