package com.jn.hr.employee.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author dt
 * @create 2019-04-15 上午 10:33
 */
@ApiModel(value = "ResumeDatabaseAdd", description = "简历库添加实体")
public class ResumeDatabaseAdd implements Serializable {
    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "姓名",required = true)
    @NotNull(message = "姓名不能为空")
    private String name;
    @ApiModelProperty(value = "性别（1:男 2:女）",example = "1",required = true)
    @NotNull(message = "性别不能为空")
    private String sex;
    @ApiModelProperty(value = "手机号",required = true)
    @NotNull(message = "手机号不能为空")
    @Pattern(regexp="^1[34578]\\d{9}$",message="请正确输入手机号")
    private String phone;
    @ApiModelProperty(value = "邮箱",required = true)
    @Pattern(regexp="^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$",message="请正确输入邮箱")
    @NotNull(message = "邮箱不能为空")
    private String mailbox;
    @ApiModelProperty(value = "部门ID",required = true)
    @NotNull(message = "部门ID不能为空")
    private String departmentId;
    @ApiModelProperty(value = "部门名称",required = true)
    @NotNull(message = "部门名称不能为空")
    private String departmentName;
    @ApiModelProperty(value = "职位ID",required = true)
    @NotNull(message = "职位ID不能为空")
    private String jobId;
    @ApiModelProperty(value = "职位名称",required = true)
    @NotNull(message = "职位名称不能为空")
    private String jobName;
    @ApiModelProperty(value = "证件类型ID",required = true)
    @NotNull(message = "证件类型ID不能为空")
    private String certificateId;
    @ApiModelProperty(value = "证件类型",required = true)
    @NotNull(message = "证件类型不能为空")
    private String certificateType;
    @ApiModelProperty(value = "证件号",required = true)
    @NotNull(message = "证件号不能为空")
    private String certificateNumber;
    @ApiModelProperty(value = "学历ID",required = true)
    @NotNull(message = "学历ID不能为空")
    private String educationId;
    @ApiModelProperty(value = "学历名称",required = true)
    @NotNull(message = "学历名称不能为空")
    private String educationName;
    @ApiModelProperty(value = "毕业院校",required = true)
    @NotNull(message = "毕业院校不能为空")
    private String graduaAcademy;
    @ApiModelProperty(value = "简历信息")
    private String resumeInfo;
    @ApiModelProperty(value = "是否完成背景调查（1：是 2：否）")
    private Byte isBackgroundInvest;
    @ApiModelProperty(value = "应聘结果（1：通过，2：淘汰，3：等待结果）")
    private Byte applicationResult;
    @ApiModelProperty(value = "状态（0删除,1有效,2失效", example = "\"1\"")
    private Byte recordStatus;

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

    @Override
    public String toString() {
        return "ResumeDatabaseAdd{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
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
                ", applicationResult=" + applicationResult +
                ", recordStatus=" + recordStatus +
                '}';
    }

    /*public static void main(String[] args) throws Exception{
        ResumeDatabaseAdd add=new ResumeDatabaseAdd();
        add.setName("小王");
        add.setSex("1");
        add.setPhone("1856500");
        add.setMailbox("32qq.com");
        add.setDepartmentId("1");
        add.setDepartmentName("开发部");
        add.setJobId("1");
        add.setJobName("开发组长");
        add.setCertificateId("1");
        add.setCertificateType("身份证");
        add.setCertificateNumber("421123");
        add.setEducationId("1");
        add.setEducationName("大专");
        add.setGraduaAcademy("理工学院");
        add.setResumeInfo("15年毕业");
        add.setIsBackgroundInvest((byte)1);
        add.setApplicationResult((byte)1);
        add.setRecordStatus((byte)1);
        ObjectMapper mapper=new ObjectMapper();
        System.out.println(mapper.writeValueAsString(add));

    }*/
}
