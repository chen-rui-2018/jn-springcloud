package com.jn.system.dict.model;

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
    private String dictKey;
    @ApiModelProperty(value = "数据字典值")
    private String dictValue;

    public SysDictKeyValue() {
    }

    public SysDictKeyValue(String dictKey, String dictValue) {
        this.dictKey = dictKey;
        this.dictValue = dictValue;
    }

    public String getDictKey() {
        return dictKey;
    }

    public void setDictKey(String dictKey) {
        this.dictKey = dictKey;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    @Override
    public String toString() {
        return "SysDictKeyValue{" +
                "dictKey='" + dictKey + '\'' +
                ", dictValue='" + dictValue + '\'' +
                '}';
    }
}
