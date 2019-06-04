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
@ApiModel(value = "MeterInfoParam",description = "电表信息入参")
public class MeterInfoParam implements Serializable {
    @ApiModelProperty("设备id")
    private String meterCode;

    @ApiModelProperty("开关状态")
    private String status;

    public String getMeterCode() {
        return meterCode;
    }

    public void setMeterCode(String meterCode) {
        this.meterCode = meterCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
