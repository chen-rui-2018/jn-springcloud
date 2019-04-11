package com.jn.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 积分收入入参
 * @author： jiangyl
 * @date： Created on 2019/4/10 10:37
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PointIncomeParam",description = "积分收入入参")
public class PointIncomeParam implements Serializable {

    @ApiModelProperty(value = "用户账号",example = "wangsong",required = true)
    @NotNull(message = "用户账号不能为空")
    private String account;

    @ApiModelProperty(value = "积分规则代码[real_name:实名认证,published:发布动态,auth:企业认证,check_in:用户签到,order_pay:订单奖励,share:好友分享]",example = "wangsong",required = true)
    @NotNull(message = "积分规则代码不能为空")
    private String ruleCode;

    @ApiModelProperty(value = "业务逻辑标识(业务侧的主键标识，非必填)",example = "7ce873bfb44e467684024d569a44f32r")
    private String poingIncomeId;



    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public String getPoingIncomeId() {
        return poingIncomeId;
    }

    public void setPoingIncomeId(String poingIncomeId) {
        this.poingIncomeId = poingIncomeId;
    }
}
