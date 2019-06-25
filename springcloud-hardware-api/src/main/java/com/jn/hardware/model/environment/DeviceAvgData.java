package com.jn.hardware.model.environment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 环境监测设备每个指标的平均值
 *
 * @Author： cm
 * @Date： Created on 2019/6/22 14:52
 * @Version： v1.0
 * @Modified By:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceAvgData implements Serializable {

    private static final long serialVersionUID = -4955158285404031427L;
    /**
     * 湿度平均值
     */
    @JsonProperty("HUM_avg")
    private String HUM_avg;
    /**
     * 统计数据条数
     */
    @JsonProperty("HUM_count")
    private String humCount;
    /**
     * 湿度最大值
     */
    @JsonProperty("HUM_max")
    private String humMax;
    /**
     * 湿度最小值
     */
    @JsonProperty("HUM_min")
    private String humMix;
    /**
     * 湿度总和
     */
    @JsonProperty("HUM_sum")
    private String humSum;
    /**
     * 亮度平均值
     */
    @JsonProperty("LIGHT_avg")
    private String lightAvg;
    /**
     * 亮度数据条数
     */
    @JsonProperty("LIGHT_count")
    private String lightCount;
    /**
     * 亮度最大值
     */
    @JsonProperty("LIGHT_max")
    private String lightMax;
    /**
     * 亮度最小值
     */
    @JsonProperty("LIGHT_min")
    private String lightMin;
    /**
     * 亮度总和
     */
    @JsonProperty("LIGHT_sum")
    private String lightSum;
    /**
     * PM10平均值
     */
    @JsonProperty("PM10_avg")
    private String pm10Avg;
    /**
     * PM10平均值
     */
    @JsonProperty("PM10_count")
    private String pm10Count;
    /**
     * PM10最大值
     */
    @JsonProperty("PM10_max")
    private String pm10Max;
    /**
     * PM10最小值
     */
    @JsonProperty("PM10_min")
    private String pm10Min;
    /**
     * PM10总和
     */
    @JsonProperty("PM10_sum")
    private String pm10Sum;
    /**
     * PM2.5平均值
     */
    @JsonProperty("PM25_avg")
    private String pm25Avg;
    /**
     * PM2.5数据条数
     */
    @JsonProperty("PM25_count")
    private String pm25Count;
    /**
     * PM2.5最大值
     */
    @JsonProperty("PM25_max")
    private String pm25Max;
    /**
     * PM2.5最小值
     */
    @JsonProperty("PM25_min")
    private String pm25Min;
    /**
     * PM2.5总和
     */
    @JsonProperty("PM25_sum")
    private String pm25Sum;
    /**
     * 温度平均值
     */
    @JsonProperty("TEMPER_avg")
    private String temperAvg;
    /**
     * 温度数据条数
     */
    @JsonProperty("TEMPER_count")
    private String temperCount;
    /**
     * 温度最大值
     */
    @JsonProperty("TEMPER_max")
    private String temperMax;
    /**
     * 温度最小值
     */
    @JsonProperty("TEMPER_min")
    private String temperMin;
    /**
     * 温度总和
     */
    @JsonProperty("TEMPER_sum")
    private String temperSum;
    /**
     * 统计时段起始点
     */
    private String time;

    public String getHUM_avg() {
        return HUM_avg;
    }

    public void setHUM_avg(String HUM_avg) {
        this.HUM_avg = HUM_avg;
    }

    public String getHumCount() {
        return humCount;
    }

    public void setHumCount(String humCount) {
        this.humCount = humCount;
    }

    public String getHumMax() {
        return humMax;
    }

    public void setHumMax(String humMax) {
        this.humMax = humMax;
    }

    public String getHumMix() {
        return humMix;
    }

    public void setHumMix(String humMix) {
        this.humMix = humMix;
    }

    public String getHumSum() {
        return humSum;
    }

    public void setHumSum(String humSum) {
        this.humSum = humSum;
    }

    public String getLightAvg() {
        return lightAvg;
    }

    public void setLightAvg(String lightAvg) {
        this.lightAvg = lightAvg;
    }

    public String getLightCount() {
        return lightCount;
    }

    public void setLightCount(String lightCount) {
        this.lightCount = lightCount;
    }

    public String getLightMax() {
        return lightMax;
    }

    public void setLightMax(String lightMax) {
        this.lightMax = lightMax;
    }

    public String getLightMin() {
        return lightMin;
    }

    public void setLightMin(String lightMin) {
        this.lightMin = lightMin;
    }

    public String getLightSum() {
        return lightSum;
    }

    public void setLightSum(String lightSum) {
        this.lightSum = lightSum;
    }

    public String getPm10Avg() {
        return pm10Avg;
    }

    public void setPm10Avg(String pm10Avg) {
        this.pm10Avg = pm10Avg;
    }

    public String getPm10Count() {
        return pm10Count;
    }

    public void setPm10Count(String pm10Count) {
        this.pm10Count = pm10Count;
    }

    public String getPm10Max() {
        return pm10Max;
    }

    public void setPm10Max(String pm10Max) {
        this.pm10Max = pm10Max;
    }

    public String getPm10Min() {
        return pm10Min;
    }

    public void setPm10Min(String pm10Min) {
        this.pm10Min = pm10Min;
    }

    public String getPm10Sum() {
        return pm10Sum;
    }

    public void setPm10Sum(String pm10Sum) {
        this.pm10Sum = pm10Sum;
    }

    public String getPm25Avg() {
        return pm25Avg;
    }

    public void setPm25Avg(String pm25Avg) {
        this.pm25Avg = pm25Avg;
    }

    public String getPm25Count() {
        return pm25Count;
    }

    public void setPm25Count(String pm25Count) {
        this.pm25Count = pm25Count;
    }

    public String getPm25Max() {
        return pm25Max;
    }

    public void setPm25Max(String pm25Max) {
        this.pm25Max = pm25Max;
    }

    public String getPm25Min() {
        return pm25Min;
    }

    public void setPm25Min(String pm25Min) {
        this.pm25Min = pm25Min;
    }

    public String getPm25Sum() {
        return pm25Sum;
    }

    public void setPm25Sum(String pm25Sum) {
        this.pm25Sum = pm25Sum;
    }

    public String getTemperAvg() {
        return temperAvg;
    }

    public void setTemperAvg(String temperAvg) {
        this.temperAvg = temperAvg;
    }

    public String getTemperCount() {
        return temperCount;
    }

    public void setTemperCount(String temperCount) {
        this.temperCount = temperCount;
    }

    public String getTemperMax() {
        return temperMax;
    }

    public void setTemperMax(String temperMax) {
        this.temperMax = temperMax;
    }

    public String getTemperMin() {
        return temperMin;
    }

    public void setTemperMin(String temperMin) {
        this.temperMin = temperMin;
    }

    public String getTemperSum() {
        return temperSum;
    }

    public void setTemperSum(String temperSum) {
        this.temperSum = temperSum;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "DeviceAvgData{" +
                "HUM_avg='" + HUM_avg + '\'' +
                ", humCount='" + humCount + '\'' +
                ", humMax='" + humMax + '\'' +
                ", humMix='" + humMix + '\'' +
                ", humSum='" + humSum + '\'' +
                ", lightAvg='" + lightAvg + '\'' +
                ", lightCount='" + lightCount + '\'' +
                ", lightMax='" + lightMax + '\'' +
                ", lightMin='" + lightMin + '\'' +
                ", lightSum='" + lightSum + '\'' +
                ", pm10Avg='" + pm10Avg + '\'' +
                ", pm10Count='" + pm10Count + '\'' +
                ", pm10Max='" + pm10Max + '\'' +
                ", pm10Min='" + pm10Min + '\'' +
                ", pm10Sum='" + pm10Sum + '\'' +
                ", pm25Avg='" + pm25Avg + '\'' +
                ", pm25Count='" + pm25Count + '\'' +
                ", pm25Max='" + pm25Max + '\'' +
                ", pm25Min='" + pm25Min + '\'' +
                ", pm25Sum='" + pm25Sum + '\'' +
                ", temperAvg='" + temperAvg + '\'' +
                ", temperCount='" + temperCount + '\'' +
                ", temperMax='" + temperMax + '\'' +
                ", temperMin='" + temperMin + '\'' +
                ", temperSum='" + temperSum + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
