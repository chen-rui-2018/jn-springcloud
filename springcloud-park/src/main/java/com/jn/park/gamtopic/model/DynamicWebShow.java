package com.jn.park.gamtopic.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/4/11 15:14
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value="DynamicWebShow",description = "前台展示动态列表")
public class DynamicWebShow implements Serializable {
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
    @ApiModelProperty(value = "公司名称")
    private String companyName;
    @ApiModelProperty(value = "评论数")
    private String commentsNum;
    @ApiModelProperty(value = "点赞数")
    private String likeNum;
    @ApiModelProperty(value = "图片列表")
    private List<String> imgList;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCommentsNum() {
        return commentsNum;
    }

    public void setCommentsNum(String commentsNum) {
        this.commentsNum = commentsNum;
    }

    public String getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(String likeNum) {
        this.likeNum = likeNum;
    }

    public List<String> getImgList() {
        return imgList;
    }

    public void setImgList(List<String> imgList) {
        this.imgList = imgList;
    }
}
