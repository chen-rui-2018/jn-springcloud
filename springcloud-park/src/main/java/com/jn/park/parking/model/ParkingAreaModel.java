package com.jn.park.parking.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/18 17:37
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingAreaModel",description = "停车场")
public class ParkingAreaModel implements Serializable {

    @ApiModelProperty(value = "停车场ID[新增传空，修改必传]",required = true,example = "8we***")
    private String areaId;
    @ApiModelProperty(value = "停车场名称",required = true,example = "F区底下停车场")
    @NotNull(message = "停车场名称不能为空")
    private String areaName;
    @ApiModelProperty(value = "停车场地址",required = true,example = "1ww2324***")
    @NotNull(message = "停车场地址不能为空")
    private String areaAddress;
    @ApiModelProperty(value = "经度",required = true,example = "132.18538415")
    @NotNull(message = "经度不能为空")
    private String longitude;
    @ApiModelProperty(value = "纬度",required = true,example = "45.254185")
    @NotNull(message = "纬度不能为空")
    private String latitude;
    @ApiModelProperty(value = "临时车价格描述",example = "15分钟内免费，半小时内首付2.5，之后每小时加上5元，24小时120元封顶，再次进场重新计费")
    private String tempPriceDepict;
    @ApiModelProperty(value = "临时车价格( 单位:元/小时)",example = "5.0")
    private Double tempPrice;
    @ApiModelProperty(value = "临时车每天价格上限",example = "120")
    private Double tempPriceTotal;
    @ApiModelProperty(value = "租车位价格(/年)",required = true,example = "2100")
    @NotNull(message = "租车位价格不能为空")
    private Double rentPrice;
    @ApiModelProperty(value = "停车场图片",example = "**/**.png")
    private String areaPicture;
    @ApiModelProperty(value = "停车位分布图",example = "**/**.png")
    private String spacePicture;
    @ApiModelProperty(value = "停车场服务[数组]，[传‘智慧停车-停车场管理-查询停车场服务列表’接口返回的id]",example = "['22wwwe','123**']")
    private String[] parkingServiceTypeIds;

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

    public String getAreaAddress() {
        return areaAddress;
    }

    public void setAreaAddress(String areaAddress) {
        this.areaAddress = areaAddress;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
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

    public Double getTempPriceTotal() {
        return tempPriceTotal;
    }

    public void setTempPriceTotal(Double tempPriceTotal) {
        this.tempPriceTotal = tempPriceTotal;
    }

    public Double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getAreaPicture() {
        return areaPicture;
    }

    public void setAreaPicture(String areaPicture) {
        this.areaPicture = areaPicture;
    }

    public String getSpacePicture() {
        return spacePicture;
    }

    public void setSpacePicture(String spacePicture) {
        this.spacePicture = spacePicture;
    }

    public String[] getParkingServiceTypeIds() {
        return parkingServiceTypeIds;
    }

    public void setParkingServiceTypeIds(String[] parkingServiceTypeIds) {
        this.parkingServiceTypeIds = parkingServiceTypeIds;
    }
}
