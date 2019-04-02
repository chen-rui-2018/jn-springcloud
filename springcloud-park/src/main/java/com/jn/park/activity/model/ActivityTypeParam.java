package com.jn.park.activity.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 根据活动类型状态分页查询活动类型列表
 *
 * @Author: chenr
 * @Date: 2018/12/24 09:35
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ActivityTypeParam", description = "活动类型列表查询条件")
public class ActivityTypeParam extends Page implements Serializable {
    @ApiModelProperty(value = "状态(0：无效，1：有效,不传则返回全部)",example = "0")
    private String typeStatus;

    public String getTypeStatus() {
        return typeStatus;
    }
    public void setTypeStatus(String typeStatus) {
        this.typeStatus = typeStatus;
    }
}
