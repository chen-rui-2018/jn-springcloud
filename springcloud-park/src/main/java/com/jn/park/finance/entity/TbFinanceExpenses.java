package com.jn.park.finance.entity;

import java.io.Serializable;
import java.util.Date;

public class TbFinanceExpenses implements Serializable {
    /*@ApiModelProperty("主键")*/
    private Integer id;

    /*@ApiModelProperty("费用发生时间")*/
    private Date costHappendTime;

    /*@ApiModelProperty("打标前费用类型")*/
    private Integer costBeforeTypeId;

    /*@ApiModelProperty("打标前费用类型名称")*/
    private String costBeforeTypeName;

    /*@ApiModelProperty("打标后费用类型")*/
    private Integer costAfterTypeId;

    /*@ApiModelProperty("打标后费用类型名称")*/
    private String costAfterTypeName;

    /*@ApiModelProperty("费用发生部门")*/
    private String departmentId;

    /*@ApiModelProperty("部门名称")*/
    private String departmentName;

    /*@ApiModelProperty("")*/
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

    public Date getCostHappendTime() {
        return costHappendTime;
    }

    public void setCostHappendTime(Date costHappendTime) {
        this.costHappendTime = costHappendTime;
    }

    public Integer getCostBeforeTypeId() {
        return costBeforeTypeId;
    }

    public void setCostBeforeTypeId(Integer costBeforeTypeId) {
        this.costBeforeTypeId = costBeforeTypeId;
    }

    public String getCostBeforeTypeName() {
        return costBeforeTypeName;
    }

    public void setCostBeforeTypeName(String costBeforeTypeName) {
        this.costBeforeTypeName = costBeforeTypeName == null ? null : costBeforeTypeName.trim();
    }

    public Integer getCostAfterTypeId() {
        return costAfterTypeId;
    }

    public void setCostAfterTypeId(Integer costAfterTypeId) {
        this.costAfterTypeId = costAfterTypeId;
    }

    public String getCostAfterTypeName() {
        return costAfterTypeName;
    }

    public void setCostAfterTypeName(String costAfterTypeName) {
        this.costAfterTypeName = costAfterTypeName == null ? null : costAfterTypeName.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
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
        TbFinanceExpenses other = (TbFinanceExpenses) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCostHappendTime() == null ? other.getCostHappendTime() == null : this.getCostHappendTime().equals(other.getCostHappendTime()))
            && (this.getCostBeforeTypeId() == null ? other.getCostBeforeTypeId() == null : this.getCostBeforeTypeId().equals(other.getCostBeforeTypeId()))
            && (this.getCostBeforeTypeName() == null ? other.getCostBeforeTypeName() == null : this.getCostBeforeTypeName().equals(other.getCostBeforeTypeName()))
            && (this.getCostAfterTypeId() == null ? other.getCostAfterTypeId() == null : this.getCostAfterTypeId().equals(other.getCostAfterTypeId()))
            && (this.getCostAfterTypeName() == null ? other.getCostAfterTypeName() == null : this.getCostAfterTypeName().equals(other.getCostAfterTypeName()))
            && (this.getDepartmentId() == null ? other.getDepartmentId() == null : this.getDepartmentId().equals(other.getDepartmentId()))
            && (this.getDepartmentName() == null ? other.getDepartmentName() == null : this.getDepartmentName().equals(other.getDepartmentName()))
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
        result = prime * result + ((getCostHappendTime() == null) ? 0 : getCostHappendTime().hashCode());
        result = prime * result + ((getCostBeforeTypeId() == null) ? 0 : getCostBeforeTypeId().hashCode());
        result = prime * result + ((getCostBeforeTypeName() == null) ? 0 : getCostBeforeTypeName().hashCode());
        result = prime * result + ((getCostAfterTypeId() == null) ? 0 : getCostAfterTypeId().hashCode());
        result = prime * result + ((getCostAfterTypeName() == null) ? 0 : getCostAfterTypeName().hashCode());
        result = prime * result + ((getDepartmentId() == null) ? 0 : getDepartmentId().hashCode());
        result = prime * result + ((getDepartmentName() == null) ? 0 : getDepartmentName().hashCode());
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
        sb.append(", costHappendTime=").append(costHappendTime);
        sb.append(", costBeforeTypeId=").append(costBeforeTypeId);
        sb.append(", costBeforeTypeName=").append(costBeforeTypeName);
        sb.append(", costAfterTypeId=").append(costAfterTypeId);
        sb.append(", costAfterTypeName=").append(costAfterTypeName);
        sb.append(", departmentId=").append(departmentId);
        sb.append(", departmentName=").append(departmentName);
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