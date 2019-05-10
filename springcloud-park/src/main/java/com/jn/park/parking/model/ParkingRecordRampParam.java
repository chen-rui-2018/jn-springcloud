package com.jn.park.parking.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/19 9:31
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingRecordRampParam",description = "停车记录匝道")
public class ParkingRecordRampParam implements Serializable {
    @ApiModelProperty(value = "停车记录ID",example = "5895425")
    private String parkingId;
    @ApiModelProperty(value = "车牌",example = "苏A00001")
    private String carLicense;
    @ApiModelProperty(value = "入场时间 yyyy-MM-dd HH:mm:ss",example = "2019-01-24 10:00:10")
    private String admissionTime;
    @ApiModelProperty(value = "离场时间 yyyy-MM-dd HH:mm:ss",example = "2019-01-24 10:00:10")
    private String departureTime;
    @ApiModelProperty(value = "匝道ID",example = "w23iwe***")
    private String gateId;
    @ApiModelProperty(value = "停车状态1-入场,0离场",example = "1")
    private String parkingStatus;

    public String getParkingId() {
        return parkingId;
    }

    public void setParkingId(String parkingId) {
        this.parkingId = parkingId;
    }

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    public String getAdmissionTime() {
        return admissionTime;
    }

    public void setAdmissionTime(String admissionTime) {
        this.admissionTime = admissionTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getGateId() {
        return gateId;
    }

    public void setGateId(String gateId) {
        this.gateId = gateId;
    }

    public String getParkingStatus() {
        return parkingStatus;
    }

    public void setParkingStatus(String parkingStatus) {
        this.parkingStatus = parkingStatus;
    }
}
