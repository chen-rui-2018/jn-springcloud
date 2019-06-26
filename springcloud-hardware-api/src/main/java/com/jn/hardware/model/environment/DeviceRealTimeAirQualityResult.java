package com.jn.hardware.model.environment;

import java.io.Serializable;

/**
 * 获取实时设备空气质量响应参数
 *
 * @Author： cm
 * @Date： Created on 2019/6/22 15:22
 * @Version： v1.0
 * @Modified By:
 */
public class DeviceRealTimeAirQualityResult implements Serializable {
    private static final long serialVersionUID = 7126554366772080819L;
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
     * 设备实时污染级别数值
     */
    private String levelData;

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

    public String getLevelData() {
        return levelData;
    }

    public void setLevelData(String levelData) {
        this.levelData = levelData;
    }

    @Override
    public String toString() {
        return "DeviceRealTimeAirQualityResult{" +
                "issuccess='" + issuccess + '\'' +
                ", message='" + message + '\'' +
                ", data='" + data + '\'' +
                ", levelData='" + levelData + '\'' +
                ", deviceId='" + deviceId + '\'' +
                '}';
    }
}
