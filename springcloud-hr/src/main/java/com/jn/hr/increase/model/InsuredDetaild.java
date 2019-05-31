package com.jn.hr.increase.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "InsuredDetaild", description = "参保明细实体")
public class InsuredDetaild extends BaseRowModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1329278653192563501L;

	@ApiModelProperty(value = "id")
	private String id;

	@ApiModelProperty(value = "创建日期")
    private String creatDate;
	
	@ApiModelProperty(value = "参保年月")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date yearMonth;
	
	@ApiModelProperty(value = "参保月份")
	@ExcelProperty(value = "参保月份", index = 1)
	private String insuredMonth;

	@ApiModelProperty(value = "工号")
	@ExcelProperty(value = "工号", index = 0)
    private String jobNumber;

	@ApiModelProperty(value = "姓名")
    private String name;

	@ApiModelProperty(value = "部门")
	@ExcelProperty(value = "部门Id", index = 2)
    private String department;
	
	@ApiModelProperty(value = "部门Id")
	private String departmentId;

	@ApiModelProperty(value = "参保城市id")
    private String cityId;

	@ApiModelProperty(value = "参保城市名称")
	@ExcelProperty(value = "参保城市名称", index = 3)
    private String cityName;

	@ApiModelProperty(value = "个人社保费")
	@ExcelProperty(value = "个人社保费", index = 4)
    private Double personalSocialSecurity;

	@ApiModelProperty(value = "公司社保费")
	@ExcelProperty(value = "公司社保费", index = 5)
    private Double companySocialSecurity;

	@ApiModelProperty(value = "个人公积金费")
	@ExcelProperty(value = "个人公积金费", index = 6)
    private Double personalAccumulationFund;

	@ApiModelProperty(value = "公司公积金费")
	@ExcelProperty(value = "公司公积金费", index = 7)
    private Double companyAccumulationFund;

	@ApiModelProperty(value = "方案id")
	@ExcelProperty(value = "方案id", index = 8)
    private String schemeId;

	@ApiModelProperty(value = "是否有效（1：有效，2：无效）")
    private Byte isEffective;
	
	@ApiModelProperty(value = "使用人数")
	private Integer number;
	
	@ApiModelProperty(value = "增减人数")
	private String lastNumber;
	
	@ApiModelProperty(value = "增减社保费")
	private String lastSocialSecurity;
	
	@ApiModelProperty(value = "社保费")
	private Double socialSecurity;
	
	@ApiModelProperty(value = "增减公积金")
	private String lastAccumulationFund;
	
	@ApiModelProperty(value = "总费用")
	private Double totalCost;
	
	@ApiModelProperty(value = "总费用")
	private String lastTotalCost;
	
	@ApiModelProperty(value = "公积金")
	private Double accumulationFund;
	
	@ApiModelProperty(value = "个人缴费")
	private Double personalPayment;
	
	@ApiModelProperty(value = "公司缴费")
	private Double companyPayment;
	
	//部门总费用
	List<SalaryKeyValue> departmentTotalCost;

	//部门公司费用
	List<SalaryKeyValue> departmentCompanyCost;
	
	//部门个人费用
	List<SalaryKeyValue> departmentPersonalCost;
	
	//部门人数
	List<SalaryKeyValue> departmentNumber;
	
	
	public Date getYearMonth() {
		return yearMonth;
	}

	public void setYearMonth(Date yearMonth) {
		this.yearMonth = yearMonth;
	}

	public String getLastNumber() {
		return lastNumber;
	}

	public void setLastNumber(String lastNumber) {
		this.lastNumber = lastNumber;
	}

	public String getLastSocialSecurity() {
		return lastSocialSecurity;
	}

	public void setLastSocialSecurity(String lastSocialSecurity) {
		this.lastSocialSecurity = lastSocialSecurity;
	}

	public String getLastAccumulationFund() {
		return lastAccumulationFund;
	}

	public void setLastAccumulationFund(String lastAccumulationFund) {
		this.lastAccumulationFund = lastAccumulationFund;
	}

	public String getLastTotalCost() {
		return lastTotalCost;
	}

	public void setLastTotalCost(String lastTotalCost) {
		this.lastTotalCost = lastTotalCost;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public List<SalaryKeyValue> getDepartmentTotalCost() {
		return departmentTotalCost;
	}

	public void setDepartmentTotalCost(List<SalaryKeyValue> departmentTotalCost) {
		this.departmentTotalCost = departmentTotalCost;
	}

	public List<SalaryKeyValue> getDepartmentCompanyCost() {
		return departmentCompanyCost;
	}

	public void setDepartmentCompanyCost(List<SalaryKeyValue> departmentCompanyCost) {
		this.departmentCompanyCost = departmentCompanyCost;
	}

	public List<SalaryKeyValue> getDepartmentPersonalCost() {
		return departmentPersonalCost;
	}

	public void setDepartmentPersonalCost(List<SalaryKeyValue> departmentPersonalCost) {
		this.departmentPersonalCost = departmentPersonalCost;
	}

	public List<SalaryKeyValue> getDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(List<SalaryKeyValue> departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

	public String getInsuredMonth() {
		return insuredMonth;
	}

	public void setInsuredMonth(String insuredMonth) {
		this.insuredMonth = insuredMonth;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public Double getPersonalPayment() {
		return personalPayment;
	}

	public void setPersonalPayment(Double personalPayment) {
		this.personalPayment = personalPayment;
	}

	public Double getCompanyPayment() {
		return companyPayment;
	}

	public void setCompanyPayment(Double companyPayment) {
		this.companyPayment = companyPayment;
	}

	public Double getSocialSecurity() {
		return socialSecurity;
	}

	public void setSocialSecurity(Double socialSecurity) {
		this.socialSecurity = socialSecurity;
	}

	public Double getAccumulationFund() {
		return accumulationFund;
	}

	public void setAccumulationFund(Double accumulationFund) {
		this.accumulationFund = accumulationFund;
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

	public String getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(String creatDate) {
		this.creatDate = creatDate;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Double getPersonalSocialSecurity() {
		return personalSocialSecurity;
	}

	public void setPersonalSocialSecurity(Double personalSocialSecurity) {
		this.personalSocialSecurity = personalSocialSecurity;
	}

	public Double getCompanySocialSecurity() {
		return companySocialSecurity;
	}

	public void setCompanySocialSecurity(Double companySocialSecurity) {
		this.companySocialSecurity = companySocialSecurity;
	}

	public Double getPersonalAccumulationFund() {
		return personalAccumulationFund;
	}

	public void setPersonalAccumulationFund(Double personalAccumulationFund) {
		this.personalAccumulationFund = personalAccumulationFund;
	}

	public Double getCompanyAccumulationFund() {
		return companyAccumulationFund;
	}

	public void setCompanyAccumulationFund(Double companyAccumulationFund) {
		this.companyAccumulationFund = companyAccumulationFund;
	}

	public String getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(String schemeId) {
		this.schemeId = schemeId;
	}

	public Byte getIsEffective() {
		return isEffective;
	}

	public void setIsEffective(Byte isEffective) {
		this.isEffective = isEffective;
	}
	
}
