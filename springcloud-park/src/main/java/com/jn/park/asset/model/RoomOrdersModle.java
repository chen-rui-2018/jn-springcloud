package com.jn.park.asset.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
* 房间订单model
* @author： zhuyz
* @date： Created on 2019/5/8 16:58
* @version： v1.0
* @modified By:
*/
public class RoomOrdersModle implements Serializable {
    private static final long serialVersionUID = -6107226237211214310L;

    @ApiModelProperty(value = "主键",example = "")
    private String id;

    @ApiModelProperty(value = "租借企业id",example = "")
    private String enterpriseId;

    @ApiModelProperty(value = "租借企业名称",example = "美的")
    private String leaseEnterprise;

    @ApiModelProperty(value = "房间id",example = "101")
    private String roomId;

    @ApiModelProperty(value = "房间名称",example = "101")
    private String roomName;

    @ApiModelProperty(value = "楼层",example = "1")
    private String floor;

    @ApiModelProperty(value = "楼宇id",example = "568817802354360320")
    private String towerId;

    @ApiModelProperty(value = "所属楼宇名称",example = "1号楼")
    private String towerName;

    @ApiModelProperty(value = "实景图片",example = "实景图片")
    private String roomUrl;

    @ApiModelProperty(value = "开始租借时间",example = "2018-05-01")
    private Date leaseStartTime;

    @ApiModelProperty(value = "租借结束时间",example = "2019-05-01")
    private Date leaseEndTime;

    @ApiModelProperty(value = "企业联系人",example = "先生")
    private String contactName;

    @ApiModelProperty(value = "联系人电话",example = "123456")
    private String contactPhone;

    @ApiModelProperty(value = "面积(平方米)",example = "100")
    private String roomArea;

    @ApiModelProperty(value = "租金单价(元/平方米/月)",example = "100")
    private BigDecimal leasePrice;

    @ApiModelProperty(value = "介绍",example = "房间介绍")
    private String introduce;

    @ApiModelProperty(value = "租金(元/月)",example = "10000")
    private BigDecimal leaseSum;

    @ApiModelProperty(value = "付款(如:押1付3)",example = "押1付3")
    private String pressPay;

    @ApiModelProperty(value = "最短租期(月)",example = "12")
    private String shortestLease;

    @ApiModelProperty(value = "合计",example = "40000")
    private String paySum ;

    @ApiModelProperty(value = "房间状态",example = "0")
    private String roomStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getLeaseEnterprise() {
        return leaseEnterprise;
    }

    public void setLeaseEnterprise(String leaseEnterprise) {
        this.leaseEnterprise = leaseEnterprise;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getTowerId() {
        return towerId;
    }

    public void setTowerId(String towerId) {
        this.towerId = towerId;
    }

    public String getTowerName() {
        return towerName;
    }

    public void setTowerName(String towerName) {
        this.towerName = towerName;
    }

    public String getRoomUrl() {
        return roomUrl;
    }

    public void setRoomUrl(String roomUrl) {
        this.roomUrl = roomUrl;
    }

    public Date getLeaseStartTime() {
        return leaseStartTime;
    }

    public void setLeaseStartTime(Date leaseStartTime) {
        this.leaseStartTime = leaseStartTime;
    }

    public Date getLeaseEndTime() {
        return leaseEndTime;
    }

    public void setLeaseEndTime(Date leaseEndTime) {
        this.leaseEndTime = leaseEndTime;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getRoomArea() {
        return roomArea;
    }

    public void setRoomArea(String roomArea) {
        this.roomArea = roomArea;
    }

    public BigDecimal getLeasePrice() {
        return leasePrice;
    }

    public void setLeasePrice(BigDecimal leasePrice) {
        this.leasePrice = leasePrice;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public BigDecimal getLeaseSum() {
        return leaseSum;
    }

    public void setLeaseSum(BigDecimal leaseSum) {
        this.leaseSum = leaseSum;
    }

    public String getPressPay() {
        return pressPay;
    }

    public void setPressPay(String pressPay) {
        this.pressPay = pressPay;
    }

    public String getShortestLease() {
        return shortestLease;
    }

    public void setShortestLease(String shortestLease) {
        this.shortestLease = shortestLease;
    }

    public String getPaySum() {
        return paySum;
    }

    public void setPaySum(String paySum) {
        this.paySum = paySum;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }
}
