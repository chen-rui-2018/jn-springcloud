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
}
