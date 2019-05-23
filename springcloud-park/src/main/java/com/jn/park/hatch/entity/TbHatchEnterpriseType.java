package com.jn.park.hatch.entity;

import java.io.Serializable;

public class TbHatchEnterpriseType implements Serializable {
    private String enterpriseTypeId;

    private String enterpriseTypeName;

    private static final long serialVersionUID = 1L;

    public String getEnterpriseTypeId() {
        return enterpriseTypeId;
    }

    public void setEnterpriseTypeId(String enterpriseTypeId) {
        this.enterpriseTypeId = enterpriseTypeId == null ? null : enterpriseTypeId.trim();
    }

    public String getEnterpriseTypeName() {
        return enterpriseTypeName;
    }

    public void setEnterpriseTypeName(String enterpriseTypeName) {
        this.enterpriseTypeName = enterpriseTypeName == null ? null : enterpriseTypeName.trim();
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
        TbHatchEnterpriseType other = (TbHatchEnterpriseType) that;
        return (this.getEnterpriseTypeId() == null ? other.getEnterpriseTypeId() == null : this.getEnterpriseTypeId().equals(other.getEnterpriseTypeId()))
            && (this.getEnterpriseTypeName() == null ? other.getEnterpriseTypeName() == null : this.getEnterpriseTypeName().equals(other.getEnterpriseTypeName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEnterpriseTypeId() == null) ? 0 : getEnterpriseTypeId().hashCode());
        result = prime * result + ((getEnterpriseTypeName() == null) ? 0 : getEnterpriseTypeName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", enterpriseTypeId=").append(enterpriseTypeId);
        sb.append(", enterpriseTypeName=").append(enterpriseTypeName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}