package com.jn.enterprise.data.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： yangh
 * @date： Created on 2019/4/8 19:47
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "CompanyModel",description = "企业列表")
public class CompanyModel implements Serializable {
    @ApiModelProperty(value = "企业ID",example = "001")
    private String companyId;
    @ApiModelProperty(value = "企业名称",example = "xxx企业")
    private String company;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
