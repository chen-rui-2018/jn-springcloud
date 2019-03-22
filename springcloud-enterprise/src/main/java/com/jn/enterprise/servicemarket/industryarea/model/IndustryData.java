package com.jn.enterprise.servicemarket.industryarea.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author： jiangyl
 * @date： Created on 2019/2/27 14:41
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "IndustryData",description = "业务领域参数")
public class IndustryData {
    @ApiModelProperty(value = "领域ID[新增时传空，修改时ID必传]")
    private String id;

    @ApiModelProperty(value = "领域值",required = true)
    @NotNull(message = "领域值不能为空")
    private String preValue;

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
}
