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
@ApiModel(value = "PolicyClassShow",description = "政策分类出参")
public class PolicyClassShow implements Serializable {
    @ApiModelProperty(value = "政策分类编码")
    private String policyClassCode;
    @ApiModelProperty(value = "政策分类名称")
    private String policyClassName;

    public String getPolicyClassCode() {
        return policyClassCode;
    }

    public void setPolicyClassCode(String policyClassCode) {
        this.policyClassCode = policyClassCode;
    }

    public String getPolicyClassName() {
        return policyClassName;
    }

    public void setPolicyClassName(String policyClassName) {
        this.policyClassName = policyClassName;
    }
}
