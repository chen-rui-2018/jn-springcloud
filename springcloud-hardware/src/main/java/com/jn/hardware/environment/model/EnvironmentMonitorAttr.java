package com.jn.hardware.environment.model;

import java.io.Serializable;

/**
 * 环境监测设备属性
 * 记录每一个设备的seckey和deviceid
 * EnvironmentMonitorProperties中使用
 * @Author： cm
 * @Date： Created on 2019/6/22 16:03
 * @Version： v1.0
 * @Modified By:
 */
public class EnvironmentMonitorAttr implements Serializable {
    private static final long serialVersionUID = -5425139718278226056L;
    /**
     * 设备seckey，设备安全验证码
     */
    private String secKey;
    /**
     * 设备的ID
     */
    private String deviceId;

    public String getSecKey() {
        return secKey;
    }

    public void setSecKey(String secKey) {
        this.secKey = secKey;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public String toString() {
        return "EnvironmentMonitorAttr{" +
                "secKey='" + secKey + '\'' +
                ", deviceId='" + deviceId + '\'' +
                '}';
    }
}
