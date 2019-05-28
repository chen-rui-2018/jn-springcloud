package com.jn.park.pmpaybill.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class TbPmPayBillItemPmList implements Serializable {
    private String id;

    private String itemId;

    private String pmName;

    private String roomAddress;

    private BigDecimal rentalArea;

    private BigDecimal totalAmount;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public String getPmName() {
        return pmName;
    }

    public void setPmName(String pmName) {
        this.pmName = pmName == null ? null : pmName.trim();
    }

    public String getRoomAddress() {
        return roomAddress;
    }

    public void setRoomAddress(String roomAddress) {
        this.roomAddress = roomAddress == null ? null : roomAddress.trim();
    }

    public BigDecimal getRentalArea() {
        return rentalArea;
    }

    public void setRentalArea(BigDecimal rentalArea) {
        this.rentalArea = rentalArea;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
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
        TbPmPayBillItemPmList other = (TbPmPayBillItemPmList) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
            && (this.getPmName() == null ? other.getPmName() == null : this.getPmName().equals(other.getPmName()))
            && (this.getRoomAddress() == null ? other.getRoomAddress() == null : this.getRoomAddress().equals(other.getRoomAddress()))
            && (this.getRentalArea() == null ? other.getRentalArea() == null : this.getRentalArea().equals(other.getRentalArea()))
            && (this.getTotalAmount() == null ? other.getTotalAmount() == null : this.getTotalAmount().equals(other.getTotalAmount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        result = prime * result + ((getPmName() == null) ? 0 : getPmName().hashCode());
        result = prime * result + ((getRoomAddress() == null) ? 0 : getRoomAddress().hashCode());
        result = prime * result + ((getRentalArea() == null) ? 0 : getRentalArea().hashCode());
        result = prime * result + ((getTotalAmount() == null) ? 0 : getTotalAmount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", itemId=").append(itemId);
        sb.append(", pmName=").append(pmName);
        sb.append(", roomAddress=").append(roomAddress);
        sb.append(", rentalArea=").append(rentalArea);
        sb.append(", totalAmount=").append(totalAmount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}