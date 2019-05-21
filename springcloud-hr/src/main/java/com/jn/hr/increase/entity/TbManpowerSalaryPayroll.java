package com.jn.hr.increase.entity;

import java.io.Serializable;

public class TbManpowerSalaryPayroll implements Serializable {
    private String id;

    private String name;

    private String jobNumber;

    private String department;

    private Double basicWage;

    private Double seniorityWage;

    private Double technicalAllowance;

    private Double dutyAllowance;

    private Double workSubsidy;

    private Double educationAllowance;

    private Double professionalTitleAllowance;

    private Double specialSubsidy;

    private Double mealSubsidy;

    private Double deserveWage;

    private Double pendingSocialpoolingInsurance;

    private Double pendingProvidentfund;

    private Double pendingPersonalTax;

    private Double canteenMealFee;

    private Double unionFee;

    private Double realWage;

    private String accountEntryTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber == null ? null : jobNumber.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
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

    public Double getTechnicalAllowance() {
        return technicalAllowance;
    }

    public void setTechnicalAllowance(Double technicalAllowance) {
        this.technicalAllowance = technicalAllowance;
    }

    public Double getDutyAllowance() {
        return dutyAllowance;
    }

    public void setDutyAllowance(Double dutyAllowance) {
        this.dutyAllowance = dutyAllowance;
    }

    public Double getWorkSubsidy() {
        return workSubsidy;
    }

    public void setWorkSubsidy(Double workSubsidy) {
        this.workSubsidy = workSubsidy;
    }

    public Double getEducationAllowance() {
        return educationAllowance;
    }

    public void setEducationAllowance(Double educationAllowance) {
        this.educationAllowance = educationAllowance;
    }

    public Double getProfessionalTitleAllowance() {
        return professionalTitleAllowance;
    }

    public void setProfessionalTitleAllowance(Double professionalTitleAllowance) {
        this.professionalTitleAllowance = professionalTitleAllowance;
    }

    public Double getSpecialSubsidy() {
        return specialSubsidy;
    }

    public void setSpecialSubsidy(Double specialSubsidy) {
        this.specialSubsidy = specialSubsidy;
    }

    public Double getMealSubsidy() {
        return mealSubsidy;
    }

    public void setMealSubsidy(Double mealSubsidy) {
        this.mealSubsidy = mealSubsidy;
    }

    public Double getDeserveWage() {
        return deserveWage;
    }

    public void setDeserveWage(Double deserveWage) {
        this.deserveWage = deserveWage;
    }

    public Double getPendingSocialpoolingInsurance() {
        return pendingSocialpoolingInsurance;
    }

    public void setPendingSocialpoolingInsurance(Double pendingSocialpoolingInsurance) {
        this.pendingSocialpoolingInsurance = pendingSocialpoolingInsurance;
    }

    public Double getPendingProvidentfund() {
        return pendingProvidentfund;
    }

    public void setPendingProvidentfund(Double pendingProvidentfund) {
        this.pendingProvidentfund = pendingProvidentfund;
    }

    public Double getPendingPersonalTax() {
        return pendingPersonalTax;
    }

    public void setPendingPersonalTax(Double pendingPersonalTax) {
        this.pendingPersonalTax = pendingPersonalTax;
    }

    public Double getCanteenMealFee() {
        return canteenMealFee;
    }

    public void setCanteenMealFee(Double canteenMealFee) {
        this.canteenMealFee = canteenMealFee;
    }

    public Double getUnionFee() {
        return unionFee;
    }

    public void setUnionFee(Double unionFee) {
        this.unionFee = unionFee;
    }

    public Double getRealWage() {
        return realWage;
    }

    public void setRealWage(Double realWage) {
        this.realWage = realWage;
    }

    public String getAccountEntryTime() {
        return accountEntryTime;
    }

    public void setAccountEntryTime(String accountEntryTime) {
        this.accountEntryTime = accountEntryTime == null ? null : accountEntryTime.trim();
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
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getJobNumber() == null ? other.getJobNumber() == null : this.getJobNumber().equals(other.getJobNumber()))
            && (this.getDepartment() == null ? other.getDepartment() == null : this.getDepartment().equals(other.getDepartment()))
            && (this.getBasicWage() == null ? other.getBasicWage() == null : this.getBasicWage().equals(other.getBasicWage()))
            && (this.getSeniorityWage() == null ? other.getSeniorityWage() == null : this.getSeniorityWage().equals(other.getSeniorityWage()))
            && (this.getTechnicalAllowance() == null ? other.getTechnicalAllowance() == null : this.getTechnicalAllowance().equals(other.getTechnicalAllowance()))
            && (this.getDutyAllowance() == null ? other.getDutyAllowance() == null : this.getDutyAllowance().equals(other.getDutyAllowance()))
            && (this.getWorkSubsidy() == null ? other.getWorkSubsidy() == null : this.getWorkSubsidy().equals(other.getWorkSubsidy()))
            && (this.getEducationAllowance() == null ? other.getEducationAllowance() == null : this.getEducationAllowance().equals(other.getEducationAllowance()))
            && (this.getProfessionalTitleAllowance() == null ? other.getProfessionalTitleAllowance() == null : this.getProfessionalTitleAllowance().equals(other.getProfessionalTitleAllowance()))
            && (this.getSpecialSubsidy() == null ? other.getSpecialSubsidy() == null : this.getSpecialSubsidy().equals(other.getSpecialSubsidy()))
            && (this.getMealSubsidy() == null ? other.getMealSubsidy() == null : this.getMealSubsidy().equals(other.getMealSubsidy()))
            && (this.getDeserveWage() == null ? other.getDeserveWage() == null : this.getDeserveWage().equals(other.getDeserveWage()))
            && (this.getPendingSocialpoolingInsurance() == null ? other.getPendingSocialpoolingInsurance() == null : this.getPendingSocialpoolingInsurance().equals(other.getPendingSocialpoolingInsurance()))
            && (this.getPendingProvidentfund() == null ? other.getPendingProvidentfund() == null : this.getPendingProvidentfund().equals(other.getPendingProvidentfund()))
            && (this.getPendingPersonalTax() == null ? other.getPendingPersonalTax() == null : this.getPendingPersonalTax().equals(other.getPendingPersonalTax()))
            && (this.getCanteenMealFee() == null ? other.getCanteenMealFee() == null : this.getCanteenMealFee().equals(other.getCanteenMealFee()))
            && (this.getUnionFee() == null ? other.getUnionFee() == null : this.getUnionFee().equals(other.getUnionFee()))
            && (this.getRealWage() == null ? other.getRealWage() == null : this.getRealWage().equals(other.getRealWage()))
            && (this.getAccountEntryTime() == null ? other.getAccountEntryTime() == null : this.getAccountEntryTime().equals(other.getAccountEntryTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getJobNumber() == null) ? 0 : getJobNumber().hashCode());
        result = prime * result + ((getDepartment() == null) ? 0 : getDepartment().hashCode());
        result = prime * result + ((getBasicWage() == null) ? 0 : getBasicWage().hashCode());
        result = prime * result + ((getSeniorityWage() == null) ? 0 : getSeniorityWage().hashCode());
        result = prime * result + ((getTechnicalAllowance() == null) ? 0 : getTechnicalAllowance().hashCode());
        result = prime * result + ((getDutyAllowance() == null) ? 0 : getDutyAllowance().hashCode());
        result = prime * result + ((getWorkSubsidy() == null) ? 0 : getWorkSubsidy().hashCode());
        result = prime * result + ((getEducationAllowance() == null) ? 0 : getEducationAllowance().hashCode());
        result = prime * result + ((getProfessionalTitleAllowance() == null) ? 0 : getProfessionalTitleAllowance().hashCode());
        result = prime * result + ((getSpecialSubsidy() == null) ? 0 : getSpecialSubsidy().hashCode());
        result = prime * result + ((getMealSubsidy() == null) ? 0 : getMealSubsidy().hashCode());
        result = prime * result + ((getDeserveWage() == null) ? 0 : getDeserveWage().hashCode());
        result = prime * result + ((getPendingSocialpoolingInsurance() == null) ? 0 : getPendingSocialpoolingInsurance().hashCode());
        result = prime * result + ((getPendingProvidentfund() == null) ? 0 : getPendingProvidentfund().hashCode());
        result = prime * result + ((getPendingPersonalTax() == null) ? 0 : getPendingPersonalTax().hashCode());
        result = prime * result + ((getCanteenMealFee() == null) ? 0 : getCanteenMealFee().hashCode());
        result = prime * result + ((getUnionFee() == null) ? 0 : getUnionFee().hashCode());
        result = prime * result + ((getRealWage() == null) ? 0 : getRealWage().hashCode());
        result = prime * result + ((getAccountEntryTime() == null) ? 0 : getAccountEntryTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", jobNumber=").append(jobNumber);
        sb.append(", department=").append(department);
        sb.append(", basicWage=").append(basicWage);
        sb.append(", seniorityWage=").append(seniorityWage);
        sb.append(", technicalAllowance=").append(technicalAllowance);
        sb.append(", dutyAllowance=").append(dutyAllowance);
        sb.append(", workSubsidy=").append(workSubsidy);
        sb.append(", educationAllowance=").append(educationAllowance);
        sb.append(", professionalTitleAllowance=").append(professionalTitleAllowance);
        sb.append(", specialSubsidy=").append(specialSubsidy);
        sb.append(", mealSubsidy=").append(mealSubsidy);
        sb.append(", deserveWage=").append(deserveWage);
        sb.append(", pendingSocialpoolingInsurance=").append(pendingSocialpoolingInsurance);
        sb.append(", pendingProvidentfund=").append(pendingProvidentfund);
        sb.append(", pendingPersonalTax=").append(pendingPersonalTax);
        sb.append(", canteenMealFee=").append(canteenMealFee);
        sb.append(", unionFee=").append(unionFee);
        sb.append(", realWage=").append(realWage);
        sb.append(", accountEntryTime=").append(accountEntryTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}