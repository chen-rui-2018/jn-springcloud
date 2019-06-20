package com.jn.enterprise.data.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author： yangh
 * @date： Created on 2019/4/24 9:33
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "DataTargetsModelParam" ,description = "指标集合")
public class DataTargetsModelParam {

    @ApiModelProperty(value = "指标Id集合",example = "[1,2,3]")
    private List<String> targetIds;

    public List<String> getTargetIds() {
        return targetIds;
    }

    public void setTargetIds(List<String> targetIds) {
        this.targetIds = targetIds;
    }
}
