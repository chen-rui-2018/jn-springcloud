package com.jn.park.enviroment.entity;

import java.io.Serializable;
import java.util.Date;

public class TbEnviDeviceRecordAirQuality implements Serializable {
    /*@ApiModelProperty("")*/
    private String id;

    /*@ApiModelProperty("设备id")*/
    private String deviceId;

    /*@ApiModelProperty("状态标识，false:失败 true:成功")*/
    private String issuccess;

    /*@ApiModelProperty("状态描述")*/
    private String message;

    /*@ApiModelProperty("设备实时空气质量数值")*/
    private String airQuality;

    /*@ApiModelProperty("设备实时污染级别数值")*/
    private String leveldata;

    /*@ApiModelProperty("园区或则市内控制质量(1园区,2市内)")*/
    private String parkOrCity;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Byte recordStatus;

    /*@ApiModelProperty("创建者账号")*/
    private String creatorAccount;

    /*@ApiModelProperty("创建时间")*/
    private Date createdTime;

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

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getIssuccess() {
        return issuccess;
    }

    public void setIssuccess(String issuccess) {
        this.issuccess = issuccess == null ? null : issuccess.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getAirQuality() {
        return airQuality;
    }

    public void setAirQuality(String airQuality) {
        this.airQuality = airQuality == null ? null : airQuality.trim();
    }

    public String getLeveldata() {
        return leveldata;
    }

    public void setLeveldata(String leveldata) {
        this.leveldata = leveldata == null ? null : leveldata.trim();
    }

    public String getParkOrCity() {
        return parkOrCity;
    }

    public void setParkOrCity(String parkOrCity) {
        this.parkOrCity = parkOrCity == null ? null : parkOrCity.trim();
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
        TbEnviDeviceRecordAirQuality other = (TbEnviDeviceRecordAirQuality) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDeviceId() == null ? other.getDeviceId() == null : this.getDeviceId().equals(other.getDeviceId()))
            && (this.getIssuccess() == null ? other.getIssuccess() == null : this.getIssuccess().equals(other.getIssuccess()))
            && (this.getMessage() == null ? other.getMessage() == null : this.getMessage().equals(other.getMessage()))
            && (this.getAirQuality() == null ? other.getAirQuality() == null : this.getAirQuality().equals(other.getAirQuality()))
            && (this.getLeveldata() == null ? other.getLeveldata() == null : this.getLeveldata().equals(other.getLeveldata()))
            && (this.getParkOrCity() == null ? other.getParkOrCity() == null : this.getParkOrCity().equals(other.getParkOrCity()))
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
        result = prime * result + ((getDeviceId() == null) ? 0 : getDeviceId().hashCode());
        result = prime * result + ((getIssuccess() == null) ? 0 : getIssuccess().hashCode());
        result = prime * result + ((getMessage() == null) ? 0 : getMessage().hashCode());
        result = prime * result + ((getAirQuality() == null) ? 0 : getAirQuality().hashCode());
        result = prime * result + ((getLeveldata() == null) ? 0 : getLeveldata().hashCode());
        result = prime * result + ((getParkOrCity() == null) ? 0 : getParkOrCity().hashCode());
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
        sb.append(", deviceId=").append(deviceId);
        sb.append(", issuccess=").append(issuccess);
        sb.append(", message=").append(message);
        sb.append(", airQuality=").append(airQuality);
        sb.append(", leveldata=").append(leveldata);
        sb.append(", parkOrCity=").append(parkOrCity);
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