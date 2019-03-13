package com.jn.park.finance.entity;

import java.io.Serializable;

public class TbMonth implements Serializable {
    /*@ApiModelProperty("yyyymm")*/
    private String month;

    private static final long serialVersionUID = 1L;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
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
        TbMonth other = (TbMonth) that;
        return (this.getMonth() == null ? other.getMonth() == null : this.getMonth().equals(other.getMonth()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMonth() == null) ? 0 : getMonth().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", month=").append(month);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}