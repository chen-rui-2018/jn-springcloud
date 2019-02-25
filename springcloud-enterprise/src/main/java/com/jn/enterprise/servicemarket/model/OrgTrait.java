package com.jn.enterprise.servicemarket.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 服务机构特性值
 * @author： jiangyl
 * @date： Created on 2019/2/22 17:49
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OrgTrait",description = "服务机构特性值")
public class OrgTrait {
    @ApiModelProperty(value = "特性值ID")
    private String id;
    @ApiModelProperty(value = "机构ID")
    private String orgId;
    @ApiModelProperty(value = "机构特性类型（1业务擅长2行业领域3发展阶段4企业性质）")
    private String traitType;
    @ApiModelProperty(value = "机构特性值")
    private String traitValue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getTraitType() {
        return traitType;
    }

    public void setTraitType(String traitType) {
        this.traitType = traitType;
    }

    public String getTraitValue() {
        return traitValue;
    }

    public void setTraitValue(String traitValue) {
        this.traitValue = traitValue;
    }
}
