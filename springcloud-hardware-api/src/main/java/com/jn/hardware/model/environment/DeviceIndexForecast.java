package com.jn.hardware.model.environment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 设备未来72小时候预测值
 *
 * @Author： cm
 * @Date： Created on 2019/6/24 10:00
 * @Version： v1.0
 * @Modified By:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceIndexForecast implements Serializable {

    private static final long serialVersionUID = -4977167677406329017L;
    /**
     * pm10预测值
     */
    private String pm10;
    /**
     * pm2.5预测值
     */
    private String pm25;

    public String getPm10() {
        return pm10;
    }

    public void setPm10(String pm10) {
        this.pm10 = pm10;
    }

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    @Override
    public String toString() {
        return "DeviceIndexForecast{" +
                "pm10='" + pm10 + '\'' +
                ", pm25='" + pm25 + '\'' +
                '}';
    }
}
