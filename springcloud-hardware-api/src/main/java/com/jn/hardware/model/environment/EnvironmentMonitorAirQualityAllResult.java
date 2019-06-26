package com.jn.hardware.model.environment;

import java.io.Serializable;
import java.util.List;

/**
 * 环境监测
 * 返回设备的实时空气质量、设备的实时污染级别、实时南京市平均空气质量
 *
 * @Author： cm
 * @Date： Created on 2019/6/23 23:00
 * @Version： v1.0
 * @Modified By:
 */
public class EnvironmentMonitorAirQualityAllResult implements Serializable {

    private static final long serialVersionUID = -8599801703155236481L;
    /**
     * 获取设备实时空气质量
     */
    private List<DeviceRealTimeAirQualityResult> deviceRealTimeAirQualityResults;
    /**
     * 获取实时南京市平均空气质量
     */
    private List<DeviceRealTimeCityAirQualityResult> deviceRealTimeCityAirQualityResults;
    /**
     * 获取实时设备污染级别
     */
    private List<DeviceRealTimePolluteLevelResult> deviceRealTimePolluteLevelResults;

    public List<DeviceRealTimeAirQualityResult> getDeviceRealTimeAirQualityResults() {
        return deviceRealTimeAirQualityResults;
    }

    public void setDeviceRealTimeAirQualityResults(List<DeviceRealTimeAirQualityResult> deviceRealTimeAirQualityResults) {
        this.deviceRealTimeAirQualityResults = deviceRealTimeAirQualityResults;
    }

    public List<DeviceRealTimeCityAirQualityResult> getDeviceRealTimeCityAirQualityResults() {
        return deviceRealTimeCityAirQualityResults;
    }

    public void setDeviceRealTimeCityAirQualityResults(List<DeviceRealTimeCityAirQualityResult> deviceRealTimeCityAirQualityResults) {
        this.deviceRealTimeCityAirQualityResults = deviceRealTimeCityAirQualityResults;
    }

    public List<DeviceRealTimePolluteLevelResult> getDeviceRealTimePolluteLevelResults() {
        return deviceRealTimePolluteLevelResults;
    }

    public void setDeviceRealTimePolluteLevelResults(List<DeviceRealTimePolluteLevelResult> deviceRealTimePolluteLevelResults) {
        this.deviceRealTimePolluteLevelResults = deviceRealTimePolluteLevelResults;
    }

    @Override
    public String toString() {
        return "EnvironmentMonitorAirQualityAllResult{" +
                "deviceRealTimeAirQualityResults=" + deviceRealTimeAirQualityResults +
                ", deviceRealTimeCityAirQualityResults=" + deviceRealTimeCityAirQualityResults +
                ", deviceRealTimePolluteLevelResults=" + deviceRealTimePolluteLevelResults +
                '}';
    }
}
