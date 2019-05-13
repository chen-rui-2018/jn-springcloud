package com.jn.system.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 数据字典keyValue实体
 *
 * @author： shaobao
 * @date： Created on 2019/1/25 16:59
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysDictKeyValue", description = "数据字典keyValue实体")
public class SysDictKeyValue implements Serializable {
    private static final long serialVersionUID = -2023039860330219992L;

    @ApiModelProperty(value = "数据字典键")
    private String key;
    @ApiModelProperty(value = "数据字典值")
    private String lable;

    public SysDictKeyValue() {
    }

    public SysDictKeyValue(String key, String lable) {
        this.key = key;
        this.lable = lable;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    @Override
    public String toString() {
        return "SysDictKeyValue{" +
                "key='" + key + '\'' +
                ", lable='" + lable + '\'' +
                '}';
    }
}
