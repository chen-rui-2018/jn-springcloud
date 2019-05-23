package com.jn.park.sp.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author： huangbq
 * @date： Created on 2019/3/24 22:10
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SpPowerBusiModel",description = "权力业务")
public class SpPowerBusiModel implements Serializable {
    private static final long serialVersionUID = -4442252254493162760L;

    @ApiModelProperty("ID")
    private String id;


    @ApiModelProperty("业务名称")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
