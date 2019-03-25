package com.jn.park.sp.entity;

import java.io.Serializable;
import java.util.Date;

public class TbSpPower implements Serializable {
    /*@ApiModelProperty("")*/
    private String id;

    /*@ApiModelProperty("父节点ID，null代表根节点")*/
    private String parentId;

    /*@ApiModelProperty("父节点名称")*/
    private String parentName;

    /*@ApiModelProperty("权力名称")*/
    private String name;

    /*@ApiModelProperty("实施部门ID")*/
    private String departId;

    /*@ApiModelProperty("实施部门名称")*/
    private String departName;

    /*@ApiModelProperty("实施依据")*/
    private String settingBasis;

    /*@ApiModelProperty("权力类型（1行政许可）")*/
    private String type;

    /*@ApiModelProperty("权力编码")*/
    private String code;

    /*@ApiModelProperty("行使层级")*/
    private String level;

    /*@ApiModelProperty("权力来源")*/
    private String from;

    /*@ApiModelProperty("是否区权(1是，0否)")*/
    private Integer isArea;

    /*@ApiModelProperty("宁政发[2018]68号权限")*/
    private Integer isNingzhengfa;

    /*@ApiModelProperty("秦政发[2018]160号权限")*/
    private Integer isQinzhengfa;

    /*@ApiModelProperty("区编办拟下放权限")*/
    private Integer isQubianban;

    /*@ApiModelProperty("备注")*/
    private String notes;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Integer recordStatus;

    /*@ApiModelProperty("创建者账号")*/
    private String creatorAccount;

    /*@ApiModelProperty("创建时间")*/
    private Date createdTime;

    /*@ApiModelProperty("最新更新者账号")*/
    private String modifierAccount;

    /*@ApiModelProperty("最新更新时间")*/
    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName == null ? null : parentName.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId == null ? null : departId.trim();
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName == null ? null : departName.trim();
    }

    public String getSettingBasis() {
        return settingBasis;
    }

    public void setSettingBasis(String settingBasis) {
        this.settingBasis = settingBasis == null ? null : settingBasis.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from == null ? null : from.trim();
    }

    public Integer getIsArea() {
        return isArea;
    }

    public void setIsArea(Integer isArea) {
        this.isArea = isArea;
    }

    public Integer getIsNingzhengfa() {
        return isNingzhengfa;
    }

    public void setIsNingzhengfa(Integer isNingzhengfa) {
        this.isNingzhengfa = isNingzhengfa;
    }

    public Integer getIsQinzhengfa() {
        return isQinzhengfa;
    }

    public void setIsQinzhengfa(Integer isQinzhengfa) {
        this.isQinzhengfa = isQinzhengfa;
    }

    public Integer getIsQubianban() {
        return isQubianban;
    }

    public void setIsQubianban(Integer isQubianban) {
        this.isQubianban = isQubianban;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    public Integer getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Integer recordStatus) {
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
        TbSpPower other = (TbSpPower) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getParentName() == null ? other.getParentName() == null : this.getParentName().equals(other.getParentName()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getDepartId() == null ? other.getDepartId() == null : this.getDepartId().equals(other.getDepartId()))
            && (this.getDepartName() == null ? other.getDepartName() == null : this.getDepartName().equals(other.getDepartName()))
            && (this.getSettingBasis() == null ? other.getSettingBasis() == null : this.getSettingBasis().equals(other.getSettingBasis()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getFrom() == null ? other.getFrom() == null : this.getFrom().equals(other.getFrom()))
            && (this.getIsArea() == null ? other.getIsArea() == null : this.getIsArea().equals(other.getIsArea()))
            && (this.getIsNingzhengfa() == null ? other.getIsNingzhengfa() == null : this.getIsNingzhengfa().equals(other.getIsNingzhengfa()))
            && (this.getIsQinzhengfa() == null ? other.getIsQinzhengfa() == null : this.getIsQinzhengfa().equals(other.getIsQinzhengfa()))
            && (this.getIsQubianban() == null ? other.getIsQubianban() == null : this.getIsQubianban().equals(other.getIsQubianban()))
            && (this.getNotes() == null ? other.getNotes() == null : this.getNotes().equals(other.getNotes()))
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
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getParentName() == null) ? 0 : getParentName().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDepartId() == null) ? 0 : getDepartId().hashCode());
        result = prime * result + ((getDepartName() == null) ? 0 : getDepartName().hashCode());
        result = prime * result + ((getSettingBasis() == null) ? 0 : getSettingBasis().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getFrom() == null) ? 0 : getFrom().hashCode());
        result = prime * result + ((getIsArea() == null) ? 0 : getIsArea().hashCode());
        result = prime * result + ((getIsNingzhengfa() == null) ? 0 : getIsNingzhengfa().hashCode());
        result = prime * result + ((getIsQinzhengfa() == null) ? 0 : getIsQinzhengfa().hashCode());
        result = prime * result + ((getIsQubianban() == null) ? 0 : getIsQubianban().hashCode());
        result = prime * result + ((getNotes() == null) ? 0 : getNotes().hashCode());
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
        sb.append(", parentId=").append(parentId);
        sb.append(", parentName=").append(parentName);
        sb.append(", name=").append(name);
        sb.append(", departId=").append(departId);
        sb.append(", departName=").append(departName);
        sb.append(", settingBasis=").append(settingBasis);
        sb.append(", type=").append(type);
        sb.append(", code=").append(code);
        sb.append(", level=").append(level);
        sb.append(", from=").append(from);
        sb.append(", isArea=").append(isArea);
        sb.append(", isNingzhengfa=").append(isNingzhengfa);
        sb.append(", isQinzhengfa=").append(isQinzhengfa);
        sb.append(", isQubianban=").append(isQubianban);
        sb.append(", notes=").append(notes);
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