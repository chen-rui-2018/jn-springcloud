package com.jn.park.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 分页查询入参bean
 * @Author: yangph
 * @Date: 2018/12/24 9:22
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ActivityQueryPaging",description = "分页查询入参")
public class ActivityQueryPaging extends Page {
    @ApiModelProperty(value = "活动ID")
    @NotBlank(message = "活动id不能为空")
    private String activityId;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }
}
