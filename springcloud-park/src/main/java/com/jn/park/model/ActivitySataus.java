package com.jn.park.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 *
 * @author： jiangyl
 * @date： Created on 2018/12/24 9:38
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ActivitySataus",description = "活动状态修改入参")
public class ActivitySataus {

    @ApiModelProperty("活动ID")
    @NotBlank(message = "活动id不能为空！")
    private String activityId;

    @ApiModelProperty("活动状态。只能传(0,1) 0代表停止报名 1开始报名")
    @Pattern(regexp="^\\-1|[01]$",message="{status:'状态值只允许为0,1,-1'}")
    private String status;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
