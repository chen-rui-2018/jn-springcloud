package com.jn.enterprise.model;

import java.io.Serializable;

/**
 * IBPS上传文件数据返回
 * @author： huxw
 * @date： Created on 2019-5-22 11:45:00
 * @version： v1.0
 * @modified By:
 */
public class IBPSUploadResult implements Serializable {

    // 返回数据
    private IBPSUploadData data;

    // 报错信息
    private String cause;

    // 请求返回状态码
    private String state;

    // 请求返回信息
    private String message;

    public IBPSUploadData getData() {
        return data;
    }

    public void setData(IBPSUploadData data) {
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
        return "IBPSUploadResult{" +
                "data=" + data +
                ", cause='" + cause + '\'' +
                ", state='" + state + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
