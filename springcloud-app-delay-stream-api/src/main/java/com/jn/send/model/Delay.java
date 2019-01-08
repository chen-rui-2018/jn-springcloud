package com.jn.send.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 延迟消息体
 *
 * @author： fengxh
 * @date： Created on 2019/1/3 18:16
 * @version： v1.0
 * @modified By:
 */
public class Delay implements Serializable {
    /**
     * 系统ID
     */
    @NotBlank(message = "系统ID不能为空")
    private String serviceId;
    /**
     * call back 的地址，
     * eg./api/system/getUser
     */
    @NotBlank(message = "回调连接不能为空")
    private String serviceUrl;
    /**
     * 触发call back的间隔，单位是毫秒，与下面的dateString二选一
     * 同时填写，那么ttl为第一优先级。
     */
    private String ttl;
    /**
     * 触发call back的时间日期，格式是yyyy-MM-dd HH:mm:ss，与上面的ttl二选一
     */
    private String dateString;
    /**
     * call back 的实体，需要转成jsong的字符
     */
    private String dataString;


    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public String getDataString() {
        return dataString;
    }

    public void setDataString(String dataString) {
        this.dataString = dataString;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }


    @Override
    public String toString() {
        return "Delay{" +
                "serviceId='" + serviceId + '\'' +
                ", serviceUrl='" + serviceUrl + '\'' +
                ", ttl='" + ttl + '\'' +
                ", dateString='" + dateString + '\'' +
                ", dataString='" + dataString + '\'' +
                '}';
    }
}
