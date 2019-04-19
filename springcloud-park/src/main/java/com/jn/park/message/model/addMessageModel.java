package com.jn.park.message.model;

import com.jn.park.finance.model.FinanceBudgetQueryModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： huangbq
 * @date： Created on 2019/3/4 15:54
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value ="addMessageModel",description = "添加消息")
public class addMessageModel implements Serializable {


    private static final long serialVersionUID = 7775713908624163861L;

    @ApiModelProperty("消息标题")
    private String messageTitle;

    @ApiModelProperty("消息内容")
    private String message_content;

    @ApiModelProperty("消息中连接")
    private String message_connect;

    @ApiModelProperty("消息接受人")
    private String message_recipien;

    @ApiModelProperty("消息发送人")
    private String message_sender;

    @ApiModelProperty("消息一级类别")
    private Integer message_one_sort;

    @ApiModelProperty("消息二级类别")
    private Integer message_tow_sort;

    @ApiModelProperty("创建者账号")
    private String creator_account;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessage_content() {
        return message_content;
    }

    public void setMessage_content(String message_content) {
        this.message_content = message_content;
    }

    public String getMessage_connect() {
        return message_connect;
    }

    public void setMessage_connect(String message_connect) {
        this.message_connect = message_connect;
    }

    public String getMessage_recipien() {
        return message_recipien;
    }

    public void setMessage_recipien(String message_recipien) {
        this.message_recipien = message_recipien;
    }

    public String getMessage_sender() {
        return message_sender;
    }

    public void setMessage_sender(String message_sender) {
        this.message_sender = message_sender;
    }

    public Integer getMessage_one_sort() {
        return message_one_sort;
    }

    public void setMessage_one_sort(Integer message_one_sort) {
        this.message_one_sort = message_one_sort;
    }

    public Integer getMessage_tow_sort() {
        return message_tow_sort;
    }

    public void setMessage_tow_sort(Integer message_tow_sort) {
        this.message_tow_sort = message_tow_sort;
    }

    public String getCreator_account() {
        return creator_account;
    }

    public void setCreator_account(String creator_account) {
        this.creator_account = creator_account;
    }

    public addMessageModel(String messageTitle, String message_content, String message_connect, String message_recipien, String message_sender, Integer message_one_sort, Integer message_tow_sort, String creator_account) {
        this.messageTitle = messageTitle;
        this.message_content = message_content;
        this.message_connect = message_connect;
        this.message_recipien = message_recipien;
        this.message_sender = message_sender;
        this.message_one_sort = message_one_sort;
        this.message_tow_sort = message_tow_sort;
        this.creator_account = creator_account;
    }

    @Override
    public String toString() {
        return "addMessageModel{" +
                "messageTitle='" + messageTitle + '\'' +
                ", message_content='" + message_content + '\'' +
                ", message_connect='" + message_connect + '\'' +
                ", message_recipien='" + message_recipien + '\'' +
                ", message_sender='" + message_sender + '\'' +
                ", message_one_sort=" + message_one_sort +
                ", message_tow_sort=" + message_tow_sort +
                ", creator_account='" + creator_account + '\'' +
                '}';
    }
}
