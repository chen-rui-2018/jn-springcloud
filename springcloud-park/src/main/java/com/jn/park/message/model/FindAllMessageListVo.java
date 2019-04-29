package com.jn.park.message.model;

import com.jn.park.finance.model.FinanceIncomeLastYearContrastModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author： tangry
 * @date： Created on 2019/4/19
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FindAllMessageListVo",description = "查询所有消息列表")
public class FindAllMessageListVo implements Serializable {

    private static final long serialVersionUID = 298840310308423700L;

    @ApiModelProperty(value = "消息类别;0:私人订单;1:信用动态;2:园区通知;3:消费汇总;4:收入汇总;5:付款通知;6:企业订单;7:信息发布动态;8:交费提醒;9:访客留言;10:数据上报提醒;")
    private Integer messageTowSort;

    @ApiModelProperty(value = "消息列表")
    List<MessageListModel> messageListModels;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getMessageTowSort() {
        return messageTowSort;
    }

    public void setMessageTowSort(Integer messageTowSort) {
        this.messageTowSort = messageTowSort;
    }

    public List<MessageListModel> getMessageListModels() {
        return messageListModels;
    }

    public void setMessageListModels(List<MessageListModel> messageListModels) {
        this.messageListModels = messageListModels;
    }


    @Override
    public String toString() {
        return "FindAllMessageListVo{" +
                "messageTowSort=" + messageTowSort +
                ", messageListModels=" + messageListModels +
                '}';
    }
}
