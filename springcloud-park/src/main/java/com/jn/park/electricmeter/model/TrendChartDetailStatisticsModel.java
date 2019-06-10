package com.jn.park.electricmeter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： yangh
 * @date： Created on 2019/5/28 16:42
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "GroupChartStatisticsModel",description = "分组明细统计")
public class TrendChartDetailStatisticsModel implements Serializable {
    @ApiModelProperty(value = "楼宇位置")
    private String position;
    @ApiModelProperty(value = "设备类型")
    private String type;
    @ApiModelProperty(value = "企业名称")
    private String companyName;
    @ApiModelProperty(value = "电表名称")
    private String meterName;
    @ApiModelProperty(value = "采集标志")
    private String flag;
    @ApiModelProperty(value = "耗能")
    private String allEnergy;
    @ApiModelProperty(value = "阀值")
    private String threshold;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    public String getMeterName() {
        return meterName;
    }

    public void setMeterName(String meterName) {
        this.meterName = meterName;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getAllEnergy() {
        return allEnergy;
    }

    public void setAllEnergy(String allEnergy) {
        this.allEnergy = allEnergy;
    }

    public String getThreshold() {
        return threshold;
    }

    public void setThreshold(String threshold) {
        this.threshold = threshold;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
