package com.jn.hr.increase.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SalaryPayrollAdd", description = "工资条添加实体")
public class SalaryPayrollAdd extends BaseRowModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8619963822507286388L;

	@ApiModelProperty(value = "id")
	private String id;

	@ApiModelProperty(value = "姓名")
	@ExcelProperty(value = "姓名", index = 0)
    private String name;
	
	@ApiModelProperty(value = "工号")
	@ExcelProperty(value = "工号", index = 1)
	private String jobNumber;

	@ApiModelProperty(value = "部门")
    private String department;

	@ApiModelProperty(value = "工资档次及金额")
	@ExcelProperty(value = "工资档次及金额", index = 2)
    private Double basicWage;

	@ApiModelProperty(value = "园区工龄工资")
	@ExcelProperty(value = "园区工龄工资", index = 3)
    private Double seniorityWage;

	@ApiModelProperty(value = "技术岗位津贴")
	@ExcelProperty(value = "技术岗位津贴", index = 4)
    private Double technicalAllowance;

	@ApiModelProperty(value = "职务津贴")
	@ExcelProperty(value = "职务津贴", index = 5)
    private Double dutyAllowance;

	@ApiModelProperty(value = "工作性补贴")
	@ExcelProperty(value = "工作性补贴", index = 6)
    private Double workSubsidy;

	@ApiModelProperty(value = "学历津贴")
	@ExcelProperty(value = "学历津贴", index = 7)
    private Double educationAllowance;

	@ApiModelProperty(value = "职称津贴")
	@ExcelProperty(value = "职称津贴", index = 8)
    private Double professionalTitleAllowance;

	@ApiModelProperty(value = "专项补贴")
	@ExcelProperty(value = "专项补贴", index = 9)
    private Double specialSubsidy;

	@ApiModelProperty(value = "餐补")
	@ExcelProperty(value = "餐补", index = 10)
    private Double mealSubsidy;

	@ApiModelProperty(value = "应发工资")
	@ExcelProperty(value = "应发工资", index = 11)
    private Double deserveWage;

	@ApiModelProperty(value = "代扣社会统筹保险")
	@ExcelProperty(value = "代扣社会统筹保险", index = 12)
    private Double pendingSocialpoolingInsurance;

	@ApiModelProperty(value = "代扣公积金")
	@ExcelProperty(value = "代扣公积金", index = 13)
    private Double pendingProvidentfund;

	@ApiModelProperty(value = "扣个税")
	@ExcelProperty(value = "扣个税", index = 14)
    private Double pendingPersonalTax;

	@ApiModelProperty(value = "食堂餐费")
	@ExcelProperty(value = "食堂餐费", index = 15)
    private Double canteenMealFee;

	@ApiModelProperty(value = "工会会费")
	@ExcelProperty(value = "工会会费", index = 16)
    private Double unionFee;

	@ApiModelProperty(value = "实发工资")
	@ExcelProperty(value = "实发工资", index = 17)
    private Double realWage;

	@ApiModelProperty(value = "入账日期")
	@ExcelProperty(value = "入账日期", index = 18)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	private Date accountEntryTime;

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

	public Date getAccountEntryTime() {
		return accountEntryTime;
	}

	public void setAccountEntryTime(Date accountEntryTime) {
		this.accountEntryTime = accountEntryTime;
	}
}
