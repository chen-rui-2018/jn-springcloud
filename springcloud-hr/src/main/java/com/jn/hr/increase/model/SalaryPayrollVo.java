package com.jn.hr.increase.model;

import java.io.Serializable;

import com.alibaba.excel.metadata.BaseRowModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SalaryPayrollPage", description = "工资条实体")
public class SalaryPayrollVo extends BaseRowModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4812412109064703025L;

	@ApiModelProperty(value = "id")
	private String id;

	@ApiModelProperty(value = "姓名")
    private String name;

	@ApiModelProperty(value = "工号")
	private String jobNumber;

	@ApiModelProperty(value = "部门")
    private String department;
	
	@ApiModelProperty(value = "工资档次及金额")
    private Double basicWage;

	@ApiModelProperty(value = "园区工龄工资")
    private Double seniorityWage;

	@ApiModelProperty(value = "技术岗位津贴")
    private Double technicalAllowance;

	@ApiModelProperty(value = "职务津贴")
    private Double dutyAllowance;

	@ApiModelProperty(value = "工作性补贴")
    private Double workSubsidy;

	@ApiModelProperty(value = "学历津贴")
    private Double educationAllowance;

	@ApiModelProperty(value = "职称津贴")
    private Double professionalTitleAllowance;

	@ApiModelProperty(value = "专项补贴")
    private Double specialSubsidy;

	@ApiModelProperty(value = "餐补")
    private Double mealSubsidy;

	@ApiModelProperty(value = "应发工资")
    private Double deserveWage;

	@ApiModelProperty(value = "代扣社会统筹保险")
    private Double pendingSocialpoolingInsurance;

	@ApiModelProperty(value = "代扣公积金")
    private Double pendingProvidentfund;

	@ApiModelProperty(value = "扣个税")
    private Double pendingPersonalTax;

	@ApiModelProperty(value = "食堂餐费")
    private Double canteenMealFee;

	@ApiModelProperty(value = "工会会费")
    private Double unionFee;

	@ApiModelProperty(value = "实发工资")
    private Double realWage;

	@ApiModelProperty(value = "入账日期")
	private String accountEntryTime;
	
	@ApiModelProperty(value = "入账日期")
	private String entryTime;
	
	@ApiModelProperty(value = "人数")
	private Integer number;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		this.accountEntryTime = accountEntryTime;
	}

	
}
