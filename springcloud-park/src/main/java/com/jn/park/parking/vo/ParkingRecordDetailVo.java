package com.jn.park.parking.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 临停缴费详情
 * @author： jiangyl
 * @date： Created on 2019/4/19 9:31
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingRecordDetailVo",description = "停车记录详情")
public class ParkingRecordDetailVo implements Serializable {
    @ApiModelProperty(value = "停车记录id",example = "2w321**")
    private String parkingId;
    @ApiModelProperty(value = "停车场名称",example = "白下智慧园区5号停车场")
    private String areaName;
    @ApiModelProperty(value = "停车场地址",example = "永智路5号科技创业研发孵化综合楼5号楼")
    private String areaAddress;
    @ApiModelProperty(value = "车牌",example = "苏A00001")
    private String carLicense;
    @ApiModelProperty(value = "入场时间 yyyy-MM-dd HH:mm:ss",example = "2019-01-24 10:00:10")
    private String admissionTime;
    @ApiModelProperty(value = "离场时间 yyyy-MM-dd HH:mm:ss",example = "2019-01-24 10:00:10")
    private String departureTime;
    @ApiModelProperty(value = "临时车价格描述",example = "5元/30分钟，15分钟内免费")
    private String tempPriceDepict;
    @ApiModelProperty(value = "临时车价格(单位:元)",example = "5")
    private Double tempPrice;
    @ApiModelProperty(value = "临时车计费周期(单位:分钟)",example = "30")
    private String tempPriceUnit;
    @ApiModelProperty(value = "临时车每天价格上限[为空/0则没有上线]",example = "50")
    private Double tempPriceTotal;
    @ApiModelProperty(value = "应缴金额[计费金额 元]",example = "12")
    private Double parkingAmount;
    @ApiModelProperty(value = "停车时长",example = "1小时20分钟")
    private String parkingTime;

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

    public String getAreaAddress() {
        return areaAddress;
    }

    public void setAreaAddress(String areaAddress) {
        this.areaAddress = areaAddress;
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

    public String getTempPriceDepict() {
        return tempPriceDepict;
    }

    public void setTempPriceDepict(String tempPriceDepict) {
        this.tempPriceDepict = tempPriceDepict;
    }

    public Double getTempPrice() {
        return tempPrice;
    }

    public void setTempPrice(Double tempPrice) {
        this.tempPrice = tempPrice;
    }

    public String getTempPriceUnit() {
        return tempPriceUnit;
    }

    public void setTempPriceUnit(String tempPriceUnit) {
        this.tempPriceUnit = tempPriceUnit;
    }

    public Double getTempPriceTotal() {
        return tempPriceTotal;
    }

    public void setTempPriceTotal(Double tempPriceTotal) {
        this.tempPriceTotal = tempPriceTotal;
    }

    public Double getParkingAmount() {
        return parkingAmount;
    }

    public void setParkingAmount(Double parkingAmount) {
        this.parkingAmount = parkingAmount;
    }

    public String getParkingTime() {
        return parkingTime;
    }

    public void setParkingTime(String parkingTime) {
        this.parkingTime = parkingTime;
    }
}
