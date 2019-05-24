package com.jn.hr.exam.entity;

import java.io.Serializable;
import java.util.Date;

public class TbManpowerExaminaManagement implements Serializable {
    private String id;

    private String examinaName;

    private Date effectiveTimeStart;

    private Date effectiveTimeEnd;

    private String examinaNotes;

    private Integer totalScore;

    private Integer passScore;

    private Integer answerTime;

    private String examinaDimensional;

    private String examinaUrl;

    private Byte status;

    private Byte isRelease;

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

    public String getExaminaName() {
        return examinaName;
    }

    public void setExaminaName(String examinaName) {
        this.examinaName = examinaName == null ? null : examinaName.trim();
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

    public String getExaminaNotes() {
        return examinaNotes;
    }

    public void setExaminaNotes(String examinaNotes) {
        this.examinaNotes = examinaNotes == null ? null : examinaNotes.trim();
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getPassScore() {
        return passScore;
    }

    public void setPassScore(Integer passScore) {
        this.passScore = passScore;
    }

    public Integer getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Integer answerTime) {
        this.answerTime = answerTime;
    }

    public String getExaminaDimensional() {
        return examinaDimensional;
    }

    public void setExaminaDimensional(String examinaDimensional) {
        this.examinaDimensional = examinaDimensional == null ? null : examinaDimensional.trim();
    }

    public String getExaminaUrl() {
        return examinaUrl;
    }

    public void setExaminaUrl(String examinaUrl) {
        this.examinaUrl = examinaUrl == null ? null : examinaUrl.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getIsRelease() {
        return isRelease;
    }

    public void setIsRelease(Byte isRelease) {
        this.isRelease = isRelease;
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
        TbManpowerExaminaManagement other = (TbManpowerExaminaManagement) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getExaminaName() == null ? other.getExaminaName() == null : this.getExaminaName().equals(other.getExaminaName()))
            && (this.getEffectiveTimeStart() == null ? other.getEffectiveTimeStart() == null : this.getEffectiveTimeStart().equals(other.getEffectiveTimeStart()))
            && (this.getEffectiveTimeEnd() == null ? other.getEffectiveTimeEnd() == null : this.getEffectiveTimeEnd().equals(other.getEffectiveTimeEnd()))
            && (this.getExaminaNotes() == null ? other.getExaminaNotes() == null : this.getExaminaNotes().equals(other.getExaminaNotes()))
            && (this.getTotalScore() == null ? other.getTotalScore() == null : this.getTotalScore().equals(other.getTotalScore()))
            && (this.getPassScore() == null ? other.getPassScore() == null : this.getPassScore().equals(other.getPassScore()))
            && (this.getAnswerTime() == null ? other.getAnswerTime() == null : this.getAnswerTime().equals(other.getAnswerTime()))
            && (this.getExaminaDimensional() == null ? other.getExaminaDimensional() == null : this.getExaminaDimensional().equals(other.getExaminaDimensional()))
            && (this.getExaminaUrl() == null ? other.getExaminaUrl() == null : this.getExaminaUrl().equals(other.getExaminaUrl()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getIsRelease() == null ? other.getIsRelease() == null : this.getIsRelease().equals(other.getIsRelease()))
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
        result = prime * result + ((getExaminaName() == null) ? 0 : getExaminaName().hashCode());
        result = prime * result + ((getEffectiveTimeStart() == null) ? 0 : getEffectiveTimeStart().hashCode());
        result = prime * result + ((getEffectiveTimeEnd() == null) ? 0 : getEffectiveTimeEnd().hashCode());
        result = prime * result + ((getExaminaNotes() == null) ? 0 : getExaminaNotes().hashCode());
        result = prime * result + ((getTotalScore() == null) ? 0 : getTotalScore().hashCode());
        result = prime * result + ((getPassScore() == null) ? 0 : getPassScore().hashCode());
        result = prime * result + ((getAnswerTime() == null) ? 0 : getAnswerTime().hashCode());
        result = prime * result + ((getExaminaDimensional() == null) ? 0 : getExaminaDimensional().hashCode());
        result = prime * result + ((getExaminaUrl() == null) ? 0 : getExaminaUrl().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getIsRelease() == null) ? 0 : getIsRelease().hashCode());
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
        sb.append(", examinaName=").append(examinaName);
        sb.append(", effectiveTimeStart=").append(effectiveTimeStart);
        sb.append(", effectiveTimeEnd=").append(effectiveTimeEnd);
        sb.append(", examinaNotes=").append(examinaNotes);
        sb.append(", totalScore=").append(totalScore);
        sb.append(", passScore=").append(passScore);
        sb.append(", answerTime=").append(answerTime);
        sb.append(", examinaDimensional=").append(examinaDimensional);
        sb.append(", examinaUrl=").append(examinaUrl);
        sb.append(", status=").append(status);
        sb.append(", isRelease=").append(isRelease);
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