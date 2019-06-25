package com.jn.hardware.environment.model;

import java.io.Serializable;
import java.util.concurrent.Future;

/**
 * 异步结果bean
 *
 * @Author： cm
 * @Date： Created on 2019/6/23 18:42
 * @Version： v1.0
 * @Modified By:
 */
public class EnvironmentMonitorAsyncResult implements Serializable {

    private static final long serialVersionUID = 5488531491863245353L;
    /**
     * 设备ID
     */
    private String deviceId;
    /**
     * 异步方法返回的对象值
     */
    private Future<String> asyncResult;
    /**
     * 异步结果值
     */
    private String result;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Future<String> getAsyncResult() {
        return asyncResult;
    }

    public void setAsyncResult(Future<String> asyncResult) {
        this.asyncResult = asyncResult;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "EnvironmentMonitorAsyncResult{" +
                "deviceId='" + deviceId + '\'' +
                ", asyncResult=" + asyncResult +
                ", result='" + result + '\'' +
                '}';
    }
}
