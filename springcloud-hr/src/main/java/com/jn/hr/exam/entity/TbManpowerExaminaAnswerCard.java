package com.jn.hr.exam.entity;

import java.io.Serializable;

public class TbManpowerExaminaAnswerCard implements Serializable {
    private String id;

    private String jobNumber;

    private String testPaperId;

    private String testQuestId;

    private String answer;

    private String titleScore;

    private String answerType;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber == null ? null : jobNumber.trim();
    }

    public String getTestPaperId() {
        return testPaperId;
    }

    public void setTestPaperId(String testPaperId) {
        this.testPaperId = testPaperId == null ? null : testPaperId.trim();
    }

    public String getTestQuestId() {
        return testQuestId;
    }

    public void setTestQuestId(String testQuestId) {
        this.testQuestId = testQuestId == null ? null : testQuestId.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getTitleScore() {
        return titleScore;
    }

    public void setTitleScore(String titleScore) {
        this.titleScore = titleScore == null ? null : titleScore.trim();
    }

    public String getAnswerType() {
        return answerType;
    }

    public void setAnswerType(String answerType) {
        this.answerType = answerType == null ? null : answerType.trim();
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
        TbManpowerExaminaAnswerCard other = (TbManpowerExaminaAnswerCard) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getJobNumber() == null ? other.getJobNumber() == null : this.getJobNumber().equals(other.getJobNumber()))
            && (this.getTestPaperId() == null ? other.getTestPaperId() == null : this.getTestPaperId().equals(other.getTestPaperId()))
            && (this.getTestQuestId() == null ? other.getTestQuestId() == null : this.getTestQuestId().equals(other.getTestQuestId()))
            && (this.getAnswer() == null ? other.getAnswer() == null : this.getAnswer().equals(other.getAnswer()))
            && (this.getTitleScore() == null ? other.getTitleScore() == null : this.getTitleScore().equals(other.getTitleScore()))
            && (this.getAnswerType() == null ? other.getAnswerType() == null : this.getAnswerType().equals(other.getAnswerType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getJobNumber() == null) ? 0 : getJobNumber().hashCode());
        result = prime * result + ((getTestPaperId() == null) ? 0 : getTestPaperId().hashCode());
        result = prime * result + ((getTestQuestId() == null) ? 0 : getTestQuestId().hashCode());
        result = prime * result + ((getAnswer() == null) ? 0 : getAnswer().hashCode());
        result = prime * result + ((getTitleScore() == null) ? 0 : getTitleScore().hashCode());
        result = prime * result + ((getAnswerType() == null) ? 0 : getAnswerType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", jobNumber=").append(jobNumber);
        sb.append(", testPaperId=").append(testPaperId);
        sb.append(", testQuestId=").append(testQuestId);
        sb.append(", answer=").append(answer);
        sb.append(", titleScore=").append(titleScore);
        sb.append(", answerType=").append(answerType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}