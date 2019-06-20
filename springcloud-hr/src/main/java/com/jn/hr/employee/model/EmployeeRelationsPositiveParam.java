package com.jn.hr.employee.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工关系-转正管理实体类
 *
 * @author： wzy
 * @date： Created on 2019/6/11 20:46
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "EmployeeRelationsPositiveParam", description = "转正管理实体类")
public class EmployeeRelationsPositiveParam implements Serializable {
    private static final long serialVersionUID = 3520997443825852984L;

    @ApiModelProperty(value="员工ID")
    private String id;

    @ApiModelProperty(value="工号")
    private String jobNumber;

    @ApiModelProperty(value="姓名")
    private String name;

    @ApiModelProperty(value="确认转正日期")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date correctionDate;

    @ApiModelProperty(value="部门")
    private String department;

    @ApiModelProperty(value="职位")
    private String jobName;

    @ApiModelProperty(value="联系电话")
    private String phone;

    @ApiModelProperty(value="入职日期")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date entryDate;

    @ApiModelProperty(value="试用期到期日期")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date periodDate;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCorrectionDate() {
        return correctionDate;
    }

    public void setCorrectionDate(Date correctionDate) {
        this.correctionDate = correctionDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getPeriodDate() {
        return periodDate;
    }

    public void setPeriodDate(Date periodDate) {
        this.periodDate = periodDate;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EmployeeRelationsPositiveParam{" +
                "id='" + id + '\'' +
                ", jobNumber='" + jobNumber + '\'' +
                ", name='" + name + '\'' +
                ", correctionDate=" + correctionDate +
                ", department='" + department + '\'' +
                ", jobName='" + jobName + '\'' +
                ", phone='" + phone + '\'' +
                ", entryDate=" + entryDate +
                ", periodDate=" + periodDate +
                ", status=" + status +
                '}';
    }
}
