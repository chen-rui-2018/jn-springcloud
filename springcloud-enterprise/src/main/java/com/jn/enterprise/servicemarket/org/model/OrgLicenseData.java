package com.jn.enterprise.servicemarket.org.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 服务机构认证资质信息
 * @author： jiangyl
 * @date： Created on 2019/2/18 11:43
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OrgLicenseData",description = "服务机构认证资质信息")
public class OrgLicenseData implements Serializable {

    @ApiModelProperty(value = "机构ID",example = "e2ia03***",required = true)
    @NotNull(message = "机构ID不能为空")
    private String orgId;

    @ApiModelProperty(value = "一级业务领域[机构的一级业务领域。取企业字典表type=0的，即业务领域类型。数据从【服务超市-机构字典】接口获取(id)]"
            ,required = true,example = "ogistics"
            ,notes = "机构的一级业务领域。取企业字典表type=0的，即业务领域类型。数据从【服务超市-机构字典】接口获取(id)")
    @NotNull(message = "一级业务领域不能为空")
    private String businessType;

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

    public List<OrgLicense> getLicenses() {
        return licenses;
    }

    public void setLicenses(List<OrgLicense> licenses) {
        this.licenses = licenses;
    }
}
