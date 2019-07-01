package com.jn.user.model;

import java.io.Serializable;

/**
 * 密码规则返回
 * @author： huxw
 * @date： Created on 2019-7-1 11:33:52
 * @version： v1.0
 * @modified By:
 */
public class SecurityInfoResult implements Serializable {

    // 流程实例ID
    private Object data;

    // 报错信息
    private String cause;

    // 请求返回状态码
    private String state;

    // 请求返回信息
    private String message;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
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

    @Override
    public String toString() {
        return "IBPSResult{" +
                "data=" + data +
                ", cause='" + cause + '\'' +
                ", state='" + state + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
