package com.jn.hr.increase.model;

import java.io.Serializable;

import com.alibaba.excel.annotation.ExcelProperty;
import com.jn.common.model.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SalaryPayrollPage", description = "工资条分页实体")
public class SalaryPayrollPage extends Page implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8418425310780565005L;

	@ApiModelProperty(value = "id")
	private String id;

	@ApiModelProperty(value = "发放单位")
    private String issuingUnit;

	@ApiModelProperty(value = "姓名")
	@ExcelProperty(value = "姓名", index = 0)
    private String name;
	
	@ApiModelProperty(value = "部门名称")
    private String department;

    @ApiModelProperty(value = "身份证")
    private String idCard;

    @ApiModelProperty(value = "人员类别")
    private String personnelCategory;

    @ApiModelProperty(value = "应发工资")
	@ExcelProperty(value = "应发工资", index = 11)
    private Double deserveWage;

    @ApiModelProperty(value = "基本工资")
	@ExcelProperty(value = "基本工资", index = 2)
    private Double basicWage;

    @ApiModelProperty(value = "本单位工龄工资")
	@ExcelProperty(value = "本单位工龄工资", index = 3)
    private Double seniorityWage;

    @ApiModelProperty(value = "职称津贴")
	@ExcelProperty(value = "职称津贴", index = 8)
    private Double professionalTitleAllowance;

    @ApiModelProperty(value = "技术岗位津贴")
	@ExcelProperty(value = "技术岗位津贴", index = 4)
    private Double technicalAllowance;

    @ApiModelProperty(value = "学历津贴")
	@ExcelProperty(value = "学历津贴", index = 7)
    private Double educationAllowance;

    @ApiModelProperty(value = "工作性津贴")
    private Double workAllowance;

    @ApiModelProperty(value = "职务津贴")
	@ExcelProperty(value = "职务津贴", index = 5)
    private Double dutyAllowance;

    @ApiModelProperty(value = "专项补贴")
	@ExcelProperty(value = "专项补贴", index = 9)
    private Double specialSubsidy;

    @ApiModelProperty(value = "岗位津贴")
    private Double jobAllowance;

    @ApiModelProperty(value = "综合补贴")
    private Double compositeSubsidy;

    @ApiModelProperty(value = "季度奖")
    private Double seasonBonus;

    @ApiModelProperty(value = "年终奖")
    private Double yearEndBonus;

    @ApiModelProperty(value = "任期激励")
    private Double workExcitation;

    @ApiModelProperty(value = "加班费")
    private Double overtimeCost;

    @ApiModelProperty(value = "值班费")
    private Double onDutyCost;

    @ApiModelProperty(value = "公务用车补贴")
    private Double businessCarSubsidy;

    @ApiModelProperty(value = "现场加班补助")
    private Double siteOvertimeSubsidy;

    @ApiModelProperty(value = "走户奖")
    private Double walkDoorBouns;

    @ApiModelProperty(value = "拆迁补贴")
    private Double demolitionSubsidy;

    @ApiModelProperty(value = "误餐费")
    private Double delayCost;

    @ApiModelProperty(value = "奖励金")
    private Double rewardWage;

    @ApiModelProperty(value = "其他奖金")
    private Double otherWage;

    @ApiModelProperty(value = "养老金")
    private Double pensionWage;

    @ApiModelProperty(value = "失业保险金")
    private Double unemploymentWage;

    @ApiModelProperty(value = "医疗保险金")
    private Double medicalWage;

    @ApiModelProperty(value = "大病统筹")
    private Double majorIllnessWage;

    @ApiModelProperty(value = "单位社会保险")
    private Double unitSocietyWage;

    @ApiModelProperty(value = "公积金")
    private Double providentFund;

    @ApiModelProperty(value = "单位公积金")
    private Double unitProvidentFund;

    @ApiModelProperty(value = "工会会费")
	@ExcelProperty(value = "工会会费", index = 16)
    private Double unionFee;

    @ApiModelProperty(value = "餐费")
    private Double mealFee;

    @ApiModelProperty(value = "事假扣除")
    private Double leaveFee;

    @ApiModelProperty(value = "病假扣除")
    private Double sickLeaveFee;

    @ApiModelProperty(value = "扣罚金")
    private Double penaltyFee;

    @ApiModelProperty(value = "1")
    private Double deductionOne;

    @ApiModelProperty(value = "2")
    private Double deductionTwo;

    @ApiModelProperty(value = "个人所得税")
	@ExcelProperty(value = "扣个税", index = 14)
    private Double pendingPersonalTax;

    @ApiModelProperty(value = "实发工资")
	@ExcelProperty(value = "实发工资", index = 17)
    private Double realWage;

    @ApiModelProperty(value = "入账年月")
    private String accountEntryTime;
    
    @ApiModelProperty(value = "存入个人账户")
    private Double depositPersonalAccount;
    
    @ApiModelProperty(value = "基础工资小计")
    private Double basicWageTotal;
    
    @ApiModelProperty(value = "绩效薪酬小计")
    private Double salaryTotal;
    
    @ApiModelProperty(value = "加值班费小计")
    private Double overtimeTotal;
    
    @ApiModelProperty(value = "拆迁补贴小计")
    private Double demolitionSubsidyTotal;
    
    @ApiModelProperty(value = "其他一小计")
    private Double otherOneTotal;
    
    @ApiModelProperty(value = "应发小计")
    private Double deserveWageTotal;
    
    @ApiModelProperty(value = "个人社会保险小计")
    private Double personalSocialSecurityWageTotal;
    
    @ApiModelProperty(value = "扣款一小计")
    private Double deductionOneWageTotal;
    
    @ApiModelProperty(value = "扣款二小计")
    private Double deductionTwoWageTotal;
    
    @ApiModelProperty(value = "序号")
	private String serialNumber;

    
	public Double getDepositPersonalAccount() {
		return depositPersonalAccount;
	}

	public void setDepositPersonalAccount(Double depositPersonalAccount) {
		this.depositPersonalAccount = depositPersonalAccount;
	}

	public Double getBasicWageTotal() {
		return basicWageTotal;
	}

	public void setBasicWageTotal(Double basicWageTotal) {
		this.basicWageTotal = basicWageTotal;
	}

	public Double getSalaryTotal() {
		return salaryTotal;
	}

	public void setSalaryTotal(Double salaryTotal) {
		this.salaryTotal = salaryTotal;
	}

	public Double getOvertimeTotal() {
		return overtimeTotal;
	}

	public void setOvertimeTotal(Double overtimeTotal) {
		this.overtimeTotal = overtimeTotal;
	}

	public Double getDemolitionSubsidyTotal() {
		return demolitionSubsidyTotal;
	}

	public void setDemolitionSubsidyTotal(Double demolitionSubsidyTotal) {
		this.demolitionSubsidyTotal = demolitionSubsidyTotal;
	}

	public Double getOtherOneTotal() {
		return otherOneTotal;
	}

	public void setOtherOneTotal(Double otherOneTotal) {
		this.otherOneTotal = otherOneTotal;
	}

	public Double getDeserveWageTotal() {
		return deserveWageTotal;
	}

	public void setDeserveWageTotal(Double deserveWageTotal) {
		this.deserveWageTotal = deserveWageTotal;
	}

	public Double getPersonalSocialSecurityWageTotal() {
		return personalSocialSecurityWageTotal;
	}

	public void setPersonalSocialSecurityWageTotal(Double personalSocialSecurityWageTotal) {
		this.personalSocialSecurityWageTotal = personalSocialSecurityWageTotal;
	}

	public Double getDeductionOneWageTotal() {
		return deductionOneWageTotal;
	}

	public void setDeductionOneWageTotal(Double deductionOneWageTotal) {
		this.deductionOneWageTotal = deductionOneWageTotal;
	}

	public Double getDeductionTwoWageTotal() {
		return deductionTwoWageTotal;
	}

	public void setDeductionTwoWageTotal(Double deductionTwoWageTotal) {
		this.deductionTwoWageTotal = deductionTwoWageTotal;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
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

	public String getIssuingUnit() {
		return issuingUnit;
	}

	public void setIssuingUnit(String issuingUnit) {
		this.issuingUnit = issuingUnit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPersonnelCategory() {
		return personnelCategory;
	}

	public void setPersonnelCategory(String personnelCategory) {
		this.personnelCategory = personnelCategory;
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

	public Double getOtherWage() {
		return otherWage;
	}

	public void setOtherWage(Double otherWage) {
		this.otherWage = otherWage;
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

	public String getAccountEntryTime() {
		return accountEntryTime;
	}

	public void setAccountEntryTime(String accountEntryTime) {
		this.accountEntryTime = accountEntryTime;
	}
}
