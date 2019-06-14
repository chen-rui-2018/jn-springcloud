package com.jn.park.electricmeter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： yangh
 * @date： Created on 2019/5/25 12:45
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "MeterCompanyIdParam",description = "企业id")
public class MeterCompanyIdParam implements Serializable {
    @ApiModelProperty("企业记录Id")
    private String companyId;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
