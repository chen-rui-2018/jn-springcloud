package com.jn.enterprise.servicemarket.product.entity;

import java.io.Serializable;
import java.util.Arrays;

public class TbServiceDetails implements Serializable {
    private String productId;

    private byte[] serviceDetails;

    private static final long serialVersionUID = 1L;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public byte[] getServiceDetails() {
        return serviceDetails;
    }

    public void setServiceDetails(byte[] serviceDetails) {
        this.serviceDetails = serviceDetails;
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
        TbServiceDetails other = (TbServiceDetails) that;
        return (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (Arrays.equals(this.getServiceDetails(), other.getServiceDetails()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + (Arrays.hashCode(getServiceDetails()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productId=").append(productId);
        sb.append(", serviceDetails=").append(serviceDetails);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}