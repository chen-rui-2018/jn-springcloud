package com.jn.park.electricmeter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author： yangh
 * @date： Created on 2019/5/28 16:42
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "GategaryEnergyStatisticsModel",description = "分类统计")
public class GategaryEnergyStatisticsModel implements Serializable {
    @ApiModelProperty(value = "账期")
    private String dealDateValue;
    @ApiModelProperty(value = "设备类型 1：公共照明，2：空调用电，3：楼层用电",example = "1")
    private String type;
    @ApiModelProperty(value = "账期")
    private String bValue;

    public String getDealDateValue() {
        return dealDateValue;
    }

    public void setDealDateValue(String dealDateValue) {
        this.dealDateValue = dealDateValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getbValue() {
        return bValue;
    }

    public void setbValue(String bValue) {
        this.bValue = bValue;
    }
}
