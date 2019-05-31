package com.jn.park.message.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: tangry
 * @Date: 2019/5/10
 * @Version 1.0
 */
@ApiModel(value ="AddMessageModel",description = "添加消息")
public class AddMessageModel implements Serializable {

    @ApiModelProperty("消息id")
    private String id;

    @ApiModelProperty("消息标题")
    private String messageTitle;

    @ApiModelProperty("消息内容")
    private String messageContent;

    @ApiModelProperty("消息中连接")
    private String messageConnect;

    @ApiModelProperty("消息中连接名称")
    private String messageConnectName;

    @ApiModelProperty("消息接受人")
    private String messageRecipien;

    @ApiModelProperty("消息发送人")
    private String messageSender;

    @ApiModelProperty(value = "消息一级分类 （0：个人动态，1：企业空间）")
    private Integer messageOneSort;

    @ApiModelProperty(value = "消息一级分类名称 （0：个人动态，1：企业空间）")
    private String messageOneSortName;

    @ApiModelProperty(value = "消息二级分类（0：私人订单，1：信用动态，2：园区通知，3：消费汇总，4：收入汇总，5，付款通知，6：企业订单，7：信息发布动态，8：交费提醒，9：访客留言，10：数据上报提醒  11.机构邀请）")
    private Integer messageTowSort;

    @ApiModelProperty(value = "消息二级分类名称（0：私人订单，1：信用动态，2：园区通知，3：消费汇总，4：收入汇总，5，付款通知，6：企业订单，7：信息发布动态，8：交费提醒，9：访客留言，10：数据上报提醒  11.机构邀请）")
    private String messageTowSortName;

    @ApiModelProperty("创建者账号")
    private String creatorAccount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getMessageConnectName() {
        return messageConnectName;
    }

    public void setMessageConnectName(String messageConnectName) {
        this.messageConnectName = messageConnectName;
    }

    public String getMessageRecipien() {
        return messageRecipien;
    }

    public void setMessageRecipien(String messageRecipien) {
        this.messageRecipien = messageRecipien;
    }

    public String getMessageSender() {
        return messageSender;
    }

    public void setMessageSender(String messageSender) {
        this.messageSender = messageSender;
    }

    public Integer getMessageOneSort() {
        return messageOneSort;
    }

    public void setMessageOneSort(Integer messageOneSort) {
        this.messageOneSort = messageOneSort;
    }

    public String getMessageOneSortName() {
        return messageOneSortName;
    }

    public void setMessageOneSortName(String messageOneSortName) {
        this.messageOneSortName = messageOneSortName;
    }

    public Integer getMessageTowSort() {
        return messageTowSort;
    }

    public void setMessageTowSort(Integer messageTowSort) {
        this.messageTowSort = messageTowSort;
    }

    public String getMessageTowSortName() {
        return messageTowSortName;
    }

    public void setMessageTowSortName(String messageTowSortName) {
        this.messageTowSortName = messageTowSortName;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    @Override
    public String toString() {
        return "AddMessageModel{" +
                "id='" + id + '\'' +
                ", messageTitle='" + messageTitle + '\'' +
                ", messageContent='" + messageContent + '\'' +
                ", messageConnect='" + messageConnect + '\'' +
                ", messageConnectName='" + messageConnectName + '\'' +
                ", messageRecipien='" + messageRecipien + '\'' +
                ", messageSender='" + messageSender + '\'' +
                ", messageOneSort=" + messageOneSort +
                ", messageOneSortName='" + messageOneSortName + '\'' +
                ", messageTowSort=" + messageTowSort +
                ", messageTowSortName='" + messageTowSortName + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                '}';
    }
}
