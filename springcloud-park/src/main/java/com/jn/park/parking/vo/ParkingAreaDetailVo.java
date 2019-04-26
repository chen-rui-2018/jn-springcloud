package com.jn.park.parking.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/18 17:37
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingAreaVo",description = "停车场详情")
public class ParkingAreaDetailVo implements Serializable {

    @ApiModelProperty(value = "停车场ID",example = "1ww2324***")
    private String areaId;
    @ApiModelProperty(value = "停车场名称",example = "F区底下停车场")
    private String areaName;
    @ApiModelProperty(value = "停车场地址",example = "1ww2324***")
    private String areaAddress;
    @ApiModelProperty(value = "经度",example = "132.18538415")
    private String longitude;
    @ApiModelProperty(value = "纬度",example = "45.254185")
    private String latitude;
    @ApiModelProperty(value = "空闲车位数",example = "132")
    private Integer leisureNumber;
    @ApiModelProperty(value = "已出租车位数",example = "515")
    private Integer rentNumber;
    @ApiModelProperty(value = "车位总数",example = "647")
    private Integer parkingTotal;
    @ApiModelProperty(value = "临时车价格描述",example = "15分钟内免费，半小时内首付2.5，之后每小时加上5元，24小时120元封顶，再次进场重新计费")
    private String tempPriceDepict;
    @ApiModelProperty(value = "临时车价格( 单位:元)",example = "5.0")
    private Double tempPrice;
    @ApiModelProperty(value = "临时车价格周期( 单位:分钟)",example = "30")
    private String tempPriceUnit;
    @ApiModelProperty(value = "临时车每天价格上限",example = "120")
    private Double tempPriceTotal;
    @ApiModelProperty(value = "租车位价格",example = "2100")
    private Double rentPrice;
    @ApiModelProperty(value = "停车场图片",example = "**/**.png")
    private String areaPicture;
    @ApiModelProperty(value = "停车位分布图",example = "**/**.png")
    private String spacePicture;
    @ApiModelProperty(value = "临时车免费停车时间(单位:分钟)",example = "15")
    private Integer tempFreeTime;
    @ApiModelProperty(value = "道闸厂家名称",example = "道尔")
    private String gateFactory;
    @ApiModelProperty(value = "道闸标识",example = "218we232***")
    private String gateId;
    @ApiModelProperty(value = "停车场服务")
    private List<ParkingServiceTypeVo> serviceType;

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

    public Integer getLeisureNumber() {
        return leisureNumber;
    }

    public void setLeisureNumber(Integer leisureNumber) {
        this.leisureNumber = leisureNumber;
    }

    public Integer getRentNumber() {
        return rentNumber;
    }

    public void setRentNumber(Integer rentNumber) {
        this.rentNumber = rentNumber;
    }

    public Integer getParkingTotal() {
        return parkingTotal;
    }

    public void setParkingTotal(Integer parkingTotal) {
        this.parkingTotal = parkingTotal;
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

    public List<ParkingServiceTypeVo> getServiceType() {
        return serviceType;
    }

    public void setServiceType(List<ParkingServiceTypeVo> serviceType) {
        this.serviceType = serviceType;
    }

    public String getTempPriceUnit() {
        return tempPriceUnit;
    }

    public void setTempPriceUnit(String tempPriceUnit) {
        this.tempPriceUnit = tempPriceUnit;
    }

    public Integer getTempFreeTime() {
        return tempFreeTime;
    }

    public void setTempFreeTime(Integer tempFreeTime) {
        this.tempFreeTime = tempFreeTime;
    }

    public String getGateFactory() {
        return gateFactory;
    }

    public void setGateFactory(String gateFactory) {
        this.gateFactory = gateFactory;
    }

    public String getGateId() {
        return gateId;
    }

    public void setGateId(String gateId) {
        this.gateId = gateId;
    }
}
