package com.jn.hardware.model.electricmeter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/24 20:59
 * @version： v1.0
 * @modified By:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "ElectricMeterWaterOrElectricShow",description = "类型为水表或电表数据采集的实体")
public class ElectricMeterWaterOrElectricShow implements Serializable {

    private static final long serialVersionUID = 3744377726890972323L;
    @ApiModelProperty(value = "关联建筑ID")
    private String  buildingId;
    @ApiModelProperty(value = "关联仪表ID")
    private String  deviceId;
    @ApiModelProperty(value = "累积用量")
    private String  readingEnd;
    @ApiModelProperty(value = "本条数据采集时间 时间格式 :yyyy-MM-dd HH:mm:ss")
    private String  timeEnd;

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

    public String getReadingEnd() {
        return readingEnd;
    }

    public void setReadingEnd(String readingEnd) {
        this.readingEnd = readingEnd;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Override
    public String toString() {
        return "ElectricMeterWaterOrElectricShow{" +
                "buildingId='" + buildingId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", readingEnd='" + readingEnd + '\'' +
                ", timeEnd='" + timeEnd + '\'' +
                '}';
    }
}
