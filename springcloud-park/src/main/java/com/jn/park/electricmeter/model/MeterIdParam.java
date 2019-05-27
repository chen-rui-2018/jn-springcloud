package com.jn.park.electricmeter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： yangh
 * @date： Created on 2019/5/25 12:45
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "MeterIdParam",description = "电表信息")
public class MeterIdParam implements Serializable {
    @ApiModelProperty("记录Id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
