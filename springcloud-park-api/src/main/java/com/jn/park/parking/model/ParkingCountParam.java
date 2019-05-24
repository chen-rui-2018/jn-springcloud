package com.jn.park.parking.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 停车场统计数据
 *
 * @Author: jiangyl
 * @Date: 2019/5/23 11:15
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingCountParam", description = "停车场统计入参")
public class ParkingCountParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "开始时间[yyyy-MM-dd HH:mm:ss][不传默认当天0点]",example = "2019-05-23 00:00:00")
    private String startTime;
    @ApiModelProperty(value = "结束时间[yyyy-MM-dd HH:mm:ss][不传默认当前时间]",example = "2019-05-23 16:12:00")
    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "ParkingCountParam{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}