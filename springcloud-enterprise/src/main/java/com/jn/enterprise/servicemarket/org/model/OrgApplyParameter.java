package com.jn.enterprise.servicemarket.org.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 服务机构申请查询入参
 * @author： jiangyl
 * @date： Created on 2019/2/21 15:52
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OrgApplyParameter",description = "服务机构申请查询入参")
public class OrgApplyParameter extends Page{

    @ApiModelProperty(value = "审核状态[0未审核1审核通过2审核不通过]")
    private String orgStatus;

    @ApiModelProperty(value = "机构名称")
    private String orgName;

    public String getOrgStatus() {
        return orgStatus;
    }

    public void setOrgStatus(String orgStatus) {
        this.orgStatus = orgStatus;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}
