package com.jn.hr.exam.entity;

import java.io.Serializable;
import java.util.Date;

public class TbManpowerExaminaBank implements Serializable {
    private String testQuestionId;

    private String examinationQuestion;

    private String testQuestionType;

    private String examinationDifficulty;

    private String standardAnswer;

    private String fraction;

    private Byte recordStatus;

    private String creatorAccount;

    private Date createdTime;

    private String modifierAccount;

    private Date modifiedTime;

    private String itemAnalysis;

    private String id;

    private static final long serialVersionUID = 1L;

    public String getTestQuestionId() {
        return testQuestionId;
    }

    public void setTestQuestionId(String testQuestionId) {
        this.testQuestionId = testQuestionId == null ? null : testQuestionId.trim();
    }

    public String getExaminationQuestion() {
        return examinationQuestion;
    }

    public void setExaminationQuestion(String examinationQuestion) {
        this.examinationQuestion = examinationQuestion == null ? null : examinationQuestion.trim();
    }

    public String getTestQuestionType() {
        return testQuestionType;
    }

    public void setTestQuestionType(String testQuestionType) {
        this.testQuestionType = testQuestionType == null ? null : testQuestionType.trim();
    }

    public String getExaminationDifficulty() {
        return examinationDifficulty;
    }

    public void setExaminationDifficulty(String examinationDifficulty) {
        this.examinationDifficulty = examinationDifficulty == null ? null : examinationDifficulty.trim();
    }

    public String getStandardAnswer() {
        return standardAnswer;
    }

    public void setStandardAnswer(String standardAnswer) {
        this.standardAnswer = standardAnswer == null ? null : standardAnswer.trim();
    }

    public String getFraction() {
        return fraction;
    }

    public void setFraction(String fraction) {
        this.fraction = fraction == null ? null : fraction.trim();
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

    public String getItemAnalysis() {
        return itemAnalysis;
    }

    public void setItemAnalysis(String itemAnalysis) {
        this.itemAnalysis = itemAnalysis == null ? null : itemAnalysis.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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
        TbManpowerExaminaBank other = (TbManpowerExaminaBank) that;
        return (this.getTestQuestionId() == null ? other.getTestQuestionId() == null : this.getTestQuestionId().equals(other.getTestQuestionId()))
            && (this.getExaminationQuestion() == null ? other.getExaminationQuestion() == null : this.getExaminationQuestion().equals(other.getExaminationQuestion()))
            && (this.getTestQuestionType() == null ? other.getTestQuestionType() == null : this.getTestQuestionType().equals(other.getTestQuestionType()))
            && (this.getExaminationDifficulty() == null ? other.getExaminationDifficulty() == null : this.getExaminationDifficulty().equals(other.getExaminationDifficulty()))
            && (this.getStandardAnswer() == null ? other.getStandardAnswer() == null : this.getStandardAnswer().equals(other.getStandardAnswer()))
            && (this.getFraction() == null ? other.getFraction() == null : this.getFraction().equals(other.getFraction()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getItemAnalysis() == null ? other.getItemAnalysis() == null : this.getItemAnalysis().equals(other.getItemAnalysis()))
            && (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTestQuestionId() == null) ? 0 : getTestQuestionId().hashCode());
        result = prime * result + ((getExaminationQuestion() == null) ? 0 : getExaminationQuestion().hashCode());
        result = prime * result + ((getTestQuestionType() == null) ? 0 : getTestQuestionType().hashCode());
        result = prime * result + ((getExaminationDifficulty() == null) ? 0 : getExaminationDifficulty().hashCode());
        result = prime * result + ((getStandardAnswer() == null) ? 0 : getStandardAnswer().hashCode());
        result = prime * result + ((getFraction() == null) ? 0 : getFraction().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getItemAnalysis() == null) ? 0 : getItemAnalysis().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", testQuestionId=").append(testQuestionId);
        sb.append(", examinationQuestion=").append(examinationQuestion);
        sb.append(", testQuestionType=").append(testQuestionType);
        sb.append(", examinationDifficulty=").append(examinationDifficulty);
        sb.append(", standardAnswer=").append(standardAnswer);
        sb.append(", fraction=").append(fraction);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", itemAnalysis=").append(itemAnalysis);
        sb.append(", id=").append(id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}