package com.jn.enterprise.servicemarket.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 服务机构认证资质信息
 * @author： jiangyl
 * @date： Created on 2019/2/18 11:43
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OrgLicenseData",description = "服务机构认证资质信息")
public class OrgLicenseData {

    @ApiModelProperty(value = "机构ID")
    private String orgId;

    @ApiModelProperty(value = "一级业务领域")
    private String businessType;

    @ApiModelProperty(value = "二级业务领域")
    private String businessSType;

    @ApiModelProperty(value = "机构资质集合")
    private List<OrgLicense> licenses;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

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

    public List<OrgLicense> getLicenses() {
        return licenses;
    }

    public void setLicenses(List<OrgLicense> licenses) {
        this.licenses = licenses;
    }
}
