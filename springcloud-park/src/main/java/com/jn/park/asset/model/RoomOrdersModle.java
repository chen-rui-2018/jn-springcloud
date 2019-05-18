package com.jn.park.asset.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
* 房间订单model
* @author： zhuyz
* @date： Created on 2019/5/8 16:58
* @version： v1.0
* @modified By:
*/
public class RoomOrdersModle implements Serializable {
    private static final long serialVersionUID = -6107226237211214310L;

    @ApiModelProperty(value = "订单编号",example = "2019051111365096306")
    private String id;

    @ApiModelProperty(value = "订单表ID",example = "2019050811515490657")
    private String orderId;

    @ApiModelProperty(value = "房间id",example = "575020345132580865")
    private String roomId;

    @ApiModelProperty(value = "房间名称",example = "101")
    private String roomName;

    @ApiModelProperty(value = "楼层",example = "1")
    private String floor;

    @ApiModelProperty(value = "楼宇id",example = "568817802354360320")
    private String towerId;

    @ApiModelProperty(value = "楼宇名称",example = "1号楼")
    private String towerName;

    @ApiModelProperty(value = "房间图片")
    private String imgUrl;

    @ApiModelProperty(value = "面积(平方米)",example = "500")
    private String roomArea;

    @ApiModelProperty(value = "户型",example = "2室1厅")
    private String houseType;

    @ApiModelProperty(value = "租金单价(元/平方米/月)",example = "4000")
    private BigDecimal leasePrice;

    @ApiModelProperty(value = "租金(面积X租金单价) 元/月",example = "20000")
    private BigDecimal leaseSum;

    @ApiModelProperty(value = "押:press付pay(如:押1付3)",example = "押1付3")
    private String pressPay;

    @ApiModelProperty(value = "最短租期(月)",example = "6")
    private String shortestLease;

    @ApiModelProperty(value = "创建时间")
    private java.sql.Date createTime;

    @ApiModelProperty(value ="介绍",example ="介绍内容")
    private String introduce;

    @ApiModelProperty(value = "租借企业id")
    private String enterpriseId;

    @ApiModelProperty(value = "租借企业名称",example = "美的")
    private String leaseEnterprise;

    @ApiModelProperty(value = "开始租借时间",example = "2018-05-01")
    private Date leaseStartTime;

    @ApiModelProperty(value = "租借结束时间",example = "2019-05-01")
    private Date leaseEndTime;

    @ApiModelProperty(value = "企业联系人",example = "先生")
    private String contactName;

    @ApiModelProperty(value = "联系人电话",example = "123456")
    private String contactPhone;

    @ApiModelProperty(value = "房间状态(0空闲,1租借申请中,2租借中,3退租申请中,4已到期)")
    private Byte roomStatus;

    @ApiModelProperty(value = "创建者账号")
    private String creatorAccount;

    @ApiModelProperty(value = "同属分组房间")
    private List<RoomOrdersModle> roomOrdersModlesList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getRoomArea() {
        return roomArea;
    }

    public void setRoomArea(String roomArea) {
        this.roomArea = roomArea;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
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

    public Byte getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Byte roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public List<RoomOrdersModle> getRoomOrdersModlesList() {
        return roomOrdersModlesList;
    }

    public void setRoomOrdersModlesList(List<RoomOrdersModle> roomOrdersModlesList) {
        this.roomOrdersModlesList = roomOrdersModlesList;
    }

    @Override
    public String toString() {
        return "RoomOrdersModle{" +
                "id='" + id + '\'' +
                ", orderId='" + orderId + '\'' +
                ", roomId='" + roomId + '\'' +
                ", roomName='" + roomName + '\'' +
                ", floor='" + floor + '\'' +
                ", towerId='" + towerId + '\'' +
                ", towerName='" + towerName + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", roomArea='" + roomArea + '\'' +
                ", houseType='" + houseType + '\'' +
                ", leasePrice=" + leasePrice +
                ", leaseSum=" + leaseSum +
                ", pressPay='" + pressPay + '\'' +
                ", shortestLease='" + shortestLease + '\'' +
                ", createTime=" + createTime +
                ", introduce='" + introduce + '\'' +
                ", enterpriseId='" + enterpriseId + '\'' +
                ", leaseEnterprise='" + leaseEnterprise + '\'' +
                ", leaseStartTime=" + leaseStartTime +
                ", leaseEndTime=" + leaseEndTime +
                ", contactName='" + contactName + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", roomStatus=" + roomStatus +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", roomOrdersModlesList=" + roomOrdersModlesList +
                '}';
    }
}
