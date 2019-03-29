package com.jn.enterprise.technologyfinancial.investors.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/15 10:25
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "AffiliationUnitShow", description = "科技金融投资人认证查询所属单位出参")
public class AffiliationUnitShow implements Serializable {
    @ApiModelProperty(value = "所属单位id")
    private String orgId;
    @ApiModelProperty(value = "所属单位名称")
    private String orgName;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Override
    public String toString() {
        return "AffiliationUnitShow{" +
                "orgId='" + orgId + '\'' +
                ", orgName='" + orgName + '\'' +
                '}';
    }
}
