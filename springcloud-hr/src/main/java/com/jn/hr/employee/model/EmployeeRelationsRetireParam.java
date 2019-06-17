package com.jn.hr.employee.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工关系-退休管理实体类
 *
 * @author： wzy
 * @date： Created on 2019/6/11 20:46
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "EmployeeRelationsRetireParam", description = "退休管理实体类")
public class EmployeeRelationsRetireParam implements Serializable {
    private static final long serialVersionUID = 3520997443825852984L;

    @ApiModelProperty(value="员工ID")
    private String id;

    @ApiModelProperty(value="工号")
    private String jobNumber;

    @ApiModelProperty(value="部门")
    private String department;

    @ApiModelProperty(value="姓名")
    private String name;

    @ApiModelProperty(value="申请日期")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date applicationDate;

    @ApiModelProperty(value="申请原因")
    private String applicationReason;

    @ApiModelProperty(value="预计退休日期")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date expectedRetirementDate;

    @ApiModelProperty(value="最后工作日期")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date finalWorkDate;

    @ApiModelProperty(value="薪资结算日期")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date salarySettlementDate;

    @ApiModelProperty(value="备注")
    private String remark;

    @ApiModelProperty(value="审批状态（1：通过，2：不通过，3：审核中，4：未审核）")
    private Byte status;

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getApplicationReason() {
        return applicationReason;
    }

    public void setApplicationReason(String applicationReason) {
        this.applicationReason = applicationReason;
    }

    public Date getExpectedRetirementDate() {
        return expectedRetirementDate;
    }

    public void setExpectedRetirementDate(Date expectedRetirementDate) {
        this.expectedRetirementDate = expectedRetirementDate;
    }

    public Date getFinalWorkDate() {
        return finalWorkDate;
    }

    public void setFinalWorkDate(Date finalWorkDate) {
        this.finalWorkDate = finalWorkDate;
    }

    public Date getSalarySettlementDate() {
        return salarySettlementDate;
    }

    public void setSalarySettlementDate(Date salarySettlementDate) {
        this.salarySettlementDate = salarySettlementDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EmployeeRelationsRetireParam{" +
                "id='" + id + '\'' +
                ", jobNumber='" + jobNumber + '\'' +
                ", department='" + department + '\'' +
                ", name='" + name + '\'' +
                ", applicationDate=" + applicationDate +
                ", applicationReason='" + applicationReason + '\'' +
                ", expectedRetirementDate=" + expectedRetirementDate +
                ", finalWorkDate=" + finalWorkDate +
                ", salarySettlementDate=" + salarySettlementDate +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                '}';
    }
}
