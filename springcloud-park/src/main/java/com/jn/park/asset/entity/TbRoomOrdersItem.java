package com.jn.park.asset.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbRoomOrdersItem implements Serializable {
    /*@ApiModelProperty("订单编号")*/
    private String id;

    /*@ApiModelProperty("订单表ID")*/
    private String orderId;

    /*@ApiModelProperty("房间id")*/
    private String roomId;

    /*@ApiModelProperty("房间名称")*/
    private String roomName;

    /*@ApiModelProperty("楼层")*/
    private String floor;

    /*@ApiModelProperty("楼宇id")*/
    private String towerId;

    /*@ApiModelProperty("楼宇名称")*/
    private String towerName;

    /*@ApiModelProperty("房间图片")*/
    private String roomUrl;

    /*@ApiModelProperty("面积(平方米)")*/
    private String roomArea;

    /*@ApiModelProperty("租金单价(元/平方米/月)")*/
    private BigDecimal leasePrice;

    /*@ApiModelProperty("租金(面积X租金单价) 元/月")*/
    private BigDecimal leaseSum;

    /*@ApiModelProperty("押:press付pay(如:押1付3)")*/
    private String pressPay;

    /*@ApiModelProperty("最短租期(月)")*/
    private String shortestLease;

    /*@ApiModelProperty("介绍")*/
    private String introduce;

    /*@ApiModelProperty("付款金额")*/
    private BigDecimal paySum;

    /*@ApiModelProperty("房间状态(0空闲,1租借申请中,2租借中,3退租申请中,4已到期)(暂时没用)")*/
    private Byte roomStatus;

    /*@ApiModelProperty("退租违约金")*/
    private BigDecimal quitPenalSum;

    /*@ApiModelProperty("说明")*/
    private String explain;

    /*@ApiModelProperty("意见")*/
    private String approvalOpinion;

    /*@ApiModelProperty("实际退租时间")*/
    private Date practicalQuitTime;

    /*@ApiModelProperty("租赁申请状态(0申请失败,1申请中,2申请成功)")*/
    private Byte leaseApplyStatus;

    /*@ApiModelProperty("退租申请状态(0申请失败,1申请中,2申请成功)")*/
    private Byte quitApplyStatus;

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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId == null ? null : roomId.trim();
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName == null ? null : roomName.trim();
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

    public String getRoomUrl() {
        return roomUrl;
    }

    public void setRoomUrl(String roomUrl) {
        this.roomUrl = roomUrl == null ? null : roomUrl.trim();
    }

    public String getRoomArea() {
        return roomArea;
    }

    public void setRoomArea(String roomArea) {
        this.roomArea = roomArea == null ? null : roomArea.trim();
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
        this.pressPay = pressPay == null ? null : pressPay.trim();
    }

    public String getShortestLease() {
        return shortestLease;
    }

    public void setShortestLease(String shortestLease) {
        this.shortestLease = shortestLease == null ? null : shortestLease.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public BigDecimal getPaySum() {
        return paySum;
    }

    public void setPaySum(BigDecimal paySum) {
        this.paySum = paySum;
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
        this.explain = explain == null ? null : explain.trim();
    }

    public String getApprovalOpinion() {
        return approvalOpinion;
    }

    public void setApprovalOpinion(String approvalOpinion) {
        this.approvalOpinion = approvalOpinion == null ? null : approvalOpinion.trim();
    }

    public Date getPracticalQuitTime() {
        return practicalQuitTime;
    }

    public void setPracticalQuitTime(Date practicalQuitTime) {
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
        TbRoomOrdersItem other = (TbRoomOrdersItem) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getRoomId() == null ? other.getRoomId() == null : this.getRoomId().equals(other.getRoomId()))
            && (this.getRoomName() == null ? other.getRoomName() == null : this.getRoomName().equals(other.getRoomName()))
            && (this.getFloor() == null ? other.getFloor() == null : this.getFloor().equals(other.getFloor()))
            && (this.getTowerId() == null ? other.getTowerId() == null : this.getTowerId().equals(other.getTowerId()))
            && (this.getTowerName() == null ? other.getTowerName() == null : this.getTowerName().equals(other.getTowerName()))
            && (this.getRoomUrl() == null ? other.getRoomUrl() == null : this.getRoomUrl().equals(other.getRoomUrl()))
            && (this.getRoomArea() == null ? other.getRoomArea() == null : this.getRoomArea().equals(other.getRoomArea()))
            && (this.getLeasePrice() == null ? other.getLeasePrice() == null : this.getLeasePrice().equals(other.getLeasePrice()))
            && (this.getLeaseSum() == null ? other.getLeaseSum() == null : this.getLeaseSum().equals(other.getLeaseSum()))
            && (this.getPressPay() == null ? other.getPressPay() == null : this.getPressPay().equals(other.getPressPay()))
            && (this.getShortestLease() == null ? other.getShortestLease() == null : this.getShortestLease().equals(other.getShortestLease()))
            && (this.getIntroduce() == null ? other.getIntroduce() == null : this.getIntroduce().equals(other.getIntroduce()))
            && (this.getPaySum() == null ? other.getPaySum() == null : this.getPaySum().equals(other.getPaySum()))
            && (this.getRoomStatus() == null ? other.getRoomStatus() == null : this.getRoomStatus().equals(other.getRoomStatus()))
            && (this.getQuitPenalSum() == null ? other.getQuitPenalSum() == null : this.getQuitPenalSum().equals(other.getQuitPenalSum()))
            && (this.getExplain() == null ? other.getExplain() == null : this.getExplain().equals(other.getExplain()))
            && (this.getApprovalOpinion() == null ? other.getApprovalOpinion() == null : this.getApprovalOpinion().equals(other.getApprovalOpinion()))
            && (this.getPracticalQuitTime() == null ? other.getPracticalQuitTime() == null : this.getPracticalQuitTime().equals(other.getPracticalQuitTime()))
            && (this.getLeaseApplyStatus() == null ? other.getLeaseApplyStatus() == null : this.getLeaseApplyStatus().equals(other.getLeaseApplyStatus()))
            && (this.getQuitApplyStatus() == null ? other.getQuitApplyStatus() == null : this.getQuitApplyStatus().equals(other.getQuitApplyStatus()))
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
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getRoomId() == null) ? 0 : getRoomId().hashCode());
        result = prime * result + ((getRoomName() == null) ? 0 : getRoomName().hashCode());
        result = prime * result + ((getFloor() == null) ? 0 : getFloor().hashCode());
        result = prime * result + ((getTowerId() == null) ? 0 : getTowerId().hashCode());
        result = prime * result + ((getTowerName() == null) ? 0 : getTowerName().hashCode());
        result = prime * result + ((getRoomUrl() == null) ? 0 : getRoomUrl().hashCode());
        result = prime * result + ((getRoomArea() == null) ? 0 : getRoomArea().hashCode());
        result = prime * result + ((getLeasePrice() == null) ? 0 : getLeasePrice().hashCode());
        result = prime * result + ((getLeaseSum() == null) ? 0 : getLeaseSum().hashCode());
        result = prime * result + ((getPressPay() == null) ? 0 : getPressPay().hashCode());
        result = prime * result + ((getShortestLease() == null) ? 0 : getShortestLease().hashCode());
        result = prime * result + ((getIntroduce() == null) ? 0 : getIntroduce().hashCode());
        result = prime * result + ((getPaySum() == null) ? 0 : getPaySum().hashCode());
        result = prime * result + ((getRoomStatus() == null) ? 0 : getRoomStatus().hashCode());
        result = prime * result + ((getQuitPenalSum() == null) ? 0 : getQuitPenalSum().hashCode());
        result = prime * result + ((getExplain() == null) ? 0 : getExplain().hashCode());
        result = prime * result + ((getApprovalOpinion() == null) ? 0 : getApprovalOpinion().hashCode());
        result = prime * result + ((getPracticalQuitTime() == null) ? 0 : getPracticalQuitTime().hashCode());
        result = prime * result + ((getLeaseApplyStatus() == null) ? 0 : getLeaseApplyStatus().hashCode());
        result = prime * result + ((getQuitApplyStatus() == null) ? 0 : getQuitApplyStatus().hashCode());
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
        sb.append(", orderId=").append(orderId);
        sb.append(", roomId=").append(roomId);
        sb.append(", roomName=").append(roomName);
        sb.append(", floor=").append(floor);
        sb.append(", towerId=").append(towerId);
        sb.append(", towerName=").append(towerName);
        sb.append(", roomUrl=").append(roomUrl);
        sb.append(", roomArea=").append(roomArea);
        sb.append(", leasePrice=").append(leasePrice);
        sb.append(", leaseSum=").append(leaseSum);
        sb.append(", pressPay=").append(pressPay);
        sb.append(", shortestLease=").append(shortestLease);
        sb.append(", introduce=").append(introduce);
        sb.append(", paySum=").append(paySum);
        sb.append(", roomStatus=").append(roomStatus);
        sb.append(", quitPenalSum=").append(quitPenalSum);
        sb.append(", explain=").append(explain);
        sb.append(", approvalOpinion=").append(approvalOpinion);
        sb.append(", practicalQuitTime=").append(practicalQuitTime);
        sb.append(", leaseApplyStatus=").append(leaseApplyStatus);
        sb.append(", quitApplyStatus=").append(quitApplyStatus);
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