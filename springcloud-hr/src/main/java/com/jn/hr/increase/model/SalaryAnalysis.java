package com.jn.hr.increase.model;

import java.io.Serializable;
import java.util.List;

import com.alibaba.excel.metadata.BaseRowModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SalaryAnalysis", description = "薪酬分析实体")
public class SalaryAnalysis extends BaseRowModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6695293584006387577L;

	@ApiModelProperty(value = "实发工资")
    private Double realWage;
	
	@ApiModelProperty(value = "部门")
    private String department;
	
	@ApiModelProperty(value = "应发工资")
    private Double deserveWage;
	
	@ApiModelProperty(value = "计薪人数")
	private Integer number;
	
	@ApiModelProperty(value = "各部门薪资比例统计")
	private String departmentInfo;
	
	@ApiModelProperty(value = "固定工资")
    private Double basicWage;
	
	@ApiModelProperty(value = "浮动工资")
	private Double floatWage;
	
	@ApiModelProperty(value = "津补贴")
	private Double allowanceSubsidy;
	
	@ApiModelProperty(value = "加班费")
	private Double overtimePay;
	
	@ApiModelProperty(value = "税前补发")
	private Double beforeTaxReissue;
	
	@ApiModelProperty(value = "税后补发")
	private Double afterTaxReissue;
	
	@ApiModelProperty(value = "应发环比增长")
    private String lastDeserveWage;
	
	@ApiModelProperty(value = "实发环比增长")
    private String lastRealWage;
	
	@ApiModelProperty(value = "增长人数")
	private String lastNumber;

	@ApiModelProperty(value = "薪资组成")
	private List<SalaryKeyValue> salaryComposition;
	
	@ApiModelProperty(value = "人力成本")
	private List<SalaryKeyValue> laborCosts;
	
	@ApiModelProperty(value = "人均工资")
	private List<SalaryKeyValue> perpleCapita;
	
	@ApiModelProperty(value = "部门人数")
	private List<SalaryKeyValue> departmentNumber;
	
	
	public List<SalaryKeyValue> getSalaryComposition() {
		return salaryComposition;
	}

	public void setSalaryComposition(List<SalaryKeyValue> salaryComposition) {
		this.salaryComposition = salaryComposition;
	}

	public List<SalaryKeyValue> getLaborCosts() {
		return laborCosts;
	}

	public void setLaborCosts(List<SalaryKeyValue> laborCosts) {
		this.laborCosts = laborCosts;
	}

	public List<SalaryKeyValue> getPerpleCapita() {
		return perpleCapita;
	}

	public void setPerpleCapita(List<SalaryKeyValue> perpleCapita) {
		this.perpleCapita = perpleCapita;
	}

	public List<SalaryKeyValue> getDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(List<SalaryKeyValue> departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

	public String getLastDeserveWage() {
		return lastDeserveWage;
	}

	public void setLastDeserveWage(String lastDeserveWage) {
		this.lastDeserveWage = lastDeserveWage;
	}

	public String getLastRealWage() {
		return lastRealWage;
	}

	public void setLastRealWage(String lastRealWage) {
		this.lastRealWage = lastRealWage;
	}

	public String getLastNumber() {
		return lastNumber;
	}

	public void setLastNumber(String lastNumber) {
		this.lastNumber = lastNumber;
	}

	public Double getRealWage() {
		return realWage;
	}

	public void setRealWage(Double realWage) {
		this.realWage = realWage;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Double getDeserveWage() {
		return deserveWage;
	}

	public void setDeserveWage(Double deserveWage) {
		this.deserveWage = deserveWage;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getDepartmentInfo() {
		return departmentInfo;
	}

	public void setDepartmentInfo(String departmentInfo) {
		this.departmentInfo = departmentInfo;
	}

	public Double getBasicWage() {
		return basicWage;
	}

	public void setBasicWage(Double basicWage) {
		this.basicWage = basicWage;
	}

	public Double getFloatWage() {
		return floatWage;
	}

	public void setFloatWage(Double floatWage) {
		this.floatWage = floatWage;
	}

	public Double getAllowanceSubsidy() {
		return allowanceSubsidy;
	}

	public void setAllowanceSubsidy(Double allowanceSubsidy) {
		this.allowanceSubsidy = allowanceSubsidy;
	}

	public Double getOvertimePay() {
		return overtimePay;
	}

	public void setOvertimePay(Double overtimePay) {
		this.overtimePay = overtimePay;
	}

	public Double getBeforeTaxReissue() {
		return beforeTaxReissue;
	}

	public void setBeforeTaxReissue(Double beforeTaxReissue) {
		this.beforeTaxReissue = beforeTaxReissue;
	}

	public Double getAfterTaxReissue() {
		return afterTaxReissue;
	}

	public void setAfterTaxReissue(Double afterTaxReissue) {
		this.afterTaxReissue = afterTaxReissue;
	}
	
}
