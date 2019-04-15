package com.jn.park.gamtopic.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/11 20:46
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value="DynamicComments",description = "动态评论内容,评论回复内容")
public class DynamicComments implements Serializable {
    @ApiModelProperty(value="评论id")
    private String  commentId;
    @ApiModelProperty(value="评论根目标id")
    private String  rootId;
    @ApiModelProperty(value="评论人账号")
    private String  creatorAccount;
    @ApiModelProperty(value="昵称")
    private String  nickName;
    @ApiModelProperty(value="头像")
    private String  avatar;
    @ApiModelProperty(value="评论回复数")
    private String  replyNum;
    @ApiModelProperty(value="点赞数")
    private String  likeNum;
    @ApiModelProperty(value= "评论的内容")
    private String comContent;


    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getRootId() {
        return rootId;
    }

    public void setRootId(String rootId) {
        this.rootId = rootId;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(String replyNum) {
        this.replyNum = replyNum;
    }

    public String getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(String likeNum) {
        this.likeNum = likeNum;
    }

    public String getComContent() {
        return comContent;
    }

    public void setComContent(String comContent) {
        this.comContent = comContent;
    }
}
