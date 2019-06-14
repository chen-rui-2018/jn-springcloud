package com.jn.park.electricmeter.entity;

import java.io.Serializable;

public class VElectricRulesInfo implements Serializable {
    /*@ApiModelProperty("")*/
    private String monitorObject;

    /*@ApiModelProperty("")*/
    private String ruleName;

    /*@ApiModelProperty("")*/
    private String ruleDesc;

    /*@ApiModelProperty("")*/
    private String ruleShowValue;

    /*@ApiModelProperty("")*/
    private String monitorUserIds;

    /*@ApiModelProperty("")*/
    private String threshold;

    /*@ApiModelProperty("")*/
    private String operation;

    /*@ApiModelProperty("")*/
    private String typeCode;

    /*@ApiModelProperty("")*/
    private String val;

    private static final long serialVersionUID = 1L;

    public String getMonitorObject() {
        return monitorObject;
    }

    public void setMonitorObject(String monitorObject) {
        this.monitorObject = monitorObject == null ? null : monitorObject.trim();
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName == null ? null : ruleName.trim();
    }

    public String getRuleDesc() {
        return ruleDesc;
    }

    public void setRuleDesc(String ruleDesc) {
        this.ruleDesc = ruleDesc == null ? null : ruleDesc.trim();
    }

    public String getRuleShowValue() {
        return ruleShowValue;
    }

    public void setRuleShowValue(String ruleShowValue) {
        this.ruleShowValue = ruleShowValue == null ? null : ruleShowValue.trim();
    }

    public String getMonitorUserIds() {
        return monitorUserIds;
    }

    public void setMonitorUserIds(String monitorUserIds) {
        this.monitorUserIds = monitorUserIds == null ? null : monitorUserIds.trim();
    }

    public String getThreshold() {
        return threshold;
    }

    public void setThreshold(String threshold) {
        this.threshold = threshold == null ? null : threshold.trim();
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode == null ? null : typeCode.trim();
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val == null ? null : val.trim();
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
        VElectricRulesInfo other = (VElectricRulesInfo) that;
        return (this.getMonitorObject() == null ? other.getMonitorObject() == null : this.getMonitorObject().equals(other.getMonitorObject()))
            && (this.getRuleName() == null ? other.getRuleName() == null : this.getRuleName().equals(other.getRuleName()))
            && (this.getRuleDesc() == null ? other.getRuleDesc() == null : this.getRuleDesc().equals(other.getRuleDesc()))
            && (this.getRuleShowValue() == null ? other.getRuleShowValue() == null : this.getRuleShowValue().equals(other.getRuleShowValue()))
            && (this.getMonitorUserIds() == null ? other.getMonitorUserIds() == null : this.getMonitorUserIds().equals(other.getMonitorUserIds()))
            && (this.getThreshold() == null ? other.getThreshold() == null : this.getThreshold().equals(other.getThreshold()))
            && (this.getOperation() == null ? other.getOperation() == null : this.getOperation().equals(other.getOperation()))
            && (this.getTypeCode() == null ? other.getTypeCode() == null : this.getTypeCode().equals(other.getTypeCode()))
            && (this.getVal() == null ? other.getVal() == null : this.getVal().equals(other.getVal()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMonitorObject() == null) ? 0 : getMonitorObject().hashCode());
        result = prime * result + ((getRuleName() == null) ? 0 : getRuleName().hashCode());
        result = prime * result + ((getRuleDesc() == null) ? 0 : getRuleDesc().hashCode());
        result = prime * result + ((getRuleShowValue() == null) ? 0 : getRuleShowValue().hashCode());
        result = prime * result + ((getMonitorUserIds() == null) ? 0 : getMonitorUserIds().hashCode());
        result = prime * result + ((getThreshold() == null) ? 0 : getThreshold().hashCode());
        result = prime * result + ((getOperation() == null) ? 0 : getOperation().hashCode());
        result = prime * result + ((getTypeCode() == null) ? 0 : getTypeCode().hashCode());
        result = prime * result + ((getVal() == null) ? 0 : getVal().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", monitorObject=").append(monitorObject);
        sb.append(", ruleName=").append(ruleName);
        sb.append(", ruleDesc=").append(ruleDesc);
        sb.append(", ruleShowValue=").append(ruleShowValue);
        sb.append(", monitorUserIds=").append(monitorUserIds);
        sb.append(", threshold=").append(threshold);
        sb.append(", operation=").append(operation);
        sb.append(", typeCode=").append(typeCode);
        sb.append(", val=").append(val);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}