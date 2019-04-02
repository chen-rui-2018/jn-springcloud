package com.jn.park.feedback.entity;

import java.io.Serializable;
import java.util.Date;

public class TbUserFeedback implements Serializable {
    private String feedId;

    private String feedContent;

    private String feedTypeId;

    private String feedTypeName;

    private Date createdTime;

    private String creatorAccount;

    private Date modifiedTime;

    private String modifierAccount;

    private Byte recordStatus;

    private static final long serialVersionUID = 1L;

    public String getFeedId() {
        return feedId;
    }

    public void setFeedId(String feedId) {
        this.feedId = feedId == null ? null : feedId.trim();
    }

    public String getFeedContent() {
        return feedContent;
    }

    public void setFeedContent(String feedContent) {
        this.feedContent = feedContent == null ? null : feedContent.trim();
    }

    public String getFeedTypeId() {
        return feedTypeId;
    }

    public void setFeedTypeId(String feedTypeId) {
        this.feedTypeId = feedTypeId == null ? null : feedTypeId.trim();
    }

    public String getFeedTypeName() {
        return feedTypeName;
    }

    public void setFeedTypeName(String feedTypeName) {
        this.feedTypeName = feedTypeName == null ? null : feedTypeName.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount == null ? null : creatorAccount.trim();
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount == null ? null : modifierAccount.trim();
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
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
        TbUserFeedback other = (TbUserFeedback) that;
        return (this.getFeedId() == null ? other.getFeedId() == null : this.getFeedId().equals(other.getFeedId()))
            && (this.getFeedContent() == null ? other.getFeedContent() == null : this.getFeedContent().equals(other.getFeedContent()))
            && (this.getFeedTypeId() == null ? other.getFeedTypeId() == null : this.getFeedTypeId().equals(other.getFeedTypeId()))
            && (this.getFeedTypeName() == null ? other.getFeedTypeName() == null : this.getFeedTypeName().equals(other.getFeedTypeName()))
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
        result = prime * result + ((getFeedId() == null) ? 0 : getFeedId().hashCode());
        result = prime * result + ((getFeedContent() == null) ? 0 : getFeedContent().hashCode());
        result = prime * result + ((getFeedTypeId() == null) ? 0 : getFeedTypeId().hashCode());
        result = prime * result + ((getFeedTypeName() == null) ? 0 : getFeedTypeName().hashCode());
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
        sb.append(", feedId=").append(feedId);
        sb.append(", feedContent=").append(feedContent);
        sb.append(", feedTypeId=").append(feedTypeId);
        sb.append(", feedTypeName=").append(feedTypeName);
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