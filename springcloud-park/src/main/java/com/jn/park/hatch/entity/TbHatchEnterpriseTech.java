package com.jn.park.hatch.entity;

import java.io.Serializable;

public class TbHatchEnterpriseTech implements Serializable {
    private String enterpriseTechId;

    private String enterpriseTechName;

    private static final long serialVersionUID = 1L;

    public String getEnterpriseTechId() {
        return enterpriseTechId;
    }

    public void setEnterpriseTechId(String enterpriseTechId) {
        this.enterpriseTechId = enterpriseTechId == null ? null : enterpriseTechId.trim();
    }

    public String getEnterpriseTechName() {
        return enterpriseTechName;
    }

    public void setEnterpriseTechName(String enterpriseTechName) {
        this.enterpriseTechName = enterpriseTechName == null ? null : enterpriseTechName.trim();
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
        TbHatchEnterpriseTech other = (TbHatchEnterpriseTech) that;
        return (this.getEnterpriseTechId() == null ? other.getEnterpriseTechId() == null : this.getEnterpriseTechId().equals(other.getEnterpriseTechId()))
            && (this.getEnterpriseTechName() == null ? other.getEnterpriseTechName() == null : this.getEnterpriseTechName().equals(other.getEnterpriseTechName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEnterpriseTechId() == null) ? 0 : getEnterpriseTechId().hashCode());
        result = prime * result + ((getEnterpriseTechName() == null) ? 0 : getEnterpriseTechName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", enterpriseTechId=").append(enterpriseTechId);
        sb.append(", enterpriseTechName=").append(enterpriseTechName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}