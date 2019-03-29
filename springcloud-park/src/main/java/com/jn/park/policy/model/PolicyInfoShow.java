package com.jn.park.policy.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/29 17:41
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "PolicyInfoShow",description = "系统中关联图解政策信息/关联政策原文信息")
public class PolicyInfoShow implements Serializable {
    @ApiModelProperty(value = "政策id")
    private String policyId;
    @ApiModelProperty(value = "政策标题")
    private String policyTitle;

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getPolicyTitle() {
        return policyTitle;
    }

    public void setPolicyTitle(String policyTitle) {
        this.policyTitle = policyTitle;
    }
}
