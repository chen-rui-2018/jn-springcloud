package com.jn.hr.increase.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SalaryInfoPage", description = "薪资管理分页实体")
public class SalaryInfoPage extends Page implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8050795276699055954L;

	@ApiModelProperty(value = "序列")
	private String id;

	@ApiModelProperty(value = "工号")
    private String jobNumber;
	
	@ApiModelProperty(value = "姓名")
	private String name;
	
	@ApiModelProperty(value = "部门")
	private String departmentName;
	
	@ApiModelProperty(value = "部门Id")
	private String departmentId;
	
	@ApiModelProperty(value = "职位")
	private String jobName;
	
	@ApiModelProperty(value = "职级")
	private String rankName;
	
	@ApiModelProperty(value = "联系电话")
	private String phone;
	
	@ApiModelProperty(value = "证件类型")
	private String certificateType;
	
	@ApiModelProperty(value = "身份证号")
	private String certificateNumber;
	
	@ApiModelProperty(value = "入职日期")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	private Date entryDate;
	
	@ApiModelProperty(value = "试用期工资")
	private String probationWage;

	@ApiModelProperty(value = "转正工资")
	private String conversionWage;
	
	@ApiModelProperty(value = "当前工资")
	private String currentWage;

	@ApiModelProperty(value = "基础工资(试用期)")
    private Double probationBasicWage;

	@ApiModelProperty(value = "职务津贴(试用期)")
    private Double probationDutyAllowance;

	@ApiModelProperty(value = "职称津贴(试用期)")
    private Double probationProfessionalTitleAllowance;

	@ApiModelProperty(value = "工龄工资(试用期)")
    private Double probationSeniorityWage;

	@ApiModelProperty(value = "学历津贴(试用期)")
    private Double probationEducationAllowance;

	@ApiModelProperty(value = "工作性补贴(试用期)")
    private Double probationWorkSubsidy;

	@ApiModelProperty(value = "绩效奖金(试用期)")
    private Double probationAchievementBonus;

	@ApiModelProperty(value = "单项奖励(试用期)")
    private BigDecimal probationSingleReward;

	@ApiModelProperty(value = "基础工资（转正期）")
    private Double conversionBasicWage;

	@ApiModelProperty(value = "职务津贴（转正期）")
    private Double conversionDutyAllowance;

	@ApiModelProperty(value = "职称津贴（转正期）")
    private Double conversionProfessionalTitleAllowance;

	@ApiModelProperty(value = "工龄工资（转正期）")
    private Double conversionSeniorityWage;

	@ApiModelProperty(value = "学历津贴（转正期）")
    private Double conversionEducationAllowance;

	@ApiModelProperty(value = "工作性补贴（转正期）")
    private Double conversionWorkSubsidy;

	@ApiModelProperty(value = "绩效奖金（转正期）")
    private Double conversionAchievementBonus;

	@ApiModelProperty(value = "单项奖励（转正期）")
    private Double conversionSingleReward;

	@ApiModelProperty(value = "基础工资(当前工资)")
    private String currentBasicWage;

	@ApiModelProperty(value = "职务津贴(当前工资)")
    private String currentDutyAllowance;

	@ApiModelProperty(value = "职称津贴(当前工资)")
    private String currentProfessionalTitleAllowance;

	@ApiModelProperty(value = "工龄工资(当前工资)")
    private String currentSeniorityWage;

	@ApiModelProperty(value = "学历津贴(当前工资)")
    private String currentEducationAllowance;

	@ApiModelProperty(value = "工作性补贴(当前工资)")
    private String currentWorkSubsidy;

	@ApiModelProperty(value = "绩效奖金(当前工资)")
    private String currentAchievementBonus;

	@ApiModelProperty(value = "单项奖励(当前工资)")
    private String currentSingleReward;
	
	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getRankName() {
		return rankName;
	}

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}

	public String getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public String getProbationWage() {
		return probationWage;
	}

	public void setProbationWage(String probationWage) {
		this.probationWage = probationWage;
	}

	public String getConversionWage() {
		return conversionWage;
	}

	public void setConversionWage(String conversionWage) {
		this.conversionWage = conversionWage;
	}

	public String getCurrentWage() {
		return currentWage;
	}

	public void setCurrentWage(String currentWage) {
		this.currentWage = currentWage;
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
		this.currentBasicWage = currentBasicWage;
	}

	public String getCurrentDutyAllowance() {
		return currentDutyAllowance;
	}

	public void setCurrentDutyAllowance(String currentDutyAllowance) {
		this.currentDutyAllowance = currentDutyAllowance;
	}

	public String getCurrentProfessionalTitleAllowance() {
		return currentProfessionalTitleAllowance;
	}

	public void setCurrentProfessionalTitleAllowance(String currentProfessionalTitleAllowance) {
		this.currentProfessionalTitleAllowance = currentProfessionalTitleAllowance;
	}

	public String getCurrentSeniorityWage() {
		return currentSeniorityWage;
	}

	public void setCurrentSeniorityWage(String currentSeniorityWage) {
		this.currentSeniorityWage = currentSeniorityWage;
	}

	public String getCurrentEducationAllowance() {
		return currentEducationAllowance;
	}

	public void setCurrentEducationAllowance(String currentEducationAllowance) {
		this.currentEducationAllowance = currentEducationAllowance;
	}

	public String getCurrentWorkSubsidy() {
		return currentWorkSubsidy;
	}

	public void setCurrentWorkSubsidy(String currentWorkSubsidy) {
		this.currentWorkSubsidy = currentWorkSubsidy;
	}

	public String getCurrentAchievementBonus() {
		return currentAchievementBonus;
	}

	public void setCurrentAchievementBonus(String currentAchievementBonus) {
		this.currentAchievementBonus = currentAchievementBonus;
	}

	public String getCurrentSingleReward() {
		return currentSingleReward;
	}

	public void setCurrentSingleReward(String currentSingleReward) {
		this.currentSingleReward = currentSingleReward;
	}
	
}
