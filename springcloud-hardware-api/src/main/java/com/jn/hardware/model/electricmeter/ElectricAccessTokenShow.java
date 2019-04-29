package com.jn.hardware.model.electricmeter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/23 17:25
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ElectricAccessTokenShow",description = "电表access_token获取实体")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ElectricAccessTokenShow implements Serializable {

    private static final long serialVersionUID = -2594237606397329975L;
    @ApiModelProperty(value = "获取到的access_token的值")
    private  String access_token;
    @ApiModelProperty(value = "获取到的access_token 有效时间,单位秒")
    private  String expires_in;


    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }



    @Override
    public String toString() {
        return "ElectricAccessTokenShow{" +
                "access_token='" + access_token + '\'' +
                ", expires_in='" + expires_in + '\'' +
                '}';
    }


}
