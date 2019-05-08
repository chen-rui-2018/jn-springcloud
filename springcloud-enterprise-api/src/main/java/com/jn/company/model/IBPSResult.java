package com.jn.company.model;

import java.io.Serializable;

/**
 * 启动IBPS数据返回
 * @author： huxw
 * @date： Created on 2019-5-7 15:54:37
 * @version： v1.0
 * @modified By:
 */
public class IBPSResult implements Serializable {

    // 流程实例ID
    private String data;

    // 报错信息
    private String cause;

    // 请求返回状态码
    private String state;

    // 请求返回信息
    private String message;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
