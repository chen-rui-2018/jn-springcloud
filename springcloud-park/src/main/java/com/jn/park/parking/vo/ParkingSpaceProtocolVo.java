package com.jn.park.parking.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/19 9:31
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingSpaceProtocolVo",description = "停车位租聘协议")
public class ParkingSpaceProtocolVo implements Serializable {

    @ApiModelProperty(value = "停车场名称")
    private String areaName;

    @ApiModelProperty(value = "车主名称")
    private String name;

    @ApiModelProperty(value = "车位号")
    private String spaceSerial;

    @ApiModelProperty(value = "车牌号")
    private String carLicense;

    @ApiModelProperty(value = "车辆数")
    private String carcount;

    @ApiModelProperty(value = "开始时间")
    private String startTime;

    @ApiModelProperty(value = "结束时间")
    private String endTime;

    @ApiModelProperty(value = "租金")
    private String actualMoney;


    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpaceSerial() {
        return spaceSerial;
    }

    public void setSpaceSerial(String spaceSerial) {
        this.spaceSerial = spaceSerial;
    }

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    public String getCarcount() {
        return carcount;
    }

    public void setCarcount(String carcount) {
        this.carcount = carcount;
    }

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

    public String getActualMoney() {
        return actualMoney;
    }

    public void setActualMoney(String actualMoney) {
        this.actualMoney = actualMoney;
    }

    @Override
    public String toString() {
        return "ParkingSpaceProtocolVo{" +
                "areaName='" + areaName + '\'' +
                ", name='" + name + '\'' +
                ", spaceSerial='" + spaceSerial + '\'' +
                ", carLicense='" + carLicense + '\'' +
                ", carcount='" + carcount + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", actualMoney='" + actualMoney + '\'' +
                '}';
    }
}
