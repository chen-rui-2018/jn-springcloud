package com.jn.portals.activity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 活动详情信息
 *
 * @Author: jiangyl
 * @Date: 2018/12/5 11:17
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ActivityDetail", description = "活动详情信息")
public class ActivityDetail implements Serializable {
    @ApiModelProperty(value = "活动ID")
    private String activityId;
    @ApiModelProperty(value = "活动详情")
    private String actiDetail;

    private static final long serialVersionUID = 1L;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId == null ? null : activityId.trim();
    }

    public String getActiDetail() {
        return actiDetail;
    }

    public void setActiDetail(String actiDetail) {
        this.actiDetail = actiDetail == null ? null : actiDetail.trim();
    }

}