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
@ApiModel(value = "ParkingSpaceDetailVo",description = "停车位详情")
public class ParkingSpaceDetailVo extends ParkingSpaceRentalVo implements Serializable {

    @ApiModelProperty(value = "停车场ID",example = "e2ew3***")
    private String areaId;

    @ApiModelProperty(value = "停车场名称",example = "F1区停车场")
    private String areaName;

    @ApiModelProperty(value = "当前租赁车牌号",example = "e2ew3***")
    private String carLicense;

    @ApiModelProperty(value = "车位状态(1未出租,2已出租)",example = "e2ew3***")
    private String spaceStatus;

    @ApiModelProperty(value = "创建时间",example = "2019-01-01 11:11:11")
    private String createdTime;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }


    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
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
