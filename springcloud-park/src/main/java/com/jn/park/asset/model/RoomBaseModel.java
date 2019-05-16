package com.jn.park.asset.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
* 房间基本信息Model
* @author： zhuyz
* @date： Created on 2019/5/15 21:52
* @version： v1.0
* @modified By:
*/
public class RoomBaseModel implements Serializable {
    private static final long serialVersionUID = -4538450425956025695L;

    /*@ApiModelProperty("")*/
    private String id;

    @ApiModelProperty("房间名称(如:101)")
    private String name;

    @ApiModelProperty("楼层")
    private String floor;

    @ApiModelProperty("楼宇id")
    private String towerId;

    @ApiModelProperty("所属楼宇名称")
    private String towerName;

    @ApiModelProperty("分组id")
    private String groupId;

    @ApiModelProperty("面积(平方米)")
    private String roomArea;

    @ApiModelProperty("最短租期(月)")
    private String shortestLease;

    @ApiModelProperty("租金单价(元/平方米/月)")
    private BigDecimal leasePrice;

    @ApiModelProperty("租金(面积X租金单价) 元/月")
    private BigDecimal leaseSum;


    @ApiModelProperty("押:press付pay(如:押1付3)")
    private String pressPay;

    @ApiModelProperty("户型")
    private String houseType;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty(value = "同属分组(房间id)",example = "")
    private List<RoomBaseModel> groupRoomList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getRoomArea() {
        return roomArea;
    }

    public void setRoomArea(String roomArea) {
        this.roomArea = roomArea;
    }

    public String getShortestLease() {
        return shortestLease;
    }

    public void setShortestLease(String shortestLease) {
        this.shortestLease = shortestLease;
    }

    public BigDecimal getLeasePrice() {
        return leasePrice;
    }

    public void setLeasePrice(BigDecimal leasePrice) {
        this.leasePrice = leasePrice;
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

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<RoomBaseModel> getGroupRoomList() {
        return groupRoomList;
    }

    public void setGroupRoomList(List<RoomBaseModel> groupRoomList) {
        this.groupRoomList = groupRoomList;
    }

    @Override
    public String toString() {
        return "RoomBaseModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", floor='" + floor + '\'' +
                ", towerId='" + towerId + '\'' +
                ", towerName='" + towerName + '\'' +
                ", groupId='" + groupId + '\'' +
                ", roomArea='" + roomArea + '\'' +
                ", shortestLease='" + shortestLease + '\'' +
                ", leasePrice=" + leasePrice +
                ", leaseSum=" + leaseSum +
                ", pressPay='" + pressPay + '\'' +
                ", houseType='" + houseType + '\'' +
                ", createTime=" + createTime +
                ", groupRoomList=" + groupRoomList +
                '}';
    }
}
