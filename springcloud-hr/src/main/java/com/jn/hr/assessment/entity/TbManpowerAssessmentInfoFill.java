package com.jn.hr.assessment.entity;

import java.io.Serializable;

public class TbManpowerAssessmentInfoFill implements Serializable {
    private String id;

    private String templateDetailId;

    private String templateId;

    private String jobNumber;

    private Integer assessmentScore;

    private String causeDeduction;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTemplateDetailId() {
        return templateDetailId;
    }

    public void setTemplateDetailId(String templateDetailId) {
        this.templateDetailId = templateDetailId == null ? null : templateDetailId.trim();
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId == null ? null : templateId.trim();
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber == null ? null : jobNumber.trim();
    }

    public Integer getAssessmentScore() {
        return assessmentScore;
    }

    public void setAssessmentScore(Integer assessmentScore) {
        this.assessmentScore = assessmentScore;
    }

    public String getCauseDeduction() {
        return causeDeduction;
    }

    public void setCauseDeduction(String causeDeduction) {
        this.causeDeduction = causeDeduction == null ? null : causeDeduction.trim();
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
        TbManpowerAssessmentInfoFill other = (TbManpowerAssessmentInfoFill) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTemplateDetailId() == null ? other.getTemplateDetailId() == null : this.getTemplateDetailId().equals(other.getTemplateDetailId()))
            && (this.getTemplateId() == null ? other.getTemplateId() == null : this.getTemplateId().equals(other.getTemplateId()))
            && (this.getJobNumber() == null ? other.getJobNumber() == null : this.getJobNumber().equals(other.getJobNumber()))
            && (this.getAssessmentScore() == null ? other.getAssessmentScore() == null : this.getAssessmentScore().equals(other.getAssessmentScore()))
            && (this.getCauseDeduction() == null ? other.getCauseDeduction() == null : this.getCauseDeduction().equals(other.getCauseDeduction()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTemplateDetailId() == null) ? 0 : getTemplateDetailId().hashCode());
        result = prime * result + ((getTemplateId() == null) ? 0 : getTemplateId().hashCode());
        result = prime * result + ((getJobNumber() == null) ? 0 : getJobNumber().hashCode());
        result = prime * result + ((getAssessmentScore() == null) ? 0 : getAssessmentScore().hashCode());
        result = prime * result + ((getCauseDeduction() == null) ? 0 : getCauseDeduction().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", templateDetailId=").append(templateDetailId);
        sb.append(", templateId=").append(templateId);
        sb.append(", jobNumber=").append(jobNumber);
        sb.append(", assessmentScore=").append(assessmentScore);
        sb.append(", causeDeduction=").append(causeDeduction);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}