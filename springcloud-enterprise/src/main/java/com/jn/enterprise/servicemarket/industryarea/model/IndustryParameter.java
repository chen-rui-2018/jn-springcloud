package com.jn.enterprise.servicemarket.industryarea.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 业务领域查询入参
 * @author： jiangyl
 * @date： Created on 2019/2/27 11:37
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "IndustryParameter",description = "业务领域查询入参")
public class IndustryParameter extends Page {

    @ApiModelProperty(value = "领域值")
    private String preValue;

    @ApiModelProperty(value = "行业id")
    private String id;

    public String getPreValue() {
        return preValue;
    }

    public void setPreValue(String preValue) {
        this.preValue = preValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
