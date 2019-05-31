package com.jn.hr.employee.entity;

import java.io.Serializable;

public class TbManpowerHolidayRule implements Serializable {
    private String ruleId;

    private Integer reachedYear;

    private Integer notFullYear;

    private Integer annualLeave;

    private Integer serialNumber;

    private static final long serialVersionUID = 1L;

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId == null ? null : ruleId.trim();
    }

    public Integer getReachedYear() {
        return reachedYear;
    }

    public void setReachedYear(Integer reachedYear) {
        this.reachedYear = reachedYear;
    }

    public Integer getNotFullYear() {
        return notFullYear;
    }

    public void setNotFullYear(Integer notFullYear) {
        this.notFullYear = notFullYear;
    }

    public Integer getAnnualLeave() {
        return annualLeave;
    }

    public void setAnnualLeave(Integer annualLeave) {
        this.annualLeave = annualLeave;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
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
        TbManpowerHolidayRule other = (TbManpowerHolidayRule) that;
        return (this.getRuleId() == null ? other.getRuleId() == null : this.getRuleId().equals(other.getRuleId()))
            && (this.getReachedYear() == null ? other.getReachedYear() == null : this.getReachedYear().equals(other.getReachedYear()))
            && (this.getNotFullYear() == null ? other.getNotFullYear() == null : this.getNotFullYear().equals(other.getNotFullYear()))
            && (this.getAnnualLeave() == null ? other.getAnnualLeave() == null : this.getAnnualLeave().equals(other.getAnnualLeave()))
            && (this.getSerialNumber() == null ? other.getSerialNumber() == null : this.getSerialNumber().equals(other.getSerialNumber()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRuleId() == null) ? 0 : getRuleId().hashCode());
        result = prime * result + ((getReachedYear() == null) ? 0 : getReachedYear().hashCode());
        result = prime * result + ((getNotFullYear() == null) ? 0 : getNotFullYear().hashCode());
        result = prime * result + ((getAnnualLeave() == null) ? 0 : getAnnualLeave().hashCode());
        result = prime * result + ((getSerialNumber() == null) ? 0 : getSerialNumber().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ruleId=").append(ruleId);
        sb.append(", reachedYear=").append(reachedYear);
        sb.append(", notFullYear=").append(notFullYear);
        sb.append(", annualLeave=").append(annualLeave);
        sb.append(", serialNumber=").append(serialNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}