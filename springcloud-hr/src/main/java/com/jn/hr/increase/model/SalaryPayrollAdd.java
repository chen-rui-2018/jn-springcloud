package com.jn.hr.increase.model;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

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

	@ApiModelProperty(value = "序号")
	@ExcelProperty(value = "序号", index = 0)
	private String serialNumber;
	
	@ApiModelProperty(value = "发放单位")
	@ExcelProperty(value = "", index = 1 )
    private String issuingUnit;

	@ApiModelProperty(value = "姓名")
	@ExcelProperty(value = "", index = 2)
    private String name;

    @ApiModelProperty(value = "身份证")
    @ExcelProperty(value = "", index = 3)
    private String idCard;

    @ApiModelProperty(value = "人员类别")
    @ExcelProperty(value = "", index = 4)
    private String personnelCategory;

    @ApiModelProperty(value = "应付工资")
    @ExcelProperty(value = "应付工资", index = 5)
    private Double deserveWage;

    @ApiModelProperty(value = "基本工资")
    @ExcelProperty(value = "基本工资", index = 6)
    private Double basicWage = 0.0;

    @ApiModelProperty(value = "本单位工龄工资")
    @ExcelProperty(value = "本单位工龄工资", index = 7)
    private Double seniorityWage = 0.0;

    @ApiModelProperty(value = "职称津贴")
    @ExcelProperty(value = "职称津贴", index = 8)
    private Double professionalTitleAllowance = 0.0;

    @ApiModelProperty(value = "技术岗位津贴")
    @ExcelProperty(value = "技术岗位津贴", index = 9)
    private Double technicalAllowance = 0.0;

    @ApiModelProperty(value = "学历津贴")
    @ExcelProperty(value = "学历津贴", index = 10)
    private Double educationAllowance = 0.0;

    @ApiModelProperty(value = "工作性津贴")
    @ExcelProperty(value = "工作性津贴", index = 11)
    private Double workAllowance = 0.0;

    @ApiModelProperty(value = "职务津贴")
    @ExcelProperty(value = "职务津贴", index = 12)
    private Double dutyAllowance = 0.0;

    @ApiModelProperty(value = "专项补贴")
    @ExcelProperty(value = "专项补贴", index = 13)
    private Double specialSubsidy = 0.0;

    @ApiModelProperty(value = "岗位津贴")
    @ExcelProperty(value = "岗位津贴", index = 14)
    private Double jobAllowance = 0.0;

    @ApiModelProperty(value = "综合补贴")
    @ExcelProperty(value = "综合补贴", index = 15)
    private Double compositeSubsidy = 0.0;
    
    @ApiModelProperty(value = "基础薪酬小计")
    @ExcelProperty(value = "基础薪酬小计", index = 16)
    private Double basicWageTotal;

    @ApiModelProperty(value = "季度奖")
    @ExcelProperty(value = "季度奖", index = 17)
    private Double seasonBonus = 0.0;
    
    @ApiModelProperty(value = "年终奖")
    @ExcelProperty(value = "年终奖", index = 18)
    private Double yearEndBonus = 0.0;
    
    @ApiModelProperty(value = "绩效薪酬小计")
    @ExcelProperty(value = "绩效薪酬小计", index = 19)
    private Double salaryTotal = 0.0;

    @ApiModelProperty(value = "任期激励")
    @ExcelProperty(value = "任期激励", index = 20)
    private Double workExcitation = 0.0;

    @ApiModelProperty(value = "加班费")
    @ExcelProperty(value = "加班费", index = 21)
    private Double overtimeCost = 0.0;

    @ApiModelProperty(value = "值班费")
    @ExcelProperty(value = "值班费", index = 22)
    private Double onDutyCost = 0.0;
    
    @ApiModelProperty(value = "加值班费小计")
    @ExcelProperty(value = "加值班费小计", index = 23)
    private Double overtimeTotal;

    @ApiModelProperty(value = "公务用车补贴")
    @ExcelProperty(value = "公务用车补贴", index = 24)
    private Double businessCarSubsidy = 0.0;

    @ApiModelProperty(value = "现场加班补助")
    @ExcelProperty(value = "现场加班补助", index = 25)
    private Double siteOvertimeSubsidy = 0.0;

    @ApiModelProperty(value = "走户奖")
    @ExcelProperty(value = "走户奖", index = 26)
    private Double walkDoorBouns = 0.0;

    @ApiModelProperty(value = "拆迁补贴")
    @ExcelProperty(value = "拆迁补贴", index = 27)
    private Double demolitionSubsidy = 0.0;
    
    @ApiModelProperty(value = "拆迁补贴小计")
    @ExcelProperty(value = "入账年月", index = 28)
    private Double demolitionSubsidyTotal;

    @ApiModelProperty(value = "误餐费")
    @ExcelProperty(value = "误餐费", index = 29)
    private Double delayCost = 0.0;

    @ApiModelProperty(value = "奖励金")
    @ExcelProperty(value = "奖励金", index = 30)
    private Double rewardWage = 0.0;
    
    @ApiModelProperty(value = "其他一小计")
    @ExcelProperty(value = "入账年月", index = 31)
    private Double otherOneTotal;

    @ApiModelProperty(value = "其他二")
    @ExcelProperty(value = "其他二", index = 32)
    private Double otherWage = 0.0;
    
    @ApiModelProperty(value = "应发小计")
    @ExcelProperty(value = "入账年月", index = 33)
    private Double deserveWageTotal;

    @ApiModelProperty(value = "养老金")
    @ExcelProperty(value = "养老金", index = 34)
    private Double pensionWage = 0.0;

    @ApiModelProperty(value = "失业保险金")
    @ExcelProperty(value = "失业保险金", index = 35)
    private Double unemploymentWage = 0.0;

    @ApiModelProperty(value = "医疗保险金")
    @ExcelProperty(value = "医疗保险金", index = 36)
    private Double medicalWage = 0.0;

    @ApiModelProperty(value = "大病统筹")
    @ExcelProperty(value = "大病统筹", index = 37)
    private Double majorIllnessWage = 0.0;
    
    @ApiModelProperty(value = "个人社会保险小计")
    @ExcelProperty(value = "入账年月", index = 38)
    private Double personalSocialSecurityWageTotal;

    @ApiModelProperty(value = "单位社会保险")
    @ExcelProperty(value = "单位社会保险", index = 39)
    private Double unitSocietyWage = 0.0;

    @ApiModelProperty(value = "公积金")
    @ExcelProperty(value = "公积金", index = 40)
    private Double providentFund = 0.0;

    @ApiModelProperty(value = "单位公积金")
    @ExcelProperty(value = "单位公积金", index = 41)
    private Double unitProvidentFund = 0.0;

    @ApiModelProperty(value = "工会会费")
    @ExcelProperty(value = "工会会费", index = 42)
    private Double unionFee = 0.0;

    @ApiModelProperty(value = "餐费")
    @ExcelProperty(value = "餐费", index = 43)
    private Double mealFee = 0.0;

    @ApiModelProperty(value = "事假扣除费")
    @ExcelProperty(value = "事假扣除费", index = 44)
    private Double leaveFee = 0.0;

    @ApiModelProperty(value = "病假扣除费")
    @ExcelProperty(value = "病假扣除费", index = 45)
    private Double sickLeaveFee = 0.0;

    @ApiModelProperty(value = "扣罚金")
    @ExcelProperty(value = "扣罚金", index = 46)
    private Double penaltyFee = 0.0;
    
    @ApiModelProperty(value = "扣款一小计")
    @ExcelProperty(value = "入账年月", index = 47)
    private Double deductionOneWageTotal;

    @ApiModelProperty(value = "1")
    @ExcelProperty(value = "1", index = 48)
    private Double deductionOne = 0.0;

    @ApiModelProperty(value = "2")
    @ExcelProperty(value = "2", index = 49)
    private Double deductionTwo = 0.0;
    
    @ApiModelProperty(value = "扣款二小计")
    @ExcelProperty(value = "入账年月", index = 50)
    private Double deductionTwoWageTotal;

    @ApiModelProperty(value = "个人所得税")
    @ExcelProperty(value = "个人所得税", index = 51)
    private Double pendingPersonalTax = 0.0;

    @ApiModelProperty(value = "实发小计")
    @ExcelProperty(value = "实发工资", index = 52)
    private Double realWage;
    
    @ApiModelProperty(value = "存入个人账户")
    @ExcelProperty(value = "入账年月", index = 53)
    private Double depositPersonalAccount;

    @ApiModelProperty(value = "入账年月")
    @ExcelProperty(value = "入账年月", index = 54)
    private String accountEntryTime;
    
    @ApiModelProperty(value = "部门名称")
    private String department;
    
    @ApiModelProperty(value = "创建账户")
    private String creatorAccount;

    @ApiModelProperty(value = "创建时间")
    private Date createdTime;

    @ApiModelProperty(value = "更新账户")
    private String modifierAccount;

    @ApiModelProperty(value = "更新时间")
    private Date modifiedTime;
    
    
	public String getCreatorAccount() {
		return creatorAccount;
	}

	public void setCreatorAccount(String creatorAccount) {
		this.creatorAccount = creatorAccount;
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
		this.modifierAccount = modifierAccount;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
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

	public Double getDepositPersonalAccount() {
		return depositPersonalAccount;
	}

	public void setDepositPersonalAccount(Double depositPersonalAccount) {
		this.depositPersonalAccount = depositPersonalAccount;
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
