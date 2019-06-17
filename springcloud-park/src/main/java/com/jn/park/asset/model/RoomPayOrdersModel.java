package com.jn.park.asset.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
*
* @author： zhuyz
* @date： Created on 2019/5/8 15:05
* @version： v1.0
* @modified By:
*/
public class RoomPayOrdersModel implements Serializable {
    private static final long serialVersionUID = 7931481554400000727L;

    @ApiModelProperty(value = "订单信息")
    private List<RoomPayOrdersModel> roomPayOrdersModelList;

    @ApiModelProperty(value ="主键(总订单id)",example = "")
    private String id;

    @ApiModelProperty(value = "时间")
    private java.util.Date createTime;

    @ApiModelProperty(value = "创建时间",example = "2019-05-04 17:22:10")
    private String Time;

    @ApiModelProperty(value = "账单类型",example = "房间租赁")
    private String ordersType;

    @ApiModelProperty(value = "最迟缴费时间",example = "2019-05-04 18:22:10")
    private String lastPayTime;

    @ApiModelProperty(value = "开始时间",example = "2019-05-01")
    private Date leaseStartTime;

    @ApiModelProperty(value = "结束时间",example = "2019-06-01")
    private Date leaseEndTime;

    @ApiModelProperty(value = "合计",example = "900.00")
    private BigDecimal paySum;

    @ApiModelProperty("订单编号")
    private String itemId;

    @ApiModelProperty("订单表ID")
    private String orderId;

    @ApiModelProperty("房间id")
    private String roomId;

    @ApiModelProperty("房间名称")
    private String roomName;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("楼层")
    private String floor;

    @ApiModelProperty("楼宇id")
    private String towerId;

    @ApiModelProperty("楼宇名称")
    private String towerName;

    @ApiModelProperty("房间图片")
    private String roomUrl;

    @ApiModelProperty("面积(平方米)")
    private String roomArea;

    @ApiModelProperty("租金单价(元/平方米/月)")
    private BigDecimal leasePrice;

    @ApiModelProperty("租金(面积X租金单价) 元/月")
    private BigDecimal leaseSum;

    @ApiModelProperty("押:press付pay(如:押1付3)")
    private String pressPay;

    @ApiModelProperty("最短租期(月)")
    private String shortestLease;

    @ApiModelProperty("介绍")
    private String introduce;

    @ApiModelProperty("(子)付款金额")
    private BigDecimal itemPaySum;

    @ApiModelProperty("房间状态(0空闲,1租借申请中,2租借中,3退租申请中,4已到期)(暂时没用)")
    private Byte roomStatus;

    @ApiModelProperty("退租违约金")
    private BigDecimal quitPenalSum;

    @ApiModelProperty("说明")
    private String explain;

    @ApiModelProperty("意见")
    private String approvalOpinion;

    @ApiModelProperty("实际退租时间")
    private java.util.Date practicalQuitTime;

    @ApiModelProperty("租赁申请状态(0申请失败,1申请中,2申请成功)")
    private Byte leaseApplyStatus;

    @ApiModelProperty("退租申请状态(0申请失败,1申请中,2申请成功)")
    private Byte quitApplyStatus;

    public List<RoomPayOrdersModel> getRoomPayOrdersModelList() {
        return roomPayOrdersModelList;
    }

    public void setRoomPayOrdersModelList(List<RoomPayOrdersModel> roomPayOrdersModelList) {
        this.roomPayOrdersModelList = roomPayOrdersModelList;
    }

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

    public BigDecimal getPaySum() {
        return paySum;
    }

    public void setPaySum(BigDecimal paySum) {
        this.paySum = paySum;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public String getRoomUrl() {
        return roomUrl;
    }

    public void setRoomUrl(String roomUrl) {
        this.roomUrl = roomUrl;
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

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public BigDecimal getItemPaySum() {
        return itemPaySum;
    }

    public void setItemPaySum(BigDecimal itemPaySum) {
        this.itemPaySum = itemPaySum;
    }

    public Byte getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Byte roomStatus) {
        this.roomStatus = roomStatus;
    }

    public BigDecimal getQuitPenalSum() {
        return quitPenalSum;
    }

    public void setQuitPenalSum(BigDecimal quitPenalSum) {
        this.quitPenalSum = quitPenalSum;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getApprovalOpinion() {
        return approvalOpinion;
    }

    public void setApprovalOpinion(String approvalOpinion) {
        this.approvalOpinion = approvalOpinion;
    }

    public java.util.Date getPracticalQuitTime() {
        return practicalQuitTime;
    }

    public void setPracticalQuitTime(java.util.Date practicalQuitTime) {
        this.practicalQuitTime = practicalQuitTime;
    }

    public Byte getLeaseApplyStatus() {
        return leaseApplyStatus;
    }

    public void setLeaseApplyStatus(Byte leaseApplyStatus) {
        this.leaseApplyStatus = leaseApplyStatus;
    }

    public Byte getQuitApplyStatus() {
        return quitApplyStatus;
    }

    public void setQuitApplyStatus(Byte quitApplyStatus) {
        this.quitApplyStatus = quitApplyStatus;
    }

    @Override
    public String toString() {
        return "RoomPayOrdersModel{" +
                "roomPayOrdersModelList=" + roomPayOrdersModelList +
                ", id='" + id + '\'' +
                ", createTime=" + createTime +
                ", Time='" + Time + '\'' +
                ", ordersType='" + ordersType + '\'' +
                ", lastPayTime='" + lastPayTime + '\'' +
                ", leaseStartTime=" + leaseStartTime +
                ", leaseEndTime=" + leaseEndTime +
                ", paySum=" + paySum +
                ", itemId='" + itemId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", roomId='" + roomId + '\'' +
                ", roomName='" + roomName + '\'' +
                ", name='" + name + '\'' +
                ", floor='" + floor + '\'' +
                ", towerId='" + towerId + '\'' +
                ", towerName='" + towerName + '\'' +
                ", roomUrl='" + roomUrl + '\'' +
                ", roomArea='" + roomArea + '\'' +
                ", leasePrice=" + leasePrice +
                ", leaseSum=" + leaseSum +
                ", pressPay='" + pressPay + '\'' +
                ", shortestLease='" + shortestLease + '\'' +
                ", introduce='" + introduce + '\'' +
                ", itemPaySum=" + itemPaySum +
                ", roomStatus=" + roomStatus +
                ", quitPenalSum=" + quitPenalSum +
                ", explain='" + explain + '\'' +
                ", approvalOpinion='" + approvalOpinion + '\'' +
                ", practicalQuitTime=" + practicalQuitTime +
                ", leaseApplyStatus=" + leaseApplyStatus +
                ", quitApplyStatus=" + quitApplyStatus +
                '}';
    }
}
