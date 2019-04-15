package com.jn.user.point.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 积分规则
 * @author： jiangyl
 * @date： Created on 2019/4/3 19:08
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PointRuleVO",description = "积分规则")
public class PointRuleVO implements Serializable {

    @ApiModelProperty(value = "规则ID",example = "aea8167ff8c24b28a24c900dcfad334b")
    private String ruleId;
    @ApiModelProperty(value = "规则代码",example = "check_in")
    private String ruleCode;
    @ApiModelProperty(value = "规则名称",example = "用户签到")
    private String ruleName;
    @ApiModelProperty(value = "积分数",example = "10.0")
    private Double integralNum;
    @ApiModelProperty(value = "积分周期[预留字段。前端固定传1，方便后续扩展为‘4周/1次’]",example = "1")
    private Integer integralCycle;
    @ApiModelProperty(value = "积分周期次数",example = "5")
    private Integer cycleUnitNum;
    @ApiModelProperty(value = "积分周期单位[total/day/month/year]",example = "day")
    private String cycleUnit;
    @ApiModelProperty(value = "积分周期是否有效[0无效1有效]",example = "1")
    private String cycleStatus;
    @ApiModelProperty(value = "规则类型[1收入规则2支出规则]",example = "1")
    private String ruleType;
    @ApiModelProperty(value = "规则是否有效[0无效1有效]",example = "1")
    private String isStatus;
    @ApiModelProperty(value = "抵扣总额",example = "10.0")
    private Double incomeTotal;
    @ApiModelProperty(value = "抵扣比例[百分比]",example = "10")
    private Double incomeScale;
    @ApiModelProperty(value = "创建时间 yyyy-MM-dd HH:mm:ss",example = "2019-04-03 10:00:00")
    private String createdTime;
    @ApiModelProperty(value = "创建人",example = "wangsong")
    private String creatorAccount;
    @ApiModelProperty(value = "修改时间 yyyy-MM-dd HH:mm:ss",example = "2019-04-04 10:00:00")
    private String modifiedTime;
    @ApiModelProperty(value = "修改人",example = "wangsong")
    private String modifierAccount;

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

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

    public Double getIntegralNum() {
        return integralNum;
    }

    public void setIntegralNum(Double integralNum) {
        this.integralNum = integralNum;
    }

    public Integer getIntegralCycle() {
        return integralCycle;
    }

    public void setIntegralCycle(Integer integralCycle) {
        this.integralCycle = integralCycle;
    }

    public Integer getCycleUnitNum() {
        return cycleUnitNum;
    }

    public void setCycleUnitNum(Integer cycleUnitNum) {
        this.cycleUnitNum = cycleUnitNum;
    }

    public String getCycleUnit() {
        return cycleUnit;
    }

    public void setCycleUnit(String cycleUnit) {
        this.cycleUnit = cycleUnit;
    }

    public String getCycleStatus() {
        return cycleStatus;
    }

    public void setCycleStatus(String cycleStatus) {
        this.cycleStatus = cycleStatus;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public String getIsStatus() {
        return isStatus;
    }

    public void setIsStatus(String isStatus) {
        this.isStatus = isStatus;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount;
    }

    public Double getIncomeTotal() {
        return incomeTotal;
    }

    public void setIncomeTotal(Double incomeTotal) {
        this.incomeTotal = incomeTotal;
    }

    public Double getIncomeScale() {
        return incomeScale;
    }

    public void setIncomeScale(Double incomeScale) {
        this.incomeScale = incomeScale;
    }

    @Override
    public String toString() {
        return "PointRuleVO{" +
                "ruleId='" + ruleId + '\'' +
                ", ruleCode='" + ruleCode + '\'' +
                ", ruleName='" + ruleName + '\'' +
                ", integralNum=" + integralNum +
                ", integralCycle=" + integralCycle +
                ", cycleUnitNum=" + cycleUnitNum +
                ", cycleUnit='" + cycleUnit + '\'' +
                ", cycleStatus='" + cycleStatus + '\'' +
                ", ruleType='" + ruleType + '\'' +
                ", isStatus='" + isStatus + '\'' +
                ", incomeTotal=" + incomeTotal +
                ", incomeScale=" + incomeScale +
                ", createdTime='" + createdTime + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", modifiedTime='" + modifiedTime + '\'' +
                ", modifierAccount='" + modifierAccount + '\'' +
                '}';
    }
}