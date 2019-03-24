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

    @ApiModelProperty(value = "活动ID",required = true)
    @NotBlank(message = "活动id不能为空！")
    private String activityId;

    @ApiModelProperty(value = "活动状态。只能传(0,1) 0代表停止报名 1开始报名",required = true)
    @Pattern(regexp="^\\-1|[01]$",message="{actiStatus:'状态值只允许为0,1,-1'}")
    @NotBlank(message = "活动状态不能为空")
    private String actiStatus;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getActiStatus() {
        return actiStatus;
    }

    public void setActiStatus(String actiStatus) {
        this.actiStatus = actiStatus;
    }
}
