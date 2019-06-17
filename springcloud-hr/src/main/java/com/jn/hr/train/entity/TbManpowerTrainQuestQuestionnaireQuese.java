package com.jn.hr.train.entity;

import java.io.Serializable;

public class TbManpowerTrainQuestQuestionnaireQuese implements Serializable {
    private String titleId;

    private String titleName;

    private Byte titleType;

    private Byte isShowAnswer;

    private String projectId;

    private static final long serialVersionUID = 1L;

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId == null ? null : titleId.trim();
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName == null ? null : titleName.trim();
    }

    public Byte getTitleType() {
        return titleType;
    }

    public void setTitleType(Byte titleType) {
        this.titleType = titleType;
    }

    public Byte getIsShowAnswer() {
        return isShowAnswer;
    }

    public void setIsShowAnswer(Byte isShowAnswer) {
        this.isShowAnswer = isShowAnswer;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
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
        TbManpowerTrainQuestQuestionnaireQuese other = (TbManpowerTrainQuestQuestionnaireQuese) that;
        return (this.getTitleId() == null ? other.getTitleId() == null : this.getTitleId().equals(other.getTitleId()))
            && (this.getTitleName() == null ? other.getTitleName() == null : this.getTitleName().equals(other.getTitleName()))
            && (this.getTitleType() == null ? other.getTitleType() == null : this.getTitleType().equals(other.getTitleType()))
            && (this.getIsShowAnswer() == null ? other.getIsShowAnswer() == null : this.getIsShowAnswer().equals(other.getIsShowAnswer()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTitleId() == null) ? 0 : getTitleId().hashCode());
        result = prime * result + ((getTitleName() == null) ? 0 : getTitleName().hashCode());
        result = prime * result + ((getTitleType() == null) ? 0 : getTitleType().hashCode());
        result = prime * result + ((getIsShowAnswer() == null) ? 0 : getIsShowAnswer().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", titleId=").append(titleId);
        sb.append(", titleName=").append(titleName);
        sb.append(", titleType=").append(titleType);
        sb.append(", isShowAnswer=").append(isShowAnswer);
        sb.append(", projectId=").append(projectId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}