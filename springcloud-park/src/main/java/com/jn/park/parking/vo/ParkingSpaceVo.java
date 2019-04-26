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
@ApiModel(value = "ParkingSpaceVo",description = "停车位列表")
public class ParkingSpaceVo implements Serializable {

    @ApiModelProperty(value = "停车位ID",example = "e2ew3***")
    private String spaceId;

    @ApiModelProperty(value = "停车场ID",example = "e2ew3***")
    private String areaId;

    @ApiModelProperty(value = "停车位编号",example = "A00001")
    private String spaceSerial;

    @ApiModelProperty(value = "当前租赁车牌号",example = "e2ew3***")
    private String carLicense;

    @ApiModelProperty(value = "当前租赁标识ID",example = "32we4***")
    private String rentId;

    @ApiModelProperty(value = "车位状态(1未出租,2已出租)",example = "e2ew3***")
    private String spaceStatus;

    @ApiModelProperty(value = "创建时间",example = "2019-01-01 11:11:11")
    private String createdTime;

    @ApiModelProperty(value = "车主姓名",example = "张三")
    private String name;

    @ApiModelProperty(value = "联系方式",example = "18177778888")
    private String phone;

    public String getRentId() {
        return rentId;
    }

    public void setRentId(String rentId) {
        this.rentId = rentId;
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

    public String getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
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

    public String getSpaceStatus() {
        return spaceStatus;
    }

    public void setSpaceStatus(String spaceStatus) {
        this.spaceStatus = spaceStatus;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
}
