package com.jn.park.hatch.entity;

import java.io.Serializable;

public class TbHatchIncubatorType implements Serializable {
    private String incubatorCode;

    private String incubatorName;

    private static final long serialVersionUID = 1L;

    public String getIncubatorCode() {
        return incubatorCode;
    }

    public void setIncubatorCode(String incubatorCode) {
        this.incubatorCode = incubatorCode == null ? null : incubatorCode.trim();
    }

    public String getIncubatorName() {
        return incubatorName;
    }

    public void setIncubatorName(String incubatorName) {
        this.incubatorName = incubatorName == null ? null : incubatorName.trim();
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
        TbHatchIncubatorType other = (TbHatchIncubatorType) that;
        return (this.getIncubatorCode() == null ? other.getIncubatorCode() == null : this.getIncubatorCode().equals(other.getIncubatorCode()))
            && (this.getIncubatorName() == null ? other.getIncubatorName() == null : this.getIncubatorName().equals(other.getIncubatorName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIncubatorCode() == null) ? 0 : getIncubatorCode().hashCode());
        result = prime * result + ((getIncubatorName() == null) ? 0 : getIncubatorName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", incubatorCode=").append(incubatorCode);
        sb.append(", incubatorName=").append(incubatorName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}