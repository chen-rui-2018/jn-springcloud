package com.jn.park.parking.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/19 9:31
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingRecordVo",description = "停车记录")
public class ParkingRecordVo implements Serializable {
    @ApiModelProperty(value = "停车记录id",example = "2w321**")
    private String parkingId;
    @ApiModelProperty(value = "停车场名称",example = "白下智慧园区5号停车场")
    private String areaName;
    @ApiModelProperty(value = "车牌",example = "苏A00001")
    private String carLicense;
    @ApiModelProperty(value = "入场时间 yyyy-MM-dd HH:mm:ss",example = "2019-01-24 10:00:10")
    private String admissionTime;
    @ApiModelProperty(value = "离场时间 yyyy-MM-dd HH:mm:ss",example = "2019-01-24 10:00:10")
    private String departureTime;
    @ApiModelProperty(value = "缴费时间 yyyy-MM-dd HH:mm:ss",example = "2019-01-24 10:00:10")
    private String paymentTime;
    @ApiModelProperty(value = "停车状态：1-入场,0离场",example = "0")
    private String parkingStatus;
    @ApiModelProperty(value = "停车持续时间(单位:小时)",example = "5")
    private String parkingTime;
    @ApiModelProperty(value = "应缴纳的金额",example = "12")
    private Double dueMoney;
    @ApiModelProperty(value = "积分抵扣数",example = "2")
    private Double useIntegral;
    @ApiModelProperty(value = "积分抵扣金额",example = "20")
    private Double deductionMoney;
    @ApiModelProperty(value = "实际金额数",example = "10")
    private Double actualMoney;
    @ApiModelProperty(value = "缴费单号",example = "2w321**")
    private String orderBillNum;
    @ApiModelProperty(value = "支付成功时间 yyyy-MM-dd HH:mm:ss",example = "2019-01-24 10:00:10")
    private String payTime;
    @ApiModelProperty(value = "支付状态[0未支付1支付成功-1取消支付]",example = "0")
    private String payStatus;

    public String getParkingId() {
        return parkingId;
    }

    public void setParkingId(String parkingId) {
        this.parkingId = parkingId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
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

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getParkingStatus() {
        return parkingStatus;
    }

    public void setParkingStatus(String parkingStatus) {
        this.parkingStatus = parkingStatus;
    }

    public String getParkingTime() {
        return parkingTime;
    }

    public void setParkingTime(String parkingTime) {
        this.parkingTime = parkingTime;
    }

    public Double getDueMoney() {
        return dueMoney;
    }

    public void setDueMoney(Double dueMoney) {
        this.dueMoney = dueMoney;
    }

    public Double getUseIntegral() {
        return useIntegral;
    }

    public void setUseIntegral(Double useIntegral) {
        this.useIntegral = useIntegral;
    }

    public Double getDeductionMoney() {
        return deductionMoney;
    }

    public void setDeductionMoney(Double deductionMoney) {
        this.deductionMoney = deductionMoney;
    }

    public Double getActualMoney() {
        return actualMoney;
    }

    public void setActualMoney(Double actualMoney) {
        this.actualMoney = actualMoney;
    }

    public String getOrderBillNum() {
        return orderBillNum;
    }

    public void setOrderBillNum(String orderBillNum) {
        this.orderBillNum = orderBillNum;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }
}
