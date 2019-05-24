package com.jn.hr.exam.entity;

import java.io.Serializable;

public class TbManpowerExaminaQuestionAnswer implements Serializable {
    private String id;

    private String testQuestionId;

    private String answerNumber;

    private String answerHtml;

    private String remark;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTestQuestionId() {
        return testQuestionId;
    }

    public void setTestQuestionId(String testQuestionId) {
        this.testQuestionId = testQuestionId == null ? null : testQuestionId.trim();
    }

    public String getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber(String answerNumber) {
        this.answerNumber = answerNumber == null ? null : answerNumber.trim();
    }

    public String getAnswerHtml() {
        return answerHtml;
    }

    public void setAnswerHtml(String answerHtml) {
        this.answerHtml = answerHtml == null ? null : answerHtml.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
        TbManpowerExaminaQuestionAnswer other = (TbManpowerExaminaQuestionAnswer) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTestQuestionId() == null ? other.getTestQuestionId() == null : this.getTestQuestionId().equals(other.getTestQuestionId()))
            && (this.getAnswerNumber() == null ? other.getAnswerNumber() == null : this.getAnswerNumber().equals(other.getAnswerNumber()))
            && (this.getAnswerHtml() == null ? other.getAnswerHtml() == null : this.getAnswerHtml().equals(other.getAnswerHtml()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTestQuestionId() == null) ? 0 : getTestQuestionId().hashCode());
        result = prime * result + ((getAnswerNumber() == null) ? 0 : getAnswerNumber().hashCode());
        result = prime * result + ((getAnswerHtml() == null) ? 0 : getAnswerHtml().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", testQuestionId=").append(testQuestionId);
        sb.append(", answerNumber=").append(answerNumber);
        sb.append(", answerHtml=").append(answerHtml);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}