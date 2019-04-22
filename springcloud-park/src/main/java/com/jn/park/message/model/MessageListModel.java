package com.jn.park.message.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： tangry
 * @date： Created on 2019/4/19
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "MessageListModel",description = "消息列表")
public class MessageListModel implements Serializable {

    private static final long serialVersionUID = -4762569385979479757L;

    @ApiModelProperty(value = "消息标题")
    private String messageTitle;

    @ApiModelProperty(value = "消息内容")
    private String messageContent;

    @ApiModelProperty(value = "消息中的连接的名称")
    private String messageConnectName;

    @ApiModelProperty(value = "消息中的连接")
    private String messageConnect;

    @ApiModelProperty(value = "是否已读 0:未读;1:已读;")
    private String isRead;

    @ApiModelProperty(value = "消息接收者")
    private String messageRecipient;

    @ApiModelProperty(value = "消息创建者")
    private String messageSender;

    @ApiModelProperty(value = "消息一级分类")
    private String messageOneSort;

    @ApiModelProperty(value = "消息二级分类")
    private String messageTowSort;

    @ApiModelProperty(value = "创建时间")
    private String createdTime;

    @ApiModelProperty(value = "创建人")
    private String creatorAccount;

    public String getMessageConnectName() {
        return messageConnectName;
    }

    public void setMessageConnectName(String messageConnectName) {
        this.messageConnectName = messageConnectName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getMessageConnect() {
        return messageConnect;
    }

    public void setMessageConnect(String messageConnect) {
        this.messageConnect = messageConnect;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    public String getMessageRecipient() {
        return messageRecipient;
    }

    public void setMessageRecipient(String messageRecipient) {
        this.messageRecipient = messageRecipient;
    }

    public String getMessageSender() {
        return messageSender;
    }

    public void setMessageSender(String messageSender) {
        this.messageSender = messageSender;
    }

    public String getMessageOneSort() {
        return messageOneSort;
    }

    public void setMessageOneSort(String messageOneSort) {
        this.messageOneSort = messageOneSort;
    }

    public String getMessageTowSort() {
        return messageTowSort;
    }

    public void setMessageTowSort(String messageTowSort) {
        this.messageTowSort = messageTowSort;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }


    @Override
    public String toString() {
        return "MessageListModel{" +
                "messageTitle='" + messageTitle + '\'' +
                ", messageContent='" + messageContent + '\'' +
                ", messageConnectName='" + messageConnectName + '\'' +
                ", messageConnect='" + messageConnect + '\'' +
                ", isRead='" + isRead + '\'' +
                ", messageRecipient='" + messageRecipient + '\'' +
                ", messageSender='" + messageSender + '\'' +
                ", messageOneSort='" + messageOneSort + '\'' +
                ", messageTowSort='" + messageTowSort + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                '}';
    }
}
