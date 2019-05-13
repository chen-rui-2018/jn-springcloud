package com.jn.park.parking.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/19 17:21
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingCarInfoParam",description = "车辆列表入参")
public class ParkingCarInfoParam extends Page {
    @ApiModelProperty(value = "车辆id",example = "32w3***")
    private String carId;
    @ApiModelProperty(value = "车牌号码",example = "湘A00001")
    private String carLicense;
    @ApiModelProperty(value = "车主姓名",example = "战三")
    private String name;
    @ApiModelProperty(value = "联系方式",example = "18175555555")
    private String phone;
    @ApiModelProperty(value = "车主账号",example = "wangsong")
    private String account;
    @ApiModelProperty(value = "车辆状态[ 停车状态：1-入场,0离场  ]",example = "1")
    private String parkingStatus;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getParkingStatus() {
        return parkingStatus;
    }

    public void setParkingStatus(String parkingStatus) {
        this.parkingStatus = parkingStatus;
    }
}
