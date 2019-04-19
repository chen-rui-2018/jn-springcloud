package com.jn.park.message.entity;

import java.io.Serializable;
import java.util.Date;

public class MessageList implements Serializable {
    private Integer id;

    private String messageTitle;

    private String messageConnect;

    private Integer isRead;

    private String messageRecipient;

    private String messageSender;

    private Integer messageOneSort;

    private Integer messageTowSort;

    private Byte recordStatus;

    private String creatorAccount;

    private Date createdTime;

    private String modifierAccount;

    private Date modifiedTime;

    private String messageContent;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle == null ? null : messageTitle.trim();
    }

    public String getMessageConnect() {
        return messageConnect;
    }

    public void setMessageConnect(String messageConnect) {
        this.messageConnect = messageConnect == null ? null : messageConnect.trim();
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    public String getMessageRecipient() {
        return messageRecipient;
    }

    public void setMessageRecipient(String messageRecipient) {
        this.messageRecipient = messageRecipient == null ? null : messageRecipient.trim();
    }

    public String getMessageSender() {
        return messageSender;
    }

    public void setMessageSender(String messageSender) {
        this.messageSender = messageSender == null ? null : messageSender.trim();
    }

    public Integer getMessageOneSort() {
        return messageOneSort;
    }

    public void setMessageOneSort(Integer messageOneSort) {
        this.messageOneSort = messageOneSort;
    }

    public Integer getMessageTowSort() {
        return messageTowSort;
    }

    public void setMessageTowSort(Integer messageTowSort) {
        this.messageTowSort = messageTowSort;
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

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent == null ? null : messageContent.trim();
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
        MessageList other = (MessageList) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMessageTitle() == null ? other.getMessageTitle() == null : this.getMessageTitle().equals(other.getMessageTitle()))
            && (this.getMessageConnect() == null ? other.getMessageConnect() == null : this.getMessageConnect().equals(other.getMessageConnect()))
            && (this.getIsRead() == null ? other.getIsRead() == null : this.getIsRead().equals(other.getIsRead()))
            && (this.getMessageRecipient() == null ? other.getMessageRecipient() == null : this.getMessageRecipient().equals(other.getMessageRecipient()))
            && (this.getMessageSender() == null ? other.getMessageSender() == null : this.getMessageSender().equals(other.getMessageSender()))
            && (this.getMessageOneSort() == null ? other.getMessageOneSort() == null : this.getMessageOneSort().equals(other.getMessageOneSort()))
            && (this.getMessageTowSort() == null ? other.getMessageTowSort() == null : this.getMessageTowSort().equals(other.getMessageTowSort()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getMessageContent() == null ? other.getMessageContent() == null : this.getMessageContent().equals(other.getMessageContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMessageTitle() == null) ? 0 : getMessageTitle().hashCode());
        result = prime * result + ((getMessageConnect() == null) ? 0 : getMessageConnect().hashCode());
        result = prime * result + ((getIsRead() == null) ? 0 : getIsRead().hashCode());
        result = prime * result + ((getMessageRecipient() == null) ? 0 : getMessageRecipient().hashCode());
        result = prime * result + ((getMessageSender() == null) ? 0 : getMessageSender().hashCode());
        result = prime * result + ((getMessageOneSort() == null) ? 0 : getMessageOneSort().hashCode());
        result = prime * result + ((getMessageTowSort() == null) ? 0 : getMessageTowSort().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getMessageContent() == null) ? 0 : getMessageContent().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", messageTitle=").append(messageTitle);
        sb.append(", messageConnect=").append(messageConnect);
        sb.append(", isRead=").append(isRead);
        sb.append(", messageRecipient=").append(messageRecipient);
        sb.append(", messageSender=").append(messageSender);
        sb.append(", messageOneSort=").append(messageOneSort);
        sb.append(", messageTowSort=").append(messageTowSort);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", messageContent=").append(messageContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}