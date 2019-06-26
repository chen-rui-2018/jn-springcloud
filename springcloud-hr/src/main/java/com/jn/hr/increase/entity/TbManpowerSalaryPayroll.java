package com.jn.hr.increase.entity;

import java.io.Serializable;
import java.util.Date;

public class TbManpowerSalaryPayroll implements Serializable {
    private String id;

    private String serialNumber;

    private String issuingUnit;

    private String name;

    private String department;

    private String idCard;

    private String personnelCategory;

    private Double deserveWage;

    private Double basicWage;

    private Double seniorityWage;

    private Double professionalTitleAllowance;

    private Double technicalAllowance;

    private Double educationAllowance;

    private Double workAllowance;

    private Double dutyAllowance;

    private Double specialSubsidy;

    private Double jobAllowance;

    private Double compositeSubsidy;

    private Double basicWageTotal;

    private Double seasonBonus;

    private Double yearEndBonus;

    private Double salaryTotal;

    private Double workExcitation;

    private Double overtimeCost;

    private Double onDutyCost;

    private Double overtimeTotal;

    private Double businessCarSubsidy;

    private Double siteOvertimeSubsidy;

    private Double walkDoorBouns;

    private Double demolitionSubsidy;

    private Double demolitionSubsidyTotal;

    private Double delayCost;

    private Double rewardWage;

    private Double otherOneTotal;

    private Double otherWage;

    private Double deserveWageTotal;

    private Double pensionWage;

    private Double unemploymentWage;

    private Double medicalWage;

    private Double majorIllnessWage;

    private Double personalSocialSecurityWagetotal;

    private Double unitSocietyWage;

    private Double providentFund;

    private Double unitProvidentFund;

    private Double unionFee;

    private Double mealFee;

    private Double leaveFee;

    private Double sickLeaveFee;

    private Double penaltyFee;

    private Double deductionOneWageTotal;

    private Double deductionOne;

    private Double deductionTwo;

    private Double deductionTwoWageTotal;

    private Double pendingPersonalTax;

    private Double realWage;

    private Double depositPersonalAccount;

    private String accountEntryTime;

    private String creatorAccount;

    private Date createdTime;

    private String modifierAccount;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getIssuingUnit() {
        return issuingUnit;
    }

    public void setIssuingUnit(String issuingUnit) {
        this.issuingUnit = issuingUnit == null ? null : issuingUnit.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getPersonnelCategory() {
        return personnelCategory;
    }

    public void setPersonnelCategory(String personnelCategory) {
        this.personnelCategory = personnelCategory == null ? null : personnelCategory.trim();
    }

    public Double getDeserveWage() {
        return deserveWage;
    }

    public void setDeserveWage(Double deserveWage) {
        this.deserveWage = deserveWage;
    }

    public Double getBasicWage() {
        return basicWage;
    }

    public void setBasicWage(Double basicWage) {
        this.basicWage = basicWage;
    }

    public Double getSeniorityWage() {
        return seniorityWage;
    }

    public void setSeniorityWage(Double seniorityWage) {
        this.seniorityWage = seniorityWage;
    }

    public Double getProfessionalTitleAllowance() {
        return professionalTitleAllowance;
    }

    public void setProfessionalTitleAllowance(Double professionalTitleAllowance) {
        this.professionalTitleAllowance = professionalTitleAllowance;
    }

    public Double getTechnicalAllowance() {
        return technicalAllowance;
    }

    public void setTechnicalAllowance(Double technicalAllowance) {
        this.technicalAllowance = technicalAllowance;
    }

    public Double getEducationAllowance() {
        return educationAllowance;
    }

    public void setEducationAllowance(Double educationAllowance) {
        this.educationAllowance = educationAllowance;
    }

    public Double getWorkAllowance() {
        return workAllowance;
    }

    public void setWorkAllowance(Double workAllowance) {
        this.workAllowance = workAllowance;
    }

    public Double getDutyAllowance() {
        return dutyAllowance;
    }

    public void setDutyAllowance(Double dutyAllowance) {
        this.dutyAllowance = dutyAllowance;
    }

    public Double getSpecialSubsidy() {
        return specialSubsidy;
    }

    public void setSpecialSubsidy(Double specialSubsidy) {
        this.specialSubsidy = specialSubsidy;
    }

    public Double getJobAllowance() {
        return jobAllowance;
    }

    public void setJobAllowance(Double jobAllowance) {
        this.jobAllowance = jobAllowance;
    }

    public Double getCompositeSubsidy() {
        return compositeSubsidy;
    }

    public void setCompositeSubsidy(Double compositeSubsidy) {
        this.compositeSubsidy = compositeSubsidy;
    }

    public Double getBasicWageTotal() {
        return basicWageTotal;
    }

    public void setBasicWageTotal(Double basicWageTotal) {
        this.basicWageTotal = basicWageTotal;
    }

    public Double getSeasonBonus() {
        return seasonBonus;
    }

    public void setSeasonBonus(Double seasonBonus) {
        this.seasonBonus = seasonBonus;
    }

    public Double getYearEndBonus() {
        return yearEndBonus;
    }

    public void setYearEndBonus(Double yearEndBonus) {
        this.yearEndBonus = yearEndBonus;
    }

    public Double getSalaryTotal() {
        return salaryTotal;
    }

    public void setSalaryTotal(Double salaryTotal) {
        this.salaryTotal = salaryTotal;
    }

    public Double getWorkExcitation() {
        return workExcitation;
    }

    public void setWorkExcitation(Double workExcitation) {
        this.workExcitation = workExcitation;
    }

    public Double getOvertimeCost() {
        return overtimeCost;
    }

    public void setOvertimeCost(Double overtimeCost) {
        this.overtimeCost = overtimeCost;
    }

    public Double getOnDutyCost() {
        return onDutyCost;
    }

    public void setOnDutyCost(Double onDutyCost) {
        this.onDutyCost = onDutyCost;
    }

    public Double getOvertimeTotal() {
        return overtimeTotal;
    }

    public void setOvertimeTotal(Double overtimeTotal) {
        this.overtimeTotal = overtimeTotal;
    }

    public Double getBusinessCarSubsidy() {
        return businessCarSubsidy;
    }

    public void setBusinessCarSubsidy(Double businessCarSubsidy) {
        this.businessCarSubsidy = businessCarSubsidy;
    }

    public Double getSiteOvertimeSubsidy() {
        return siteOvertimeSubsidy;
    }

    public void setSiteOvertimeSubsidy(Double siteOvertimeSubsidy) {
        this.siteOvertimeSubsidy = siteOvertimeSubsidy;
    }

    public Double getWalkDoorBouns() {
        return walkDoorBouns;
    }

    public void setWalkDoorBouns(Double walkDoorBouns) {
        this.walkDoorBouns = walkDoorBouns;
    }

    public Double getDemolitionSubsidy() {
        return demolitionSubsidy;
    }

    public void setDemolitionSubsidy(Double demolitionSubsidy) {
        this.demolitionSubsidy = demolitionSubsidy;
    }

    public Double getDemolitionSubsidyTotal() {
        return demolitionSubsidyTotal;
    }

    public void setDemolitionSubsidyTotal(Double demolitionSubsidyTotal) {
        this.demolitionSubsidyTotal = demolitionSubsidyTotal;
    }

    public Double getDelayCost() {
        return delayCost;
    }

    public void setDelayCost(Double delayCost) {
        this.delayCost = delayCost;
    }

    public Double getRewardWage() {
        return rewardWage;
    }

    public void setRewardWage(Double rewardWage) {
        this.rewardWage = rewardWage;
    }

    public Double getOtherOneTotal() {
        return otherOneTotal;
    }

    public void setOtherOneTotal(Double otherOneTotal) {
        this.otherOneTotal = otherOneTotal;
    }

    public Double getOtherWage() {
        return otherWage;
    }

    public void setOtherWage(Double otherWage) {
        this.otherWage = otherWage;
    }

    public Double getDeserveWageTotal() {
        return deserveWageTotal;
    }

    public void setDeserveWageTotal(Double deserveWageTotal) {
        this.deserveWageTotal = deserveWageTotal;
    }

    public Double getPensionWage() {
        return pensionWage;
    }

    public void setPensionWage(Double pensionWage) {
        this.pensionWage = pensionWage;
    }

    public Double getUnemploymentWage() {
        return unemploymentWage;
    }

    public void setUnemploymentWage(Double unemploymentWage) {
        this.unemploymentWage = unemploymentWage;
    }

    public Double getMedicalWage() {
        return medicalWage;
    }

    public void setMedicalWage(Double medicalWage) {
        this.medicalWage = medicalWage;
    }

    public Double getMajorIllnessWage() {
        return majorIllnessWage;
    }

    public void setMajorIllnessWage(Double majorIllnessWage) {
        this.majorIllnessWage = majorIllnessWage;
    }

    public Double getPersonalSocialSecurityWagetotal() {
        return personalSocialSecurityWagetotal;
    }

    public void setPersonalSocialSecurityWagetotal(Double personalSocialSecurityWagetotal) {
        this.personalSocialSecurityWagetotal = personalSocialSecurityWagetotal;
    }

    public Double getUnitSocietyWage() {
        return unitSocietyWage;
    }

    public void setUnitSocietyWage(Double unitSocietyWage) {
        this.unitSocietyWage = unitSocietyWage;
    }

    public Double getProvidentFund() {
        return providentFund;
    }

    public void setProvidentFund(Double providentFund) {
        this.providentFund = providentFund;
    }

    public Double getUnitProvidentFund() {
        return unitProvidentFund;
    }

    public void setUnitProvidentFund(Double unitProvidentFund) {
        this.unitProvidentFund = unitProvidentFund;
    }

    public Double getUnionFee() {
        return unionFee;
    }

    public void setUnionFee(Double unionFee) {
        this.unionFee = unionFee;
    }

    public Double getMealFee() {
        return mealFee;
    }

    public void setMealFee(Double mealFee) {
        this.mealFee = mealFee;
    }

    public Double getLeaveFee() {
        return leaveFee;
    }

    public void setLeaveFee(Double leaveFee) {
        this.leaveFee = leaveFee;
    }

    public Double getSickLeaveFee() {
        return sickLeaveFee;
    }

    public void setSickLeaveFee(Double sickLeaveFee) {
        this.sickLeaveFee = sickLeaveFee;
    }

    public Double getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(Double penaltyFee) {
        this.penaltyFee = penaltyFee;
    }

    public Double getDeductionOneWageTotal() {
        return deductionOneWageTotal;
    }

    public void setDeductionOneWageTotal(Double deductionOneWageTotal) {
        this.deductionOneWageTotal = deductionOneWageTotal;
    }

    public Double getDeductionOne() {
        return deductionOne;
    }

    public void setDeductionOne(Double deductionOne) {
        this.deductionOne = deductionOne;
    }

    public Double getDeductionTwo() {
        return deductionTwo;
    }

    public void setDeductionTwo(Double deductionTwo) {
        this.deductionTwo = deductionTwo;
    }

    public Double getDeductionTwoWageTotal() {
        return deductionTwoWageTotal;
    }

    public void setDeductionTwoWageTotal(Double deductionTwoWageTotal) {
        this.deductionTwoWageTotal = deductionTwoWageTotal;
    }

    public Double getPendingPersonalTax() {
        return pendingPersonalTax;
    }

    public void setPendingPersonalTax(Double pendingPersonalTax) {
        this.pendingPersonalTax = pendingPersonalTax;
    }

    public Double getRealWage() {
        return realWage;
    }

    public void setRealWage(Double realWage) {
        this.realWage = realWage;
    }

    public Double getDepositPersonalAccount() {
        return depositPersonalAccount;
    }

    public void setDepositPersonalAccount(Double depositPersonalAccount) {
        this.depositPersonalAccount = depositPersonalAccount;
    }

    public String getAccountEntryTime() {
        return accountEntryTime;
    }

    public void setAccountEntryTime(String accountEntryTime) {
        this.accountEntryTime = accountEntryTime == null ? null : accountEntryTime.trim();
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
        TbManpowerSalaryPayroll other = (TbManpowerSalaryPayroll) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSerialNumber() == null ? other.getSerialNumber() == null : this.getSerialNumber().equals(other.getSerialNumber()))
            && (this.getIssuingUnit() == null ? other.getIssuingUnit() == null : this.getIssuingUnit().equals(other.getIssuingUnit()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getDepartment() == null ? other.getDepartment() == null : this.getDepartment().equals(other.getDepartment()))
            && (this.getIdCard() == null ? other.getIdCard() == null : this.getIdCard().equals(other.getIdCard()))
            && (this.getPersonnelCategory() == null ? other.getPersonnelCategory() == null : this.getPersonnelCategory().equals(other.getPersonnelCategory()))
            && (this.getDeserveWage() == null ? other.getDeserveWage() == null : this.getDeserveWage().equals(other.getDeserveWage()))
            && (this.getBasicWage() == null ? other.getBasicWage() == null : this.getBasicWage().equals(other.getBasicWage()))
            && (this.getSeniorityWage() == null ? other.getSeniorityWage() == null : this.getSeniorityWage().equals(other.getSeniorityWage()))
            && (this.getProfessionalTitleAllowance() == null ? other.getProfessionalTitleAllowance() == null : this.getProfessionalTitleAllowance().equals(other.getProfessionalTitleAllowance()))
            && (this.getTechnicalAllowance() == null ? other.getTechnicalAllowance() == null : this.getTechnicalAllowance().equals(other.getTechnicalAllowance()))
            && (this.getEducationAllowance() == null ? other.getEducationAllowance() == null : this.getEducationAllowance().equals(other.getEducationAllowance()))
            && (this.getWorkAllowance() == null ? other.getWorkAllowance() == null : this.getWorkAllowance().equals(other.getWorkAllowance()))
            && (this.getDutyAllowance() == null ? other.getDutyAllowance() == null : this.getDutyAllowance().equals(other.getDutyAllowance()))
            && (this.getSpecialSubsidy() == null ? other.getSpecialSubsidy() == null : this.getSpecialSubsidy().equals(other.getSpecialSubsidy()))
            && (this.getJobAllowance() == null ? other.getJobAllowance() == null : this.getJobAllowance().equals(other.getJobAllowance()))
            && (this.getCompositeSubsidy() == null ? other.getCompositeSubsidy() == null : this.getCompositeSubsidy().equals(other.getCompositeSubsidy()))
            && (this.getBasicWageTotal() == null ? other.getBasicWageTotal() == null : this.getBasicWageTotal().equals(other.getBasicWageTotal()))
            && (this.getSeasonBonus() == null ? other.getSeasonBonus() == null : this.getSeasonBonus().equals(other.getSeasonBonus()))
            && (this.getYearEndBonus() == null ? other.getYearEndBonus() == null : this.getYearEndBonus().equals(other.getYearEndBonus()))
            && (this.getSalaryTotal() == null ? other.getSalaryTotal() == null : this.getSalaryTotal().equals(other.getSalaryTotal()))
            && (this.getWorkExcitation() == null ? other.getWorkExcitation() == null : this.getWorkExcitation().equals(other.getWorkExcitation()))
            && (this.getOvertimeCost() == null ? other.getOvertimeCost() == null : this.getOvertimeCost().equals(other.getOvertimeCost()))
            && (this.getOnDutyCost() == null ? other.getOnDutyCost() == null : this.getOnDutyCost().equals(other.getOnDutyCost()))
            && (this.getOvertimeTotal() == null ? other.getOvertimeTotal() == null : this.getOvertimeTotal().equals(other.getOvertimeTotal()))
            && (this.getBusinessCarSubsidy() == null ? other.getBusinessCarSubsidy() == null : this.getBusinessCarSubsidy().equals(other.getBusinessCarSubsidy()))
            && (this.getSiteOvertimeSubsidy() == null ? other.getSiteOvertimeSubsidy() == null : this.getSiteOvertimeSubsidy().equals(other.getSiteOvertimeSubsidy()))
            && (this.getWalkDoorBouns() == null ? other.getWalkDoorBouns() == null : this.getWalkDoorBouns().equals(other.getWalkDoorBouns()))
            && (this.getDemolitionSubsidy() == null ? other.getDemolitionSubsidy() == null : this.getDemolitionSubsidy().equals(other.getDemolitionSubsidy()))
            && (this.getDemolitionSubsidyTotal() == null ? other.getDemolitionSubsidyTotal() == null : this.getDemolitionSubsidyTotal().equals(other.getDemolitionSubsidyTotal()))
            && (this.getDelayCost() == null ? other.getDelayCost() == null : this.getDelayCost().equals(other.getDelayCost()))
            && (this.getRewardWage() == null ? other.getRewardWage() == null : this.getRewardWage().equals(other.getRewardWage()))
            && (this.getOtherOneTotal() == null ? other.getOtherOneTotal() == null : this.getOtherOneTotal().equals(other.getOtherOneTotal()))
            && (this.getOtherWage() == null ? other.getOtherWage() == null : this.getOtherWage().equals(other.getOtherWage()))
            && (this.getDeserveWageTotal() == null ? other.getDeserveWageTotal() == null : this.getDeserveWageTotal().equals(other.getDeserveWageTotal()))
            && (this.getPensionWage() == null ? other.getPensionWage() == null : this.getPensionWage().equals(other.getPensionWage()))
            && (this.getUnemploymentWage() == null ? other.getUnemploymentWage() == null : this.getUnemploymentWage().equals(other.getUnemploymentWage()))
            && (this.getMedicalWage() == null ? other.getMedicalWage() == null : this.getMedicalWage().equals(other.getMedicalWage()))
            && (this.getMajorIllnessWage() == null ? other.getMajorIllnessWage() == null : this.getMajorIllnessWage().equals(other.getMajorIllnessWage()))
            && (this.getPersonalSocialSecurityWagetotal() == null ? other.getPersonalSocialSecurityWagetotal() == null : this.getPersonalSocialSecurityWagetotal().equals(other.getPersonalSocialSecurityWagetotal()))
            && (this.getUnitSocietyWage() == null ? other.getUnitSocietyWage() == null : this.getUnitSocietyWage().equals(other.getUnitSocietyWage()))
            && (this.getProvidentFund() == null ? other.getProvidentFund() == null : this.getProvidentFund().equals(other.getProvidentFund()))
            && (this.getUnitProvidentFund() == null ? other.getUnitProvidentFund() == null : this.getUnitProvidentFund().equals(other.getUnitProvidentFund()))
            && (this.getUnionFee() == null ? other.getUnionFee() == null : this.getUnionFee().equals(other.getUnionFee()))
            && (this.getMealFee() == null ? other.getMealFee() == null : this.getMealFee().equals(other.getMealFee()))
            && (this.getLeaveFee() == null ? other.getLeaveFee() == null : this.getLeaveFee().equals(other.getLeaveFee()))
            && (this.getSickLeaveFee() == null ? other.getSickLeaveFee() == null : this.getSickLeaveFee().equals(other.getSickLeaveFee()))
            && (this.getPenaltyFee() == null ? other.getPenaltyFee() == null : this.getPenaltyFee().equals(other.getPenaltyFee()))
            && (this.getDeductionOneWageTotal() == null ? other.getDeductionOneWageTotal() == null : this.getDeductionOneWageTotal().equals(other.getDeductionOneWageTotal()))
            && (this.getDeductionOne() == null ? other.getDeductionOne() == null : this.getDeductionOne().equals(other.getDeductionOne()))
            && (this.getDeductionTwo() == null ? other.getDeductionTwo() == null : this.getDeductionTwo().equals(other.getDeductionTwo()))
            && (this.getDeductionTwoWageTotal() == null ? other.getDeductionTwoWageTotal() == null : this.getDeductionTwoWageTotal().equals(other.getDeductionTwoWageTotal()))
            && (this.getPendingPersonalTax() == null ? other.getPendingPersonalTax() == null : this.getPendingPersonalTax().equals(other.getPendingPersonalTax()))
            && (this.getRealWage() == null ? other.getRealWage() == null : this.getRealWage().equals(other.getRealWage()))
            && (this.getDepositPersonalAccount() == null ? other.getDepositPersonalAccount() == null : this.getDepositPersonalAccount().equals(other.getDepositPersonalAccount()))
            && (this.getAccountEntryTime() == null ? other.getAccountEntryTime() == null : this.getAccountEntryTime().equals(other.getAccountEntryTime()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSerialNumber() == null) ? 0 : getSerialNumber().hashCode());
        result = prime * result + ((getIssuingUnit() == null) ? 0 : getIssuingUnit().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDepartment() == null) ? 0 : getDepartment().hashCode());
        result = prime * result + ((getIdCard() == null) ? 0 : getIdCard().hashCode());
        result = prime * result + ((getPersonnelCategory() == null) ? 0 : getPersonnelCategory().hashCode());
        result = prime * result + ((getDeserveWage() == null) ? 0 : getDeserveWage().hashCode());
        result = prime * result + ((getBasicWage() == null) ? 0 : getBasicWage().hashCode());
        result = prime * result + ((getSeniorityWage() == null) ? 0 : getSeniorityWage().hashCode());
        result = prime * result + ((getProfessionalTitleAllowance() == null) ? 0 : getProfessionalTitleAllowance().hashCode());
        result = prime * result + ((getTechnicalAllowance() == null) ? 0 : getTechnicalAllowance().hashCode());
        result = prime * result + ((getEducationAllowance() == null) ? 0 : getEducationAllowance().hashCode());
        result = prime * result + ((getWorkAllowance() == null) ? 0 : getWorkAllowance().hashCode());
        result = prime * result + ((getDutyAllowance() == null) ? 0 : getDutyAllowance().hashCode());
        result = prime * result + ((getSpecialSubsidy() == null) ? 0 : getSpecialSubsidy().hashCode());
        result = prime * result + ((getJobAllowance() == null) ? 0 : getJobAllowance().hashCode());
        result = prime * result + ((getCompositeSubsidy() == null) ? 0 : getCompositeSubsidy().hashCode());
        result = prime * result + ((getBasicWageTotal() == null) ? 0 : getBasicWageTotal().hashCode());
        result = prime * result + ((getSeasonBonus() == null) ? 0 : getSeasonBonus().hashCode());
        result = prime * result + ((getYearEndBonus() == null) ? 0 : getYearEndBonus().hashCode());
        result = prime * result + ((getSalaryTotal() == null) ? 0 : getSalaryTotal().hashCode());
        result = prime * result + ((getWorkExcitation() == null) ? 0 : getWorkExcitation().hashCode());
        result = prime * result + ((getOvertimeCost() == null) ? 0 : getOvertimeCost().hashCode());
        result = prime * result + ((getOnDutyCost() == null) ? 0 : getOnDutyCost().hashCode());
        result = prime * result + ((getOvertimeTotal() == null) ? 0 : getOvertimeTotal().hashCode());
        result = prime * result + ((getBusinessCarSubsidy() == null) ? 0 : getBusinessCarSubsidy().hashCode());
        result = prime * result + ((getSiteOvertimeSubsidy() == null) ? 0 : getSiteOvertimeSubsidy().hashCode());
        result = prime * result + ((getWalkDoorBouns() == null) ? 0 : getWalkDoorBouns().hashCode());
        result = prime * result + ((getDemolitionSubsidy() == null) ? 0 : getDemolitionSubsidy().hashCode());
        result = prime * result + ((getDemolitionSubsidyTotal() == null) ? 0 : getDemolitionSubsidyTotal().hashCode());
        result = prime * result + ((getDelayCost() == null) ? 0 : getDelayCost().hashCode());
        result = prime * result + ((getRewardWage() == null) ? 0 : getRewardWage().hashCode());
        result = prime * result + ((getOtherOneTotal() == null) ? 0 : getOtherOneTotal().hashCode());
        result = prime * result + ((getOtherWage() == null) ? 0 : getOtherWage().hashCode());
        result = prime * result + ((getDeserveWageTotal() == null) ? 0 : getDeserveWageTotal().hashCode());
        result = prime * result + ((getPensionWage() == null) ? 0 : getPensionWage().hashCode());
        result = prime * result + ((getUnemploymentWage() == null) ? 0 : getUnemploymentWage().hashCode());
        result = prime * result + ((getMedicalWage() == null) ? 0 : getMedicalWage().hashCode());
        result = prime * result + ((getMajorIllnessWage() == null) ? 0 : getMajorIllnessWage().hashCode());
        result = prime * result + ((getPersonalSocialSecurityWagetotal() == null) ? 0 : getPersonalSocialSecurityWagetotal().hashCode());
        result = prime * result + ((getUnitSocietyWage() == null) ? 0 : getUnitSocietyWage().hashCode());
        result = prime * result + ((getProvidentFund() == null) ? 0 : getProvidentFund().hashCode());
        result = prime * result + ((getUnitProvidentFund() == null) ? 0 : getUnitProvidentFund().hashCode());
        result = prime * result + ((getUnionFee() == null) ? 0 : getUnionFee().hashCode());
        result = prime * result + ((getMealFee() == null) ? 0 : getMealFee().hashCode());
        result = prime * result + ((getLeaveFee() == null) ? 0 : getLeaveFee().hashCode());
        result = prime * result + ((getSickLeaveFee() == null) ? 0 : getSickLeaveFee().hashCode());
        result = prime * result + ((getPenaltyFee() == null) ? 0 : getPenaltyFee().hashCode());
        result = prime * result + ((getDeductionOneWageTotal() == null) ? 0 : getDeductionOneWageTotal().hashCode());
        result = prime * result + ((getDeductionOne() == null) ? 0 : getDeductionOne().hashCode());
        result = prime * result + ((getDeductionTwo() == null) ? 0 : getDeductionTwo().hashCode());
        result = prime * result + ((getDeductionTwoWageTotal() == null) ? 0 : getDeductionTwoWageTotal().hashCode());
        result = prime * result + ((getPendingPersonalTax() == null) ? 0 : getPendingPersonalTax().hashCode());
        result = prime * result + ((getRealWage() == null) ? 0 : getRealWage().hashCode());
        result = prime * result + ((getDepositPersonalAccount() == null) ? 0 : getDepositPersonalAccount().hashCode());
        result = prime * result + ((getAccountEntryTime() == null) ? 0 : getAccountEntryTime().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", serialNumber=").append(serialNumber);
        sb.append(", issuingUnit=").append(issuingUnit);
        sb.append(", name=").append(name);
        sb.append(", department=").append(department);
        sb.append(", idCard=").append(idCard);
        sb.append(", personnelCategory=").append(personnelCategory);
        sb.append(", deserveWage=").append(deserveWage);
        sb.append(", basicWage=").append(basicWage);
        sb.append(", seniorityWage=").append(seniorityWage);
        sb.append(", professionalTitleAllowance=").append(professionalTitleAllowance);
        sb.append(", technicalAllowance=").append(technicalAllowance);
        sb.append(", educationAllowance=").append(educationAllowance);
        sb.append(", workAllowance=").append(workAllowance);
        sb.append(", dutyAllowance=").append(dutyAllowance);
        sb.append(", specialSubsidy=").append(specialSubsidy);
        sb.append(", jobAllowance=").append(jobAllowance);
        sb.append(", compositeSubsidy=").append(compositeSubsidy);
        sb.append(", basicWageTotal=").append(basicWageTotal);
        sb.append(", seasonBonus=").append(seasonBonus);
        sb.append(", yearEndBonus=").append(yearEndBonus);
        sb.append(", salaryTotal=").append(salaryTotal);
        sb.append(", workExcitation=").append(workExcitation);
        sb.append(", overtimeCost=").append(overtimeCost);
        sb.append(", onDutyCost=").append(onDutyCost);
        sb.append(", overtimeTotal=").append(overtimeTotal);
        sb.append(", businessCarSubsidy=").append(businessCarSubsidy);
        sb.append(", siteOvertimeSubsidy=").append(siteOvertimeSubsidy);
        sb.append(", walkDoorBouns=").append(walkDoorBouns);
        sb.append(", demolitionSubsidy=").append(demolitionSubsidy);
        sb.append(", demolitionSubsidyTotal=").append(demolitionSubsidyTotal);
        sb.append(", delayCost=").append(delayCost);
        sb.append(", rewardWage=").append(rewardWage);
        sb.append(", otherOneTotal=").append(otherOneTotal);
        sb.append(", otherWage=").append(otherWage);
        sb.append(", deserveWageTotal=").append(deserveWageTotal);
        sb.append(", pensionWage=").append(pensionWage);
        sb.append(", unemploymentWage=").append(unemploymentWage);
        sb.append(", medicalWage=").append(medicalWage);
        sb.append(", majorIllnessWage=").append(majorIllnessWage);
        sb.append(", personalSocialSecurityWagetotal=").append(personalSocialSecurityWagetotal);
        sb.append(", unitSocietyWage=").append(unitSocietyWage);
        sb.append(", providentFund=").append(providentFund);
        sb.append(", unitProvidentFund=").append(unitProvidentFund);
        sb.append(", unionFee=").append(unionFee);
        sb.append(", mealFee=").append(mealFee);
        sb.append(", leaveFee=").append(leaveFee);
        sb.append(", sickLeaveFee=").append(sickLeaveFee);
        sb.append(", penaltyFee=").append(penaltyFee);
        sb.append(", deductionOneWageTotal=").append(deductionOneWageTotal);
        sb.append(", deductionOne=").append(deductionOne);
        sb.append(", deductionTwo=").append(deductionTwo);
        sb.append(", deductionTwoWageTotal=").append(deductionTwoWageTotal);
        sb.append(", pendingPersonalTax=").append(pendingPersonalTax);
        sb.append(", realWage=").append(realWage);
        sb.append(", depositPersonalAccount=").append(depositPersonalAccount);
        sb.append(", accountEntryTime=").append(accountEntryTime);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}