package com.jn.hr.assessment.entity;

import java.io.Serializable;

public class TbManpowerAssessmentTemplateDetail implements Serializable {
    private String id;

    private String targetCategory;

    private Integer serialNumber;

    private String assessmentTarget;

    private Integer score;

    private String scoreRubric;

    private String leadAssessmentDepartment;

    private String templateId;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTargetCategory() {
        return targetCategory;
    }

    public void setTargetCategory(String targetCategory) {
        this.targetCategory = targetCategory == null ? null : targetCategory.trim();
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getAssessmentTarget() {
        return assessmentTarget;
    }

    public void setAssessmentTarget(String assessmentTarget) {
        this.assessmentTarget = assessmentTarget == null ? null : assessmentTarget.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getScoreRubric() {
        return scoreRubric;
    }

    public void setScoreRubric(String scoreRubric) {
        this.scoreRubric = scoreRubric == null ? null : scoreRubric.trim();
    }

    public String getLeadAssessmentDepartment() {
        return leadAssessmentDepartment;
    }

    public void setLeadAssessmentDepartment(String leadAssessmentDepartment) {
        this.leadAssessmentDepartment = leadAssessmentDepartment == null ? null : leadAssessmentDepartment.trim();
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId == null ? null : templateId.trim();
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
        TbManpowerAssessmentTemplateDetail other = (TbManpowerAssessmentTemplateDetail) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTargetCategory() == null ? other.getTargetCategory() == null : this.getTargetCategory().equals(other.getTargetCategory()))
            && (this.getSerialNumber() == null ? other.getSerialNumber() == null : this.getSerialNumber().equals(other.getSerialNumber()))
            && (this.getAssessmentTarget() == null ? other.getAssessmentTarget() == null : this.getAssessmentTarget().equals(other.getAssessmentTarget()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getScoreRubric() == null ? other.getScoreRubric() == null : this.getScoreRubric().equals(other.getScoreRubric()))
            && (this.getLeadAssessmentDepartment() == null ? other.getLeadAssessmentDepartment() == null : this.getLeadAssessmentDepartment().equals(other.getLeadAssessmentDepartment()))
            && (this.getTemplateId() == null ? other.getTemplateId() == null : this.getTemplateId().equals(other.getTemplateId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTargetCategory() == null) ? 0 : getTargetCategory().hashCode());
        result = prime * result + ((getSerialNumber() == null) ? 0 : getSerialNumber().hashCode());
        result = prime * result + ((getAssessmentTarget() == null) ? 0 : getAssessmentTarget().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getScoreRubric() == null) ? 0 : getScoreRubric().hashCode());
        result = prime * result + ((getLeadAssessmentDepartment() == null) ? 0 : getLeadAssessmentDepartment().hashCode());
        result = prime * result + ((getTemplateId() == null) ? 0 : getTemplateId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", targetCategory=").append(targetCategory);
        sb.append(", serialNumber=").append(serialNumber);
        sb.append(", assessmentTarget=").append(assessmentTarget);
        sb.append(", score=").append(score);
        sb.append(", scoreRubric=").append(scoreRubric);
        sb.append(", leadAssessmentDepartment=").append(leadAssessmentDepartment);
        sb.append(", templateId=").append(templateId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}