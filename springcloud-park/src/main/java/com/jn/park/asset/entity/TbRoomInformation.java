package com.jn.park.asset.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbRoomInformation implements Serializable {
    /*@ApiModelProperty("")*/
    private String id;

    /*@ApiModelProperty("房间名称(如:101)")*/
    private String name;

    /*@ApiModelProperty("楼层")*/
    private String floor;

    /*@ApiModelProperty("楼宇id")*/
    private String towerId;

    /*@ApiModelProperty("所属楼宇名称")*/
    private String towerName;

    /*@ApiModelProperty("分组id")*/
    private String groupId;

    /*@ApiModelProperty("所属分组")*/
    private String groupName;

    /*@ApiModelProperty("面积(平方米)")*/
    private String roomArea;

    /*@ApiModelProperty("最短租期(月)")*/
    private String shortestLease;

    /*@ApiModelProperty("租金单价(元/平方米/月)")*/
    private BigDecimal leasePrice;

    /*@ApiModelProperty("租金(面积X租金单价) 元/月")*/
    private BigDecimal leaseSum;

    /*@ApiModelProperty("押:")*/
    private Integer press;

    /*@ApiModelProperty("付:")*/
    private Integer pay;

    /*@ApiModelProperty("押:press付pay(如:押1付3)")*/
    private String pressPay;

    /*@ApiModelProperty("户型")*/
    private String houseType;

    /*@ApiModelProperty("实景图片")*/
    private String imgUrl;

    /*@ApiModelProperty("流程平面图")*/
    private String floorPlan;

    /*@ApiModelProperty("户型图")*/
    private String roomPlan;

    /*@ApiModelProperty("介绍")*/
    private String introduce;

    /*@ApiModelProperty("状态(0空闲,1租借申请中,2租借中,3退租申请,4已到期)")*/
    private Byte state;

    /*@ApiModelProperty("开始租借时间")*/
    private Date leaseStartTime;

    /*@ApiModelProperty("租借结束时间")*/
    private Date leaseEndTime;

    /*@ApiModelProperty("租赁企业id")*/
    private String enterpriseId;

    /*@ApiModelProperty("租借企业名称")*/
    private String leaseEnterprise;

    /*@ApiModelProperty("企业联系人")*/
    private String contactName;

    /*@ApiModelProperty("联系人电话")*/
    private String contactPhone;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Byte recordStatus;

    /*@ApiModelProperty("创建者账号")*/
    private String creatorAccount;

    /*@ApiModelProperty("创建时间")*/
    private Date createTime;

    /*@ApiModelProperty("最新更新者账号")*/
    private String modifierAccount;

    /*@ApiModelProperty("最新更新时间")*/
    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor == null ? null : floor.trim();
    }

    public String getTowerId() {
        return towerId;
    }

    public void setTowerId(String towerId) {
        this.towerId = towerId == null ? null : towerId.trim();
    }

    public String getTowerName() {
        return towerName;
    }

    public void setTowerName(String towerName) {
        this.towerName = towerName == null ? null : towerName.trim();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getRoomArea() {
        return roomArea;
    }

    public void setRoomArea(String roomArea) {
        this.roomArea = roomArea == null ? null : roomArea.trim();
    }

    public String getShortestLease() {
        return shortestLease;
    }

    public void setShortestLease(String shortestLease) {
        this.shortestLease = shortestLease == null ? null : shortestLease.trim();
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

    public Integer getPress() {
        return press;
    }

    public void setPress(Integer press) {
        this.press = press;
    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }

    public String getPressPay() {
        return pressPay;
    }

    public void setPressPay(String pressPay) {
        this.pressPay = pressPay == null ? null : pressPay.trim();
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType == null ? null : houseType.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getFloorPlan() {
        return floorPlan;
    }

    public void setFloorPlan(String floorPlan) {
        this.floorPlan = floorPlan == null ? null : floorPlan.trim();
    }

    public String getRoomPlan() {
        return roomPlan;
    }

    public void setRoomPlan(String roomPlan) {
        this.roomPlan = roomPlan == null ? null : roomPlan.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
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

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId == null ? null : enterpriseId.trim();
    }

    public String getLeaseEnterprise() {
        return leaseEnterprise;
    }

    public void setLeaseEnterprise(String leaseEnterprise) {
        this.leaseEnterprise = leaseEnterprise == null ? null : leaseEnterprise.trim();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount == null ? null : creatorAccount.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount == null ? null : modifierAccount.trim();
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TbRoomInformation other = (TbRoomInformation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getFloor() == null ? other.getFloor() == null : this.getFloor().equals(other.getFloor()))
            && (this.getTowerId() == null ? other.getTowerId() == null : this.getTowerId().equals(other.getTowerId()))
            && (this.getTowerName() == null ? other.getTowerName() == null : this.getTowerName().equals(other.getTowerName()))
            && (this.getGroupId() == null ? other.getGroupId() == null : this.getGroupId().equals(other.getGroupId()))
            && (this.getGroupName() == null ? other.getGroupName() == null : this.getGroupName().equals(other.getGroupName()))
            && (this.getRoomArea() == null ? other.getRoomArea() == null : this.getRoomArea().equals(other.getRoomArea()))
            && (this.getShortestLease() == null ? other.getShortestLease() == null : this.getShortestLease().equals(other.getShortestLease()))
            && (this.getLeasePrice() == null ? other.getLeasePrice() == null : this.getLeasePrice().equals(other.getLeasePrice()))
            && (this.getLeaseSum() == null ? other.getLeaseSum() == null : this.getLeaseSum().equals(other.getLeaseSum()))
            && (this.getPress() == null ? other.getPress() == null : this.getPress().equals(other.getPress()))
            && (this.getPay() == null ? other.getPay() == null : this.getPay().equals(other.getPay()))
            && (this.getPressPay() == null ? other.getPressPay() == null : this.getPressPay().equals(other.getPressPay()))
            && (this.getHouseType() == null ? other.getHouseType() == null : this.getHouseType().equals(other.getHouseType()))
            && (this.getImgUrl() == null ? other.getImgUrl() == null : this.getImgUrl().equals(other.getImgUrl()))
            && (this.getFloorPlan() == null ? other.getFloorPlan() == null : this.getFloorPlan().equals(other.getFloorPlan()))
            && (this.getRoomPlan() == null ? other.getRoomPlan() == null : this.getRoomPlan().equals(other.getRoomPlan()))
            && (this.getIntroduce() == null ? other.getIntroduce() == null : this.getIntroduce().equals(other.getIntroduce()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getLeaseStartTime() == null ? other.getLeaseStartTime() == null : this.getLeaseStartTime().equals(other.getLeaseStartTime()))
            && (this.getLeaseEndTime() == null ? other.getLeaseEndTime() == null : this.getLeaseEndTime().equals(other.getLeaseEndTime()))
            && (this.getEnterpriseId() == null ? other.getEnterpriseId() == null : this.getEnterpriseId().equals(other.getEnterpriseId()))
            && (this.getLeaseEnterprise() == null ? other.getLeaseEnterprise() == null : this.getLeaseEnterprise().equals(other.getLeaseEnterprise()))
            && (this.getContactName() == null ? other.getContactName() == null : this.getContactName().equals(other.getContactName()))
            && (this.getContactPhone() == null ? other.getContactPhone() == null : this.getContactPhone().equals(other.getContactPhone()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getFloor() == null) ? 0 : getFloor().hashCode());
        result = prime * result + ((getTowerId() == null) ? 0 : getTowerId().hashCode());
        result = prime * result + ((getTowerName() == null) ? 0 : getTowerName().hashCode());
        result = prime * result + ((getGroupId() == null) ? 0 : getGroupId().hashCode());
        result = prime * result + ((getGroupName() == null) ? 0 : getGroupName().hashCode());
        result = prime * result + ((getRoomArea() == null) ? 0 : getRoomArea().hashCode());
        result = prime * result + ((getShortestLease() == null) ? 0 : getShortestLease().hashCode());
        result = prime * result + ((getLeasePrice() == null) ? 0 : getLeasePrice().hashCode());
        result = prime * result + ((getLeaseSum() == null) ? 0 : getLeaseSum().hashCode());
        result = prime * result + ((getPress() == null) ? 0 : getPress().hashCode());
        result = prime * result + ((getPay() == null) ? 0 : getPay().hashCode());
        result = prime * result + ((getPressPay() == null) ? 0 : getPressPay().hashCode());
        result = prime * result + ((getHouseType() == null) ? 0 : getHouseType().hashCode());
        result = prime * result + ((getImgUrl() == null) ? 0 : getImgUrl().hashCode());
        result = prime * result + ((getFloorPlan() == null) ? 0 : getFloorPlan().hashCode());
        result = prime * result + ((getRoomPlan() == null) ? 0 : getRoomPlan().hashCode());
        result = prime * result + ((getIntroduce() == null) ? 0 : getIntroduce().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getLeaseStartTime() == null) ? 0 : getLeaseStartTime().hashCode());
        result = prime * result + ((getLeaseEndTime() == null) ? 0 : getLeaseEndTime().hashCode());
        result = prime * result + ((getEnterpriseId() == null) ? 0 : getEnterpriseId().hashCode());
        result = prime * result + ((getLeaseEnterprise() == null) ? 0 : getLeaseEnterprise().hashCode());
        result = prime * result + ((getContactName() == null) ? 0 : getContactName().hashCode());
        result = prime * result + ((getContactPhone() == null) ? 0 : getContactPhone().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", floor=").append(floor);
        sb.append(", towerId=").append(towerId);
        sb.append(", towerName=").append(towerName);
        sb.append(", groupId=").append(groupId);
        sb.append(", groupName=").append(groupName);
        sb.append(", roomArea=").append(roomArea);
        sb.append(", shortestLease=").append(shortestLease);
        sb.append(", leasePrice=").append(leasePrice);
        sb.append(", leaseSum=").append(leaseSum);
        sb.append(", press=").append(press);
        sb.append(", pay=").append(pay);
        sb.append(", pressPay=").append(pressPay);
        sb.append(", houseType=").append(houseType);
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", floorPlan=").append(floorPlan);
        sb.append(", roomPlan=").append(roomPlan);
        sb.append(", introduce=").append(introduce);
        sb.append(", state=").append(state);
        sb.append(", leaseStartTime=").append(leaseStartTime);
        sb.append(", leaseEndTime=").append(leaseEndTime);
        sb.append(", enterpriseId=").append(enterpriseId);
        sb.append(", leaseEnterprise=").append(leaseEnterprise);
        sb.append(", contactName=").append(contactName);
        sb.append(", contactPhone=").append(contactPhone);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}