package com.jn.park.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 活动报名信息
 *
 * @Author: jiangyl
 * @Date: 2018/12/5 11:15
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ActivityApply", description = "活动报名信息")
public class ActivityApply implements Serializable {
    @ApiModelProperty(value = "报名ID")
    private String id;
    @ApiModelProperty(value = "活动ID")
    private String activityId;
    @ApiModelProperty(value = "用户账号")
    private String account;
    @ApiModelProperty(value = "申请时间")
    private String applyTime;
    @ApiModelProperty(value = "申请状态")
    private String applyStatus;
    @ApiModelProperty(value = "签到状态")
    private String signStatus;
    @ApiModelProperty(value = "签到时间")
    private String signTime;
    @ApiModelProperty(value = "签到方式(0：app签到，1：现场签到)")
    private String signType;
    @ApiModelProperty(value = "报名人头像")
    private String avatar;
    @ApiModelProperty(value = "创建时间")
    private String createdTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getSignStatus() {
        return signStatus;
    }

    public void setSignStatus(String signStatus) {
        this.signStatus = signStatus;
    }

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "ActivityApply{" +
                "id='" + id + '\'' +
                ", activityId='" + activityId + '\'' +
                ", account='" + account + '\'' +
                ", applyTime='" + applyTime + '\'' +
                ", applyStatus='" + applyStatus + '\'' +
                ", signStatus='" + signStatus + '\'' +
                ", signTime='" + signTime + '\'' +
                ", signType='" + signType + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createdTime='" + createdTime + '\'' +
                '}';
    }
}