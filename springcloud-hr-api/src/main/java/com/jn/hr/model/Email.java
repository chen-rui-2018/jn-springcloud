package com.jn.hr.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 一键Email实体类
 *
 * @author： shaobao
 * @date： Created on 2019/3/9 21:16
 * @version： v1.0
 * @modified By:
 **/
public class Email implements Serializable {
    private String id;

    private String workOrderNum;

    private String title;

    private String emailContent;

    private String sendStatus;

    private String isDelay;

    private Date delaySendTime;

    private Date sendTime;

    private Byte recordStatus;

    private String creatorAccount;

    private Date createdTime;

    private String modifierAccount;

    private Date modifiedTime;

    public Email() {
    }

    public Email(String id, String workOrderNum, String title, String emailContent, String sendStatus,
                 String isDelay, Date delaySendTime, Date sendTime, Byte recordStatus,
                 String creatorAccount, Date createdTime, String modifierAccount, Date modifiedTime) {
        this.id = id;
        this.workOrderNum = workOrderNum;
        this.title = title;
        this.emailContent = emailContent;
        this.sendStatus = sendStatus;
        this.isDelay = isDelay;
        this.delaySendTime = delaySendTime;
        this.sendTime = sendTime;
        this.recordStatus = recordStatus;
        this.creatorAccount = creatorAccount;
        this.createdTime = createdTime;
        this.modifierAccount = modifierAccount;
        this.modifiedTime = modifiedTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWorkOrderNum() {
        return workOrderNum;
    }

    public void setWorkOrderNum(String workOrderNum) {
        this.workOrderNum = workOrderNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent;
    }

    public String getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(String sendStatus) {
        this.sendStatus = sendStatus;
    }

    public String getIsDelay() {
        return isDelay;
    }

    public void setIsDelay(String isDelay) {
        this.isDelay = isDelay;
    }

    public Date getDelaySendTime() {
        return delaySendTime;
    }

    public void setDelaySendTime(Date delaySendTime) {
        this.delaySendTime = delaySendTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
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
        this.creatorAccount = creatorAccount;
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
        this.modifierAccount = modifierAccount;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id='" + id + '\'' +
                ", workOrderNum='" + workOrderNum + '\'' +
                ", title='" + title + '\'' +
                ", emailContent='" + emailContent + '\'' +
                ", sendStatus='" + sendStatus + '\'' +
                ", isDelay='" + isDelay + '\'' +
                ", delaySendTime=" + delaySendTime +
                ", sendTime=" + sendTime +
                ", recordStatus=" + recordStatus +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", createdTime=" + createdTime +
                ", modifierAccount='" + modifierAccount + '\'' +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}
