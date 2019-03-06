package com.jn.park.finance.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbFinanceIncomeMonth implements Serializable {
    /*@ApiModelProperty("费用月份")*/
    private String incomeDay;

    /*@ApiModelProperty("收入类型标识 0：电费 ；1：物业费；2：楼宇租；3：其他；4：合计")*/
    private String incomeType;

    /*@ApiModelProperty("收入类型名称")*/
    private Integer incomeTypename;

    /*@ApiModelProperty("收入金额")*/
    private BigDecimal income;

    /*@ApiModelProperty("是否删除0标记删除，1正常")*/
    private Byte recordStatus;

    /*@ApiModelProperty("创建者账号")*/
    private String creatorAccount;

    /*@ApiModelProperty("创建时间")*/
    private Date createdTime;

    /*@ApiModelProperty("最新更新者账号")*/
    private String modifierAccount;

    /*@ApiModelProperty("最新更新时间")*/
    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public String getIncomeDay() {
        return incomeDay;
    }

    public void setIncomeDay(String incomeDay) {
        this.incomeDay = incomeDay == null ? null : incomeDay.trim();
    }

    public String getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(String incomeType) {
        this.incomeType = incomeType == null ? null : incomeType.trim();
    }

    public Integer getIncomeTypename() {
        return incomeTypename;
    }

    public void setIncomeTypename(Integer incomeTypename) {
        this.incomeTypename = incomeTypename;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
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
        TbFinanceIncomeMonth other = (TbFinanceIncomeMonth) that;
        return (this.getIncomeDay() == null ? other.getIncomeDay() == null : this.getIncomeDay().equals(other.getIncomeDay()))
            && (this.getIncomeType() == null ? other.getIncomeType() == null : this.getIncomeType().equals(other.getIncomeType()))
            && (this.getIncomeTypename() == null ? other.getIncomeTypename() == null : this.getIncomeTypename().equals(other.getIncomeTypename()))
            && (this.getIncome() == null ? other.getIncome() == null : this.getIncome().equals(other.getIncome()))
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
        result = prime * result + ((getIncomeDay() == null) ? 0 : getIncomeDay().hashCode());
        result = prime * result + ((getIncomeType() == null) ? 0 : getIncomeType().hashCode());
        result = prime * result + ((getIncomeTypename() == null) ? 0 : getIncomeTypename().hashCode());
        result = prime * result + ((getIncome() == null) ? 0 : getIncome().hashCode());
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
        sb.append(", incomeDay=").append(incomeDay);
        sb.append(", incomeType=").append(incomeType);
        sb.append(", incomeTypename=").append(incomeTypename);
        sb.append(", income=").append(income);
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