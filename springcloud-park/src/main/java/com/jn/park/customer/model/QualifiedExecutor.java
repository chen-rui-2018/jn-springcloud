package com.jn.park.customer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/5/17 16:29
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "QualifiedExecutor",description = "流程节点处理人信息")
public class QualifiedExecutor implements Serializable {
    @ApiModelProperty("类型：employee:用户，role:角色")
    private String type;
    @ApiModelProperty("执行人id/角色id")
    private String executId;
    @ApiModelProperty("执行人id/角色id")
    private String executor;
}
