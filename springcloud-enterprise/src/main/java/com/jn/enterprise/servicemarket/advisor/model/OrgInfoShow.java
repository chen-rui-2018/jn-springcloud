package com.jn.enterprise.servicemarket.advisor.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/4/9 10:17
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "OrgInfoShow",description = "机构信息出参")
public class OrgInfoShow implements Serializable {
    @ApiModelProperty(value = "机构id")
    private String orgId;
    @ApiModelProperty(value = "机构名称")
    private String orgName;
    @ApiModelProperty(value = "业务领域编码")
    private String businessArea;


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

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }


    @Override
    public String toString() {
        return "OrgInfoShow{" +
                "orgId='" + orgId + '\'' +
                ", orgName='" + orgName + '\'' +
                ", businessArea='" + businessArea + '\'' +
                '}';
    }
}
