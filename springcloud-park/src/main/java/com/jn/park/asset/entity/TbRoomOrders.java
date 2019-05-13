package com.jn.park.asset.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbRoomOrders implements Serializable {
    /*@ApiModelProperty("订单编号")*/
    private String id;

    /*@ApiModelProperty("租借企业id")*/
    private String enterpriseId;

    /*@ApiModelProperty("租借企业")*/
    private String leaseEnterprise;

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

    /*@ApiModelProperty("开始租借时间")*/
    private Date leaseStartTime;

    /*@ApiModelProperty("租借结束时间")*/
    private Date leaseEndTime;

    /*@ApiModelProperty("企业联系人")*/
    private String contactName;

    /*@ApiModelProperty("联系人电话")*/
    private String contactPhone;

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

    /*@ApiModelProperty("付款金额")*/
    private BigDecimal paySum;

    /*@ApiModelProperty("支付状态(0未付款,1已付款)")*/
    private Byte payState;

    /*@ApiModelProperty("房间状态(0空闲,1租借申请中,2租借中,3退租申请中,4已到期)")*/
    private Byte roomStatus;

    /*@ApiModelProperty("退租申请时间")*/
    private Date quitApplyTime;

    /*@ApiModelProperty("退租违约金")*/
    private BigDecimal quitPenalSum;

    /*@ApiModelProperty("退租说明")*/
    private String quitExplain;

    /*@ApiModelProperty("实际退租时间")*/
    private Date practicalQuitTime;

    /*@ApiModelProperty("租赁申请状态(0申请失败,1申请成功)")*/
    private Byte leaseApplyStatus;

    /*@ApiModelProperty("退租申请状态(0申请失败,1申请成功)")*/
    private Byte quitApplyStatus;

    /*@ApiModelProperty("是否是续租订单(0不是续租订单,1是续租订单)")*/
    private Byte isRelet;

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
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
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

    public BigDecimal getPaySum() {
        return paySum;
    }

    public void setPaySum(BigDecimal paySum) {
        this.paySum = paySum;
    }

    public Byte getPayState() {
        return payState;
    }

    public void setPayState(Byte payState) {
        this.payState = payState;
    }

    public Byte getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Byte roomStatus) {
        this.roomStatus = roomStatus;
    }

    public Date getQuitApplyTime() {
        return quitApplyTime;
    }

    public void setQuitApplyTime(Date quitApplyTime) {
        this.quitApplyTime = quitApplyTime;
    }

    public BigDecimal getQuitPenalSum() {
        return quitPenalSum;
    }

    public void setQuitPenalSum(BigDecimal quitPenalSum) {
        this.quitPenalSum = quitPenalSum;
    }

    public String getQuitExplain() {
        return quitExplain;
    }

    public void setQuitExplain(String quitExplain) {
        this.quitExplain = quitExplain == null ? null : quitExplain.trim();
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

    public Byte getIsRelet() {
        return isRelet;
    }

    public void setIsRelet(Byte isRelet) {
        this.isRelet = isRelet;
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
        TbRoomOrders other = (TbRoomOrders) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEnterpriseId() == null ? other.getEnterpriseId() == null : this.getEnterpriseId().equals(other.getEnterpriseId()))
            && (this.getLeaseEnterprise() == null ? other.getLeaseEnterprise() == null : this.getLeaseEnterprise().equals(other.getLeaseEnterprise()))
            && (this.getRoomId() == null ? other.getRoomId() == null : this.getRoomId().equals(other.getRoomId()))
            && (this.getRoomName() == null ? other.getRoomName() == null : this.getRoomName().equals(other.getRoomName()))
            && (this.getFloor() == null ? other.getFloor() == null : this.getFloor().equals(other.getFloor()))
            && (this.getTowerId() == null ? other.getTowerId() == null : this.getTowerId().equals(other.getTowerId()))
            && (this.getTowerName() == null ? other.getTowerName() == null : this.getTowerName().equals(other.getTowerName()))
            && (this.getRoomUrl() == null ? other.getRoomUrl() == null : this.getRoomUrl().equals(other.getRoomUrl()))
            && (this.getLeaseStartTime() == null ? other.getLeaseStartTime() == null : this.getLeaseStartTime().equals(other.getLeaseStartTime()))
            && (this.getLeaseEndTime() == null ? other.getLeaseEndTime() == null : this.getLeaseEndTime().equals(other.getLeaseEndTime()))
            && (this.getContactName() == null ? other.getContactName() == null : this.getContactName().equals(other.getContactName()))
            && (this.getContactPhone() == null ? other.getContactPhone() == null : this.getContactPhone().equals(other.getContactPhone()))
            && (this.getRoomArea() == null ? other.getRoomArea() == null : this.getRoomArea().equals(other.getRoomArea()))
            && (this.getLeasePrice() == null ? other.getLeasePrice() == null : this.getLeasePrice().equals(other.getLeasePrice()))
            && (this.getLeaseSum() == null ? other.getLeaseSum() == null : this.getLeaseSum().equals(other.getLeaseSum()))
            && (this.getPressPay() == null ? other.getPressPay() == null : this.getPressPay().equals(other.getPressPay()))
            && (this.getShortestLease() == null ? other.getShortestLease() == null : this.getShortestLease().equals(other.getShortestLease()))
            && (this.getPaySum() == null ? other.getPaySum() == null : this.getPaySum().equals(other.getPaySum()))
            && (this.getPayState() == null ? other.getPayState() == null : this.getPayState().equals(other.getPayState()))
            && (this.getRoomStatus() == null ? other.getRoomStatus() == null : this.getRoomStatus().equals(other.getRoomStatus()))
            && (this.getQuitApplyTime() == null ? other.getQuitApplyTime() == null : this.getQuitApplyTime().equals(other.getQuitApplyTime()))
            && (this.getQuitPenalSum() == null ? other.getQuitPenalSum() == null : this.getQuitPenalSum().equals(other.getQuitPenalSum()))
            && (this.getQuitExplain() == null ? other.getQuitExplain() == null : this.getQuitExplain().equals(other.getQuitExplain()))
            && (this.getPracticalQuitTime() == null ? other.getPracticalQuitTime() == null : this.getPracticalQuitTime().equals(other.getPracticalQuitTime()))
            && (this.getLeaseApplyStatus() == null ? other.getLeaseApplyStatus() == null : this.getLeaseApplyStatus().equals(other.getLeaseApplyStatus()))
            && (this.getQuitApplyStatus() == null ? other.getQuitApplyStatus() == null : this.getQuitApplyStatus().equals(other.getQuitApplyStatus()))
            && (this.getIsRelet() == null ? other.getIsRelet() == null : this.getIsRelet().equals(other.getIsRelet()))
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
        result = prime * result + ((getEnterpriseId() == null) ? 0 : getEnterpriseId().hashCode());
        result = prime * result + ((getLeaseEnterprise() == null) ? 0 : getLeaseEnterprise().hashCode());
        result = prime * result + ((getRoomId() == null) ? 0 : getRoomId().hashCode());
        result = prime * result + ((getRoomName() == null) ? 0 : getRoomName().hashCode());
        result = prime * result + ((getFloor() == null) ? 0 : getFloor().hashCode());
        result = prime * result + ((getTowerId() == null) ? 0 : getTowerId().hashCode());
        result = prime * result + ((getTowerName() == null) ? 0 : getTowerName().hashCode());
        result = prime * result + ((getRoomUrl() == null) ? 0 : getRoomUrl().hashCode());
        result = prime * result + ((getLeaseStartTime() == null) ? 0 : getLeaseStartTime().hashCode());
        result = prime * result + ((getLeaseEndTime() == null) ? 0 : getLeaseEndTime().hashCode());
        result = prime * result + ((getContactName() == null) ? 0 : getContactName().hashCode());
        result = prime * result + ((getContactPhone() == null) ? 0 : getContactPhone().hashCode());
        result = prime * result + ((getRoomArea() == null) ? 0 : getRoomArea().hashCode());
        result = prime * result + ((getLeasePrice() == null) ? 0 : getLeasePrice().hashCode());
        result = prime * result + ((getLeaseSum() == null) ? 0 : getLeaseSum().hashCode());
        result = prime * result + ((getPressPay() == null) ? 0 : getPressPay().hashCode());
        result = prime * result + ((getShortestLease() == null) ? 0 : getShortestLease().hashCode());
        result = prime * result + ((getPaySum() == null) ? 0 : getPaySum().hashCode());
        result = prime * result + ((getPayState() == null) ? 0 : getPayState().hashCode());
        result = prime * result + ((getRoomStatus() == null) ? 0 : getRoomStatus().hashCode());
        result = prime * result + ((getQuitApplyTime() == null) ? 0 : getQuitApplyTime().hashCode());
        result = prime * result + ((getQuitPenalSum() == null) ? 0 : getQuitPenalSum().hashCode());
        result = prime * result + ((getQuitExplain() == null) ? 0 : getQuitExplain().hashCode());
        result = prime * result + ((getPracticalQuitTime() == null) ? 0 : getPracticalQuitTime().hashCode());
        result = prime * result + ((getLeaseApplyStatus() == null) ? 0 : getLeaseApplyStatus().hashCode());
        result = prime * result + ((getQuitApplyStatus() == null) ? 0 : getQuitApplyStatus().hashCode());
        result = prime * result + ((getIsRelet() == null) ? 0 : getIsRelet().hashCode());
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
        sb.append(", enterpriseId=").append(enterpriseId);
        sb.append(", leaseEnterprise=").append(leaseEnterprise);
        sb.append(", roomId=").append(roomId);
        sb.append(", roomName=").append(roomName);
        sb.append(", floor=").append(floor);
        sb.append(", towerId=").append(towerId);
        sb.append(", towerName=").append(towerName);
        sb.append(", roomUrl=").append(roomUrl);
        sb.append(", leaseStartTime=").append(leaseStartTime);
        sb.append(", leaseEndTime=").append(leaseEndTime);
        sb.append(", contactName=").append(contactName);
        sb.append(", contactPhone=").append(contactPhone);
        sb.append(", roomArea=").append(roomArea);
        sb.append(", leasePrice=").append(leasePrice);
        sb.append(", leaseSum=").append(leaseSum);
        sb.append(", pressPay=").append(pressPay);
        sb.append(", shortestLease=").append(shortestLease);
        sb.append(", paySum=").append(paySum);
        sb.append(", payState=").append(payState);
        sb.append(", roomStatus=").append(roomStatus);
        sb.append(", quitApplyTime=").append(quitApplyTime);
        sb.append(", quitPenalSum=").append(quitPenalSum);
        sb.append(", quitExplain=").append(quitExplain);
        sb.append(", practicalQuitTime=").append(practicalQuitTime);
        sb.append(", leaseApplyStatus=").append(leaseApplyStatus);
        sb.append(", quitApplyStatus=").append(quitApplyStatus);
        sb.append(", isRelet=").append(isRelet);
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