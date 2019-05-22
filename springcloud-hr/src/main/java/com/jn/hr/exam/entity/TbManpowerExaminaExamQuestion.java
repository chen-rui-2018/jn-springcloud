package com.jn.hr.exam.entity;

import java.io.Serializable;

public class TbManpowerExaminaExamQuestion implements Serializable {
    private String id;

    private String examinaId;

    private String testQuestionId;

    private String fraction;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getExaminaId() {
        return examinaId;
    }

    public void setExaminaId(String examinaId) {
        this.examinaId = examinaId == null ? null : examinaId.trim();
    }

    public String getTestQuestionId() {
        return testQuestionId;
    }

    public void setTestQuestionId(String testQuestionId) {
        this.testQuestionId = testQuestionId == null ? null : testQuestionId.trim();
    }

    public String getFraction() {
        return fraction;
    }

    public void setFraction(String fraction) {
        this.fraction = fraction == null ? null : fraction.trim();
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
        TbManpowerExaminaExamQuestion other = (TbManpowerExaminaExamQuestion) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getExaminaId() == null ? other.getExaminaId() == null : this.getExaminaId().equals(other.getExaminaId()))
            && (this.getTestQuestionId() == null ? other.getTestQuestionId() == null : this.getTestQuestionId().equals(other.getTestQuestionId()))
            && (this.getFraction() == null ? other.getFraction() == null : this.getFraction().equals(other.getFraction()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getExaminaId() == null) ? 0 : getExaminaId().hashCode());
        result = prime * result + ((getTestQuestionId() == null) ? 0 : getTestQuestionId().hashCode());
        result = prime * result + ((getFraction() == null) ? 0 : getFraction().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", examinaId=").append(examinaId);
        sb.append(", testQuestionId=").append(testQuestionId);
        sb.append(", fraction=").append(fraction);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}