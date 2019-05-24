package com.jn.hr.employee.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author dt
 * @create 2019-04-30 下午 5:13
 */
@ApiModel(value = "SocialSecurity", description = "社保福利实体")
public class SocialSecurity extends BaseRowModel implements Serializable {
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "工号")
    @ExcelProperty(value = "工号", index = 0)
    private String jobNumber;

    @ApiModelProperty(value = "工资开户行")
    @ExcelProperty(value = "工号", index = 1)
    private String salaryBank;

    @ApiModelProperty(value = "工资卡号")
    @ExcelProperty(value = "工号", index = 2)
    private String salaryNumber;

    @ApiModelProperty(value = "公积金账号")
    @ExcelProperty(value = "工号", index = 3)
    private String providentFundAccount;

    @ApiModelProperty(value = "公积金缴纳地")
    @ExcelProperty(value = "工号", index = 4)
    private String providentFundPayment;

    @ApiModelProperty(value = "社保账号")
    @ExcelProperty(value = "工号", index = 5)
    private String socialSecurityAccount;

    @ApiModelProperty(value = "社保缴纳地")
    @ExcelProperty(value = "工号", index = 6)
    private String socialSecurityPayment;

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

    public String getSalaryBank() {
        return salaryBank;
    }

    public void setSalaryBank(String salaryBank) {
        this.salaryBank = salaryBank;
    }

    public String getSalaryNumber() {
        return salaryNumber;
    }

    public void setSalaryNumber(String salaryNumber) {
        this.salaryNumber = salaryNumber;
    }

    public String getProvidentFundAccount() {
        return providentFundAccount;
    }

    public void setProvidentFundAccount(String providentFundAccount) {
        this.providentFundAccount = providentFundAccount;
    }

    public String getProvidentFundPayment() {
        return providentFundPayment;
    }

    public void setProvidentFundPayment(String providentFundPayment) {
        this.providentFundPayment = providentFundPayment;
    }

    public String getSocialSecurityAccount() {
        return socialSecurityAccount;
    }

    public void setSocialSecurityAccount(String socialSecurityAccount) {
        this.socialSecurityAccount = socialSecurityAccount;
    }

    public String getSocialSecurityPayment() {
        return socialSecurityPayment;
    }

    public void setSocialSecurityPayment(String socialSecurityPayment) {
        this.socialSecurityPayment = socialSecurityPayment;
    }

    @Override
    public String toString() {
        return "SocialSecurity{" +
                "id='" + id + '\'' +
                ", jobNumber='" + jobNumber + '\'' +
                ", salaryBank='" + salaryBank + '\'' +
                ", salaryNumber='" + salaryNumber + '\'' +
                ", providentFundAccount='" + providentFundAccount + '\'' +
                ", providentFundPayment='" + providentFundPayment + '\'' +
                ", socialSecurityAccount='" + socialSecurityAccount + '\'' +
                ", socialSecurityPayment='" + socialSecurityPayment + '\'' +
                '}';
    }
}
