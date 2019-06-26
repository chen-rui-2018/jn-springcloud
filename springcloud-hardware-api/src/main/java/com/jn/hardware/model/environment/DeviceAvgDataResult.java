package com.jn.hardware.model.environment;

import java.io.Serializable;
import java.util.List;

/**
 * 设备统计数据返回，主要返回每个设备监测到每个指标的平均值
 *
 * @Author： cm
 * @Date： Created on 2019/6/22 14:49
 * @Version： v1.0
 * @Modified By:
 */
public class DeviceAvgDataResult implements Serializable {
    private static final long serialVersionUID = -9136363990601378128L;

    /**
     * 设备的统计数据，每个指标的平均值
     */
    private List<DeviceAvgData> data;
    /**
     * 响应成功标识true:成功 false:失败
     */
    private String success;
    /**
     * 设备id
     */
    private String deviceId;
    /**
     * 状态描述
     */
    private String msg;

    public List<DeviceAvgData> getData() {
        return data;
    }

    public void setData(List<DeviceAvgData> data) {
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "DeviceAvgDataResult{" +
                "data=" + data +
                ", success='" + success + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
