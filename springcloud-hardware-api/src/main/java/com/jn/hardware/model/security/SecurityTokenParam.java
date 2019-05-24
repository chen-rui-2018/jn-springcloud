package com.jn.hardware.model.security;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/5/16 20:23
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SecurityTokenParam",description = "海康威视获取token入参实体")
public class SecurityTokenParam implements Serializable {
    private static final long serialVersionUID = -3481029914130723805L;
    @ApiModelProperty(value = "登录用户的用户名。长度不能超过 64个字符",example = "admin")
    private String  userCode="admin";
    @ApiModelProperty(value = "综合安防管理平台 portl 门户地址,长度不能超过 255个字符",example = "http://192.168.30.2/portal/")
    private String service="http://192.168.30.2/vms/preview";
    @ApiModelProperty(value = "多语言key 值,格式支持：en_US、zh_CN 或者 en-US、zh-CN",example = "zh_CN")
    private String language="zh_CN";

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "SecurityTokenParam{" +
                "userCode='" + userCode + '\'' +
                ", service='" + service + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
