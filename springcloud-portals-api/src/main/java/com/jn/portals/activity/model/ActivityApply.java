package com.jn.portals.activity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

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
    @ApiModelProperty(value = "用户ID")
    private String userId;
    @ApiModelProperty(value = "申请时间")
    private Date applyTime;
    @ApiModelProperty(value = "申请状态")
    private String applyState;
    @ApiModelProperty(value = "签到状态")
    private String signState;
    @ApiModelProperty(value = "签到时间")
    private Date signTime;
    @ApiModelProperty(value = "签到方式(0：app签到，1：现场签到)")
    private String signType;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getApplyState() {
        return applyState;
    }

    public void setApplyState(String applyState) {
        this.applyState = applyState;
    }

    public String getSignState() {
        return signState;
    }

    public void setSignState(String signState) {
        this.signState = signState;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }
}