package com.jn.hr.increase.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbManpowerSalaryInfo implements Serializable {
    private String id;

    private String jobNumber;

    private Double probationBasicWage;

    private Double probationDutyAllowance;

    private Double probationProfessionalTitleAllowance;

    private Double probationSeniorityWage;

    private Double probationEducationAllowance;

    private Double probationWorkSubsidy;

    private Double probationAchievementBonus;

    private BigDecimal probationSingleReward;

    private Byte recordStatus;

    private String creatorAccount;

    private Date createdTime;

    private String modifierAccount;

    private Date modifiedTime;

    private Double conversionBasicWage;

    private Double conversionDutyAllowance;

    private Double conversionProfessionalTitleAllowance;

    private Double conversionSeniorityWage;

    private Double conversionEducationAllowance;

    private Double conversionWorkSubsidy;

    private Double conversionAchievementBonus;

    private Double conversionSingleReward;

    private String currentBasicWage;

    private String currentDutyAllowance;

    private String currentProfessionalTitleAllowance;

    private String currentSeniorityWage;

    private String currentEducationAllowance;

    private String currentWorkSubsidy;

    private String currentAchievementBonus;

    private String currentSingleReward;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber == null ? null : jobNumber.trim();
    }

    public Double getProbationBasicWage() {
        return probationBasicWage;
    }

    public void setProbationBasicWage(Double probationBasicWage) {
        this.probationBasicWage = probationBasicWage;
    }

    public Double getProbationDutyAllowance() {
        return probationDutyAllowance;
    }

    public void setProbationDutyAllowance(Double probationDutyAllowance) {
        this.probationDutyAllowance = probationDutyAllowance;
    }

    public Double getProbationProfessionalTitleAllowance() {
        return probationProfessionalTitleAllowance;
    }

    public void setProbationProfessionalTitleAllowance(Double probationProfessionalTitleAllowance) {
        this.probationProfessionalTitleAllowance = probationProfessionalTitleAllowance;
    }

    public Double getProbationSeniorityWage() {
        return probationSeniorityWage;
    }

    public void setProbationSeniorityWage(Double probationSeniorityWage) {
        this.probationSeniorityWage = probationSeniorityWage;
    }

    public Double getProbationEducationAllowance() {
        return probationEducationAllowance;
    }

    public void setProbationEducationAllowance(Double probationEducationAllowance) {
        this.probationEducationAllowance = probationEducationAllowance;
    }

    public Double getProbationWorkSubsidy() {
        return probationWorkSubsidy;
    }

    public void setProbationWorkSubsidy(Double probationWorkSubsidy) {
        this.probationWorkSubsidy = probationWorkSubsidy;
    }

    public Double getProbationAchievementBonus() {
        return probationAchievementBonus;
    }

    public void setProbationAchievementBonus(Double probationAchievementBonus) {
        this.probationAchievementBonus = probationAchievementBonus;
    }

    public BigDecimal getProbationSingleReward() {
        return probationSingleReward;
    }

    public void setProbationSingleReward(BigDecimal probationSingleReward) {
        this.probationSingleReward = probationSingleReward;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount == null ? null : creatorAccount.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount == null ? null : modifierAccount.trim();
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Double getConversionBasicWage() {
        return conversionBasicWage;
    }

    public void setConversionBasicWage(Double conversionBasicWage) {
        this.conversionBasicWage = conversionBasicWage;
    }

    public Double getConversionDutyAllowance() {
        return conversionDutyAllowance;
    }

    public void setConversionDutyAllowance(Double conversionDutyAllowance) {
        this.conversionDutyAllowance = conversionDutyAllowance;
    }

    public Double getConversionProfessionalTitleAllowance() {
        return conversionProfessionalTitleAllowance;
    }

    public void setConversionProfessionalTitleAllowance(Double conversionProfessionalTitleAllowance) {
        this.conversionProfessionalTitleAllowance = conversionProfessionalTitleAllowance;
    }

    public Double getConversionSeniorityWage() {
        return conversionSeniorityWage;
    }

    public void setConversionSeniorityWage(Double conversionSeniorityWage) {
        this.conversionSeniorityWage = conversionSeniorityWage;
    }

    public Double getConversionEducationAllowance() {
        return conversionEducationAllowance;
    }

    public void setConversionEducationAllowance(Double conversionEducationAllowance) {
        this.conversionEducationAllowance = conversionEducationAllowance;
    }

    public Double getConversionWorkSubsidy() {
        return conversionWorkSubsidy;
    }

    public void setConversionWorkSubsidy(Double conversionWorkSubsidy) {
        this.conversionWorkSubsidy = conversionWorkSubsidy;
    }

    public Double getConversionAchievementBonus() {
        return conversionAchievementBonus;
    }

    public void setConversionAchievementBonus(Double conversionAchievementBonus) {
        this.conversionAchievementBonus = conversionAchievementBonus;
    }

    public Double getConversionSingleReward() {
        return conversionSingleReward;
    }

    public void setConversionSingleReward(Double conversionSingleReward) {
        this.conversionSingleReward = conversionSingleReward;
    }

    public String getCurrentBasicWage() {
        return currentBasicWage;
    }

    public void setCurrentBasicWage(String currentBasicWage) {
        this.currentBasicWage = currentBasicWage == null ? null : currentBasicWage.trim();
    }

    public String getCurrentDutyAllowance() {
        return currentDutyAllowance;
    }

    public void setCurrentDutyAllowance(String currentDutyAllowance) {
        this.currentDutyAllowance = currentDutyAllowance == null ? null : currentDutyAllowance.trim();
    }

    public String getCurrentProfessionalTitleAllowance() {
        return currentProfessionalTitleAllowance;
    }

    public void setCurrentProfessionalTitleAllowance(String currentProfessionalTitleAllowance) {
        this.currentProfessionalTitleAllowance = currentProfessionalTitleAllowance == null ? null : currentProfessionalTitleAllowance.trim();
    }

    public String getCurrentSeniorityWage() {
        return currentSeniorityWage;
    }

    public void setCurrentSeniorityWage(String currentSeniorityWage) {
        this.currentSeniorityWage = currentSeniorityWage == null ? null : currentSeniorityWage.trim();
    }

    public String getCurrentEducationAllowance() {
        return currentEducationAllowance;
    }

    public void setCurrentEducationAllowance(String currentEducationAllowance) {
        this.currentEducationAllowance = currentEducationAllowance == null ? null : currentEducationAllowance.trim();
    }

    public String getCurrentWorkSubsidy() {
        return currentWorkSubsidy;
    }

    public void setCurrentWorkSubsidy(String currentWorkSubsidy) {
        this.currentWorkSubsidy = currentWorkSubsidy == null ? null : currentWorkSubsidy.trim();
    }

    public String getCurrentAchievementBonus() {
        return currentAchievementBonus;
    }

    public void setCurrentAchievementBonus(String currentAchievementBonus) {
        this.currentAchievementBonus = currentAchievementBonus == null ? null : currentAchievementBonus.trim();
    }

    public String getCurrentSingleReward() {
        return currentSingleReward;
    }

    public void setCurrentSingleReward(String currentSingleReward) {
        this.currentSingleReward = currentSingleReward == null ? null : currentSingleReward.trim();
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
        TbManpowerSalaryInfo other = (TbManpowerSalaryInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getJobNumber() == null ? other.getJobNumber() == null : this.getJobNumber().equals(other.getJobNumber()))
            && (this.getProbationBasicWage() == null ? other.getProbationBasicWage() == null : this.getProbationBasicWage().equals(other.getProbationBasicWage()))
            && (this.getProbationDutyAllowance() == null ? other.getProbationDutyAllowance() == null : this.getProbationDutyAllowance().equals(other.getProbationDutyAllowance()))
            && (this.getProbationProfessionalTitleAllowance() == null ? other.getProbationProfessionalTitleAllowance() == null : this.getProbationProfessionalTitleAllowance().equals(other.getProbationProfessionalTitleAllowance()))
            && (this.getProbationSeniorityWage() == null ? other.getProbationSeniorityWage() == null : this.getProbationSeniorityWage().equals(other.getProbationSeniorityWage()))
            && (this.getProbationEducationAllowance() == null ? other.getProbationEducationAllowance() == null : this.getProbationEducationAllowance().equals(other.getProbationEducationAllowance()))
            && (this.getProbationWorkSubsidy() == null ? other.getProbationWorkSubsidy() == null : this.getProbationWorkSubsidy().equals(other.getProbationWorkSubsidy()))
            && (this.getProbationAchievementBonus() == null ? other.getProbationAchievementBonus() == null : this.getProbationAchievementBonus().equals(other.getProbationAchievementBonus()))
            && (this.getProbationSingleReward() == null ? other.getProbationSingleReward() == null : this.getProbationSingleReward().equals(other.getProbationSingleReward()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getConversionBasicWage() == null ? other.getConversionBasicWage() == null : this.getConversionBasicWage().equals(other.getConversionBasicWage()))
            && (this.getConversionDutyAllowance() == null ? other.getConversionDutyAllowance() == null : this.getConversionDutyAllowance().equals(other.getConversionDutyAllowance()))
            && (this.getConversionProfessionalTitleAllowance() == null ? other.getConversionProfessionalTitleAllowance() == null : this.getConversionProfessionalTitleAllowance().equals(other.getConversionProfessionalTitleAllowance()))
            && (this.getConversionSeniorityWage() == null ? other.getConversionSeniorityWage() == null : this.getConversionSeniorityWage().equals(other.getConversionSeniorityWage()))
            && (this.getConversionEducationAllowance() == null ? other.getConversionEducationAllowance() == null : this.getConversionEducationAllowance().equals(other.getConversionEducationAllowance()))
            && (this.getConversionWorkSubsidy() == null ? other.getConversionWorkSubsidy() == null : this.getConversionWorkSubsidy().equals(other.getConversionWorkSubsidy()))
            && (this.getConversionAchievementBonus() == null ? other.getConversionAchievementBonus() == null : this.getConversionAchievementBonus().equals(other.getConversionAchievementBonus()))
            && (this.getConversionSingleReward() == null ? other.getConversionSingleReward() == null : this.getConversionSingleReward().equals(other.getConversionSingleReward()))
            && (this.getCurrentBasicWage() == null ? other.getCurrentBasicWage() == null : this.getCurrentBasicWage().equals(other.getCurrentBasicWage()))
            && (this.getCurrentDutyAllowance() == null ? other.getCurrentDutyAllowance() == null : this.getCurrentDutyAllowance().equals(other.getCurrentDutyAllowance()))
            && (this.getCurrentProfessionalTitleAllowance() == null ? other.getCurrentProfessionalTitleAllowance() == null : this.getCurrentProfessionalTitleAllowance().equals(other.getCurrentProfessionalTitleAllowance()))
            && (this.getCurrentSeniorityWage() == null ? other.getCurrentSeniorityWage() == null : this.getCurrentSeniorityWage().equals(other.getCurrentSeniorityWage()))
            && (this.getCurrentEducationAllowance() == null ? other.getCurrentEducationAllowance() == null : this.getCurrentEducationAllowance().equals(other.getCurrentEducationAllowance()))
            && (this.getCurrentWorkSubsidy() == null ? other.getCurrentWorkSubsidy() == null : this.getCurrentWorkSubsidy().equals(other.getCurrentWorkSubsidy()))
            && (this.getCurrentAchievementBonus() == null ? other.getCurrentAchievementBonus() == null : this.getCurrentAchievementBonus().equals(other.getCurrentAchievementBonus()))
            && (this.getCurrentSingleReward() == null ? other.getCurrentSingleReward() == null : this.getCurrentSingleReward().equals(other.getCurrentSingleReward()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getJobNumber() == null) ? 0 : getJobNumber().hashCode());
        result = prime * result + ((getProbationBasicWage() == null) ? 0 : getProbationBasicWage().hashCode());
        result = prime * result + ((getProbationDutyAllowance() == null) ? 0 : getProbationDutyAllowance().hashCode());
        result = prime * result + ((getProbationProfessionalTitleAllowance() == null) ? 0 : getProbationProfessionalTitleAllowance().hashCode());
        result = prime * result + ((getProbationSeniorityWage() == null) ? 0 : getProbationSeniorityWage().hashCode());
        result = prime * result + ((getProbationEducationAllowance() == null) ? 0 : getProbationEducationAllowance().hashCode());
        result = prime * result + ((getProbationWorkSubsidy() == null) ? 0 : getProbationWorkSubsidy().hashCode());
        result = prime * result + ((getProbationAchievementBonus() == null) ? 0 : getProbationAchievementBonus().hashCode());
        result = prime * result + ((getProbationSingleReward() == null) ? 0 : getProbationSingleReward().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getConversionBasicWage() == null) ? 0 : getConversionBasicWage().hashCode());
        result = prime * result + ((getConversionDutyAllowance() == null) ? 0 : getConversionDutyAllowance().hashCode());
        result = prime * result + ((getConversionProfessionalTitleAllowance() == null) ? 0 : getConversionProfessionalTitleAllowance().hashCode());
        result = prime * result + ((getConversionSeniorityWage() == null) ? 0 : getConversionSeniorityWage().hashCode());
        result = prime * result + ((getConversionEducationAllowance() == null) ? 0 : getConversionEducationAllowance().hashCode());
        result = prime * result + ((getConversionWorkSubsidy() == null) ? 0 : getConversionWorkSubsidy().hashCode());
        result = prime * result + ((getConversionAchievementBonus() == null) ? 0 : getConversionAchievementBonus().hashCode());
        result = prime * result + ((getConversionSingleReward() == null) ? 0 : getConversionSingleReward().hashCode());
        result = prime * result + ((getCurrentBasicWage() == null) ? 0 : getCurrentBasicWage().hashCode());
        result = prime * result + ((getCurrentDutyAllowance() == null) ? 0 : getCurrentDutyAllowance().hashCode());
        result = prime * result + ((getCurrentProfessionalTitleAllowance() == null) ? 0 : getCurrentProfessionalTitleAllowance().hashCode());
        result = prime * result + ((getCurrentSeniorityWage() == null) ? 0 : getCurrentSeniorityWage().hashCode());
        result = prime * result + ((getCurrentEducationAllowance() == null) ? 0 : getCurrentEducationAllowance().hashCode());
        result = prime * result + ((getCurrentWorkSubsidy() == null) ? 0 : getCurrentWorkSubsidy().hashCode());
        result = prime * result + ((getCurrentAchievementBonus() == null) ? 0 : getCurrentAchievementBonus().hashCode());
        result = prime * result + ((getCurrentSingleReward() == null) ? 0 : getCurrentSingleReward().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", jobNumber=").append(jobNumber);
        sb.append(", probationBasicWage=").append(probationBasicWage);
        sb.append(", probationDutyAllowance=").append(probationDutyAllowance);
        sb.append(", probationProfessionalTitleAllowance=").append(probationProfessionalTitleAllowance);
        sb.append(", probationSeniorityWage=").append(probationSeniorityWage);
        sb.append(", probationEducationAllowance=").append(probationEducationAllowance);
        sb.append(", probationWorkSubsidy=").append(probationWorkSubsidy);
        sb.append(", probationAchievementBonus=").append(probationAchievementBonus);
        sb.append(", probationSingleReward=").append(probationSingleReward);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", conversionBasicWage=").append(conversionBasicWage);
        sb.append(", conversionDutyAllowance=").append(conversionDutyAllowance);
        sb.append(", conversionProfessionalTitleAllowance=").append(conversionProfessionalTitleAllowance);
        sb.append(", conversionSeniorityWage=").append(conversionSeniorityWage);
        sb.append(", conversionEducationAllowance=").append(conversionEducationAllowance);
        sb.append(", conversionWorkSubsidy=").append(conversionWorkSubsidy);
        sb.append(", conversionAchievementBonus=").append(conversionAchievementBonus);
        sb.append(", conversionSingleReward=").append(conversionSingleReward);
        sb.append(", currentBasicWage=").append(currentBasicWage);
        sb.append(", currentDutyAllowance=").append(currentDutyAllowance);
        sb.append(", currentProfessionalTitleAllowance=").append(currentProfessionalTitleAllowance);
        sb.append(", currentSeniorityWage=").append(currentSeniorityWage);
        sb.append(", currentEducationAllowance=").append(currentEducationAllowance);
        sb.append(", currentWorkSubsidy=").append(currentWorkSubsidy);
        sb.append(", currentAchievementBonus=").append(currentAchievementBonus);
        sb.append(", currentSingleReward=").append(currentSingleReward);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}