package com.jn.park.electricmeter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： yangh
 * @date： Created on 2019/5/25 12:50
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PriceRuleParam",description = "计价规则参数bean")
public class PriceRuleParam  implements Serializable {

    @ApiModelProperty("记录Id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ApiModelProperty("计价规则Id")
    private String ruleId;

    @ApiModelProperty("企业id")
    private String companyId;

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
