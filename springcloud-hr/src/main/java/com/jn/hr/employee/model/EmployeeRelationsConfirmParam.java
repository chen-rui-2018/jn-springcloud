package com.jn.hr.employee.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工关系-入职管理实体类
 *
 * @author： wzy
 * @date： Created on 2019/6/11 20:46
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "EmployeeRelationsConfirmParam", description = "入职管理实体类")
public class EmployeeRelationsConfirmParam implements Serializable {
    private static final long serialVersionUID = 3520997443825852984L;

    @ApiModelProperty(value="员工ID")
    private String id;

    @ApiModelProperty(value="工号")
    private String jobNumber;

    @ApiModelProperty(value="姓名")
    private String name;

    @ApiModelProperty(value="预计入职日期")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date expectedEntryDate;

    @ApiModelProperty(value="确认入职日期")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date confirmEntryDate;

    @ApiModelProperty(value="是否发送入职登记表（1：已发送，2：未发送，3：无）")
    private Byte isEntryRegistration;

    @ApiModelProperty(value="状态（1：未入职，2：已入职，3：放弃入职）")
    private Byte status;

    @ApiModelProperty(value="是否删除（0标记删除，1正常）")
    private Byte recordStatus;

    @ApiModelProperty(value="创建者账号")
    private String creatorAccount;

    @ApiModelProperty(value="创建时间")
    @JsonFormat(locale="zh", timezone="GMT+8",  pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    @ApiModelProperty(value="最新更新者账号")
    private String modifierAccount;

    @ApiModelProperty(value="最新更新时间")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;

    @ApiModelProperty(value="性别（1男2女）")
    private String sex;

    @ApiModelProperty(value="手机号码")
    private String phone;

    @ApiModelProperty(value="个人邮箱")
    private String mailbox;

    @ApiModelProperty(value="部门ID")
    private String departmentId;

    @ApiModelProperty(value="部门名称")
    private String departmentName;

    @ApiModelProperty(value="职级ID")
    private String jobId;

    @ApiModelProperty(value="职级名称")
    private String jobName;

    @ApiModelProperty(value="岗位ID")
    private String postId;

    @ApiModelProperty(value="岗位名称")
    private String postName;

    @ApiModelProperty(value="合同类型ID")
    private String contractId;

    @ApiModelProperty(value="合同类型名称")
    private String contractName;

    @ApiModelProperty(value="员工类型（1：正式，2：实习生）")
    private String employeeType;

    @ApiModelProperty(value="证件ID")
    private String certificateId;

    @ApiModelProperty(value="证件类型")
    private String certificateType;

    @ApiModelProperty(value="证件号码")
    private String certificateNumber;

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

    public Date getExpectedEntryDate() {
        return expectedEntryDate;
    }

    public void setExpectedEntryDate(Date expectedEntryDate) {
        this.expectedEntryDate = expectedEntryDate;
    }

    public Date getConfirmEntryDate() {
        return confirmEntryDate;
    }

    public void setConfirmEntryDate(Date confirmEntryDate) {
        this.confirmEntryDate = confirmEntryDate;
    }

    public Byte getIsEntryRegistration() {
        return isEntryRegistration;
    }

    public void setIsEntryRegistration(Byte isEntryRegistration) {
        this.isEntryRegistration = isEntryRegistration;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
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

    @Override
    public String toString() {
        return "EmployeeRelationsConfirmParam{" +
                "id='" + id + '\'' +
                ", jobNumber='" + jobNumber + '\'' +
                ", name='" + name + '\'' +
                ", expectedEntryDate=" + expectedEntryDate +
                ", confirmEntryDate=" + confirmEntryDate +
                ", isEntryRegistration=" + isEntryRegistration +
                ", status=" + status +
                ", recordStatus=" + recordStatus +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", createdTime=" + createdTime +
                ", modifierAccount='" + modifierAccount + '\'' +
                ", modifiedTime=" + modifiedTime +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", mailbox='" + mailbox + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", jobId='" + jobId + '\'' +
                ", jobName='" + jobName + '\'' +
                ", postId='" + postId + '\'' +
                ", postName='" + postName + '\'' +
                ", contractId='" + contractId + '\'' +
                ", contractName='" + contractName + '\'' +
                ", employeeType='" + employeeType + '\'' +
                ", certificateId='" + certificateId + '\'' +
                ", certificateType='" + certificateType + '\'' +
                ", certificateNumber='" + certificateNumber + '\'' +
                '}';
    }
}
