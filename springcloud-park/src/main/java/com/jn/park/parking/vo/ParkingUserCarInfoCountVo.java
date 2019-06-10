package com.jn.park.parking.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/22 10:31
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingUserCarInfoCountVo",description = "用户车辆统计信息")
public class ParkingUserCarInfoCountVo implements Serializable {

    @ApiModelProperty(value = "已入场车辆数",example = "2")
    private String parkingCarNum;

    @ApiModelProperty(value = "总车辆数",example = "5")
    private String carTotal;

    public String getParkingCarNum() {
        return parkingCarNum;
    }

    public void setParkingCarNum(String parkingCarNum) {
        this.parkingCarNum = parkingCarNum;
    }

    public String getCarTotal() {
        return carTotal;
    }

    public void setCarTotal(String carTotal) {
        this.carTotal = carTotal;
    }
}
