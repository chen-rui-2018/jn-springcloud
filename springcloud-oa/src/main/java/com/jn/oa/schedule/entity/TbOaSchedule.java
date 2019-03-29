package com.jn.oa.schedule.entity;

import java.io.Serializable;
import java.util.Date;

public class TbOaSchedule implements Serializable {
    private String id;

    private String title;

    private String content;

    private Date startTime;

    private Date endTime;

    private Date remindTime;

    private String isRemind;

    private String wechatRemind;

    private String messageRemind;

    private String pcRemind;

    private String appRemind;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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

    public Date getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(Date remindTime) {
        this.remindTime = remindTime;
    }

    public String getIsRemind() {
        return isRemind;
    }

    public void setIsRemind(String isRemind) {
        this.isRemind = isRemind == null ? null : isRemind.trim();
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
        TbOaSchedule other = (TbOaSchedule) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getRemindTime() == null ? other.getRemindTime() == null : this.getRemindTime().equals(other.getRemindTime()))
            && (this.getIsRemind() == null ? other.getIsRemind() == null : this.getIsRemind().equals(other.getIsRemind()))
            && (this.getWechatRemind() == null ? other.getWechatRemind() == null : this.getWechatRemind().equals(other.getWechatRemind()))
            && (this.getMessageRemind() == null ? other.getMessageRemind() == null : this.getMessageRemind().equals(other.getMessageRemind()))
            && (this.getPcRemind() == null ? other.getPcRemind() == null : this.getPcRemind().equals(other.getPcRemind()))
            && (this.getAppRemind() == null ? other.getAppRemind() == null : this.getAppRemind().equals(other.getAppRemind()))
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
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getRemindTime() == null) ? 0 : getRemindTime().hashCode());
        result = prime * result + ((getIsRemind() == null) ? 0 : getIsRemind().hashCode());
        result = prime * result + ((getWechatRemind() == null) ? 0 : getWechatRemind().hashCode());
        result = prime * result + ((getMessageRemind() == null) ? 0 : getMessageRemind().hashCode());
        result = prime * result + ((getPcRemind() == null) ? 0 : getPcRemind().hashCode());
        result = prime * result + ((getAppRemind() == null) ? 0 : getAppRemind().hashCode());
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
        sb.append(", title=").append(title);
        sb.append(", content=").append(content);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", remindTime=").append(remindTime);
        sb.append(", isRemind=").append(isRemind);
        sb.append(", wechatRemind=").append(wechatRemind);
        sb.append(", messageRemind=").append(messageRemind);
        sb.append(", pcRemind=").append(pcRemind);
        sb.append(", appRemind=").append(appRemind);
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