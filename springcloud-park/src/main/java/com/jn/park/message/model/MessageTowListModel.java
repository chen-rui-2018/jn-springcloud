package com.jn.park.message.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： tangry
 * @date： Created on 2019/5/17
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "MessageTowListModel",description = "二级类别列表")
public class MessageTowListModel implements Serializable {


    private static final long serialVersionUID = -6003707520844982517L;
    @ApiModelProperty(value = "消息类别Code")
    private String messageOneTortCode;

    @ApiModelProperty(value = "消息类型名称")
    private String messageOneTortName;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMessageOneTortCode() {
        return messageOneTortCode;
    }

    public void setMessageOneTortCode(String messageOneTortCode) {
        this.messageOneTortCode = messageOneTortCode;
    }

    public String getMessageOneTortName() {
        return messageOneTortName;
    }

    public void setMessageOneTortName(String messageOneTortName) {
        this.messageOneTortName = messageOneTortName;
    }

    @Override
    public String toString() {
        return "MessageTowListModel{" +
                "messageOneTortCode='" + messageOneTortCode + '\'' +
                ", messageOneTortName='" + messageOneTortName + '\'' +
                '}';
    }
}
