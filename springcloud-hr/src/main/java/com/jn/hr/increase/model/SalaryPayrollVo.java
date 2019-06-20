package com.jn.hr.increase.model;

import java.io.Serializable;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SalaryPayrollPage", description = "工资条实体")
public class SalaryPayrollVo extends BaseRowModel implements Serializable{

	private static final long serialVersionUID = -4812412109064703025L;
	
	@ApiModelProperty(value = "序号")
	@ExcelProperty(value = { "序号", "序号" }, index = 0)
	private String serialNumber;

	@ApiModelProperty(value = "发放单位")
	@ExcelProperty(value = { "发放单位", "发放单位" }, index = 1)
	private String issuingUnit;

	@ApiModelProperty(value = "姓名")
	@ExcelProperty(value = { "姓名", "姓名" }, index = 2)
	private String name;
	
	@ApiModelProperty(value = "身份证号")
	@ExcelProperty(value = { "身份证号", "身份证号" }, index = 3)
	private String idCard;

	@ApiModelProperty(value = "人员类别")
	@ExcelProperty(value = { "人员类别", "人员类别" }, index = 4)
	private String personnelCategory;

	@ApiModelProperty(value = "应付工资")
	@ExcelProperty(value = { "应付工资", "应付工资" }, index = 5)
	private Double deserveWage = 0.0;

	@ApiModelProperty(value = "基本工资")
	@ExcelProperty(value = { "基本薪酬(固定类工资)", "基本工资" }, index = 6)
	private Double basicWage;

	@ApiModelProperty(value = "本单位工龄工资")
	@ExcelProperty(value = { "基本薪酬(固定类工资)", "本单位工龄工资" }, index = 7)
	private Double seniorityWage;

	@ApiModelProperty(value = "职称津贴")
	@ExcelProperty(value = { "基本薪酬(固定类工资)", "职称津贴" }, index = 8)
	private Double professionalTitleAllowance;

	@ApiModelProperty(value = "技术岗位津贴")
	@ExcelProperty(value = { "基本薪酬(固定类工资)", "技术岗位津贴" }, index = 9)
	private Double technicalAllowance;

	@ApiModelProperty(value = "学历津贴")
	@ExcelProperty(value = { "基本薪酬(固定类工资)", "学历津贴" }, index = 10)
	private Double educationAllowance;

	@ApiModelProperty(value = "工作性津贴")
	@ExcelProperty(value = { "基本薪酬(固定类工资)", "工作性津贴" }, index = 11)
	private Double workAllowance;

	@ApiModelProperty(value = "职务津贴")
	@ExcelProperty(value = { "基本薪酬(固定类工资)", "职务津贴" }, index = 12)
	private Double dutyAllowance;

	@ApiModelProperty(value = "专项补贴")
	@ExcelProperty(value = { "基本薪酬(固定类工资)", "专项补贴" }, index = 13)
	private Double specialSubsidy;

	@ApiModelProperty(value = "岗位津贴")
	@ExcelProperty(value = { "基本薪酬(固定类工资)", "岗位津贴" }, index = 14)
	private Double jobAllowance;

	@ApiModelProperty(value = "综合补贴")
	@ExcelProperty(value = { "基本薪酬(固定类工资)", "综合补贴" }, index = 15)
	private Double compositeSubsidy;

	@ApiModelProperty(value = "基础薪酬(固定类工资)小计")
	@ExcelProperty(value = { "基本薪酬(固定类工资)", "基础薪酬(固定类工资)小计" }, index = 16)
	private Double basicWageTotal;

	@ApiModelProperty(value = "季度奖")
	@ExcelProperty(value = { "绩效薪酬(浮动类工资)", "季度奖" }, index = 17)
	private Double seasonBonus;

	@ApiModelProperty(value = "年终奖")
	@ExcelProperty(value = { "绩效薪酬(浮动类工资)", "年终奖" }, index = 18)
	private Double yearEndBonus;
	
	@ApiModelProperty(value = "绩效薪酬小计")
	@ExcelProperty(value = { "绩效薪酬(浮动类工资)", "绩效薪酬小计" }, index = 19)
	private Double salaryTotal;

	@ApiModelProperty(value = "任期激励")
	@ExcelProperty(value = { "任期激励", "任期激励" }, index = 20)
	private Double workExcitation;

	@ApiModelProperty(value = "加班费")
	@ExcelProperty(value = { "加、值班费", "加班费" }, index = 21)
	private Double overtimeCost;

	@ApiModelProperty(value = "值班费")
	@ExcelProperty(value = { "加、值班费", "值班费" }, index = 22)
	private Double onDutyCost;
	
	@ApiModelProperty(value = "加值班费小计")
	@ExcelProperty(value = { "加、值班费", "加值班费小计" }, index = 23)
	private Double overtimeTotal;

	@ApiModelProperty(value = "公务用车补贴")
	@ExcelProperty(value = { "公务用车补贴", "公务用车补贴" }, index = 24)
	private Double businessCarSubsidy;

	@ApiModelProperty(value = "现场加班补助")
	@ExcelProperty(value = { "拆迁补贴", "现场加班补助" }, index = 25)
	private Double siteOvertimeSubsidy;

	@ApiModelProperty(value = "走户奖")
	@ExcelProperty(value = { "拆迁补贴", "走户奖" }, index = 26)
	private Double walkDoorBouns;

	@ApiModelProperty(value = "拆迁补贴其他")
	@ExcelProperty(value = { "拆迁补贴", "拆迁补贴其他" }, index = 27)
	private Double demolitionSubsidy;

	@ApiModelProperty(value = "拆迁补贴小计")
	@ExcelProperty(value = { "拆迁补贴", "拆迁补贴小计" }, index = 28)
	private Double demolitionSubsidyTotal;

	@ApiModelProperty(value = "误餐费")
	@ExcelProperty(value = { "其他一", "误餐费" }, index = 29)
	private Double delayCost;

	@ApiModelProperty(value = "奖励金")
	@ExcelProperty(value = { "其他一", "奖励金" }, index = 30)
	private Double rewardWage;

	@ApiModelProperty(value = "其他一小计")
	@ExcelProperty(value = { "其他一", "其他一小计" }, index = 31)
	private Double otherOneTotal;

	@ApiModelProperty(value = "其他二")
	@ExcelProperty(value = { "其他二", "其他二" }, index = 32)
	private Double otherWage;

	@ApiModelProperty(value = "应发小计")
	@ExcelProperty(value = { "应发小计", "应发小计" }, index = 33)
	private Double deserveWageTotal;

	@ApiModelProperty(value = "养老")
	@ExcelProperty(value = { "个人社会保险", "养老" }, index = 34)
	private Double pensionWage;

	@ApiModelProperty(value = "失业")
	@ExcelProperty(value = { "个人社会保险", "失业" }, index = 35)
	private Double unemploymentWage;

	@ApiModelProperty(value = "医疗")
	@ExcelProperty(value = { "个人社会保险", "医疗" }, index = 36)
	private Double medicalWage;

	@ApiModelProperty(value = "大病统筹")
	@ExcelProperty(value = { "个人社会保险", "大病统筹" }, index = 37)
	private Double majorIllnessWage;

	@ApiModelProperty(value = "个人社会保险小计")
	@ExcelProperty(value = { "个人社会保险", "个人社会保险小计" }, index = 38)
	private Double personalSocialSecurityWageTotal;

	@ApiModelProperty(value = "单位社会保险")
	@ExcelProperty(value = { "单位社会保险", "单位社会保险" }, index = 39)
	private Double unitSocietyWage;

	@ApiModelProperty(value = "公积金")
	@ExcelProperty(value = { "公积金", "公积金" }, index = 40)
	private Double providentFund;

	@ApiModelProperty(value = "单位公积金")
	@ExcelProperty(value = { "单位公积金", "单位公积金" }, index = 41)
	private Double unitProvidentFund;

	@ApiModelProperty(value = "工会会费")
	@ExcelProperty(value = { "工会会费", "工会会费" }, index = 42)
	private Double unionFee;

	@ApiModelProperty(value = "餐费")
	@ExcelProperty(value = { "扣款1", "餐费" }, index = 43)
	private Double mealFee;

	@ApiModelProperty(value = "事假")
	@ExcelProperty(value = { "扣款1", "事假" }, index = 44)
	private Double leaveFee;

	@ApiModelProperty(value = "病假")
	@ExcelProperty(value = { "扣款1", "病假" }, index = 45)
	private Double sickLeaveFee;

	@ApiModelProperty(value = "扣罚金")
	@ExcelProperty(value = { "扣款1", "扣罚金" }, index = 46)
	private Double penaltyFee;

	@ApiModelProperty(value = "扣款1小计")
	@ExcelProperty(value = { "扣款1", "扣款1小计" }, index = 47)
	private Double deductionOneWageTotal;

	@ApiModelProperty(value = "扣款2-1")
	@ExcelProperty(value = { "扣款2", "1" }, index = 48)
	private Double deductionOne;

	@ApiModelProperty(value = "扣款2-2")
	@ExcelProperty(value = { "扣款2", "2" }, index = 49)
	private Double deductionTwo;

	@ApiModelProperty(value = "扣款2小计")
	@ExcelProperty(value = { "扣款2", "扣款2小计" }, index = 50)
	private Double deductionTwoWageTotal;

	@ApiModelProperty(value = "个人所得税")
	@ExcelProperty(value = { "个人所得税", "个人所得税" }, index = 51)
	private Double pendingPersonalTax;

	@ApiModelProperty(value = "实发工资")
	@ExcelProperty(value = { "实发工资", "实发工资" }, index = 52)
	private Double realWage = 0.0;

	@ApiModelProperty(value = "存入个人账户")
	@ExcelProperty(value = { "存入个人账户", "存入个人账户" }, index = 53)
	private Double depositPersonalAccount;

	@ApiModelProperty(value = "id")
	private String id;
    
    @ApiModelProperty(value = "入账年月")
    private String accountEntryTime;
    
    @ApiModelProperty(value = "人数")
    private Integer number = 0;
    
    @ApiModelProperty(value = "部门名称")
    private String department;
    
    
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
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
