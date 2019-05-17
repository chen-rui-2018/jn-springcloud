package com.jn.park.message.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: tangry
 * @Date: 2019/5/13
 * @Version 1.0
 */
@ApiModel(value = "findAllAppMessageListModel",description = "查询所有消息列表App")
public class findAllAppMessageListModel extends Page implements Serializable{


    private static final long serialVersionUID = -2506530982670682856L;
    @ApiModelProperty(value ="一级消息类别(不可为空), 0:个人动态;1:企业空间;")
    private String  messageOneSort;


    @ApiModelProperty(value = "消息是否已读(0:未读;1:已读);为空时查询全部")
    private Integer  isRead;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMessageOneSort() {
        return messageOneSort;
    }

    public void setMessageOneSort(String messageOneSort) {
        this.messageOneSort = messageOneSort;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    @Override
    public String toString() {
        return "findAllAppMessageListModel{" +
                "messageOneSort=" + messageOneSort +
                ", isRead=" + isRead +
                '}';
    }
}
