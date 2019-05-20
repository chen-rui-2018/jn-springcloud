package com.jn.park.customer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/5/17 16:20
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "QualFieds",description = "流程节点处理人信息")
public class QualFieds implements Serializable {
    @ApiModelProperty("发起人用户id/角色id")
    private String id;
    @ApiModelProperty("发起人类型：employee:人员，role:角色...")
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
