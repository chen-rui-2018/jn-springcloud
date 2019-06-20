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
 * @create 2019-04-23 上午 10:37
 */
@ApiModel(value = "EducationExperience", description = "教育经历实体")
public class EducationExperience extends BaseRowModel implements Serializable {
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "学校",required = true)
    @ExcelProperty(value = "学校", index = 1)
    private String school;

    @ApiModelProperty(value = "专业")
    @ExcelProperty(value = "专业", index = 2)
    private String major;

    @ApiModelProperty(value = "入校时间",required = true)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date admissionTime;

    @ExcelProperty(value = "入校时间", index = 3)
    private String admissionTimeStr;

    @ApiModelProperty(value = "结业时间",required = true)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date completionTime;

    @ExcelProperty(value = "结业时间", index = 4)
    private String completionTimeStr;

    @ApiModelProperty(value = "学历编码")
    private String educationCode;

    @ApiModelProperty(value = "学历名称")
    @ExcelProperty(value = "学历", index = 5)
    private String educationName;

    @ApiModelProperty(value = "是否取得学位（1：是，2：否）")
    private Byte isAcademicDegree;
    @ExcelProperty(value = "是否取得学位", index = 6)
    private String isAcademicDegreeStr;

    @ApiModelProperty(value = "教育证书照1")
    private String certificateEducaUrlOne;

    @ApiModelProperty(value = "教育证书照2")
    private String certificateEducaUrlTwo;

    @ApiModelProperty(value = "工号",required = true)
    @ExcelProperty(value = "工号", index = 0)
    private String jobNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Date getAdmissionTime() {
        return admissionTime;
    }

    public void setAdmissionTime(Date admissionTime) {
        this.admissionTime = admissionTime;
    }

    public Date getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(Date completionTime) {
        this.completionTime = completionTime;
    }

    public String getEducationCode() {
        return educationCode;
    }

    public void setEducationCode(String educationCode) {
        this.educationCode = educationCode;
    }

    public String getEducationName() {
        return educationName;
    }

    public void setEducationName(String educationName) {
        this.educationName = educationName;
    }

    public Byte getIsAcademicDegree() {
        return isAcademicDegree;
    }

    public void setIsAcademicDegree(Byte isAcademicDegree) {
        this.isAcademicDegree = isAcademicDegree;
    }

    public String getCertificateEducaUrlOne() {
        return certificateEducaUrlOne;
    }

    public void setCertificateEducaUrlOne(String certificateEducaUrlOne) {
        this.certificateEducaUrlOne = certificateEducaUrlOne;
    }

    public String getCertificateEducaUrlTwo() {
        return certificateEducaUrlTwo;
    }

    public void setCertificateEducaUrlTwo(String certificateEducaUrlTwo) {
        this.certificateEducaUrlTwo = certificateEducaUrlTwo;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getAdmissionTimeStr() {
        return admissionTimeStr;
    }

    public void setAdmissionTimeStr(String admissionTimeStr) {
        this.admissionTimeStr = admissionTimeStr;
    }

    public String getCompletionTimeStr() {
        return completionTimeStr;
    }

    public void setCompletionTimeStr(String completionTimeStr) {
        this.completionTimeStr = completionTimeStr;
    }

    public String getIsAcademicDegreeStr() {
        return isAcademicDegreeStr;
    }

    public void setIsAcademicDegreeStr(String isAcademicDegreeStr) {
        this.isAcademicDegreeStr = isAcademicDegreeStr;
    }

    @Override
    public String toString() {
        return "EducationExperience{" +
                "id='" + id + '\'' +
                ", school='" + school + '\'' +
                ", major='" + major + '\'' +
                ", admissionTime=" + admissionTime +
                ", completionTime=" + completionTime +
                ", educationCode='" + educationCode + '\'' +
                ", educationName='" + educationName + '\'' +
                ", isAcademicDegree=" + isAcademicDegree +
                ", certificateEducaUrlOne='" + certificateEducaUrlOne + '\'' +
                ", certificateEducaUrlTwo='" + certificateEducaUrlTwo + '\'' +
                ", jobNumber='" + jobNumber + '\'' +
                '}';
    }
}
