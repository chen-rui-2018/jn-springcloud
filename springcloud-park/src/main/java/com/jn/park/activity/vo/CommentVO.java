package com.jn.park.activity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 活动点评信息
 * @Author: jiangyl
 * @Date: 2018/12/5 11:17
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "CommentVO", description = "活动报名信息")
public class CommentVO implements Serializable {
    @ApiModelProperty(value = "点评ID")
    private String id;
    @ApiModelProperty(value = "点评父ID(点评ID/活动ID)")
    private String pId;
    @ApiModelProperty(value = "点评人")
    private String comAccount;
    @ApiModelProperty(value = "点评时间")
    private String comTime;
    @ApiModelProperty(value = "点评点赞数")
    private Integer likeNum;
    @ApiModelProperty(value = "点评状态")
    private String status;
    @ApiModelProperty(value = "点评类型(0：活动点评，1：服务点评...)")
    private String comType;
    @ApiModelProperty(value = "点评人头像)")
    private String avatar;
    @ApiModelProperty(value = "点评人数)")
    private String commentNum;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getComAccount() {
        return comAccount;
    }

    public void setComAccount(String comAccount) {
        this.comAccount = comAccount;
    }

    public String getComTime() {
        return comTime;
    }

    public void setComTime(String comTime) {
        this.comTime = comTime;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComType() {
        return comType;
    }

    public void setComType(String comType) {
        this.comType = comType;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(String commentNum) {
        this.commentNum = commentNum;
    }

    @Override
    public String toString() {
        return "CommentVO{" +
                "id='" + id + '\'' +
                ", pId='" + pId + '\'' +
                ", comAccount='" + comAccount + '\'' +
                ", comTime='" + comTime + '\'' +
                ", likeNum=" + likeNum +
                ", status='" + status + '\'' +
                ", comType='" + comType + '\'' +
                ", avatar='" + avatar + '\'' +
                ", commentNum='" + commentNum + '\'' +
                '}';
    }
}