package com.jn.hr.employee.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工关系-离职管理实体类
 *
 * @author： wzy
 * @date： Created on 2019/6/11 20:46
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "EmployeeRelationsQuitParam", description = "退休管理离职管理实体类实体类")
public class EmployeeRelationsQuitParam implements Serializable {
    private static final long serialVersionUID = 3520997443825852984L;

    @ApiModelProperty(value="员工ID")
    private String id;

    @ApiModelProperty(value="工号")
    private String jobNumber;

    @ApiModelProperty(value="申请日期")
    private Date applicationDate;

    @ApiModelProperty(value="姓名")
    private String name;

    @ApiModelProperty(value="离职类型（1：主动，2：被动，3：其他）")
    private Byte turnoverType;

    @ApiModelProperty(value="离职原因")
    private String reasonsLeav;

    @ApiModelProperty(value="预计离职日期")
    private Date estimateLeaveDate;

    @ApiModelProperty(value="最后工作日期")
    private Date finalWorkDate;

    @ApiModelProperty(value="薪资结算日期")
    private Date salarySettlementDate;

    @ApiModelProperty(value="备注")
    private String remark;

    @ApiModelProperty(value="审批状态（1：通过，2：不通过，3：审核中，4：未审核）")
    private Byte status;

    @ApiModelProperty(value="部门")
    private String department;

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

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getTurnoverType() {
        return turnoverType;
    }

    public void setTurnoverType(Byte turnoverType) {
        this.turnoverType = turnoverType;
    }

    public String getReasonsLeav() {
        return reasonsLeav;
    }

    public void setReasonsLeav(String reasonsLeav) {
        this.reasonsLeav = reasonsLeav;
    }

    public Date getEstimateLeaveDate() {
        return estimateLeaveDate;
    }

    public void setEstimateLeaveDate(Date estimateLeaveDate) {
        this.estimateLeaveDate = estimateLeaveDate;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "EmployeeRelationsQuitParam{" +
                "id='" + id + '\'' +
                ", jobNumber='" + jobNumber + '\'' +
                ", applicationDate=" + applicationDate +
                ", name='" + name + '\'' +
                ", turnoverType=" + turnoverType +
                ", reasonsLeav='" + reasonsLeav + '\'' +
                ", estimateLeaveDate=" + estimateLeaveDate +
                ", finalWorkDate=" + finalWorkDate +
                ", salarySettlementDate=" + salarySettlementDate +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                ", department='" + department + '\'' +
                '}';
    }
}
