package com.jn.enterprise.pd.personnel.entity;

import java.io.Serializable;
import java.util.Date;

public class TbPdPersonnelQualificationsHonours implements Serializable {
    /*@ApiModelProperty("唯一标识符")*/
    private Integer id;

    /*@ApiModelProperty("资质荣誉名称")*/
    private String qualificationsHonoursName;

    /*@ApiModelProperty("特色标签")*/
    private String featuredLabels;

    /*@ApiModelProperty("颁发时间")*/
    private String issueTime;

    /*@ApiModelProperty("主管部门")*/
    private String competentDepartment;

    /*@ApiModelProperty("附件")*/
    private String enclosureUrl;

    /*@ApiModelProperty("项目ID")*/
    private Integer projectId;

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

    public String getQualificationsHonoursName() {
        return qualificationsHonoursName;
    }

    public void setQualificationsHonoursName(String qualificationsHonoursName) {
        this.qualificationsHonoursName = qualificationsHonoursName == null ? null : qualificationsHonoursName.trim();
    }

    public String getFeaturedLabels() {
        return featuredLabels;
    }

    public void setFeaturedLabels(String featuredLabels) {
        this.featuredLabels = featuredLabels == null ? null : featuredLabels.trim();
    }

    public String getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(String issueTime) {
        this.issueTime = issueTime == null ? null : issueTime.trim();
    }

    public String getCompetentDepartment() {
        return competentDepartment;
    }

    public void setCompetentDepartment(String competentDepartment) {
        this.competentDepartment = competentDepartment == null ? null : competentDepartment.trim();
    }

    public String getEnclosureUrl() {
        return enclosureUrl;
    }

    public void setEnclosureUrl(String enclosureUrl) {
        this.enclosureUrl = enclosureUrl == null ? null : enclosureUrl.trim();
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
        TbPdPersonnelQualificationsHonours other = (TbPdPersonnelQualificationsHonours) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getQualificationsHonoursName() == null ? other.getQualificationsHonoursName() == null : this.getQualificationsHonoursName().equals(other.getQualificationsHonoursName()))
            && (this.getFeaturedLabels() == null ? other.getFeaturedLabels() == null : this.getFeaturedLabels().equals(other.getFeaturedLabels()))
            && (this.getIssueTime() == null ? other.getIssueTime() == null : this.getIssueTime().equals(other.getIssueTime()))
            && (this.getCompetentDepartment() == null ? other.getCompetentDepartment() == null : this.getCompetentDepartment().equals(other.getCompetentDepartment()))
            && (this.getEnclosureUrl() == null ? other.getEnclosureUrl() == null : this.getEnclosureUrl().equals(other.getEnclosureUrl()))
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
        result = prime * result + ((getQualificationsHonoursName() == null) ? 0 : getQualificationsHonoursName().hashCode());
        result = prime * result + ((getFeaturedLabels() == null) ? 0 : getFeaturedLabels().hashCode());
        result = prime * result + ((getIssueTime() == null) ? 0 : getIssueTime().hashCode());
        result = prime * result + ((getCompetentDepartment() == null) ? 0 : getCompetentDepartment().hashCode());
        result = prime * result + ((getEnclosureUrl() == null) ? 0 : getEnclosureUrl().hashCode());
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
        sb.append(", qualificationsHonoursName=").append(qualificationsHonoursName);
        sb.append(", featuredLabels=").append(featuredLabels);
        sb.append(", issueTime=").append(issueTime);
        sb.append(", competentDepartment=").append(competentDepartment);
        sb.append(", enclosureUrl=").append(enclosureUrl);
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