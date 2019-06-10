package com.jn.park.parking.entity;

import java.io.Serializable;
import java.util.Date;

public class TbParkingArea implements Serializable {
    /*@ApiModelProperty("停车场Id")*/
    private String areaId;

    /*@ApiModelProperty("停车场名称")*/
    private String areaName;

    /*@ApiModelProperty("停车场地址")*/
    private String areaAddress;

    /*@ApiModelProperty("经度")*/
    private String longitude;

    /*@ApiModelProperty("纬度")*/
    private String latitude;

    /*@ApiModelProperty("停车场空闲月租车位数")*/
    private Integer leisureNumber;

    /*@ApiModelProperty("已出租车位数")*/
    private Integer rentNumber;

    /*@ApiModelProperty("车位总数")*/
    private Integer parkingTotal;

    /*@ApiModelProperty("临时车价格描述")*/
    private String tempPriceDepict;

    /*@ApiModelProperty("临时车个数")*/
    private Integer tempNumber;

    /*@ApiModelProperty("临时车价格(单位:元)")*/
    private Double tempPrice;

    /*@ApiModelProperty("临时车计费周期(单位:分钟)")*/
    private String tempPriceUnit;

    /*@ApiModelProperty("临时车每天价格上限")*/
    private Double tempPriceTotal;

    /*@ApiModelProperty("临时车免费停车时间(单位:分钟)")*/
    private Integer tempFreeTime;

    /*@ApiModelProperty("租车位价格(单位:元/年)")*/
    private Double rentPrice;

    /*@ApiModelProperty("停车场图片")*/
    private String areaPicture;

    /*@ApiModelProperty("停车位分布图")*/
    private String spacePicture;

    /*@ApiModelProperty("道闸厂家名称")*/
    private String gateFactory;

    /*@ApiModelProperty("道闸ID")*/
    private String gateId;

    /*@ApiModelProperty("停车场状态 0无效1有效")*/
    private String areaStatus;

    /*@ApiModelProperty("创建者账号")*/
    private String creatorAccount;

    /*@ApiModelProperty("创建时间")*/
    private Date createdTime;

    /*@ApiModelProperty("最新更新者账号")*/
    private String modifierAccount;

    /*@ApiModelProperty("最新更新时间")*/
    private Date modifiedTime;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Byte recordStatus;

    private static final long serialVersionUID = 1L;

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public String getAreaAddress() {
        return areaAddress;
    }

    public void setAreaAddress(String areaAddress) {
        this.areaAddress = areaAddress == null ? null : areaAddress.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public Integer getLeisureNumber() {
        return leisureNumber;
    }

    public void setLeisureNumber(Integer leisureNumber) {
        this.leisureNumber = leisureNumber;
    }

    public Integer getRentNumber() {
        return rentNumber;
    }

    public void setRentNumber(Integer rentNumber) {
        this.rentNumber = rentNumber;
    }

    public Integer getParkingTotal() {
        return parkingTotal;
    }

    public void setParkingTotal(Integer parkingTotal) {
        this.parkingTotal = parkingTotal;
    }

    public String getTempPriceDepict() {
        return tempPriceDepict;
    }

    public void setTempPriceDepict(String tempPriceDepict) {
        this.tempPriceDepict = tempPriceDepict == null ? null : tempPriceDepict.trim();
    }

    public Integer getTempNumber() {
        return tempNumber;
    }

    public void setTempNumber(Integer tempNumber) {
        this.tempNumber = tempNumber;
    }

    public Double getTempPrice() {
        return tempPrice;
    }

    public void setTempPrice(Double tempPrice) {
        this.tempPrice = tempPrice;
    }

    public String getTempPriceUnit() {
        return tempPriceUnit;
    }

    public void setTempPriceUnit(String tempPriceUnit) {
        this.tempPriceUnit = tempPriceUnit == null ? null : tempPriceUnit.trim();
    }

    public Double getTempPriceTotal() {
        return tempPriceTotal;
    }

    public void setTempPriceTotal(Double tempPriceTotal) {
        this.tempPriceTotal = tempPriceTotal;
    }

    public Integer getTempFreeTime() {
        return tempFreeTime;
    }

    public void setTempFreeTime(Integer tempFreeTime) {
        this.tempFreeTime = tempFreeTime;
    }

    public Double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getAreaPicture() {
        return areaPicture;
    }

    public void setAreaPicture(String areaPicture) {
        this.areaPicture = areaPicture == null ? null : areaPicture.trim();
    }

    public String getSpacePicture() {
        return spacePicture;
    }

    public void setSpacePicture(String spacePicture) {
        this.spacePicture = spacePicture == null ? null : spacePicture.trim();
    }

    public String getGateFactory() {
        return gateFactory;
    }

    public void setGateFactory(String gateFactory) {
        this.gateFactory = gateFactory == null ? null : gateFactory.trim();
    }

    public String getGateId() {
        return gateId;
    }

    public void setGateId(String gateId) {
        this.gateId = gateId == null ? null : gateId.trim();
    }

    public String getAreaStatus() {
        return areaStatus;
    }

    public void setAreaStatus(String areaStatus) {
        this.areaStatus = areaStatus == null ? null : areaStatus.trim();
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

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
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
        TbParkingArea other = (TbParkingArea) that;
        return (this.getAreaId() == null ? other.getAreaId() == null : this.getAreaId().equals(other.getAreaId()))
            && (this.getAreaName() == null ? other.getAreaName() == null : this.getAreaName().equals(other.getAreaName()))
            && (this.getAreaAddress() == null ? other.getAreaAddress() == null : this.getAreaAddress().equals(other.getAreaAddress()))
            && (this.getLongitude() == null ? other.getLongitude() == null : this.getLongitude().equals(other.getLongitude()))
            && (this.getLatitude() == null ? other.getLatitude() == null : this.getLatitude().equals(other.getLatitude()))
            && (this.getLeisureNumber() == null ? other.getLeisureNumber() == null : this.getLeisureNumber().equals(other.getLeisureNumber()))
            && (this.getRentNumber() == null ? other.getRentNumber() == null : this.getRentNumber().equals(other.getRentNumber()))
            && (this.getParkingTotal() == null ? other.getParkingTotal() == null : this.getParkingTotal().equals(other.getParkingTotal()))
            && (this.getTempPriceDepict() == null ? other.getTempPriceDepict() == null : this.getTempPriceDepict().equals(other.getTempPriceDepict()))
            && (this.getTempNumber() == null ? other.getTempNumber() == null : this.getTempNumber().equals(other.getTempNumber()))
            && (this.getTempPrice() == null ? other.getTempPrice() == null : this.getTempPrice().equals(other.getTempPrice()))
            && (this.getTempPriceUnit() == null ? other.getTempPriceUnit() == null : this.getTempPriceUnit().equals(other.getTempPriceUnit()))
            && (this.getTempPriceTotal() == null ? other.getTempPriceTotal() == null : this.getTempPriceTotal().equals(other.getTempPriceTotal()))
            && (this.getTempFreeTime() == null ? other.getTempFreeTime() == null : this.getTempFreeTime().equals(other.getTempFreeTime()))
            && (this.getRentPrice() == null ? other.getRentPrice() == null : this.getRentPrice().equals(other.getRentPrice()))
            && (this.getAreaPicture() == null ? other.getAreaPicture() == null : this.getAreaPicture().equals(other.getAreaPicture()))
            && (this.getSpacePicture() == null ? other.getSpacePicture() == null : this.getSpacePicture().equals(other.getSpacePicture()))
            && (this.getGateFactory() == null ? other.getGateFactory() == null : this.getGateFactory().equals(other.getGateFactory()))
            && (this.getGateId() == null ? other.getGateId() == null : this.getGateId().equals(other.getGateId()))
            && (this.getAreaStatus() == null ? other.getAreaStatus() == null : this.getAreaStatus().equals(other.getAreaStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAreaId() == null) ? 0 : getAreaId().hashCode());
        result = prime * result + ((getAreaName() == null) ? 0 : getAreaName().hashCode());
        result = prime * result + ((getAreaAddress() == null) ? 0 : getAreaAddress().hashCode());
        result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());
        result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());
        result = prime * result + ((getLeisureNumber() == null) ? 0 : getLeisureNumber().hashCode());
        result = prime * result + ((getRentNumber() == null) ? 0 : getRentNumber().hashCode());
        result = prime * result + ((getParkingTotal() == null) ? 0 : getParkingTotal().hashCode());
        result = prime * result + ((getTempPriceDepict() == null) ? 0 : getTempPriceDepict().hashCode());
        result = prime * result + ((getTempNumber() == null) ? 0 : getTempNumber().hashCode());
        result = prime * result + ((getTempPrice() == null) ? 0 : getTempPrice().hashCode());
        result = prime * result + ((getTempPriceUnit() == null) ? 0 : getTempPriceUnit().hashCode());
        result = prime * result + ((getTempPriceTotal() == null) ? 0 : getTempPriceTotal().hashCode());
        result = prime * result + ((getTempFreeTime() == null) ? 0 : getTempFreeTime().hashCode());
        result = prime * result + ((getRentPrice() == null) ? 0 : getRentPrice().hashCode());
        result = prime * result + ((getAreaPicture() == null) ? 0 : getAreaPicture().hashCode());
        result = prime * result + ((getSpacePicture() == null) ? 0 : getSpacePicture().hashCode());
        result = prime * result + ((getGateFactory() == null) ? 0 : getGateFactory().hashCode());
        result = prime * result + ((getGateId() == null) ? 0 : getGateId().hashCode());
        result = prime * result + ((getAreaStatus() == null) ? 0 : getAreaStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", areaId=").append(areaId);
        sb.append(", areaName=").append(areaName);
        sb.append(", areaAddress=").append(areaAddress);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", leisureNumber=").append(leisureNumber);
        sb.append(", rentNumber=").append(rentNumber);
        sb.append(", parkingTotal=").append(parkingTotal);
        sb.append(", tempPriceDepict=").append(tempPriceDepict);
        sb.append(", tempNumber=").append(tempNumber);
        sb.append(", tempPrice=").append(tempPrice);
        sb.append(", tempPriceUnit=").append(tempPriceUnit);
        sb.append(", tempPriceTotal=").append(tempPriceTotal);
        sb.append(", tempFreeTime=").append(tempFreeTime);
        sb.append(", rentPrice=").append(rentPrice);
        sb.append(", areaPicture=").append(areaPicture);
        sb.append(", spacePicture=").append(spacePicture);
        sb.append(", gateFactory=").append(gateFactory);
        sb.append(", gateId=").append(gateId);
        sb.append(", areaStatus=").append(areaStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}