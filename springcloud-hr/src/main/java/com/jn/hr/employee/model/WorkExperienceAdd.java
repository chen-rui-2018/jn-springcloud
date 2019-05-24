package com.jn.hr.employee.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author dt
 * @create 2019-04-23 上午 8:59
 */
@ApiModel(value = "WorkExperienceAdd", description = "工作经历添加实体")
public class WorkExperienceAdd implements Serializable {
    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "工号",required = true)
    private String jobNumber;
    @ApiModelProperty(value = "公司名称",required = true)
    @NotNull(message = "公司名称不能为空")
    private String corporateName;
    @ApiModelProperty(value = "担任职位",required = true)
    @NotNull(message = "担任职位不能为空")
    private String assumeOffice;
    @ApiModelProperty(value = "入职日期",required = true)
    @NotNull(message = "入职日期不能为空")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date entryDate;
    @ApiModelProperty(value = "离职日期",required = true)
    @NotNull(message = "离职日期不能为空")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date leaveDate;
    @ApiModelProperty(value = "职位描述")
    private String jobDescription;
    @ApiModelProperty(value = "工作类型（1：社会实践，2：工作经历）",required = true)
    @NotNull(message = "工作类型不能为空")
    private Byte workType;

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

    @Override
    public String toString() {
        return "WorkExperienceAdd{" +
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
