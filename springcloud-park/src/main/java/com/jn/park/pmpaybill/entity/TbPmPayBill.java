package com.jn.park.pmpaybill.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbPmPayBill implements Serializable {
    private String id;

    private String companyId;

    private String companyName;

    private String companyAddress;

    private String buildingId;

    private String buildingName;

    private String dealDate;

    private BigDecimal billAmount;

    private BigDecimal freeAmount;

    private BigDecimal totalAmount;

    private Date lastPayTime;

    private Byte payStatus;

    private Byte isExpire;

    private Byte generateSatus;

    private Byte derateState;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId == null ? null : buildingId.trim();
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName == null ? null : buildingName.trim();
    }

    public String getDealDate() {
        return dealDate;
    }

    public void setDealDate(String dealDate) {
        this.dealDate = dealDate == null ? null : dealDate.trim();
    }

    public BigDecimal getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(BigDecimal billAmount) {
        this.billAmount = billAmount;
    }

    public BigDecimal getFreeAmount() {
        return freeAmount;
    }

    public void setFreeAmount(BigDecimal freeAmount) {
        this.freeAmount = freeAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getLastPayTime() {
        return lastPayTime;
    }

    public void setLastPayTime(Date lastPayTime) {
        this.lastPayTime = lastPayTime;
    }

    public Byte getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Byte payStatus) {
        this.payStatus = payStatus;
    }

    public Byte getIsExpire() {
        return isExpire;
    }

    public void setIsExpire(Byte isExpire) {
        this.isExpire = isExpire;
    }

    public Byte getGenerateSatus() {
        return generateSatus;
    }

    public void setGenerateSatus(Byte generateSatus) {
        this.generateSatus = generateSatus;
    }

    public Byte getDerateState() {
        return derateState;
    }

    public void setDerateState(Byte derateState) {
        this.derateState = derateState;
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
        TbPmPayBill other = (TbPmPayBill) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getCompanyAddress() == null ? other.getCompanyAddress() == null : this.getCompanyAddress().equals(other.getCompanyAddress()))
            && (this.getBuildingId() == null ? other.getBuildingId() == null : this.getBuildingId().equals(other.getBuildingId()))
            && (this.getBuildingName() == null ? other.getBuildingName() == null : this.getBuildingName().equals(other.getBuildingName()))
            && (this.getDealDate() == null ? other.getDealDate() == null : this.getDealDate().equals(other.getDealDate()))
            && (this.getBillAmount() == null ? other.getBillAmount() == null : this.getBillAmount().equals(other.getBillAmount()))
            && (this.getFreeAmount() == null ? other.getFreeAmount() == null : this.getFreeAmount().equals(other.getFreeAmount()))
            && (this.getTotalAmount() == null ? other.getTotalAmount() == null : this.getTotalAmount().equals(other.getTotalAmount()))
            && (this.getLastPayTime() == null ? other.getLastPayTime() == null : this.getLastPayTime().equals(other.getLastPayTime()))
            && (this.getPayStatus() == null ? other.getPayStatus() == null : this.getPayStatus().equals(other.getPayStatus()))
            && (this.getIsExpire() == null ? other.getIsExpire() == null : this.getIsExpire().equals(other.getIsExpire()))
            && (this.getGenerateSatus() == null ? other.getGenerateSatus() == null : this.getGenerateSatus().equals(other.getGenerateSatus()))
            && (this.getDerateState() == null ? other.getDerateState() == null : this.getDerateState().equals(other.getDerateState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getCompanyAddress() == null) ? 0 : getCompanyAddress().hashCode());
        result = prime * result + ((getBuildingId() == null) ? 0 : getBuildingId().hashCode());
        result = prime * result + ((getBuildingName() == null) ? 0 : getBuildingName().hashCode());
        result = prime * result + ((getDealDate() == null) ? 0 : getDealDate().hashCode());
        result = prime * result + ((getBillAmount() == null) ? 0 : getBillAmount().hashCode());
        result = prime * result + ((getFreeAmount() == null) ? 0 : getFreeAmount().hashCode());
        result = prime * result + ((getTotalAmount() == null) ? 0 : getTotalAmount().hashCode());
        result = prime * result + ((getLastPayTime() == null) ? 0 : getLastPayTime().hashCode());
        result = prime * result + ((getPayStatus() == null) ? 0 : getPayStatus().hashCode());
        result = prime * result + ((getIsExpire() == null) ? 0 : getIsExpire().hashCode());
        result = prime * result + ((getGenerateSatus() == null) ? 0 : getGenerateSatus().hashCode());
        result = prime * result + ((getDerateState() == null) ? 0 : getDerateState().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", companyId=").append(companyId);
        sb.append(", companyName=").append(companyName);
        sb.append(", companyAddress=").append(companyAddress);
        sb.append(", buildingId=").append(buildingId);
        sb.append(", buildingName=").append(buildingName);
        sb.append(", dealDate=").append(dealDate);
        sb.append(", billAmount=").append(billAmount);
        sb.append(", freeAmount=").append(freeAmount);
        sb.append(", totalAmount=").append(totalAmount);
        sb.append(", lastPayTime=").append(lastPayTime);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", isExpire=").append(isExpire);
        sb.append(", generateSatus=").append(generateSatus);
        sb.append(", derateState=").append(derateState);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}