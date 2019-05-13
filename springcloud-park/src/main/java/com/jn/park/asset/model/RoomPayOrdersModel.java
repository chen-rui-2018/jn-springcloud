package com.jn.park.asset.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
*
* @author： zhuyz
* @date： Created on 2019/5/8 15:05
* @version： v1.0
* @modified By:
*/
public class RoomPayOrdersModel implements Serializable {
    private static final long serialVersionUID = 7931481554400000727L;
    @ApiModelProperty(value ="主键",example = "")
    private String id;

    @ApiModelProperty(value = "时间")
    private java.util.Date createTime;

    @ApiModelProperty(value = "创建时间",example = "")
    private String Time;

    @ApiModelProperty(value = "账单类型",example = "")
    private String ordersType;

    @ApiModelProperty(value = "最迟缴费时间",example = "")
    private String lastPayTime;

    @ApiModelProperty(value = "房间id",example = "")
    private String roomId;

    @ApiModelProperty(value = "房间名称",example = "")
    private String roomName;

    @ApiModelProperty(value = "面积",example = "")
    private String roomArea;

    @ApiModelProperty(value = "单价",example = "")
    private BigDecimal leasePrice;

    @ApiModelProperty(value = "租金",example = "")
    private BigDecimal leaseSum;

    @ApiModelProperty(value = "开始时间",example = "")
    private Date leaseStartTime;

    @ApiModelProperty(value = "结束时间",example = "")
    private Date leaseEndTime;

    @ApiModelProperty(value = "合计",example = "")
    private String paySum ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public java.util.Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getOrdersType() {
        return ordersType;
    }

    public void setOrdersType(String ordersType) {
        this.ordersType = ordersType;
    }

    public String getLastPayTime() {
        return lastPayTime;
    }

    public void setLastPayTime(String lastPayTime) {
        this.lastPayTime = lastPayTime;
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

    public BigDecimal getLeaseSum() {
        return leaseSum;
    }

    public void setLeaseSum(BigDecimal leaseSum) {
        this.leaseSum = leaseSum;
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

    public String getPaySum() {
        return paySum;
    }

    public void setPaySum(String paySum) {
        this.paySum = paySum;
    }
}
