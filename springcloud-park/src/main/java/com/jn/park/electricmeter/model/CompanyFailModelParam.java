package com.jn.park.electricmeter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author： yangh
 * @date： Created on 2019/6/22 12:16
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "CompanyFailModelParam",description = "计价失败的重试参数")
public class CompanyFailModelParam implements Serializable {
    @ApiModelProperty("企业id")
    private String companyId;
    @ApiModelProperty("处理日期")
    private Date day;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }
}
