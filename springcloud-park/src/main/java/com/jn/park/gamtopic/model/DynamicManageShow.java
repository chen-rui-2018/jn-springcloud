package com.jn.park.gamtopic.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/10 16:33
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "DynamicManageShow",description = "后台动态管理界面列表")
public class DynamicManageShow implements Serializable {
    @ApiModelProperty(value="动态id")
    private String topicId;
    @ApiModelProperty(value="动态内容")
    private String topicContent;
    @ApiModelProperty(value = "发布时间")
    private String createdTime;
    @ApiModelProperty(value = "发布人账号")
    private String creatorAccount;
    @ApiModelProperty(value = "发布人头像")
    private String avatar;
    @ApiModelProperty(value = "发布人昵称")
    private String nickName;
    @ApiModelProperty(value = "联系电话")
    private String phone;
    @ApiModelProperty(value = "性别(0:女  1：男)")
    private String sex;
    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
