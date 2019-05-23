package com.jn.hr.train.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class TbManpowerTrainInvestiga implements Serializable {
    private String projectId;

    private String researchProject;

    private Date effectiveTimeStart;

    private Date effectiveTimeEnd;

    private String trainer;

    private Byte isShowTrainer;

    private Date trainDate;

    private Byte isShowTrainDate;

    private String surveyDimensional;

    private String surveyUrl;

    private Byte status;

    private Byte recordStatus;

    private String creatorAccount;

    private Date createdTime;

    private String modifierAccount;

    private Date modifiedTime;

    private byte[] projectNote;

    private static final long serialVersionUID = 1L;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getResearchProject() {
        return researchProject;
    }

    public void setResearchProject(String researchProject) {
        this.researchProject = researchProject == null ? null : researchProject.trim();
    }

    public Date getEffectiveTimeStart() {
        return effectiveTimeStart;
    }

    public void setEffectiveTimeStart(Date effectiveTimeStart) {
        this.effectiveTimeStart = effectiveTimeStart;
    }

    public Date getEffectiveTimeEnd() {
        return effectiveTimeEnd;
    }

    public void setEffectiveTimeEnd(Date effectiveTimeEnd) {
        this.effectiveTimeEnd = effectiveTimeEnd;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer == null ? null : trainer.trim();
    }

    public Byte getIsShowTrainer() {
        return isShowTrainer;
    }

    public void setIsShowTrainer(Byte isShowTrainer) {
        this.isShowTrainer = isShowTrainer;
    }

    public Date getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(Date trainDate) {
        this.trainDate = trainDate;
    }

    public Byte getIsShowTrainDate() {
        return isShowTrainDate;
    }

    public void setIsShowTrainDate(Byte isShowTrainDate) {
        this.isShowTrainDate = isShowTrainDate;
    }

    public String getSurveyDimensional() {
        return surveyDimensional;
    }

    public void setSurveyDimensional(String surveyDimensional) {
        this.surveyDimensional = surveyDimensional == null ? null : surveyDimensional.trim();
    }

    public String getSurveyUrl() {
        return surveyUrl;
    }

    public void setSurveyUrl(String surveyUrl) {
        this.surveyUrl = surveyUrl == null ? null : surveyUrl.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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

    public byte[] getProjectNote() {
        return projectNote;
    }

    public void setProjectNote(byte[] projectNote) {
        this.projectNote = projectNote;
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
        TbManpowerTrainInvestiga other = (TbManpowerTrainInvestiga) that;
        return (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getResearchProject() == null ? other.getResearchProject() == null : this.getResearchProject().equals(other.getResearchProject()))
            && (this.getEffectiveTimeStart() == null ? other.getEffectiveTimeStart() == null : this.getEffectiveTimeStart().equals(other.getEffectiveTimeStart()))
            && (this.getEffectiveTimeEnd() == null ? other.getEffectiveTimeEnd() == null : this.getEffectiveTimeEnd().equals(other.getEffectiveTimeEnd()))
            && (this.getTrainer() == null ? other.getTrainer() == null : this.getTrainer().equals(other.getTrainer()))
            && (this.getIsShowTrainer() == null ? other.getIsShowTrainer() == null : this.getIsShowTrainer().equals(other.getIsShowTrainer()))
            && (this.getTrainDate() == null ? other.getTrainDate() == null : this.getTrainDate().equals(other.getTrainDate()))
            && (this.getIsShowTrainDate() == null ? other.getIsShowTrainDate() == null : this.getIsShowTrainDate().equals(other.getIsShowTrainDate()))
            && (this.getSurveyDimensional() == null ? other.getSurveyDimensional() == null : this.getSurveyDimensional().equals(other.getSurveyDimensional()))
            && (this.getSurveyUrl() == null ? other.getSurveyUrl() == null : this.getSurveyUrl().equals(other.getSurveyUrl()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (Arrays.equals(this.getProjectNote(), other.getProjectNote()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getResearchProject() == null) ? 0 : getResearchProject().hashCode());
        result = prime * result + ((getEffectiveTimeStart() == null) ? 0 : getEffectiveTimeStart().hashCode());
        result = prime * result + ((getEffectiveTimeEnd() == null) ? 0 : getEffectiveTimeEnd().hashCode());
        result = prime * result + ((getTrainer() == null) ? 0 : getTrainer().hashCode());
        result = prime * result + ((getIsShowTrainer() == null) ? 0 : getIsShowTrainer().hashCode());
        result = prime * result + ((getTrainDate() == null) ? 0 : getTrainDate().hashCode());
        result = prime * result + ((getIsShowTrainDate() == null) ? 0 : getIsShowTrainDate().hashCode());
        result = prime * result + ((getSurveyDimensional() == null) ? 0 : getSurveyDimensional().hashCode());
        result = prime * result + ((getSurveyUrl() == null) ? 0 : getSurveyUrl().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + (Arrays.hashCode(getProjectNote()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", projectId=").append(projectId);
        sb.append(", researchProject=").append(researchProject);
        sb.append(", effectiveTimeStart=").append(effectiveTimeStart);
        sb.append(", effectiveTimeEnd=").append(effectiveTimeEnd);
        sb.append(", trainer=").append(trainer);
        sb.append(", isShowTrainer=").append(isShowTrainer);
        sb.append(", trainDate=").append(trainDate);
        sb.append(", isShowTrainDate=").append(isShowTrainDate);
        sb.append(", surveyDimensional=").append(surveyDimensional);
        sb.append(", surveyUrl=").append(surveyUrl);
        sb.append(", status=").append(status);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", projectNote=").append(projectNote);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}