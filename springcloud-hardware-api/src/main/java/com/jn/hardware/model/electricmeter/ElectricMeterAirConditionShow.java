package com.jn.hardware.model.electricmeter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/24 21:07
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ElectricMeterAirConditionShow",description = "数据采集空调表数据实体")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ElectricMeterAirConditionShow implements Serializable {

    private static final long serialVersionUID = -184612609912434976L;
    @ApiModelProperty(value = "关联建筑id")
        private String buildingId;
        @ApiModelProperty(value = "关联仪表id")
        private String deviceId;
        @ApiModelProperty(value = "瞬时流量")
        private String instantFlow;
        @ApiModelProperty(value = "瞬时流速")
        private String instantVelocity;
        @ApiModelProperty(value = "功率")
        private String power;
        @ApiModelProperty(value = "累积冷量")
        private String readingEndCool;
        @ApiModelProperty(value = "累积流量")
        private String readingEndFlow;
        @ApiModelProperty(value = "累积热量")
        private String readingEndHot;
        @ApiModelProperty(value = "回水温度")
        private String returnTemperature;
        @ApiModelProperty(value = "供水温度")
        private String supplyTemperature;
        @ApiModelProperty(value = "温差")
        private String temperatureDifference;
        @ApiModelProperty(value = "本条数据采集时间")
        private String timeEnd;

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getInstantFlow() {
        return instantFlow;
    }

    public void setInstantFlow(String instantFlow) {
        this.instantFlow = instantFlow;
    }

    public String getInstantVelocity() {
        return instantVelocity;
    }

    public void setInstantVelocity(String instantVelocity) {
        this.instantVelocity = instantVelocity;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getReadingEndCool() {
        return readingEndCool;
    }

    public void setReadingEndCool(String readingEndCool) {
        this.readingEndCool = readingEndCool;
    }

    public String getReadingEndFlow() {
        return readingEndFlow;
    }

    public void setReadingEndFlow(String readingEndFlow) {
        this.readingEndFlow = readingEndFlow;
    }

    public String getReadingEndHot() {
        return readingEndHot;
    }

    public void setReadingEndHot(String readingEndHot) {
        this.readingEndHot = readingEndHot;
    }

    public String getReturnTemperature() {
        return returnTemperature;
    }

    public void setReturnTemperature(String returnTemperature) {
        this.returnTemperature = returnTemperature;
    }

    public String getSupplyTemperature() {
        return supplyTemperature;
    }

    public void setSupplyTemperature(String supplyTemperature) {
        this.supplyTemperature = supplyTemperature;
    }

    public String getTemperatureDifference() {
        return temperatureDifference;
    }

    public void setTemperatureDifference(String temperatureDifference) {
        this.temperatureDifference = temperatureDifference;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Override
    public String toString() {
        return "ElectricMeterAirConditionShow{" +
                "buildingId='" + buildingId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", instantFlow='" + instantFlow + '\'' +
                ", instantVelocity='" + instantVelocity + '\'' +
                ", power='" + power + '\'' +
                ", readingEndCool='" + readingEndCool + '\'' +
                ", readingEndFlow='" + readingEndFlow + '\'' +
                ", readingEndHot='" + readingEndHot + '\'' +
                ", returnTemperature='" + returnTemperature + '\'' +
                ", supplyTemperature='" + supplyTemperature + '\'' +
                ", temperatureDifference='" + temperatureDifference + '\'' +
                ", timeEnd='" + timeEnd + '\'' +
                '}';
    }
}
