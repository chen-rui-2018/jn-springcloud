package com.jn.park.asset.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
* 房间信息model
* @author： zhuyz
* @date： Created on 2019/5/7 16:42
* @version： v1.0
* @modified By:
*/
public class RoomInformationModel implements Serializable {
    private static final long serialVersionUID = 4394990128329017817L;

    @ApiModelProperty(value = "主键",example = "575020345132580865")
    private String id;

    @ApiModelProperty(value = "房间名称",example = "101")
    private String name;

    @ApiModelProperty(value = "楼层",example = "1")
    private String floor;

    @ApiModelProperty(value = "楼宇id",example = "568817802354360320")
    private String towerId;

    @ApiModelProperty(value = "所属楼宇名称",example = "1号楼")
    private String towerName;

    @ApiModelProperty(value = "分组id",example = "2019051300020")
    private String groupId;

    @ApiModelProperty(value = "所属分组",example = "分组一")
    private String groupName;



    @ApiModelProperty(value = "面积(平方米)",example = "100")
    private String roomArea;

    @ApiModelProperty(value = "最短租期(月)",example = "12")
    private String shortestLease;

    @ApiModelProperty(value = "租金单价(元/平方米/月)",example = "100")
    private BigDecimal leasePrice;

    @ApiModelProperty(value = "租金(元/月)",example = "10000")
    private BigDecimal leaseSum;

    @ApiModelProperty(value = "押",example = "1")
    private String press;

    @ApiModelProperty(value = "付",example = "3")
    private String pay;

    @ApiModelProperty(value = "付款(如:押1付3)",example = "押1付3")
    private String pressPay;

    @ApiModelProperty(value = "户型",example = "2室1厅")
    private String houseType;

    @ApiModelProperty(value = "实景图片",example = "实景图片")
    private String imgUrl;

    @ApiModelProperty(value = "流程平面图",example = "流程平面图")
    private String floorPlan;

    @ApiModelProperty(value = "户型图",example = "户型图")
    private String roomPlan;

    @ApiModelProperty(value = "介绍",example = "房间介绍")
    private String introduce;

    @ApiModelProperty(value = "状态(0空闲,1租借申请中,2租借中,3退租申请,4已到期)",example = "0")
    private String state;

    @ApiModelProperty(value = "租借企业id",example = "")
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

    @ApiModelProperty(value = "创建时间",example = "2019-05-05")
    private Date crateTime;

    @ApiModelProperty(value = "地址",example = "南京市秦淮区白下智慧园区XX街1号")
    private String address;

    @ApiModelProperty(value = "同属分组(房间id)",example = "")
    private List<RoomInformationModel> groupRoomList;

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

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getFloorPlan() {
        return floorPlan;
    }

    public void setFloorPlan(String floorPlan) {
        this.floorPlan = floorPlan;
    }

    public String getRoomPlan() {
        return roomPlan;
    }

    public void setRoomPlan(String roomPlan) {
        this.roomPlan = roomPlan;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public Date getCrateTime() {
        return crateTime;
    }

    public void setCrateTime(Date crateTime) {
        this.crateTime = crateTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<RoomInformationModel> getGroupRoomList() {
        return groupRoomList;
    }

    public void setGroupRoomList(List<RoomInformationModel> groupRoomList) {
        this.groupRoomList = groupRoomList;
    }

    @Override
    public String toString() {
        return "RoomInformationModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", floor='" + floor + '\'' +
                ", towerId='" + towerId + '\'' +
                ", towerName='" + towerName + '\'' +
                ", groupId='" + groupId + '\'' +
                ", groupName='" + groupName + '\'' +
                ", roomArea='" + roomArea + '\'' +
                ", shortestLease='" + shortestLease + '\'' +
                ", leasePrice=" + leasePrice +
                ", leaseSum=" + leaseSum +
                ", press='" + press + '\'' +
                ", pay='" + pay + '\'' +
                ", pressPay='" + pressPay + '\'' +
                ", houseType='" + houseType + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", floorPlan='" + floorPlan + '\'' +
                ", roomPlan='" + roomPlan + '\'' +
                ", introduce='" + introduce + '\'' +
                ", state='" + state + '\'' +
                ", enterpriseId='" + enterpriseId + '\'' +
                ", leaseEnterprise='" + leaseEnterprise + '\'' +
                ", leaseStartTime=" + leaseStartTime +
                ", leaseEndTime=" + leaseEndTime +
                ", contactName='" + contactName + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", crateTime=" + crateTime +
                ", address='" + address + '\'' +
                ", groupRoomList=" + groupRoomList +
                '}';
    }
}
