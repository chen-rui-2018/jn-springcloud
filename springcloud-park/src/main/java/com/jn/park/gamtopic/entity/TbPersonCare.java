package com.jn.park.gamtopic.entity;

import java.io.Serializable;

public class TbPersonCare implements Serializable {
    private String careId;

    private String careAccount;

    private String receiveAccount;

    private static final long serialVersionUID = 1L;

    public String getCareId() {
        return careId;
    }

    public void setCareId(String careId) {
        this.careId = careId == null ? null : careId.trim();
    }

    public String getCareAccount() {
        return careAccount;
    }

    public void setCareAccount(String careAccount) {
        this.careAccount = careAccount == null ? null : careAccount.trim();
    }

    public String getReceiveAccount() {
        return receiveAccount;
    }

    public void setReceiveAccount(String receiveAccount) {
        this.receiveAccount = receiveAccount == null ? null : receiveAccount.trim();
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
        TbPersonCare other = (TbPersonCare) that;
        return (this.getCareId() == null ? other.getCareId() == null : this.getCareId().equals(other.getCareId()))
            && (this.getCareAccount() == null ? other.getCareAccount() == null : this.getCareAccount().equals(other.getCareAccount()))
            && (this.getReceiveAccount() == null ? other.getReceiveAccount() == null : this.getReceiveAccount().equals(other.getReceiveAccount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCareId() == null) ? 0 : getCareId().hashCode());
        result = prime * result + ((getCareAccount() == null) ? 0 : getCareAccount().hashCode());
        result = prime * result + ((getReceiveAccount() == null) ? 0 : getReceiveAccount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", careId=").append(careId);
        sb.append(", careAccount=").append(careAccount);
        sb.append(", receiveAccount=").append(receiveAccount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}