package com.jn.hardware.model.dingtalk;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 钉钉：响应基础参数
 *
 * @Author： cm
 * @Date： Created on 2019/6/15 15:39
 * @Version： v1.0
 * @Modified By:
 */
public class BaseResult implements Serializable {
    private static final long serialVersionUID = 8633830238197971781L;

    public static final String SUCCESS_CODE = "0";

    /**
     * 响应状态码
     */
    private String errcode;
    /**
     * 响应状态描述
     */
    private String errmsg;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

}
