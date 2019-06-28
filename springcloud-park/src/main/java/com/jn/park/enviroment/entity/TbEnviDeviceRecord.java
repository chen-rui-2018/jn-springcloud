package com.jn.park.enviroment.entity;

import java.io.Serializable;
import java.util.Date;

public class TbEnviDeviceRecord implements Serializable {
    /*@ApiModelProperty("id")*/
    private String id;

    /*@ApiModelProperty("日期时间")*/
    private Date dealDate;

    /*@ApiModelProperty("小时（0-23）")*/
    private Integer hour;

    /*@ApiModelProperty("设备id")*/
    private String deviceId;

    /*@ApiModelProperty("设备记录时间")*/
    private Date deviceRecordTime;

    /*@ApiModelProperty("湿度")*/
    private String hum;

    /*@ApiModelProperty("纬度")*/
    private String lat;

    /*@ApiModelProperty("亮度")*/
    private String light;

    /*@ApiModelProperty("经度")*/
    private String log;

    /*@ApiModelProperty("PM10（范围：0-2000）")*/
    private String pm10;

    /*@ApiModelProperty("PM2.5（范围：0-1000）")*/
    private String pm25;

    /*@ApiModelProperty("温度（范围：-40-125）")*/
    private String temper;

    /*@ApiModelProperty("远程ip")*/
    private String remoteIp;

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

    public Date getDealDate() {
        return dealDate;
    }

    public void setDealDate(Date dealDate) {
        this.dealDate = dealDate;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public Date getDeviceRecordTime() {
        return deviceRecordTime;
    }

    public void setDeviceRecordTime(Date deviceRecordTime) {
        this.deviceRecordTime = deviceRecordTime;
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum == null ? null : hum.trim();
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light == null ? null : light.trim();
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log == null ? null : log.trim();
    }

    public String getPm10() {
        return pm10;
    }

    public void setPm10(String pm10) {
        this.pm10 = pm10 == null ? null : pm10.trim();
    }

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25 == null ? null : pm25.trim();
    }

    public String getTemper() {
        return temper;
    }

    public void setTemper(String temper) {
        this.temper = temper == null ? null : temper.trim();
    }

    public String getRemoteIp() {
        return remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp == null ? null : remoteIp.trim();
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
        TbEnviDeviceRecord other = (TbEnviDeviceRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDealDate() == null ? other.getDealDate() == null : this.getDealDate().equals(other.getDealDate()))
            && (this.getHour() == null ? other.getHour() == null : this.getHour().equals(other.getHour()))
            && (this.getDeviceId() == null ? other.getDeviceId() == null : this.getDeviceId().equals(other.getDeviceId()))
            && (this.getDeviceRecordTime() == null ? other.getDeviceRecordTime() == null : this.getDeviceRecordTime().equals(other.getDeviceRecordTime()))
            && (this.getHum() == null ? other.getHum() == null : this.getHum().equals(other.getHum()))
            && (this.getLat() == null ? other.getLat() == null : this.getLat().equals(other.getLat()))
            && (this.getLight() == null ? other.getLight() == null : this.getLight().equals(other.getLight()))
            && (this.getLog() == null ? other.getLog() == null : this.getLog().equals(other.getLog()))
            && (this.getPm10() == null ? other.getPm10() == null : this.getPm10().equals(other.getPm10()))
            && (this.getPm25() == null ? other.getPm25() == null : this.getPm25().equals(other.getPm25()))
            && (this.getTemper() == null ? other.getTemper() == null : this.getTemper().equals(other.getTemper()))
            && (this.getRemoteIp() == null ? other.getRemoteIp() == null : this.getRemoteIp().equals(other.getRemoteIp()))
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
        result = prime * result + ((getDealDate() == null) ? 0 : getDealDate().hashCode());
        result = prime * result + ((getHour() == null) ? 0 : getHour().hashCode());
        result = prime * result + ((getDeviceId() == null) ? 0 : getDeviceId().hashCode());
        result = prime * result + ((getDeviceRecordTime() == null) ? 0 : getDeviceRecordTime().hashCode());
        result = prime * result + ((getHum() == null) ? 0 : getHum().hashCode());
        result = prime * result + ((getLat() == null) ? 0 : getLat().hashCode());
        result = prime * result + ((getLight() == null) ? 0 : getLight().hashCode());
        result = prime * result + ((getLog() == null) ? 0 : getLog().hashCode());
        result = prime * result + ((getPm10() == null) ? 0 : getPm10().hashCode());
        result = prime * result + ((getPm25() == null) ? 0 : getPm25().hashCode());
        result = prime * result + ((getTemper() == null) ? 0 : getTemper().hashCode());
        result = prime * result + ((getRemoteIp() == null) ? 0 : getRemoteIp().hashCode());
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
        sb.append(", dealDate=").append(dealDate);
        sb.append(", hour=").append(hour);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", deviceRecordTime=").append(deviceRecordTime);
        sb.append(", hum=").append(hum);
        sb.append(", lat=").append(lat);
        sb.append(", light=").append(light);
        sb.append(", log=").append(log);
        sb.append(", pm10=").append(pm10);
        sb.append(", pm25=").append(pm25);
        sb.append(", temper=").append(temper);
        sb.append(", remoteIp=").append(remoteIp);
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