package com.jn.park.activity.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 分页查询入参bean
 * @Author: yangph
 * @Date: 2018/12/24 9:22
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ActivityPagingParam",description = "分页查询入参")
public class ActivityPagingParam extends Page implements Serializable {
    @ApiModelProperty(value = "活动ID/企业ID/动态ID",required = true,example = "f5c95f9adf714aedab3739cbc9297178")
    @NotBlank(message = "活动id不能为空")
    private String activityId;

    @ApiModelProperty(value = "账号[前端无需理会该参数]")
    private String account;

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

    @Override
    public String toString() {
        return "ActivityPagingParam{" +
                "activityId='" + activityId + '\'' +
                ", account='" + account + '\'' +
                '}';
    }
}
