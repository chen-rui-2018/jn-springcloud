package com.jn.hardware.model.security;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/5/16 19:44
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SecurityTokenShow",description = "海康监控token实体bean")
public class SecurityTokenShow implements Serializable {

    private static final long serialVersionUID = -8507856829156928718L;
    @ApiModelProperty(value = "海康监控的token")
    private String  token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "SecurityTokenShow{" +
                "token='" + token + '\'' +
                '}';
    }
}
