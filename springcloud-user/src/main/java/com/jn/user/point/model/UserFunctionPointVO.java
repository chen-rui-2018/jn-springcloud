package com.jn.user.point.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 用户功能模块积分细则
 * @author： jiangyl
 * @date： Created on 2019/4/3 19:08
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "UserFunctionPointVO",description = "用户功能模块积分细则")
public class UserFunctionPointVO implements Serializable {
    @ApiModelProperty(value = "用户账号",example = "wangsong")
    private String userAccount;
    @ApiModelProperty(value = "规则名称",example = "实名认证")
    private String ruleTypeName;
    @ApiModelProperty(value = "规则代码",example = "real_name")
    private String ruleTypeId;
    @ApiModelProperty(value = "积分周期单位[total/day/month/year]",example = "day")
    private String cycleUnit;
    @ApiModelProperty(value = "周期总次数",example = "5")
    private String cycleUnitNum;
    @ApiModelProperty(value = "周期完成次数",example = "2")
    private String ruleCompleteNum;

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getRuleTypeName() {
        return ruleTypeName;
    }

    public void setRuleTypeName(String ruleTypeName) {
        this.ruleTypeName = ruleTypeName;
    }

    public String getRuleTypeId() {
        return ruleTypeId;
    }

    public void setRuleTypeId(String ruleTypeId) {
        this.ruleTypeId = ruleTypeId;
    }

    public String getCycleUnit() {
        return cycleUnit;
    }

    public void setCycleUnit(String cycleUnit) {
        this.cycleUnit = cycleUnit;
    }

    public String getCycleUnitNum() {
        return cycleUnitNum;
    }

    public void setCycleUnitNum(String cycleUnitNum) {
        this.cycleUnitNum = cycleUnitNum;
    }

    public String getRuleCompleteNum() {
        return ruleCompleteNum;
    }

    public void setRuleCompleteNum(String ruleCompleteNum) {
        this.ruleCompleteNum = ruleCompleteNum;
    }

    @Override
    public String toString() {
        return "UserFunctionPointVO{" +
                "userAccount='" + userAccount + '\'' +
                ", ruleTypeName='" + ruleTypeName + '\'' +
                ", ruleTypeId='" + ruleTypeId + '\'' +
                ", cycleUnit='" + cycleUnit + '\'' +
                ", cycleUnitNum='" + cycleUnitNum + '\'' +
                ", ruleCompleteNum='" + ruleCompleteNum + '\'' +
                '}';
    }
}