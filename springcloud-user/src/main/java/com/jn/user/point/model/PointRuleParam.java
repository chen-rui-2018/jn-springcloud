package com.jn.user.point.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 规则查询条件
 * @author： jiangyl
 * @date： Created on 2019/4/3 16:55
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PointRuleParam",description = "规则查询条件")
public class PointRuleParam extends Page {

    @ApiModelProperty(value = "规则代码",example = "check_in")
    private String ruleCode;
    @ApiModelProperty(value = "规则名称",example = "用户签到")
    private String ruleName;
    @ApiModelProperty(value = "规则类型[1收入规则2支出规则]",example = "1")
    private String ruleType;

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }
}
