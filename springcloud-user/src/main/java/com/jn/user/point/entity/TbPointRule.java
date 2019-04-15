package com.jn.user.point.entity;

import java.io.Serializable;
import java.util.Date;

public class TbPointRule implements Serializable {
    private String ruleId;

    private String ruleCode;

    private String ruleName;

    private Double integralNum;

    private Integer integralCycle;

    private Integer cycleUnitNum;

    private String cycleUnit;

    private String cycleStatus;

    private Double incomeTotal;

    private Double incomeScale;

    private String ruleType;

    private String isStatus;

    private String creatorAccount;

    private Date createdTime;

    private Date modifiedTime;

    private String modifierAccount;

    private Byte recordStatus;

    private static final long serialVersionUID = 1L;

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId == null ? null : ruleId.trim();
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode == null ? null : ruleCode.trim();
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName == null ? null : ruleName.trim();
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
        this.cycleUnit = cycleUnit == null ? null : cycleUnit.trim();
    }

    public String getCycleStatus() {
        return cycleStatus;
    }

    public void setCycleStatus(String cycleStatus) {
        this.cycleStatus = cycleStatus == null ? null : cycleStatus.trim();
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

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType == null ? null : ruleType.trim();
    }

    public String getIsStatus() {
        return isStatus;
    }

    public void setIsStatus(String isStatus) {
        this.isStatus = isStatus == null ? null : isStatus.trim();
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount == null ? null : creatorAccount.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount == null ? null : modifierAccount.trim();
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TbPointRule other = (TbPointRule) that;
        return (this.getRuleId() == null ? other.getRuleId() == null : this.getRuleId().equals(other.getRuleId()))
            && (this.getRuleCode() == null ? other.getRuleCode() == null : this.getRuleCode().equals(other.getRuleCode()))
            && (this.getRuleName() == null ? other.getRuleName() == null : this.getRuleName().equals(other.getRuleName()))
            && (this.getIntegralNum() == null ? other.getIntegralNum() == null : this.getIntegralNum().equals(other.getIntegralNum()))
            && (this.getIntegralCycle() == null ? other.getIntegralCycle() == null : this.getIntegralCycle().equals(other.getIntegralCycle()))
            && (this.getCycleUnitNum() == null ? other.getCycleUnitNum() == null : this.getCycleUnitNum().equals(other.getCycleUnitNum()))
            && (this.getCycleUnit() == null ? other.getCycleUnit() == null : this.getCycleUnit().equals(other.getCycleUnit()))
            && (this.getCycleStatus() == null ? other.getCycleStatus() == null : this.getCycleStatus().equals(other.getCycleStatus()))
            && (this.getIncomeTotal() == null ? other.getIncomeTotal() == null : this.getIncomeTotal().equals(other.getIncomeTotal()))
            && (this.getIncomeScale() == null ? other.getIncomeScale() == null : this.getIncomeScale().equals(other.getIncomeScale()))
            && (this.getRuleType() == null ? other.getRuleType() == null : this.getRuleType().equals(other.getRuleType()))
            && (this.getIsStatus() == null ? other.getIsStatus() == null : this.getIsStatus().equals(other.getIsStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRuleId() == null) ? 0 : getRuleId().hashCode());
        result = prime * result + ((getRuleCode() == null) ? 0 : getRuleCode().hashCode());
        result = prime * result + ((getRuleName() == null) ? 0 : getRuleName().hashCode());
        result = prime * result + ((getIntegralNum() == null) ? 0 : getIntegralNum().hashCode());
        result = prime * result + ((getIntegralCycle() == null) ? 0 : getIntegralCycle().hashCode());
        result = prime * result + ((getCycleUnitNum() == null) ? 0 : getCycleUnitNum().hashCode());
        result = prime * result + ((getCycleUnit() == null) ? 0 : getCycleUnit().hashCode());
        result = prime * result + ((getCycleStatus() == null) ? 0 : getCycleStatus().hashCode());
        result = prime * result + ((getIncomeTotal() == null) ? 0 : getIncomeTotal().hashCode());
        result = prime * result + ((getIncomeScale() == null) ? 0 : getIncomeScale().hashCode());
        result = prime * result + ((getRuleType() == null) ? 0 : getRuleType().hashCode());
        result = prime * result + ((getIsStatus() == null) ? 0 : getIsStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ruleId=").append(ruleId);
        sb.append(", ruleCode=").append(ruleCode);
        sb.append(", ruleName=").append(ruleName);
        sb.append(", integralNum=").append(integralNum);
        sb.append(", integralCycle=").append(integralCycle);
        sb.append(", cycleUnitNum=").append(cycleUnitNum);
        sb.append(", cycleUnit=").append(cycleUnit);
        sb.append(", cycleStatus=").append(cycleStatus);
        sb.append(", incomeTotal=").append(incomeTotal);
        sb.append(", incomeScale=").append(incomeScale);
        sb.append(", ruleType=").append(ruleType);
        sb.append(", isStatus=").append(isStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}