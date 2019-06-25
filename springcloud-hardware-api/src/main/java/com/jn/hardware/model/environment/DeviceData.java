package com.jn.hardware.model.environment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 环境监测设备属性值
 *
 * @Author： cm
 * @Date： Created on 2019/6/22 14:30
 * @Version： v1.0
 * @Modified By:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceData implements Serializable {
    private static final long serialVersionUID = 458779610888298869L;

    /**
     * 设备ID
     */
    @JsonProperty("DEV_ID")
    private String devId;
    /**
     * 湿度（范围：0-100）
     */
    @JsonProperty("HUM")
    private String hum;
    /**
     * 纬度
     */
    @JsonProperty("LAT")
    private String lat;
    /**
     * 亮度 11
     */
    @JsonProperty("LIGHT")
    private String light;
    /**
     * 经度
     */
    @JsonProperty("LOG")
    private String log;
    /**
     * PM10（范围：0-2000）
     */
    @JsonProperty("PM10")
    private String pm10;
    /**
     * PM2.5（范围：0-1000）
     */
    @JsonProperty("PM25")
    private String pm25;
    /**
     * 温度（范围：-40-125）
     */
    @JsonProperty("TEMPER")
    private String temper;
    /**
     * 数据上传时间
     */
    @JsonProperty("Time")
    private String time;

    @JsonProperty("REMOTEIP")
    private String remoteIp;

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getPm10() {
        return pm10;
    }

    public void setPm10(String pm10) {
        this.pm10 = pm10;
    }

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    public String getTemper() {
        return temper;
    }

    public void setTemper(String temper) {
        this.temper = temper;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRemoteIp() {
        return remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }

    @Override
    public String toString() {
        return "DeviceData{" +
                "devId='" + devId + '\'' +
                ", hum='" + hum + '\'' +
                ", lat='" + lat + '\'' +
                ", light='" + light + '\'' +
                ", log='" + log + '\'' +
                ", pm10='" + pm10 + '\'' +
                ", pm25='" + pm25 + '\'' +
                ", temper='" + temper + '\'' +
                ", time='" + time + '\'' +
                ", remoteIp='" + remoteIp + '\'' +
                '}';
    }
}
