package com.jn.enterprise.technologyfinancial.investors.entity;

import java.io.Serializable;
import java.util.Date;

public class TbServiceInvestorMainRound implements Serializable {
    private String id;

    private String investorAccount;

    private String mainRoundCode;

    private String mainRoundName;

    private Date createdTime;

    private String creatorAccount;

    private Date modifiedTime;

    private String modifierAccount;

    private Byte recordStatus;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getInvestorAccount() {
        return investorAccount;
    }

    public void setInvestorAccount(String investorAccount) {
        this.investorAccount = investorAccount == null ? null : investorAccount.trim();
    }

    public String getMainRoundCode() {
        return mainRoundCode;
    }

    public void setMainRoundCode(String mainRoundCode) {
        this.mainRoundCode = mainRoundCode == null ? null : mainRoundCode.trim();
    }

    public String getMainRoundName() {
        return mainRoundName;
    }

    public void setMainRoundName(String mainRoundName) {
        this.mainRoundName = mainRoundName == null ? null : mainRoundName.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount == null ? null : creatorAccount.trim();
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount == null ? null : modifierAccount.trim();
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
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
        TbServiceInvestorMainRound other = (TbServiceInvestorMainRound) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getInvestorAccount() == null ? other.getInvestorAccount() == null : this.getInvestorAccount().equals(other.getInvestorAccount()))
            && (this.getMainRoundCode() == null ? other.getMainRoundCode() == null : this.getMainRoundCode().equals(other.getMainRoundCode()))
            && (this.getMainRoundName() == null ? other.getMainRoundName() == null : this.getMainRoundName().equals(other.getMainRoundName()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getInvestorAccount() == null) ? 0 : getInvestorAccount().hashCode());
        result = prime * result + ((getMainRoundCode() == null) ? 0 : getMainRoundCode().hashCode());
        result = prime * result + ((getMainRoundName() == null) ? 0 : getMainRoundName().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", investorAccount=").append(investorAccount);
        sb.append(", mainRoundCode=").append(mainRoundCode);
        sb.append(", mainRoundName=").append(mainRoundName);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}