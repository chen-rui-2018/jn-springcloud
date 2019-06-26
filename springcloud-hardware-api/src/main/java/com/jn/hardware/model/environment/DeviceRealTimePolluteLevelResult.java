package com.jn.hardware.model.environment;

import java.io.Serializable;

/**
 * 获取实时设备污染级别
 * 市内污染指数平均值，污染级：只有污染级别，没有数值，且是设备(需求是指市内)
 *
 * @Author： cm
 * @Date： Created on 2019/6/22 15:33
 * @Version： v1.0
 * @Modified By:
 */
public class DeviceRealTimePolluteLevelResult implements Serializable {

    /**
     * 状态标识，false:失败 true:成功
     */
    private String issuccess;
    /**
     * 状态描述
     */
    private String message;
    /**
     * 污染级别（严重，重度，中度，轻度，良，优）
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
        return "DeviceRealTimePolluteLevelResult{" +
                "issuccess='" + issuccess + '\'' +
                ", message='" + message + '\'' +
                ", data='" + data + '\'' +
                ", deviceId='" + deviceId + '\'' +
                '}';
    }
}
