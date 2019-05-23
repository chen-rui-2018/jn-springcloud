package com.jn.park.electricmeter.entity;

import java.io.Serializable;
import java.util.Date;

public class TbElectricEnergyControlRules implements Serializable {
    /*@ApiModelProperty("规则Id")*/
    private String id;

    /*@ApiModelProperty("规则名称")*/
    private String ruleName;

    /*@ApiModelProperty("规则描述")*/
    private String ruleDesc;

    /*@ApiModelProperty("预警模板")*/
    private String warningModel;

    /*@ApiModelProperty("监控对象（0：整个园区,2:分组设备，3：单个设备）")*/
    private Byte monitorObject;

    /*@ApiModelProperty("指标Id")*/
    private String targetId;

    /*@ApiModelProperty("阀值")*/
    private String threshold;

    /*@ApiModelProperty("操作符号（0：>=, 1：=<）")*/
    private Byte operation;

    /*@ApiModelProperty("当前值")*/
    private String nowValue;

    /*@ApiModelProperty("监控的单个设备/分组组号")*/
    private String monitorTarget;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Byte recordStatus;

    /*@ApiModelProperty("创建者账号")*/
    private String creatorAccount;

    /*@ApiModelProperty("创建时间")*/
    private Date createdTime;

    /*@ApiModelProperty("更新者账号")*/
    private String modifierAccount;

    /*@ApiModelProperty("更新时间")*/
    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public String getWarningModel() {
        return warningModel;
    }

    public void setWarningModel(String warningModel) {
        this.warningModel = warningModel == null ? null : warningModel.trim();
    }

    public Byte getMonitorObject() {
        return monitorObject;
    }

    public void setMonitorObject(Byte monitorObject) {
        this.monitorObject = monitorObject;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId == null ? null : targetId.trim();
    }

    public String getThreshold() {
        return threshold;
    }

    public void setThreshold(String threshold) {
        this.threshold = threshold == null ? null : threshold.trim();
    }

    public Byte getOperation() {
        return operation;
    }

    public void setOperation(Byte operation) {
        this.operation = operation;
    }

    public String getNowValue() {
        return nowValue;
    }

    public void setNowValue(String nowValue) {
        this.nowValue = nowValue == null ? null : nowValue.trim();
    }

    public String getMonitorTarget() {
        return monitorTarget;
    }

    public void setMonitorTarget(String monitorTarget) {
        this.monitorTarget = monitorTarget == null ? null : monitorTarget.trim();
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
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

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount == null ? null : modifierAccount.trim();
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
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
        TbElectricEnergyControlRules other = (TbElectricEnergyControlRules) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRuleName() == null ? other.getRuleName() == null : this.getRuleName().equals(other.getRuleName()))
            && (this.getRuleDesc() == null ? other.getRuleDesc() == null : this.getRuleDesc().equals(other.getRuleDesc()))
            && (this.getWarningModel() == null ? other.getWarningModel() == null : this.getWarningModel().equals(other.getWarningModel()))
            && (this.getMonitorObject() == null ? other.getMonitorObject() == null : this.getMonitorObject().equals(other.getMonitorObject()))
            && (this.getTargetId() == null ? other.getTargetId() == null : this.getTargetId().equals(other.getTargetId()))
            && (this.getThreshold() == null ? other.getThreshold() == null : this.getThreshold().equals(other.getThreshold()))
            && (this.getOperation() == null ? other.getOperation() == null : this.getOperation().equals(other.getOperation()))
            && (this.getNowValue() == null ? other.getNowValue() == null : this.getNowValue().equals(other.getNowValue()))
            && (this.getMonitorTarget() == null ? other.getMonitorTarget() == null : this.getMonitorTarget().equals(other.getMonitorTarget()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRuleName() == null) ? 0 : getRuleName().hashCode());
        result = prime * result + ((getRuleDesc() == null) ? 0 : getRuleDesc().hashCode());
        result = prime * result + ((getWarningModel() == null) ? 0 : getWarningModel().hashCode());
        result = prime * result + ((getMonitorObject() == null) ? 0 : getMonitorObject().hashCode());
        result = prime * result + ((getTargetId() == null) ? 0 : getTargetId().hashCode());
        result = prime * result + ((getThreshold() == null) ? 0 : getThreshold().hashCode());
        result = prime * result + ((getOperation() == null) ? 0 : getOperation().hashCode());
        result = prime * result + ((getNowValue() == null) ? 0 : getNowValue().hashCode());
        result = prime * result + ((getMonitorTarget() == null) ? 0 : getMonitorTarget().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", ruleName=").append(ruleName);
        sb.append(", ruleDesc=").append(ruleDesc);
        sb.append(", warningModel=").append(warningModel);
        sb.append(", monitorObject=").append(monitorObject);
        sb.append(", targetId=").append(targetId);
        sb.append(", threshold=").append(threshold);
        sb.append(", operation=").append(operation);
        sb.append(", nowValue=").append(nowValue);
        sb.append(", monitorTarget=").append(monitorTarget);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}