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
@ApiModel(value = "ParkingCarInfoVo",description = "车辆")
public class ParkingCarInfoVo implements Serializable {
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
    @ApiModelProperty(value = "车辆类型[1已绑定车位 0未绑定车位]",example = "0")
    private String leaseStatus;
    @ApiModelProperty(value = "月租车租赁标识（点击‘已绑定车位’携带该参数跳转至车位明细）",example = "32ew3***")
    private String rentId;
    @ApiModelProperty(value = "入场时间",example = "201-01-01 10:00:14")
    private String admissionTime;
    @ApiModelProperty(value = "出场时间",example = "201-01-01 18:04:14")
    private String departureTime;
    @ApiModelProperty(value = "车辆状态[ 停车状态：1-入场,0离场  ]",example = "1")
    private String parkingStatus;
    @ApiModelProperty(value = "车辆入场名称",example = "白下高新1号停车场")
    private String parkingName;
    @ApiModelProperty(value = "月租停车位信息",example = "白下高新金融中心裙楼A0001")
    private String parkingInfo;

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

    public String getLeaseStatus() {
        return leaseStatus;
    }

    public void setLeaseStatus(String leaseStatus) {
        this.leaseStatus = leaseStatus;
    }

    public String getRentId() {
        return rentId;
    }

    public void setRentId(String rentId) {
        this.rentId = rentId;
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

    public String getParkingStatus() {
        return parkingStatus;
    }

    public void setParkingStatus(String parkingStatus) {
        this.parkingStatus = parkingStatus;
    }

    public String getParkingInfo() {
        return parkingInfo;
    }

    public void setParkingInfo(String parkingInfo) {
        this.parkingInfo = parkingInfo;
    }

    public String getParkingName() {
        return parkingName;
    }

    public void setParkingName(String parkingName) {
        this.parkingName = parkingName;
    }
}
