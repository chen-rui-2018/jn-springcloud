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
    private String messageTowSort;

    @ApiModelProperty(value = "消息类型名称")
    private String messageTowSortName;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMessageTowSort() {
        return messageTowSort;
    }

    public void setMessageTowSort(String messageTowSort) {
        this.messageTowSort = messageTowSort;
    }

    public String getMessageTowSortName() {
        return messageTowSortName;
    }

    public void setMessageTowSortName(String messageTowSortName) {
        this.messageTowSortName = messageTowSortName;
    }

    @Override
    public String toString() {
        return "MessageTowListModel{" +
                "messageTowSort='" + messageTowSort + '\'' +
                ", messageTowSortName='" + messageTowSortName + '\'' +
                '}';
    }
}
