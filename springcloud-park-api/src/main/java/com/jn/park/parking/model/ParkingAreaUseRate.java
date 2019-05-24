package com.jn.park.parking.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 停车场使用率
 *
 * @Author: jiangyl
 * @Date: 2019/5/23 11:15
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingAreaUseRate", description = "停车场使用率")
public class ParkingAreaUseRate implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "停车场标识")
    private String areaId;
    @ApiModelProperty(value = "停车场名称")
    private String areaName;
    @ApiModelProperty(value = "停车场车辆停放数")
    private Integer parkingCar;
    @ApiModelProperty(value = "停车场使用率")
    private Double useRate;

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getParkingCar() {
        return parkingCar;
    }

    public void setParkingCar(Integer parkingCar) {
        this.parkingCar = parkingCar;
    }

    public Double getUseRate() {
        return useRate;
    }

    public void setUseRate(Double useRate) {
        this.useRate = useRate;
    }

    @Override
    public String toString() {
        return "ParkingAreaUseRate{" +
                "areaId='" + areaId + '\'' +
                ", areaName='" + areaName + '\'' +
                ", parkingCar=" + parkingCar +
                ", useRate=" + useRate +
                '}';
    }
}