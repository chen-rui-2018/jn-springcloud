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
@ApiModel(value = "TrendChartStatisticsModel",description = "分组统计")
public class TrendChartStatisticsModel implements Serializable {
    @ApiModelProperty(value = "账期")
    private String dealDateValue;
    @ApiModelProperty(value = "耗能")
    private String allEnergy;

    public String getDealDateValue() {
        return dealDateValue;
    }

    public void setDealDateValue(String dealDateValue) {
        this.dealDateValue = dealDateValue;
    }

    public String getAllEnergy() {
        return allEnergy;
    }

    public void setAllEnergy(String allEnergy) {
        this.allEnergy = allEnergy;
    }
}
