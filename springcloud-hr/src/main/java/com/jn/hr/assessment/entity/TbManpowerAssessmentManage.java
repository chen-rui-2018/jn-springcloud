package com.jn.hr.assessment.entity;

import java.io.Serializable;
import java.util.Date;

public class TbManpowerAssessmentManage implements Serializable {
    private String id;

    private String assessmentId;

    private String assessmentName;

    private Date assessmentStartTime;

    private Date assessmentEndTime;

    private String assessmentObject;

    private String assessmentPeople;

    private Byte status;

    private String templateId;

    private String templateName;

    private Byte recordStatus;

    private String assessmentJobNumber;

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

    public String getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(String assessmentId) {
        this.assessmentId = assessmentId == null ? null : assessmentId.trim();
    }

    public String getAssessmentName() {
        return assessmentName;
    }

    public void setAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName == null ? null : assessmentName.trim();
    }

    public Date getAssessmentStartTime() {
        return assessmentStartTime;
    }

    public void setAssessmentStartTime(Date assessmentStartTime) {
        this.assessmentStartTime = assessmentStartTime;
    }

    public Date getAssessmentEndTime() {
        return assessmentEndTime;
    }

    public void setAssessmentEndTime(Date assessmentEndTime) {
        this.assessmentEndTime = assessmentEndTime;
    }

    public String getAssessmentObject() {
        return assessmentObject;
    }

    public void setAssessmentObject(String assessmentObject) {
        this.assessmentObject = assessmentObject == null ? null : assessmentObject.trim();
    }

    public String getAssessmentPeople() {
        return assessmentPeople;
    }

    public void setAssessmentPeople(String assessmentPeople) {
        this.assessmentPeople = assessmentPeople == null ? null : assessmentPeople.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId == null ? null : templateId.trim();
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName == null ? null : templateName.trim();
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getAssessmentJobNumber() {
        return assessmentJobNumber;
    }

    public void setAssessmentJobNumber(String assessmentJobNumber) {
        this.assessmentJobNumber = assessmentJobNumber == null ? null : assessmentJobNumber.trim();
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
        TbManpowerAssessmentManage other = (TbManpowerAssessmentManage) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAssessmentId() == null ? other.getAssessmentId() == null : this.getAssessmentId().equals(other.getAssessmentId()))
            && (this.getAssessmentName() == null ? other.getAssessmentName() == null : this.getAssessmentName().equals(other.getAssessmentName()))
            && (this.getAssessmentStartTime() == null ? other.getAssessmentStartTime() == null : this.getAssessmentStartTime().equals(other.getAssessmentStartTime()))
            && (this.getAssessmentEndTime() == null ? other.getAssessmentEndTime() == null : this.getAssessmentEndTime().equals(other.getAssessmentEndTime()))
            && (this.getAssessmentObject() == null ? other.getAssessmentObject() == null : this.getAssessmentObject().equals(other.getAssessmentObject()))
            && (this.getAssessmentPeople() == null ? other.getAssessmentPeople() == null : this.getAssessmentPeople().equals(other.getAssessmentPeople()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getTemplateId() == null ? other.getTemplateId() == null : this.getTemplateId().equals(other.getTemplateId()))
            && (this.getTemplateName() == null ? other.getTemplateName() == null : this.getTemplateName().equals(other.getTemplateName()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getAssessmentJobNumber() == null ? other.getAssessmentJobNumber() == null : this.getAssessmentJobNumber().equals(other.getAssessmentJobNumber()))
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
        result = prime * result + ((getAssessmentId() == null) ? 0 : getAssessmentId().hashCode());
        result = prime * result + ((getAssessmentName() == null) ? 0 : getAssessmentName().hashCode());
        result = prime * result + ((getAssessmentStartTime() == null) ? 0 : getAssessmentStartTime().hashCode());
        result = prime * result + ((getAssessmentEndTime() == null) ? 0 : getAssessmentEndTime().hashCode());
        result = prime * result + ((getAssessmentObject() == null) ? 0 : getAssessmentObject().hashCode());
        result = prime * result + ((getAssessmentPeople() == null) ? 0 : getAssessmentPeople().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getTemplateId() == null) ? 0 : getTemplateId().hashCode());
        result = prime * result + ((getTemplateName() == null) ? 0 : getTemplateName().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getAssessmentJobNumber() == null) ? 0 : getAssessmentJobNumber().hashCode());
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
        sb.append(", assessmentId=").append(assessmentId);
        sb.append(", assessmentName=").append(assessmentName);
        sb.append(", assessmentStartTime=").append(assessmentStartTime);
        sb.append(", assessmentEndTime=").append(assessmentEndTime);
        sb.append(", assessmentObject=").append(assessmentObject);
        sb.append(", assessmentPeople=").append(assessmentPeople);
        sb.append(", status=").append(status);
        sb.append(", templateId=").append(templateId);
        sb.append(", templateName=").append(templateName);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", assessmentJobNumber=").append(assessmentJobNumber);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}