package com.jn.park.enviroment.entity;

import java.io.Serializable;
import java.util.Date;

public class TbEnviDeviceRecordAvg implements Serializable {
    /*@ApiModelProperty("")*/
    private String id;

    /*@ApiModelProperty("账期")*/
    private Date dealDate;

    /*@ApiModelProperty("小时（0-23）")*/
    private Integer hour;

    /*@ApiModelProperty("湿度（范围：0-100)")*/
    private String hum;

    /*@ApiModelProperty("温度（范围：-40-125）摄氏度")*/
    private String temper;

    /*@ApiModelProperty("PM2.5（范围：0-1000)")*/
    private String pm25;

    /*@ApiModelProperty("PM10（范围：0-2000）")*/
    private String pm10;

    /*@ApiModelProperty("园区空气质量指数")*/
    private String parkAirQuality;

    /*@ApiModelProperty("园区空气质量等级")*/
    private String parkAirQualityLevel;

    /*@ApiModelProperty("市空气质量指数")*/
    private String cityAirQuality;

    /*@ApiModelProperty("市空气质量等级")*/
    private String cityAirQualityLevel;

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

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum == null ? null : hum.trim();
    }

    public String getTemper() {
        return temper;
    }

    public void setTemper(String temper) {
        this.temper = temper == null ? null : temper.trim();
    }

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25 == null ? null : pm25.trim();
    }

    public String getPm10() {
        return pm10;
    }

    public void setPm10(String pm10) {
        this.pm10 = pm10 == null ? null : pm10.trim();
    }

    public String getParkAirQuality() {
        return parkAirQuality;
    }

    public void setParkAirQuality(String parkAirQuality) {
        this.parkAirQuality = parkAirQuality == null ? null : parkAirQuality.trim();
    }

    public String getParkAirQualityLevel() {
        return parkAirQualityLevel;
    }

    public void setParkAirQualityLevel(String parkAirQualityLevel) {
        this.parkAirQualityLevel = parkAirQualityLevel == null ? null : parkAirQualityLevel.trim();
    }

    public String getCityAirQuality() {
        return cityAirQuality;
    }

    public void setCityAirQuality(String cityAirQuality) {
        this.cityAirQuality = cityAirQuality == null ? null : cityAirQuality.trim();
    }

    public String getCityAirQualityLevel() {
        return cityAirQualityLevel;
    }

    public void setCityAirQualityLevel(String cityAirQualityLevel) {
        this.cityAirQualityLevel = cityAirQualityLevel == null ? null : cityAirQualityLevel.trim();
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
        TbEnviDeviceRecordAvg other = (TbEnviDeviceRecordAvg) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDealDate() == null ? other.getDealDate() == null : this.getDealDate().equals(other.getDealDate()))
            && (this.getHour() == null ? other.getHour() == null : this.getHour().equals(other.getHour()))
            && (this.getHum() == null ? other.getHum() == null : this.getHum().equals(other.getHum()))
            && (this.getTemper() == null ? other.getTemper() == null : this.getTemper().equals(other.getTemper()))
            && (this.getPm25() == null ? other.getPm25() == null : this.getPm25().equals(other.getPm25()))
            && (this.getPm10() == null ? other.getPm10() == null : this.getPm10().equals(other.getPm10()))
            && (this.getParkAirQuality() == null ? other.getParkAirQuality() == null : this.getParkAirQuality().equals(other.getParkAirQuality()))
            && (this.getParkAirQualityLevel() == null ? other.getParkAirQualityLevel() == null : this.getParkAirQualityLevel().equals(other.getParkAirQualityLevel()))
            && (this.getCityAirQuality() == null ? other.getCityAirQuality() == null : this.getCityAirQuality().equals(other.getCityAirQuality()))
            && (this.getCityAirQualityLevel() == null ? other.getCityAirQualityLevel() == null : this.getCityAirQualityLevel().equals(other.getCityAirQualityLevel()))
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
        result = prime * result + ((getHum() == null) ? 0 : getHum().hashCode());
        result = prime * result + ((getTemper() == null) ? 0 : getTemper().hashCode());
        result = prime * result + ((getPm25() == null) ? 0 : getPm25().hashCode());
        result = prime * result + ((getPm10() == null) ? 0 : getPm10().hashCode());
        result = prime * result + ((getParkAirQuality() == null) ? 0 : getParkAirQuality().hashCode());
        result = prime * result + ((getParkAirQualityLevel() == null) ? 0 : getParkAirQualityLevel().hashCode());
        result = prime * result + ((getCityAirQuality() == null) ? 0 : getCityAirQuality().hashCode());
        result = prime * result + ((getCityAirQualityLevel() == null) ? 0 : getCityAirQualityLevel().hashCode());
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
        sb.append(", hum=").append(hum);
        sb.append(", temper=").append(temper);
        sb.append(", pm25=").append(pm25);
        sb.append(", pm10=").append(pm10);
        sb.append(", parkAirQuality=").append(parkAirQuality);
        sb.append(", parkAirQualityLevel=").append(parkAirQualityLevel);
        sb.append(", cityAirQuality=").append(cityAirQuality);
        sb.append(", cityAirQualityLevel=").append(cityAirQualityLevel);
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