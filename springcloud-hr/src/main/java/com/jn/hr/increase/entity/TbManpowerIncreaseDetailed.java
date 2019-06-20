package com.jn.hr.increase.entity;

import java.io.Serializable;

public class TbManpowerIncreaseDetailed implements Serializable {
    private String id;

    private String insuredMonth;

    private String jobNumber;

    private String schemeId;

    private String schemeName;

    private String projectId;

    private Integer defaultCardinalNumber;

    private Integer corporateContributionRatio;

    private Integer individualContributionRatio;

    private Byte projectType;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getInsuredMonth() {
        return insuredMonth;
    }

    public void setInsuredMonth(String insuredMonth) {
        this.insuredMonth = insuredMonth == null ? null : insuredMonth.trim();
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber == null ? null : jobNumber.trim();
    }

    public String getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(String schemeId) {
        this.schemeId = schemeId == null ? null : schemeId.trim();
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName == null ? null : schemeName.trim();
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public Integer getDefaultCardinalNumber() {
        return defaultCardinalNumber;
    }

    public void setDefaultCardinalNumber(Integer defaultCardinalNumber) {
        this.defaultCardinalNumber = defaultCardinalNumber;
    }

    public Integer getCorporateContributionRatio() {
        return corporateContributionRatio;
    }

    public void setCorporateContributionRatio(Integer corporateContributionRatio) {
        this.corporateContributionRatio = corporateContributionRatio;
    }

    public Integer getIndividualContributionRatio() {
        return individualContributionRatio;
    }

    public void setIndividualContributionRatio(Integer individualContributionRatio) {
        this.individualContributionRatio = individualContributionRatio;
    }

    public Byte getProjectType() {
        return projectType;
    }

    public void setProjectType(Byte projectType) {
        this.projectType = projectType;
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
        TbManpowerIncreaseDetailed other = (TbManpowerIncreaseDetailed) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getInsuredMonth() == null ? other.getInsuredMonth() == null : this.getInsuredMonth().equals(other.getInsuredMonth()))
            && (this.getJobNumber() == null ? other.getJobNumber() == null : this.getJobNumber().equals(other.getJobNumber()))
            && (this.getSchemeId() == null ? other.getSchemeId() == null : this.getSchemeId().equals(other.getSchemeId()))
            && (this.getSchemeName() == null ? other.getSchemeName() == null : this.getSchemeName().equals(other.getSchemeName()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getDefaultCardinalNumber() == null ? other.getDefaultCardinalNumber() == null : this.getDefaultCardinalNumber().equals(other.getDefaultCardinalNumber()))
            && (this.getCorporateContributionRatio() == null ? other.getCorporateContributionRatio() == null : this.getCorporateContributionRatio().equals(other.getCorporateContributionRatio()))
            && (this.getIndividualContributionRatio() == null ? other.getIndividualContributionRatio() == null : this.getIndividualContributionRatio().equals(other.getIndividualContributionRatio()))
            && (this.getProjectType() == null ? other.getProjectType() == null : this.getProjectType().equals(other.getProjectType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getInsuredMonth() == null) ? 0 : getInsuredMonth().hashCode());
        result = prime * result + ((getJobNumber() == null) ? 0 : getJobNumber().hashCode());
        result = prime * result + ((getSchemeId() == null) ? 0 : getSchemeId().hashCode());
        result = prime * result + ((getSchemeName() == null) ? 0 : getSchemeName().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getDefaultCardinalNumber() == null) ? 0 : getDefaultCardinalNumber().hashCode());
        result = prime * result + ((getCorporateContributionRatio() == null) ? 0 : getCorporateContributionRatio().hashCode());
        result = prime * result + ((getIndividualContributionRatio() == null) ? 0 : getIndividualContributionRatio().hashCode());
        result = prime * result + ((getProjectType() == null) ? 0 : getProjectType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", insuredMonth=").append(insuredMonth);
        sb.append(", jobNumber=").append(jobNumber);
        sb.append(", schemeId=").append(schemeId);
        sb.append(", schemeName=").append(schemeName);
        sb.append(", projectId=").append(projectId);
        sb.append(", defaultCardinalNumber=").append(defaultCardinalNumber);
        sb.append(", corporateContributionRatio=").append(corporateContributionRatio);
        sb.append(", individualContributionRatio=").append(individualContributionRatio);
        sb.append(", projectType=").append(projectType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}