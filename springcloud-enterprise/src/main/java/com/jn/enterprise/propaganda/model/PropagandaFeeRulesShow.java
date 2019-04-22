package com.jn.enterprise.propaganda.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/4/18 17:34
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "PropagandaFeeRulesShow", description = "企业宣传费用规则出参")
public class PropagandaFeeRulesShow implements Serializable {
    @ApiModelProperty(value = "宣传费用规则编码")
    private String proFeeRuleCode;
    @ApiModelProperty(value = "宣传费用规则详情")
    private String proFeeRuleDetails;
    @ApiModelProperty(value = "宣传费用")
    private String propagandaFee;

    public String getProFeeRuleCode() {
        return proFeeRuleCode;
    }

    public void setProFeeRuleCode(String proFeeRuleCode) {
        this.proFeeRuleCode = proFeeRuleCode;
    }

    public String getProFeeRuleDetails() {
        return proFeeRuleDetails;
    }

    public void setProFeeRuleDetails(String proFeeRuleDetails) {
        this.proFeeRuleDetails = proFeeRuleDetails;
    }

    public String getPropagandaFee() {
        return propagandaFee;
    }

    public void setPropagandaFee(String propagandaFee) {
        this.propagandaFee = propagandaFee;
    }

    @Override
    public String toString() {
        return "PropagandaFeeRulesShow{" +
                "proFeeRuleCode='" + proFeeRuleCode + '\'' +
                ", proFeeRuleDetails='" + proFeeRuleDetails + '\'' +
                ", propagandaFee=" + propagandaFee +
                '}';
    }
}
