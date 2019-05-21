package com.jn.hr.train.entity;

import java.io.Serializable;

public class TbManpowerTrainAnswerInfo implements Serializable {
    private String answerId;

    private String id;

    private String titleId;

    private String optionAnswer;

    private String subjectiveQuestionAnswer;

    private String jobNumber;

    private static final long serialVersionUID = 1L;

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId == null ? null : answerId.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId == null ? null : titleId.trim();
    }

    public String getOptionAnswer() {
        return optionAnswer;
    }

    public void setOptionAnswer(String optionAnswer) {
        this.optionAnswer = optionAnswer == null ? null : optionAnswer.trim();
    }

    public String getSubjectiveQuestionAnswer() {
        return subjectiveQuestionAnswer;
    }

    public void setSubjectiveQuestionAnswer(String subjectiveQuestionAnswer) {
        this.subjectiveQuestionAnswer = subjectiveQuestionAnswer == null ? null : subjectiveQuestionAnswer.trim();
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber == null ? null : jobNumber.trim();
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
        TbManpowerTrainAnswerInfo other = (TbManpowerTrainAnswerInfo) that;
        return (this.getAnswerId() == null ? other.getAnswerId() == null : this.getAnswerId().equals(other.getAnswerId()))
            && (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitleId() == null ? other.getTitleId() == null : this.getTitleId().equals(other.getTitleId()))
            && (this.getOptionAnswer() == null ? other.getOptionAnswer() == null : this.getOptionAnswer().equals(other.getOptionAnswer()))
            && (this.getSubjectiveQuestionAnswer() == null ? other.getSubjectiveQuestionAnswer() == null : this.getSubjectiveQuestionAnswer().equals(other.getSubjectiveQuestionAnswer()))
            && (this.getJobNumber() == null ? other.getJobNumber() == null : this.getJobNumber().equals(other.getJobNumber()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAnswerId() == null) ? 0 : getAnswerId().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitleId() == null) ? 0 : getTitleId().hashCode());
        result = prime * result + ((getOptionAnswer() == null) ? 0 : getOptionAnswer().hashCode());
        result = prime * result + ((getSubjectiveQuestionAnswer() == null) ? 0 : getSubjectiveQuestionAnswer().hashCode());
        result = prime * result + ((getJobNumber() == null) ? 0 : getJobNumber().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", answerId=").append(answerId);
        sb.append(", id=").append(id);
        sb.append(", titleId=").append(titleId);
        sb.append(", optionAnswer=").append(optionAnswer);
        sb.append(", subjectiveQuestionAnswer=").append(subjectiveQuestionAnswer);
        sb.append(", jobNumber=").append(jobNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}