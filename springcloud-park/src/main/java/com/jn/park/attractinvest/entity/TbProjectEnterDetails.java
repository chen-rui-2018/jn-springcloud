package com.jn.park.attractinvest.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbProjectEnterDetails implements Serializable {
    private String id;

    private String projectId;

    private String enterTower;

    private String towerId;

    private String roomId;

    private String roomName;

    private String roomArea;

    private String compactPeriod;

    private BigDecimal roomUnitPrice;

    private BigDecimal leaseSum;

    private BigDecimal accordingAreaAccout;

    private BigDecimal accordingCompAccout;

    private BigDecimal freeAccount;

    private BigDecimal actualAccount;

    private BigDecimal pmUnitPrice;

    private BigDecimal electricityConsumption;

    private BigDecimal depositCash;

    private String taxPromise;

    private String freeClause;

    private String remark;

    private Byte recordStatus;

    private String creatorAccount;

    private Date createdTime;

    private String modifierAccount;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getEnterTower() {
        return enterTower;
    }

    public void setEnterTower(String enterTower) {
        this.enterTower = enterTower == null ? null : enterTower.trim();
    }

    public String getTowerId() {
        return towerId;
    }

    public void setTowerId(String towerId) {
        this.towerId = towerId == null ? null : towerId.trim();
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

    public String getRoomArea() {
        return roomArea;
    }

    public void setRoomArea(String roomArea) {
        this.roomArea = roomArea == null ? null : roomArea.trim();
    }

    public String getCompactPeriod() {
        return compactPeriod;
    }

    public void setCompactPeriod(String compactPeriod) {
        this.compactPeriod = compactPeriod == null ? null : compactPeriod.trim();
    }

    public BigDecimal getRoomUnitPrice() {
        return roomUnitPrice;
    }

    public void setRoomUnitPrice(BigDecimal roomUnitPrice) {
        this.roomUnitPrice = roomUnitPrice;
    }

    public BigDecimal getLeaseSum() {
        return leaseSum;
    }

    public void setLeaseSum(BigDecimal leaseSum) {
        this.leaseSum = leaseSum;
    }

    public BigDecimal getAccordingAreaAccout() {
        return accordingAreaAccout;
    }

    public void setAccordingAreaAccout(BigDecimal accordingAreaAccout) {
        this.accordingAreaAccout = accordingAreaAccout;
    }

    public BigDecimal getAccordingCompAccout() {
        return accordingCompAccout;
    }

    public void setAccordingCompAccout(BigDecimal accordingCompAccout) {
        this.accordingCompAccout = accordingCompAccout;
    }

    public BigDecimal getFreeAccount() {
        return freeAccount;
    }

    public void setFreeAccount(BigDecimal freeAccount) {
        this.freeAccount = freeAccount;
    }

    public BigDecimal getActualAccount() {
        return actualAccount;
    }

    public void setActualAccount(BigDecimal actualAccount) {
        this.actualAccount = actualAccount;
    }

    public BigDecimal getPmUnitPrice() {
        return pmUnitPrice;
    }

    public void setPmUnitPrice(BigDecimal pmUnitPrice) {
        this.pmUnitPrice = pmUnitPrice;
    }

    public BigDecimal getElectricityConsumption() {
        return electricityConsumption;
    }

    public void setElectricityConsumption(BigDecimal electricityConsumption) {
        this.electricityConsumption = electricityConsumption;
    }

    public BigDecimal getDepositCash() {
        return depositCash;
    }

    public void setDepositCash(BigDecimal depositCash) {
        this.depositCash = depositCash;
    }

    public String getTaxPromise() {
        return taxPromise;
    }

    public void setTaxPromise(String taxPromise) {
        this.taxPromise = taxPromise == null ? null : taxPromise.trim();
    }

    public String getFreeClause() {
        return freeClause;
    }

    public void setFreeClause(String freeClause) {
        this.freeClause = freeClause == null ? null : freeClause.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
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
        TbProjectEnterDetails other = (TbProjectEnterDetails) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getEnterTower() == null ? other.getEnterTower() == null : this.getEnterTower().equals(other.getEnterTower()))
            && (this.getTowerId() == null ? other.getTowerId() == null : this.getTowerId().equals(other.getTowerId()))
            && (this.getRoomId() == null ? other.getRoomId() == null : this.getRoomId().equals(other.getRoomId()))
            && (this.getRoomName() == null ? other.getRoomName() == null : this.getRoomName().equals(other.getRoomName()))
            && (this.getRoomArea() == null ? other.getRoomArea() == null : this.getRoomArea().equals(other.getRoomArea()))
            && (this.getCompactPeriod() == null ? other.getCompactPeriod() == null : this.getCompactPeriod().equals(other.getCompactPeriod()))
            && (this.getRoomUnitPrice() == null ? other.getRoomUnitPrice() == null : this.getRoomUnitPrice().equals(other.getRoomUnitPrice()))
            && (this.getLeaseSum() == null ? other.getLeaseSum() == null : this.getLeaseSum().equals(other.getLeaseSum()))
            && (this.getAccordingAreaAccout() == null ? other.getAccordingAreaAccout() == null : this.getAccordingAreaAccout().equals(other.getAccordingAreaAccout()))
            && (this.getAccordingCompAccout() == null ? other.getAccordingCompAccout() == null : this.getAccordingCompAccout().equals(other.getAccordingCompAccout()))
            && (this.getFreeAccount() == null ? other.getFreeAccount() == null : this.getFreeAccount().equals(other.getFreeAccount()))
            && (this.getActualAccount() == null ? other.getActualAccount() == null : this.getActualAccount().equals(other.getActualAccount()))
            && (this.getPmUnitPrice() == null ? other.getPmUnitPrice() == null : this.getPmUnitPrice().equals(other.getPmUnitPrice()))
            && (this.getElectricityConsumption() == null ? other.getElectricityConsumption() == null : this.getElectricityConsumption().equals(other.getElectricityConsumption()))
            && (this.getDepositCash() == null ? other.getDepositCash() == null : this.getDepositCash().equals(other.getDepositCash()))
            && (this.getTaxPromise() == null ? other.getTaxPromise() == null : this.getTaxPromise().equals(other.getTaxPromise()))
            && (this.getFreeClause() == null ? other.getFreeClause() == null : this.getFreeClause().equals(other.getFreeClause()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getEnterTower() == null) ? 0 : getEnterTower().hashCode());
        result = prime * result + ((getTowerId() == null) ? 0 : getTowerId().hashCode());
        result = prime * result + ((getRoomId() == null) ? 0 : getRoomId().hashCode());
        result = prime * result + ((getRoomName() == null) ? 0 : getRoomName().hashCode());
        result = prime * result + ((getRoomArea() == null) ? 0 : getRoomArea().hashCode());
        result = prime * result + ((getCompactPeriod() == null) ? 0 : getCompactPeriod().hashCode());
        result = prime * result + ((getRoomUnitPrice() == null) ? 0 : getRoomUnitPrice().hashCode());
        result = prime * result + ((getLeaseSum() == null) ? 0 : getLeaseSum().hashCode());
        result = prime * result + ((getAccordingAreaAccout() == null) ? 0 : getAccordingAreaAccout().hashCode());
        result = prime * result + ((getAccordingCompAccout() == null) ? 0 : getAccordingCompAccout().hashCode());
        result = prime * result + ((getFreeAccount() == null) ? 0 : getFreeAccount().hashCode());
        result = prime * result + ((getActualAccount() == null) ? 0 : getActualAccount().hashCode());
        result = prime * result + ((getPmUnitPrice() == null) ? 0 : getPmUnitPrice().hashCode());
        result = prime * result + ((getElectricityConsumption() == null) ? 0 : getElectricityConsumption().hashCode());
        result = prime * result + ((getDepositCash() == null) ? 0 : getDepositCash().hashCode());
        result = prime * result + ((getTaxPromise() == null) ? 0 : getTaxPromise().hashCode());
        result = prime * result + ((getFreeClause() == null) ? 0 : getFreeClause().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
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
        sb.append(", projectId=").append(projectId);
        sb.append(", enterTower=").append(enterTower);
        sb.append(", towerId=").append(towerId);
        sb.append(", roomId=").append(roomId);
        sb.append(", roomName=").append(roomName);
        sb.append(", roomArea=").append(roomArea);
        sb.append(", compactPeriod=").append(compactPeriod);
        sb.append(", roomUnitPrice=").append(roomUnitPrice);
        sb.append(", leaseSum=").append(leaseSum);
        sb.append(", accordingAreaAccout=").append(accordingAreaAccout);
        sb.append(", accordingCompAccout=").append(accordingCompAccout);
        sb.append(", freeAccount=").append(freeAccount);
        sb.append(", actualAccount=").append(actualAccount);
        sb.append(", pmUnitPrice=").append(pmUnitPrice);
        sb.append(", electricityConsumption=").append(electricityConsumption);
        sb.append(", depositCash=").append(depositCash);
        sb.append(", taxPromise=").append(taxPromise);
        sb.append(", freeClause=").append(freeClause);
        sb.append(", remark=").append(remark);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}