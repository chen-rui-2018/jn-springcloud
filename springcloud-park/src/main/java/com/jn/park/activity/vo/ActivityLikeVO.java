package com.jn.park.activity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动点赞信息
 *
 * @Author: jiangyl
 * @Date: 2018/12/5 11:21
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ActivityLike", description = "活动点赞信息")
public class ActivityLikeVO implements Serializable {
    @ApiModelProperty(value = "点赞ID")
    private String id;
    @ApiModelProperty(value = "活动ID")
    private String activityId;
    @ApiModelProperty(value = "点赞用户ID")
    private String likeUserId;
    @ApiModelProperty(value = "点赞时间")
    private Date likeTime;
    @ApiModelProperty(value = "点赞状态(0点赞 1点赞取消)")
    private String state;
    @ApiModelProperty(value = "点赞数")
    private String likeAccount;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId == null ? null : activityId.trim();
    }

    public String getLikeUserId() {
        return likeUserId;
    }

    public void setLikeUserId(String likeUserId) {
        this.likeUserId = likeUserId == null ? null : likeUserId.trim();
    }

    public Date getLikeTime() {
        return likeTime;
    }

    public void setLikeTime(Date likeTime) {
        this.likeTime = likeTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getLikeAccount() {
        return likeAccount;
    }

    public void setLikeAccount(String likeAccount) {
        this.likeAccount = likeAccount;
    }

    @Override
    public String toString() {
        return "ActivityLikeVO{" +
                "id='" + id + '\'' +
                ", activityId='" + activityId + '\'' +
                ", likeUserId='" + likeUserId + '\'' +
                ", likeTime=" + likeTime +
                ", state='" + state + '\'' +
                ", likeAccount='" + likeAccount + '\'' +
                '}';
    }
}