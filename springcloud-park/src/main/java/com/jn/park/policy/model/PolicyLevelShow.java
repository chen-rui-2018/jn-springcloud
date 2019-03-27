package com.jn.park.policy.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/27 14:52
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "PolicyLevelShow",description = "政策级别出参")
public class PolicyLevelShow implements Serializable {
    @ApiModelProperty(value = "政策级别编码")
    private String policyLevelCode;
    @ApiModelProperty(value = "政策级别名称")
    private String policyLevelName;

    public String getPolicyLevelCode() {
        return policyLevelCode;
    }

    public void setPolicyLevelCode(String policyLevelCode) {
        this.policyLevelCode = policyLevelCode;
    }

    public String getPolicyLevelName() {
        return policyLevelName;
    }

    public void setPolicyLevelName(String policyLevelName) {
        this.policyLevelName = policyLevelName;
    }
}
