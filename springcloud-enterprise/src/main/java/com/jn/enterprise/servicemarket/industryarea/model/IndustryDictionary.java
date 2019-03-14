package com.jn.enterprise.servicemarket.industryarea.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 机构数据字典
 * @author： jiangyl
 * @date： Created on 2019/3/1 15:31
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "IndustryDictionary",description = "机构数据字典")
public class IndustryDictionary {
    @ApiModelProperty(value = "领域ID")
    private String id;

    @ApiModelProperty(value = "领域值")
    private String preValue;

    @ApiModelProperty(value = "领域类型")
    private String preType;

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

    public String getPreType() {
        return preType;
    }

    public void setPreType(String preType) {
        this.preType = preType;
    }
}
