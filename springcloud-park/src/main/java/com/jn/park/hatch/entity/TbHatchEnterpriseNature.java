package com.jn.park.hatch.entity;

import java.io.Serializable;

public class TbHatchEnterpriseNature implements Serializable {
    private String enterpriseNatureId;

    private String enterpriseNatureName;

    private static final long serialVersionUID = 1L;

    public String getEnterpriseNatureId() {
        return enterpriseNatureId;
    }

    public void setEnterpriseNatureId(String enterpriseNatureId) {
        this.enterpriseNatureId = enterpriseNatureId == null ? null : enterpriseNatureId.trim();
    }

    public String getEnterpriseNatureName() {
        return enterpriseNatureName;
    }

    public void setEnterpriseNatureName(String enterpriseNatureName) {
        this.enterpriseNatureName = enterpriseNatureName == null ? null : enterpriseNatureName.trim();
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
        TbHatchEnterpriseNature other = (TbHatchEnterpriseNature) that;
        return (this.getEnterpriseNatureId() == null ? other.getEnterpriseNatureId() == null : this.getEnterpriseNatureId().equals(other.getEnterpriseNatureId()))
            && (this.getEnterpriseNatureName() == null ? other.getEnterpriseNatureName() == null : this.getEnterpriseNatureName().equals(other.getEnterpriseNatureName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEnterpriseNatureId() == null) ? 0 : getEnterpriseNatureId().hashCode());
        result = prime * result + ((getEnterpriseNatureName() == null) ? 0 : getEnterpriseNatureName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", enterpriseNatureId=").append(enterpriseNatureId);
        sb.append(", enterpriseNatureName=").append(enterpriseNatureName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}