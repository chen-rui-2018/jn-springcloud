package com.jn.park.model;

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
@ApiModel(value = "ActivityTypeQuery", description = "活动列表查询条件")
public class ActivityTypeQuery extends Page implements Serializable {
    @ApiModelProperty(value = "状态(0：无效，1：有效,不传则返回全部)")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
