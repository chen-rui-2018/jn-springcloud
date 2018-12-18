package com.jn.park.activity.vo;


import com.jn.park.activity.model.ActivityDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 活动详情信息
 *
 * @Author: jiangyl
 * @Date: 2018/12/5 11:17
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ActivityDetailVO", description = "活动详情信息")
public class ActivityDetailVO implements Serializable {
    @ApiModelProperty(value = "园区活动信息)")
    private ActivityDetail activityDetail;
    @ApiModelProperty(value = "活动点赞信息，活动id、点赞人、点赞时间、点赞状态、点赞人数")
    private List activityLikeList;
    @ApiModelProperty(value = "点赞数)")
    private Integer likeNum;
    @ApiModelProperty(value = "活动报名信息，活动id、报名人、报名时间、报名状态、签到状态、签到时间、签到方式、报名人数")
    private List activityApplyList;
    @ApiModelProperty(value = "实际报名人数")
    private Integer realapplyNum;
    @ApiModelProperty(value = "系统当前时间")
    private String sysTemTime;
    @ApiModelProperty(value = "报名成功标志，报名成功为true，否则为false,默认为true")
    private Boolean applySuccess;

    private static final long serialVersionUID = 1L;

    public ActivityDetail getActivityDetail() {
        return activityDetail;
    }

    public void setActivityDetail(ActivityDetail activityDetail) {
        this.activityDetail = activityDetail;
    }

    public List getActivityLikeList() {
        return activityLikeList;
    }

    public void setActivityLikeList(List activityLikeList) {
        this.activityLikeList = activityLikeList;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public List getActivityApplyList() {
        return activityApplyList;
    }

    public void setActivityApplyList(List activityApplyList) {
        this.activityApplyList = activityApplyList;
    }

    public Integer getRealapplyNum() {
        return realapplyNum;
    }

    public void setRealapplyNum(Integer realapplyNum) {
        this.realapplyNum = realapplyNum;
    }

    public String getSysTemTime() {
        return sysTemTime;
    }

    public void setSysTemTime(String sysTemTime) {
        this.sysTemTime = sysTemTime;
    }

    public Boolean getApplySuccess() {
        return applySuccess;
    }

    public void setApplySuccess(Boolean applySuccess) {
        this.applySuccess = applySuccess;
    }

    @Override
    public String toString() {
        return "ActivityDetailVO{" +
                "activityDetail=" + activityDetail +
                ", activityLikeList=" + activityLikeList +
                ", likeNum=" + likeNum +
                ", activityApplyList=" + activityApplyList +
                ", realapplyNum=" + realapplyNum +
                ", sysTemTime='" + sysTemTime + '\'' +
                ", applySuccess=" + applySuccess +
                '}';
    }
}