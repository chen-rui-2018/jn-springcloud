package com.jn.hardware.model.electricmeter;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/24 15:10
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ElectricMeterInfoParam",description = "获取仪表信息入参")
public class ElectricMeterInfoParam extends Page implements Serializable {

    @ApiModelProperty(value = "建筑编码",required = true,example = "420105A001")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
