package com.jn.enterprise.servicemarket.org.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/6/11 19:13
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "IndustryTypeShow",description = "客户偏好-行业领域/发展阶段出参")
public class IndustryTypeShow implements Serializable {
    @ApiModelProperty(value = "行业领域id/发展阶段id")
    private String orgTraitId;
    @ApiModelProperty(value = "行业领域名称/发展阶段名称")
    private String orgTraitName;

    public String getOrgTraitId() {
        return orgTraitId;
    }

    public void setOrgTraitId(String orgTraitId) {
        this.orgTraitId = orgTraitId;
    }

    public String getOrgTraitName() {
        return orgTraitName;
    }

    public void setOrgTraitName(String orgTraitName) {
        this.orgTraitName = orgTraitName;
    }

    @Override
    public String toString() {
        return "IndustryTypeShow{" +
                "orgTraitId='" + orgTraitId + '\'' +
                ", orgTraitName='" + orgTraitName + '\'' +
                '}';
    }
}
