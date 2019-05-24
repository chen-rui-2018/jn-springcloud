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
 * @create 2019-04-15 上午 10:34
 */
@ApiModel(value = "ResumeDatabase", description = "简历库实体")
public class ResumeDatabase extends BaseRowModel implements Serializable {
    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "姓名")
    @ExcelProperty(value = "姓名", index = 0)
    private String name;
    @ApiModelProperty(value = "性别（1:男 2:女）")
    private String sex;

    @ApiModelProperty(value = "性别（1:男 2:女）")
    @ExcelProperty(value = "性别", index = 1)
    private String sexStr;
    @ApiModelProperty(value = "手机号")
    @ExcelProperty(value = "手机号", index = 2)
    private String phone;
    @ApiModelProperty(value = "邮箱")
    @ExcelProperty(value = "邮箱", index = 3)
    private String mailbox;
    @ApiModelProperty(value = "部门ID")
    private String departmentId;
    @ApiModelProperty(value = "部门名称")
    @ExcelProperty(value = "部门名称", index = 4)
    private String departmentName;
    @ApiModelProperty(value = "职位ID")
    private String jobId;

    @ApiModelProperty(value = "职位名称")
    @ExcelProperty(value = "职位名称", index = 5)
    private String jobName;
    @ApiModelProperty(value = "证件类型ID")
    private String certificateId;
    @ApiModelProperty(value = "证件类型")
    @ExcelProperty(value = "证件类型", index = 6)
    private String certificateType;
    @ApiModelProperty(value = "证件号")
    @ExcelProperty(value = "证件号", index = 7)
    private String certificateNumber;
    @ApiModelProperty(value = "学历ID")
    private String educationId;
    @ApiModelProperty(value = "学历名称")
    @ExcelProperty(value = "学历名称", index = 8)
    private String educationName;
    @ApiModelProperty(value = "毕业院校")
    @ExcelProperty(value = "毕业院校", index = 9)
    private String graduaAcademy;
    @ApiModelProperty(value = "简历信息")
    private String resumeInfo;
    @ApiModelProperty(value = "是否完成背景调查（1：是 2：否）")
    private Byte isBackgroundInvest;
    @ApiModelProperty(value = "是否完成背景调查（1：是 2：否）")
    private String isBackgroundInvestStr;
    @ApiModelProperty(value = "应聘结果（1：通过，2：淘汰，3：等待结果）")
    private Byte applicationResult;
    @ApiModelProperty(value = "应聘结果（1：通过，2：淘汰，3：等待结果）")
    private String applicationResultStr;
    @ApiModelProperty(value = "状态")
    private Byte recordStatus;
    @ApiModelProperty(value = "创建者账号")
    private String creatorAccount;
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
    @ApiModelProperty(value = "最新更新者账号")
    private String modifierAccount;
    @ApiModelProperty(value = "最新更新时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;
    @ApiModelProperty(value = "背景调查")
    private BackgroundInvest backgroundInvest;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
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

    public String getEducationId() {
        return educationId;
    }

    public void setEducationId(String educationId) {
        this.educationId = educationId;
    }

    public String getEducationName() {
        return educationName;
    }

    public void setEducationName(String educationName) {
        this.educationName = educationName;
    }

    public String getGraduaAcademy() {
        return graduaAcademy;
    }

    public void setGraduaAcademy(String graduaAcademy) {
        this.graduaAcademy = graduaAcademy;
    }

    public String getResumeInfo() {
        return resumeInfo;
    }

    public void setResumeInfo(String resumeInfo) {
        this.resumeInfo = resumeInfo;
    }

    public Byte getIsBackgroundInvest() {
        return isBackgroundInvest;
    }

    public void setIsBackgroundInvest(Byte isBackgroundInvest) {
        this.isBackgroundInvest = isBackgroundInvest;
    }

    public Byte getApplicationResult() {
        return applicationResult;
    }

    public void setApplicationResult(Byte applicationResult) {
        this.applicationResult = applicationResult;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public BackgroundInvest getBackgroundInvest() {
        return backgroundInvest;
    }

    public void setBackgroundInvest(BackgroundInvest backgroundInvest) {
        this.backgroundInvest = backgroundInvest;
    }

    public String getSexStr() {
        return sexStr;
    }

    public void setSexStr(String sexStr) {
        this.sexStr = sexStr;
    }

    public String getIsBackgroundInvestStr() {
        return isBackgroundInvestStr;
    }

    public void setIsBackgroundInvestStr(String isBackgroundInvestStr) {
        this.isBackgroundInvestStr = isBackgroundInvestStr;
    }

    public String getApplicationResultStr() {
        return applicationResultStr;
    }

    public void setApplicationResultStr(String applicationResultStr) {
        this.applicationResultStr = applicationResultStr;
    }

    @Override
    public String toString() {
        return "ResumeDatabase{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", sexStr='" + sexStr + '\'' +
                ", phone='" + phone + '\'' +
                ", mailbox='" + mailbox + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", jobId='" + jobId + '\'' +
                ", jobName='" + jobName + '\'' +
                ", certificateId='" + certificateId + '\'' +
                ", certificateType='" + certificateType + '\'' +
                ", certificateNumber='" + certificateNumber + '\'' +
                ", educationId='" + educationId + '\'' +
                ", educationName='" + educationName + '\'' +
                ", graduaAcademy='" + graduaAcademy + '\'' +
                ", resumeInfo='" + resumeInfo + '\'' +
                ", isBackgroundInvest=" + isBackgroundInvest +
                ", isBackgroundInvestStr='" + isBackgroundInvestStr + '\'' +
                ", applicationResult=" + applicationResult +
                ", applicationResultStr='" + applicationResultStr + '\'' +
                ", recordStatus=" + recordStatus +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", createdTime=" + createdTime +
                ", modifierAccount='" + modifierAccount + '\'' +
                ", modifiedTime=" + modifiedTime +
                ", backgroundInvest=" + backgroundInvest +
                '}';
    }
}
