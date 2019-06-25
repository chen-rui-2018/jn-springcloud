package com.jn.enterprise.joinpark.org.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/6/24 11:50
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "PreferInfoShow", description = "客户偏好出参")
public class PreferInfoShow implements Serializable {
    @ApiModelProperty(value = "客户偏好类型")
    private int preType;
    @ApiModelProperty(value = "客户偏好类型-key")
    private String id;
    @ApiModelProperty(value = "客户偏好类型-value")
    private String preValue;

    public int getPreType() {
        return preType;
    }

    public void setPreType(int preType) {
        this.preType = preType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPreValue() {
        return preValue;
    }

    public void setPreValue(String preValue) {
        this.preValue = preValue;
    }

    @Override
    public String toString() {
        return "PreferInfoShow{" +
                "preType=" + preType +
                ", id='" + id + '\'' +
                ", preValue='" + preValue + '\'' +
                '}';
    }
}
