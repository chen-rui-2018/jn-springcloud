package com.jn.park.gamtopic.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/5/8 16:35
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "DynamicCommentReplyShow",description = "动态评论和评论回复列表实体bean")
public class DynamicCommentReplyShow  implements Serializable {
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
    @ApiModelProperty(value= "评论时间")
    private String createdTime;
    @ApiModelProperty(value="评论回复数")
    private String  replyNum;
    @ApiModelProperty(value="点赞数")
    private String  likeNum;
    @ApiModelProperty(value= "评论的内容")
    private String comContent;
    @ApiModelProperty(value = "评论的回复列表信息")
    private List<DynamicComments> replyList;

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

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

    public List<DynamicComments> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<DynamicComments> replyList) {
        this.replyList = replyList;
    }
}
