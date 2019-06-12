package com.jn.hr.train.entity;

import java.io.Serializable;

public class TbManpowerTrainQuestResearchSet implements Serializable {
    private String projectId;

    private Byte researchMethod;

    private Byte isShowName;

    private Byte isShowJobNumber;

    private Byte isShowPhone;

    private Byte frequencyLimit;

    private Byte isShowTips;

    private String promptingLanguage;

    private static final long serialVersionUID = 1L;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public Byte getResearchMethod() {
        return researchMethod;
    }

    public void setResearchMethod(Byte researchMethod) {
        this.researchMethod = researchMethod;
    }

    public Byte getIsShowName() {
        return isShowName;
    }

    public void setIsShowName(Byte isShowName) {
        this.isShowName = isShowName;
    }

    public Byte getIsShowJobNumber() {
        return isShowJobNumber;
    }

    public void setIsShowJobNumber(Byte isShowJobNumber) {
        this.isShowJobNumber = isShowJobNumber;
    }

    public Byte getIsShowPhone() {
        return isShowPhone;
    }

    public void setIsShowPhone(Byte isShowPhone) {
        this.isShowPhone = isShowPhone;
    }

    public Byte getFrequencyLimit() {
        return frequencyLimit;
    }

    public void setFrequencyLimit(Byte frequencyLimit) {
        this.frequencyLimit = frequencyLimit;
    }

    public Byte getIsShowTips() {
        return isShowTips;
    }

    public void setIsShowTips(Byte isShowTips) {
        this.isShowTips = isShowTips;
    }

    public String getPromptingLanguage() {
        return promptingLanguage;
    }

    public void setPromptingLanguage(String promptingLanguage) {
        this.promptingLanguage = promptingLanguage == null ? null : promptingLanguage.trim();
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
        TbManpowerTrainQuestResearchSet other = (TbManpowerTrainQuestResearchSet) that;
        return (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getResearchMethod() == null ? other.getResearchMethod() == null : this.getResearchMethod().equals(other.getResearchMethod()))
            && (this.getIsShowName() == null ? other.getIsShowName() == null : this.getIsShowName().equals(other.getIsShowName()))
            && (this.getIsShowJobNumber() == null ? other.getIsShowJobNumber() == null : this.getIsShowJobNumber().equals(other.getIsShowJobNumber()))
            && (this.getIsShowPhone() == null ? other.getIsShowPhone() == null : this.getIsShowPhone().equals(other.getIsShowPhone()))
            && (this.getFrequencyLimit() == null ? other.getFrequencyLimit() == null : this.getFrequencyLimit().equals(other.getFrequencyLimit()))
            && (this.getIsShowTips() == null ? other.getIsShowTips() == null : this.getIsShowTips().equals(other.getIsShowTips()))
            && (this.getPromptingLanguage() == null ? other.getPromptingLanguage() == null : this.getPromptingLanguage().equals(other.getPromptingLanguage()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getResearchMethod() == null) ? 0 : getResearchMethod().hashCode());
        result = prime * result + ((getIsShowName() == null) ? 0 : getIsShowName().hashCode());
        result = prime * result + ((getIsShowJobNumber() == null) ? 0 : getIsShowJobNumber().hashCode());
        result = prime * result + ((getIsShowPhone() == null) ? 0 : getIsShowPhone().hashCode());
        result = prime * result + ((getFrequencyLimit() == null) ? 0 : getFrequencyLimit().hashCode());
        result = prime * result + ((getIsShowTips() == null) ? 0 : getIsShowTips().hashCode());
        result = prime * result + ((getPromptingLanguage() == null) ? 0 : getPromptingLanguage().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", projectId=").append(projectId);
        sb.append(", researchMethod=").append(researchMethod);
        sb.append(", isShowName=").append(isShowName);
        sb.append(", isShowJobNumber=").append(isShowJobNumber);
        sb.append(", isShowPhone=").append(isShowPhone);
        sb.append(", frequencyLimit=").append(frequencyLimit);
        sb.append(", isShowTips=").append(isShowTips);
        sb.append(", promptingLanguage=").append(promptingLanguage);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}