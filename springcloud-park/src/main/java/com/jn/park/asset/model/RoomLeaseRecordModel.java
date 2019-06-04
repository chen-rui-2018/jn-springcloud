package com.jn.park.asset.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.sql.Date;

/**
* 房间租赁记录model
* @author： zhuyz
* @date： Created on 2019/5/17 17:53
* @version： v1.0
* @modified By:
*/
public class RoomLeaseRecordModel implements Serializable {
    private static final long serialVersionUID = -5232453050315220704L;

    @ApiModelProperty(value = "主键",example = "")
    private String id;

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

    @ApiModelProperty("房间状态(0空闲,1租借申请中,2租借中,3退租申请中,4已到期)")
    private Byte roomStatus;

    @ApiModelProperty("支付状态(0未付款,1已付款,2订单已取消)")
    private Byte payState;

    @ApiModelProperty(value = "楼宇地址",example = "南京市秦淮区白下智慧园区XX街1号")
    private String address;

    @ApiModelProperty(value = "创建时间",example = "2019-05-23")
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Byte getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Byte roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Byte getPayState() {
        return payState;
    }

    public void setPayState(Byte payState) {
        this.payState = payState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "RoomLeaseRecordModel{" +
                "id='" + id + '\'' +
                ", roomId='" + roomId + '\'' +
                ", roomName='" + roomName + '\'' +
                ", floor='" + floor + '\'' +
                ", towerId='" + towerId + '\'' +
                ", towerName='" + towerName + '\'' +
                ", roomUrl='" + roomUrl + '\'' +
                ", leaseStartTime=" + leaseStartTime +
                ", leaseEndTime=" + leaseEndTime +
                ", roomStatus=" + roomStatus +
                ", payState=" + payState +
                ", address='" + address + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
