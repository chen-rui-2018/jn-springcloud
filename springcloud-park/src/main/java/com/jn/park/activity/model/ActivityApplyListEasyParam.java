package com.jn.park.activity.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/6/3 21:31
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ActivityApplyListEasyParam",description = "活动管理，报名活动列表查询入参")
public class ActivityApplyListEasyParam extends Page implements Serializable {
    @ApiModelProperty(value = "活动ID",example = "92wefjw***")
    private String activityId;
    @ApiModelProperty(value = "报名转态 1:报名成功-2报名待审核",example = "1")
    @Pattern(regexp = "^[1-2]$",message = "状态值只能为 1或 2, 1:报名成功-2报名待审核")
    @NotBlank(message = "报名转态不能为空")
    private String applyStatus;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }
}
