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
@ApiModel(value = "findAllMessageListModel",description = "查询所有消息列表")
public class findAllMessageListModel extends Page implements Serializable{
    private static final long serialVersionUID = -9020107199446600992L;


    @ApiModelProperty(value ="二级消息类别(必填)(（1级）1:个人动态;（2级）2:企业订单;3:信息发布动态;4:交费提醒;5:访客留言;6:数据上报提醒;7:机构邀请;8:企业邀请;9:机构邀请;10:私人订单);")

    private String  messageTowTort;


    @ApiModelProperty(value = "消息是否已读(0:未读;1:已读);为空时查询全部")
    private Integer  isRead;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }



    public String getMessageTowTort() {
        return messageTowTort;
    }

    public void setMessageTowTort(String messageTowTort) {
        this.messageTowTort = messageTowTort;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }


    @Override
    public String toString() {
        return "findAllMessageListModel{" +
                ", messageTowTort=" + messageTowTort +
                ", isRead=" + isRead +
                '}';
    }
}
