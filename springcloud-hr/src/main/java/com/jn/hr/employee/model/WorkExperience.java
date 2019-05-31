package com.jn.hr.employee.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author dt
 * @create 2019-04-23 上午 10:35
 */
@ApiModel(value = "WorkExperience", description = "工作经历实体")
public class WorkExperience extends BaseRowModel implements Serializable {
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "工号",required = true)
    @ExcelProperty(value = "工号", index = 0)
    private String jobNumber;

    @ApiModelProperty(value = "公司名称",required = true)
    @ExcelProperty(value = "公司名称", index = 1)
    private String corporateName;

    @ApiModelProperty(value = "担任职位",required = true)
    @ExcelProperty(value = "担任职位", index = 2)
    private String assumeOffice;

    @ApiModelProperty(value = "入职日期",required = true)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date entryDate;

    @ExcelProperty(value = "入职日期", index = 3)
    private String entryDateStr;

    @ApiModelProperty(value = "离职日期",required = true)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date leaveDate;

    @ExcelProperty(value = "离职日期", index = 4)
    private String leaveDateStr;

    @ApiModelProperty(value = "职位描述")
    @ExcelProperty(value = "职位描述", index = 5)
    private String jobDescription;

    @ApiModelProperty(value = "工作类型（1：社会实践，2：工作经历）",required = true)
    private Byte workType;
    @ExcelProperty(value = "工作类型", index = 6)
    private String workTypeStr;

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

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public String getAssumeOffice() {
        return assumeOffice;
    }

    public void setAssumeOffice(String assumeOffice) {
        this.assumeOffice = assumeOffice;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public Byte getWorkType() {
        return workType;
    }

    public void setWorkType(Byte workType) {
        this.workType = workType;
    }

    public String getEntryDateStr() {
        return entryDateStr;
    }

    public void setEntryDateStr(String entryDateStr) {
        this.entryDateStr = entryDateStr;
    }

    public String getLeaveDateStr() {
        return leaveDateStr;
    }

    public void setLeaveDateStr(String leaveDateStr) {
        this.leaveDateStr = leaveDateStr;
    }

    public String getWorkTypeStr() {
        return workTypeStr;
    }

    public void setWorkTypeStr(String workTypeStr) {
        this.workTypeStr = workTypeStr;
    }

    @Override
    public String toString() {
        return "WorkExperience{" +
                "id='" + id + '\'' +
                ", jobNumber='" + jobNumber + '\'' +
                ", corporateName='" + corporateName + '\'' +
                ", assumeOffice='" + assumeOffice + '\'' +
                ", entryDate=" + entryDate +
                ", leaveDate=" + leaveDate +
                ", jobDescription='" + jobDescription + '\'' +
                ", workType=" + workType +
                '}';
    }
}
