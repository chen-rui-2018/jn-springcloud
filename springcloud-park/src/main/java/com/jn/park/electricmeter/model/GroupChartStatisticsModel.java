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
@ApiModel(value = "GroupChartStatisticsModel",description = "分组统计")
public class GroupChartStatisticsModel implements Serializable {
    @ApiModelProperty(value = "楼宇位置")
    private String position;
    @ApiModelProperty(value = "电表读数")
    private String brReadingEnd;
    @ApiModelProperty(value = "高能耗设备个数")
    private String isHigh;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBrReadingEnd() {
        return brReadingEnd;
    }

    public void setBrReadingEnd(String brReadingEnd) {
        this.brReadingEnd = brReadingEnd;
    }

    public String getIsHigh() {
        return isHigh;
    }

    public void setIsHigh(String isHigh) {
        this.isHigh = isHigh;
    }
}
