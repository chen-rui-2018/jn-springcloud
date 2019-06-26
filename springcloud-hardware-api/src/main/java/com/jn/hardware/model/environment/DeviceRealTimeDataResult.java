package com.jn.hardware.model.environment;

import java.io.Serializable;
import java.util.List;

/**
 * 环境监测实时数据返回
 *
 * @Author： cm
 * @Date： Created on 2019/6/22 14:43
 * @Version： v1.0
 * @Modified By:
 */
public class DeviceRealTimeDataResult implements Serializable {

    private static final long serialVersionUID = 8745221767099320880L;

    /**
     * 设备实时数据
     */
    private List<DeviceData> data;
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

    public List<DeviceData> getData() {
        return data;
    }

    public void setData(List<DeviceData> data) {
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
        return "DeviceRealTimeDataResult{" +
                "data=" + data +
                ", success='" + success + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
