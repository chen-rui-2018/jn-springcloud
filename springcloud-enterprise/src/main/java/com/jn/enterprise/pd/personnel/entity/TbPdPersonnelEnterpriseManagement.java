package com.jn.enterprise.pd.personnel.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbPdPersonnelEnterpriseManagement implements Serializable {
    /*@ApiModelProperty("唯一标识符")*/
    private Integer id;

    /*@ApiModelProperty("月份")*/
    private String month;

    /*@ApiModelProperty("营业收入")*/
    private BigDecimal businessIncome;

    /*@ApiModelProperty("企业研发投入")*/
    private BigDecimal enterpriseInvestment;

    /*@ApiModelProperty("人工成本")*/
    private BigDecimal laborCost;

    /*@ApiModelProperty("企业人数")*/
    private BigDecimal numberEnterprises;

    /*@ApiModelProperty("项目ID")*/
    private Integer projectId;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    public BigDecimal getBusinessIncome() {
        return businessIncome;
    }

    public void setBusinessIncome(BigDecimal businessIncome) {
        this.businessIncome = businessIncome;
    }

    public BigDecimal getEnterpriseInvestment() {
        return enterpriseInvestment;
    }

    public void setEnterpriseInvestment(BigDecimal enterpriseInvestment) {
        this.enterpriseInvestment = enterpriseInvestment;
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }

    public BigDecimal getNumberEnterprises() {
        return numberEnterprises;
    }

    public void setNumberEnterprises(BigDecimal numberEnterprises) {
        this.numberEnterprises = numberEnterprises;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
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
        TbPdPersonnelEnterpriseManagement other = (TbPdPersonnelEnterpriseManagement) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMonth() == null ? other.getMonth() == null : this.getMonth().equals(other.getMonth()))
            && (this.getBusinessIncome() == null ? other.getBusinessIncome() == null : this.getBusinessIncome().equals(other.getBusinessIncome()))
            && (this.getEnterpriseInvestment() == null ? other.getEnterpriseInvestment() == null : this.getEnterpriseInvestment().equals(other.getEnterpriseInvestment()))
            && (this.getLaborCost() == null ? other.getLaborCost() == null : this.getLaborCost().equals(other.getLaborCost()))
            && (this.getNumberEnterprises() == null ? other.getNumberEnterprises() == null : this.getNumberEnterprises().equals(other.getNumberEnterprises()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
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
        result = prime * result + ((getMonth() == null) ? 0 : getMonth().hashCode());
        result = prime * result + ((getBusinessIncome() == null) ? 0 : getBusinessIncome().hashCode());
        result = prime * result + ((getEnterpriseInvestment() == null) ? 0 : getEnterpriseInvestment().hashCode());
        result = prime * result + ((getLaborCost() == null) ? 0 : getLaborCost().hashCode());
        result = prime * result + ((getNumberEnterprises() == null) ? 0 : getNumberEnterprises().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
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
        sb.append(", month=").append(month);
        sb.append(", businessIncome=").append(businessIncome);
        sb.append(", enterpriseInvestment=").append(enterpriseInvestment);
        sb.append(", laborCost=").append(laborCost);
        sb.append(", numberEnterprises=").append(numberEnterprises);
        sb.append(", projectId=").append(projectId);
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