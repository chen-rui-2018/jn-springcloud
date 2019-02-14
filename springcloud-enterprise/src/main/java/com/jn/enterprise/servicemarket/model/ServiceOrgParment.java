package com.jn.enterprise.servicemarket.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 机构查询入参Bean
 * @author： jiangyl
 * @date： Created on 2019/2/13 14:42
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ServiceOrgParment",description = "机构查询入参")
public class ServiceOrgParment extends Page {

    @ApiModelProperty("一级业务领域")
    private String businessType;

    @ApiModelProperty("二级业务领域")
    private String businessSType;

    @ApiModelProperty("机构名称")
    private String orgName;

    @ApiModelProperty("主营业务")
    private String orgBusiness;

    @ApiModelProperty("排序字段")
    private String sort;

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessSType() {
        return businessSType;
    }

    public void setBusinessSType(String businessSType) {
        this.businessSType = businessSType;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgBusiness() {
        return orgBusiness;
    }

    public void setOrgBusiness(String orgBusiness) {
        this.orgBusiness = orgBusiness;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
