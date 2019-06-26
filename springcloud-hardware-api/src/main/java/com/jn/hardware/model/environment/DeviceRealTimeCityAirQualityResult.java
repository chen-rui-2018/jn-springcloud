package com.jn.hardware.model.environment;

import java.io.Serializable;

/**
 * 获取实时南京市平均空气质量
 *
 * @Author： cm
 * @Date： Created on 2019/6/22 15:26
 * @Version： v1.0
 * @Modified By:
 */
public class DeviceRealTimeCityAirQualityResult implements Serializable {

    private static final long serialVersionUID = -2523219313765383614L;
    /**
     * 状态标识，false:失败 true:成功
     */
    private String issuccess;
    /**
     * 状态描述
     */
    private String message;
    /**
     * 设备实时空气质量数值
     */
    private String data;
    /**
     * 设备id
     */
    private String deviceId;

    public String getIssuccess() {
        return issuccess;
    }

    public void setIssuccess(String issuccess) {
        this.issuccess = issuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public String toString() {
        return "DeviceRealTimeCityAirQualityResult{" +
                "issuccess='" + issuccess + '\'' +
                ", message='" + message + '\'' +
                ", data='" + data + '\'' +
                ", deviceId='" + deviceId + '\'' +
                '}';
    }
}
