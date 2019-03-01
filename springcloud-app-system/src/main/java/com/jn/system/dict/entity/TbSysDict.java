package com.jn.system.dict.entity;

import java.io.Serializable;
import java.util.Date;

public class TbSysDict implements Serializable {
    private String id;

    private String moduleCode;

    private String parentGroupCode;

    private String groupCode;

    private String dictKey;

    private String dictValue;

    private String dictDescribe;

    private Integer sort;

    private Byte recordStatus;

    private String creatorAccount;

    private Date createdTime;

    private String modifierAccount;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode == null ? null : moduleCode.trim();
    }

    public String getParentGroupCode() {
        return parentGroupCode;
    }

    public void setParentGroupCode(String parentGroupCode) {
        this.parentGroupCode = parentGroupCode == null ? null : parentGroupCode.trim();
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode == null ? null : groupCode.trim();
    }

    public String getDictKey() {
        return dictKey;
    }

    public void setDictKey(String dictKey) {
        this.dictKey = dictKey == null ? null : dictKey.trim();
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue == null ? null : dictValue.trim();
    }

    public String getDictDescribe() {
        return dictDescribe;
    }

    public void setDictDescribe(String dictDescribe) {
        this.dictDescribe = dictDescribe == null ? null : dictDescribe.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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
        TbSysDict other = (TbSysDict) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getModuleCode() == null ? other.getModuleCode() == null : this.getModuleCode().equals(other.getModuleCode()))
            && (this.getParentGroupCode() == null ? other.getParentGroupCode() == null : this.getParentGroupCode().equals(other.getParentGroupCode()))
            && (this.getGroupCode() == null ? other.getGroupCode() == null : this.getGroupCode().equals(other.getGroupCode()))
            && (this.getDictKey() == null ? other.getDictKey() == null : this.getDictKey().equals(other.getDictKey()))
            && (this.getDictValue() == null ? other.getDictValue() == null : this.getDictValue().equals(other.getDictValue()))
            && (this.getDictDescribe() == null ? other.getDictDescribe() == null : this.getDictDescribe().equals(other.getDictDescribe()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
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
        result = prime * result + ((getModuleCode() == null) ? 0 : getModuleCode().hashCode());
        result = prime * result + ((getParentGroupCode() == null) ? 0 : getParentGroupCode().hashCode());
        result = prime * result + ((getGroupCode() == null) ? 0 : getGroupCode().hashCode());
        result = prime * result + ((getDictKey() == null) ? 0 : getDictKey().hashCode());
        result = prime * result + ((getDictValue() == null) ? 0 : getDictValue().hashCode());
        result = prime * result + ((getDictDescribe() == null) ? 0 : getDictDescribe().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
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
        sb.append(", moduleCode=").append(moduleCode);
        sb.append(", parentGroupCode=").append(parentGroupCode);
        sb.append(", groupCode=").append(groupCode);
        sb.append(", dictKey=").append(dictKey);
        sb.append(", dictValue=").append(dictValue);
        sb.append(", dictDescribe=").append(dictDescribe);
        sb.append(", sort=").append(sort);
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