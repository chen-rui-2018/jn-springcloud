package com.jn.hardware.model.environment;

import java.io.Serializable;
import java.util.List;

/**
 * 环境监测：未来72小时候预测值，只能预测pm10，pm2.5
 *
 * @Author： cm
 * @Date： Created on 2019/6/24 9:52
 * @Version： v1.0
 * @Modified By:
 */
public class DeviceIndexForecastDataResult implements Serializable {
    private static final long serialVersionUID = -4305961547132358844L;
    /**
     * 请求成功标志
     */
    private String issuccess;
    /**
     * 请求返回的信息描述
     */
    private String message;
    /**
     * pm10和pm2.5的预测值
     */
    private List<DeviceIndexForecast> data;
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

    public List<DeviceIndexForecast> getData() {
        return data;
    }

    public void setData(List<DeviceIndexForecast> data) {
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
        return "DeviceIndexForecastDataResult{" +
                "issuccess='" + issuccess + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", deviceId='" + deviceId + '\'' +
                '}';
    }
}
