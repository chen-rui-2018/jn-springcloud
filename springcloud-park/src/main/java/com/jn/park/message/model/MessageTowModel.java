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
@ApiModel(value = "MessageTowModel",description = "二级类别")
public class MessageTowModel implements Serializable {


    private static final long serialVersionUID = -212151685031710825L;
    @ApiModelProperty(value = "消息类别Code")
    private String messageTowSort;


    public String getMessageOneTortCode() {
        return messageTowSort;
    }

    public void setMessageOneTortCode(String messageOneTortCode) {
        this.messageTowSort = messageOneTortCode;
    }

    @Override
    public String toString() {
        return "MessageTowModel{" +
                "messageOneTortCode='" + messageTowSort + '\'' +
                '}';
    }
}
