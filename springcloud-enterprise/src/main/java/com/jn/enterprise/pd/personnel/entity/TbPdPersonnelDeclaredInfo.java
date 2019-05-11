package com.jn.enterprise.pd.personnel.entity;

import java.io.Serializable;
import java.util.Date;

public class TbPdPersonnelDeclaredInfo implements Serializable {
    /*@ApiModelProperty("唯一标识符（工单编号）")*/
    private Integer id;

    /*@ApiModelProperty("申报人姓名")*/
    private String declarerName;

    /*@ApiModelProperty("项目名称")*/
    private String projectName;

    /*@ApiModelProperty("产业领域ID")*/
    private String industrialFieldId;

    /*@ApiModelProperty("产业领域名称")*/
    private String industrialFieldName;

    /*@ApiModelProperty("身份证号")*/
    private String idNumber;

    /*@ApiModelProperty("毕业院校")*/
    private String graduateInstitutions;

    /*@ApiModelProperty("学历ID")*/
    private String educaId;

    /*@ApiModelProperty("学历名称")*/
    private String educaName;

    /*@ApiModelProperty("工作单位")*/
    private String workUnit;

    /*@ApiModelProperty("职务")*/
    private String business;

    /*@ApiModelProperty("是否有留学（1：是，2：否）")*/
    private Byte isOverseasStudy;

    /*@ApiModelProperty("是否有创业经历（1：是，2：否）")*/
    private Byte isEntrepreneurialExperience;

    /*@ApiModelProperty("是否注册落地（1：是，2：否）")*/
    private Byte isRegistrationLand;

    /*@ApiModelProperty("联系人")*/
    private String contactName;

    /*@ApiModelProperty("联系人电话")*/
    private String contactTelephone;

    /*@ApiModelProperty("项目简介")*/
    private String projectSynopsis;

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

    public String getDeclarerName() {
        return declarerName;
    }

    public void setDeclarerName(String declarerName) {
        this.declarerName = declarerName == null ? null : declarerName.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getIndustrialFieldId() {
        return industrialFieldId;
    }

    public void setIndustrialFieldId(String industrialFieldId) {
        this.industrialFieldId = industrialFieldId == null ? null : industrialFieldId.trim();
    }

    public String getIndustrialFieldName() {
        return industrialFieldName;
    }

    public void setIndustrialFieldName(String industrialFieldName) {
        this.industrialFieldName = industrialFieldName == null ? null : industrialFieldName.trim();
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    public String getGraduateInstitutions() {
        return graduateInstitutions;
    }

    public void setGraduateInstitutions(String graduateInstitutions) {
        this.graduateInstitutions = graduateInstitutions == null ? null : graduateInstitutions.trim();
    }

    public String getEducaId() {
        return educaId;
    }

    public void setEducaId(String educaId) {
        this.educaId = educaId == null ? null : educaId.trim();
    }

    public String getEducaName() {
        return educaName;
    }

    public void setEducaName(String educaName) {
        this.educaName = educaName == null ? null : educaName.trim();
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit == null ? null : workUnit.trim();
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business == null ? null : business.trim();
    }

    public Byte getIsOverseasStudy() {
        return isOverseasStudy;
    }

    public void setIsOverseasStudy(Byte isOverseasStudy) {
        this.isOverseasStudy = isOverseasStudy;
    }

    public Byte getIsEntrepreneurialExperience() {
        return isEntrepreneurialExperience;
    }

    public void setIsEntrepreneurialExperience(Byte isEntrepreneurialExperience) {
        this.isEntrepreneurialExperience = isEntrepreneurialExperience;
    }

    public Byte getIsRegistrationLand() {
        return isRegistrationLand;
    }

    public void setIsRegistrationLand(Byte isRegistrationLand) {
        this.isRegistrationLand = isRegistrationLand;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactTelephone() {
        return contactTelephone;
    }

    public void setContactTelephone(String contactTelephone) {
        this.contactTelephone = contactTelephone == null ? null : contactTelephone.trim();
    }

    public String getProjectSynopsis() {
        return projectSynopsis;
    }

    public void setProjectSynopsis(String projectSynopsis) {
        this.projectSynopsis = projectSynopsis == null ? null : projectSynopsis.trim();
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
        TbPdPersonnelDeclaredInfo other = (TbPdPersonnelDeclaredInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDeclarerName() == null ? other.getDeclarerName() == null : this.getDeclarerName().equals(other.getDeclarerName()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getIndustrialFieldId() == null ? other.getIndustrialFieldId() == null : this.getIndustrialFieldId().equals(other.getIndustrialFieldId()))
            && (this.getIndustrialFieldName() == null ? other.getIndustrialFieldName() == null : this.getIndustrialFieldName().equals(other.getIndustrialFieldName()))
            && (this.getIdNumber() == null ? other.getIdNumber() == null : this.getIdNumber().equals(other.getIdNumber()))
            && (this.getGraduateInstitutions() == null ? other.getGraduateInstitutions() == null : this.getGraduateInstitutions().equals(other.getGraduateInstitutions()))
            && (this.getEducaId() == null ? other.getEducaId() == null : this.getEducaId().equals(other.getEducaId()))
            && (this.getEducaName() == null ? other.getEducaName() == null : this.getEducaName().equals(other.getEducaName()))
            && (this.getWorkUnit() == null ? other.getWorkUnit() == null : this.getWorkUnit().equals(other.getWorkUnit()))
            && (this.getBusiness() == null ? other.getBusiness() == null : this.getBusiness().equals(other.getBusiness()))
            && (this.getIsOverseasStudy() == null ? other.getIsOverseasStudy() == null : this.getIsOverseasStudy().equals(other.getIsOverseasStudy()))
            && (this.getIsEntrepreneurialExperience() == null ? other.getIsEntrepreneurialExperience() == null : this.getIsEntrepreneurialExperience().equals(other.getIsEntrepreneurialExperience()))
            && (this.getIsRegistrationLand() == null ? other.getIsRegistrationLand() == null : this.getIsRegistrationLand().equals(other.getIsRegistrationLand()))
            && (this.getContactName() == null ? other.getContactName() == null : this.getContactName().equals(other.getContactName()))
            && (this.getContactTelephone() == null ? other.getContactTelephone() == null : this.getContactTelephone().equals(other.getContactTelephone()))
            && (this.getProjectSynopsis() == null ? other.getProjectSynopsis() == null : this.getProjectSynopsis().equals(other.getProjectSynopsis()))
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
        result = prime * result + ((getDeclarerName() == null) ? 0 : getDeclarerName().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getIndustrialFieldId() == null) ? 0 : getIndustrialFieldId().hashCode());
        result = prime * result + ((getIndustrialFieldName() == null) ? 0 : getIndustrialFieldName().hashCode());
        result = prime * result + ((getIdNumber() == null) ? 0 : getIdNumber().hashCode());
        result = prime * result + ((getGraduateInstitutions() == null) ? 0 : getGraduateInstitutions().hashCode());
        result = prime * result + ((getEducaId() == null) ? 0 : getEducaId().hashCode());
        result = prime * result + ((getEducaName() == null) ? 0 : getEducaName().hashCode());
        result = prime * result + ((getWorkUnit() == null) ? 0 : getWorkUnit().hashCode());
        result = prime * result + ((getBusiness() == null) ? 0 : getBusiness().hashCode());
        result = prime * result + ((getIsOverseasStudy() == null) ? 0 : getIsOverseasStudy().hashCode());
        result = prime * result + ((getIsEntrepreneurialExperience() == null) ? 0 : getIsEntrepreneurialExperience().hashCode());
        result = prime * result + ((getIsRegistrationLand() == null) ? 0 : getIsRegistrationLand().hashCode());
        result = prime * result + ((getContactName() == null) ? 0 : getContactName().hashCode());
        result = prime * result + ((getContactTelephone() == null) ? 0 : getContactTelephone().hashCode());
        result = prime * result + ((getProjectSynopsis() == null) ? 0 : getProjectSynopsis().hashCode());
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
        sb.append(", declarerName=").append(declarerName);
        sb.append(", projectName=").append(projectName);
        sb.append(", industrialFieldId=").append(industrialFieldId);
        sb.append(", industrialFieldName=").append(industrialFieldName);
        sb.append(", idNumber=").append(idNumber);
        sb.append(", graduateInstitutions=").append(graduateInstitutions);
        sb.append(", educaId=").append(educaId);
        sb.append(", educaName=").append(educaName);
        sb.append(", workUnit=").append(workUnit);
        sb.append(", business=").append(business);
        sb.append(", isOverseasStudy=").append(isOverseasStudy);
        sb.append(", isEntrepreneurialExperience=").append(isEntrepreneurialExperience);
        sb.append(", isRegistrationLand=").append(isRegistrationLand);
        sb.append(", contactName=").append(contactName);
        sb.append(", contactTelephone=").append(contactTelephone);
        sb.append(", projectSynopsis=").append(projectSynopsis);
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