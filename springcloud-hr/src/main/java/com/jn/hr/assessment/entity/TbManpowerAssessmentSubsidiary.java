package com.jn.hr.assessment.entity;

import java.io.Serializable;

public class TbManpowerAssessmentSubsidiary implements Serializable {
    private String id;

    private String assessmentId;

    private String templateId;

    private String assessmentDepartment;

    private String assessmentName;

    private String name;

    private Byte assessmentStatus;

    private String assessmentJobNumber;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(String assessmentId) {
        this.assessmentId = assessmentId == null ? null : assessmentId.trim();
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId == null ? null : templateId.trim();
    }

    public String getAssessmentDepartment() {
        return assessmentDepartment;
    }

    public void setAssessmentDepartment(String assessmentDepartment) {
        this.assessmentDepartment = assessmentDepartment == null ? null : assessmentDepartment.trim();
    }

    public String getAssessmentName() {
        return assessmentName;
    }

    public void setAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName == null ? null : assessmentName.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getAssessmentStatus() {
        return assessmentStatus;
    }

    public void setAssessmentStatus(Byte assessmentStatus) {
        this.assessmentStatus = assessmentStatus;
    }

    public String getAssessmentJobNumber() {
        return assessmentJobNumber;
    }

    public void setAssessmentJobNumber(String assessmentJobNumber) {
        this.assessmentJobNumber = assessmentJobNumber == null ? null : assessmentJobNumber.trim();
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
        TbManpowerAssessmentSubsidiary other = (TbManpowerAssessmentSubsidiary) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAssessmentId() == null ? other.getAssessmentId() == null : this.getAssessmentId().equals(other.getAssessmentId()))
            && (this.getTemplateId() == null ? other.getTemplateId() == null : this.getTemplateId().equals(other.getTemplateId()))
            && (this.getAssessmentDepartment() == null ? other.getAssessmentDepartment() == null : this.getAssessmentDepartment().equals(other.getAssessmentDepartment()))
            && (this.getAssessmentName() == null ? other.getAssessmentName() == null : this.getAssessmentName().equals(other.getAssessmentName()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAssessmentStatus() == null ? other.getAssessmentStatus() == null : this.getAssessmentStatus().equals(other.getAssessmentStatus()))
            && (this.getAssessmentJobNumber() == null ? other.getAssessmentJobNumber() == null : this.getAssessmentJobNumber().equals(other.getAssessmentJobNumber()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAssessmentId() == null) ? 0 : getAssessmentId().hashCode());
        result = prime * result + ((getTemplateId() == null) ? 0 : getTemplateId().hashCode());
        result = prime * result + ((getAssessmentDepartment() == null) ? 0 : getAssessmentDepartment().hashCode());
        result = prime * result + ((getAssessmentName() == null) ? 0 : getAssessmentName().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAssessmentStatus() == null) ? 0 : getAssessmentStatus().hashCode());
        result = prime * result + ((getAssessmentJobNumber() == null) ? 0 : getAssessmentJobNumber().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", assessmentId=").append(assessmentId);
        sb.append(", templateId=").append(templateId);
        sb.append(", assessmentDepartment=").append(assessmentDepartment);
        sb.append(", assessmentName=").append(assessmentName);
        sb.append(", name=").append(name);
        sb.append(", assessmentStatus=").append(assessmentStatus);
        sb.append(", assessmentJobNumber=").append(assessmentJobNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}