package com.jn.park.sp.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
* 推送企业参数
* @author： yongze
* @date： Created on 2019/6/22 15:06
* @version： v1.0
* @modified By:
*/
@ApiModel(value = "SpParam",description = "推送企业参数")
public class SpParam implements Serializable {
    @ApiModelProperty("缴费单id")
    private String powerBusiIds;

    public String getPowerBusiIds() {
        return powerBusiIds;
    }

    public void setPowerBusiIds(String powerBusiIds) {
        this.powerBusiIds = powerBusiIds;
    }
}
