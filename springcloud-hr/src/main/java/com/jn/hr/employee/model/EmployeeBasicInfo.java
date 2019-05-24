package com.jn.hr.employee.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author dt
 * @create 2019-04-19 上午 9:23
 */
@ApiModel(value = "EmployeeBasicInfo", description = "员工基础信息实体")
public class EmployeeBasicInfo extends BaseRowModel implements Serializable {
    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "员工头像")
    private String employeePortrait;
    @ApiModelProperty(value = "姓名")
    @ExcelProperty(value = "姓名", index = 0)
    private String name;
    @ApiModelProperty(value = "性别")
    private String sex;
    @ApiModelProperty(value = "性别")
    @ExcelProperty(value = "性别", index = 1)
    private String sexStr;
    @ApiModelProperty(value = "手机号码")
    @ExcelProperty(value = "手机号码", index = 2)
    private String phone;
    @ApiModelProperty(value = "个人邮箱")
    @ExcelProperty(value = "个人邮箱", index = 3)
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
    @ApiModelProperty(value = "证件ID")
    private String certificateId;
    @ApiModelProperty(value = "证件类型")
    @ExcelProperty(value = "证件类型", index = 6)
    private String certificateType;
    @ApiModelProperty(value = "证件号码")
    @ExcelProperty(value = "证件号码", index = 7)
    private String certificateNumber;
    @ApiModelProperty(value = "职务ID")
    private String postId;
    @ApiModelProperty(value = "职务名称")
    @ExcelProperty(value = "职务名称", index = 8)
    private String postName;
    @ApiModelProperty(value = "工号")
    @ExcelProperty(value = "工号")
    private String jobNumber;
    @ApiModelProperty(value = "合同类型ID")
    private String contractId;
    @ApiModelProperty(value = "合同类型名称")
    @ExcelProperty(value = "合同类型名称", index = 9)
    private String contractName;
    @ApiModelProperty(value = "员工类型（1：正式，2：实习生）")
    private String employeeType;
    @ExcelProperty(value = "员工类型", index = 10)
    private String employeeTypeStr;
    @ApiModelProperty(value = "入职日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date entryDate;
    @ExcelProperty(value = "入职日期", index = 11,format = "yyyy-MM-dd")
    private String entryDateStr;
    @ApiModelProperty(value = "出生日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthDate;
    @ExcelProperty(value = "出生日期", index = 12,format = "yyyy-MM-dd")
    private String birthDateStr;
    @ApiModelProperty(value = "国籍编号")
    private String nationalityId;
    @ApiModelProperty(value = "国籍名称")
    @ExcelProperty(value = "国籍名称", index = 13)
    private String nationalityName;
    @ApiModelProperty(value = "工作地址")
    @ExcelProperty(value = "工作地址", index = 14)
    private String workAddress;
    @ApiModelProperty(value = "联系地址")
    @ExcelProperty(value = "联系地址", index = 15)
    private String contactAddress;
    @ApiModelProperty(value = "证件姓名")
    private String certificateName;
    @ApiModelProperty(value = "民族")
    private String nation;
    @ApiModelProperty(value = "户口类型（1：城市，2：农村）")
    private String registeredType;
    private String registeredTypeStr;
    @ApiModelProperty(value = "户口所在地")
    private String registeredResidence;
    @ApiModelProperty(value = "籍贯")
    private String nativePlace;
    @ApiModelProperty(value = "居住地址")
    private String residentialAddress;
    @ApiModelProperty(value = "最高学历")
    private String highestAcademic;
    @ApiModelProperty(value = "政治面貌（1：党员，2：团员，3：其他）")
    private String politicalOutlook;
    private String politicalOutlookStr;
    @ApiModelProperty(value = "婚姻状态（1：未婚，2：已婚）")
    private String maritalStatus;
    private String maritalStatusStr;
    @ApiModelProperty(value = "紧急联系人姓名")
    private String emergencyContactName;
    @ApiModelProperty(value = "紧急联系人电话")
    private String emergencyContactPhone;
    @ApiModelProperty(value = "QQ")
    private String qq;
    @ApiModelProperty(value = "微信")
    private String wechat;
    @ApiModelProperty(value = "当前合同起始日")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startCurrent;
    @ExcelProperty(value = "当前合同起始日", index = 16,format = "yyyy-MM-dd")
    private String startCurrentStr;
    @ApiModelProperty(value = "当前合同终止日")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endCurrent;
    @ExcelProperty(value = "当前合同终止日", index = 17,format = "yyyy-MM-dd")
    private String endCurrentStr;
    @ApiModelProperty(value = "工作邮箱")
    private String workMailbox;
    @ApiModelProperty(value = "工作电话")
    private String workPhone;
    @ApiModelProperty(value = "试用期到期日")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expirationDate;
    @ExcelProperty(value = "试用期到期日", index = 18,format = "yyyy-MM-dd")
    private String expirationDateStr;
    @ApiModelProperty(value = "试用期")
    private String probationPeriod;
    @ApiModelProperty(value = "是否删除（0标记删除，1正常）")
    private Byte recordStatus;
    @ApiModelProperty(value = "创建者账号")
    private String creatorAccount;
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
    @ApiModelProperty(value = "创建时间")
    private String createdTimeStr;
    @ApiModelProperty(value = "最新更新者账号")
    private String modifierAccount;
    @ApiModelProperty(value = "最新更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;

    @ApiModelProperty(value = "员工状态(1在职，2医疗期)")
    private Byte employStatus;
    @ApiModelProperty(value = "员工状态(1在职，2医疗期)")
    @ExcelProperty(value = "员工状态", index = 19)
    private String employStatusStr;

    @ApiModelProperty(value = "用户Id")
    private String userId;
    @ApiModelProperty(value = "用户账号")
    private String userAccount;

    @ApiModelProperty(value = "教育经历")
    private List<EducationExperience> educationExperienceList;
    @ApiModelProperty(value = "工作经历")
    private List<WorkExperience> workExperienceList;
    @ApiModelProperty(value = "荣誉墙")
    private List<HonorWall> honorWallList;
    @ApiModelProperty(value = "工龄")
    private Integer workingAge;
    @ApiModelProperty(value = "年休假")
    private Integer annualLeave;

    @ApiModelProperty(value = "直属领导")
    private DirectlyLeader directlyLeader;

    @ApiModelProperty(value = "社保福利")
    private SocialSecurity socialSecurity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeePortrait() {
        return employeePortrait;
    }

    public void setEmployeePortrait(String employeePortrait) {
        this.employeePortrait = employeePortrait;
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

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
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

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(String nationalityId) {
        this.nationalityId = nationalityId;
    }

    public String getNationalityName() {
        return nationalityName;
    }

    public void setNationalityName(String nationalityName) {
        this.nationalityName = nationalityName;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getRegisteredType() {
        return registeredType;
    }

    public void setRegisteredType(String registeredType) {
        this.registeredType = registeredType;
    }

    public String getRegisteredResidence() {
        return registeredResidence;
    }

    public void setRegisteredResidence(String registeredResidence) {
        this.registeredResidence = registeredResidence;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getResidentialAddress() {
        return residentialAddress;
    }

    public void setResidentialAddress(String residentialAddress) {
        this.residentialAddress = residentialAddress;
    }

    public String getHighestAcademic() {
        return highestAcademic;
    }

    public void setHighestAcademic(String highestAcademic) {
        this.highestAcademic = highestAcademic;
    }

    public String getPoliticalOutlook() {
        return politicalOutlook;
    }

    public void setPoliticalOutlook(String politicalOutlook) {
        this.politicalOutlook = politicalOutlook;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public Date getStartCurrent() {
        return startCurrent;
    }

    public void setStartCurrent(Date startCurrent) {
        this.startCurrent = startCurrent;
    }

    public Date getEndCurrent() {
        return endCurrent;
    }

    public void setEndCurrent(Date endCurrent) {
        this.endCurrent = endCurrent;
    }

    public String getWorkMailbox() {
        return workMailbox;
    }

    public void setWorkMailbox(String workMailbox) {
        this.workMailbox = workMailbox;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getProbationPeriod() {
        return probationPeriod;
    }

    public void setProbationPeriod(String probationPeriod) {
        this.probationPeriod = probationPeriod;
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

    public String getCreatedTimeStr() {
        return createdTimeStr;
    }

    public void setCreatedTimeStr(String createdTimeStr) {
        this.createdTimeStr = createdTimeStr;
    }

    public String getEntryDateStr() {
        return entryDateStr;
    }

    public void setEntryDateStr(String entryDateStr) {
        this.entryDateStr = entryDateStr;
    }

    public String getBirthDateStr() {
        return birthDateStr;
    }

    public void setBirthDateStr(String birthDateStr) {
        this.birthDateStr = birthDateStr;
    }

    public String getStartCurrentStr() {
        return startCurrentStr;
    }

    public void setStartCurrentStr(String startCurrentStr) {
        this.startCurrentStr = startCurrentStr;
    }

    public String getEndCurrentStr() {
        return endCurrentStr;
    }

    public void setEndCurrentStr(String endCurrentStr) {
        this.endCurrentStr = endCurrentStr;
    }

    public String getExpirationDateStr() {
        return expirationDateStr;
    }

    public void setExpirationDateStr(String expirationDateStr) {
        this.expirationDateStr = expirationDateStr;
    }

    public String getEmployeeTypeStr() {
        return employeeTypeStr;
    }

    public void setEmployeeTypeStr(String employeeTypeStr) {
        this.employeeTypeStr = employeeTypeStr;
    }

    public String getRegisteredTypeStr() {
        return registeredTypeStr;
    }

    public void setRegisteredTypeStr(String registeredTypeStr) {
        this.registeredTypeStr = registeredTypeStr;
    }

    public String getPoliticalOutlookStr() {
        return politicalOutlookStr;
    }

    public void setPoliticalOutlookStr(String politicalOutlookStr) {
        this.politicalOutlookStr = politicalOutlookStr;
    }

    public String getMaritalStatusStr() {
        return maritalStatusStr;
    }

    public void setMaritalStatusStr(String maritalStatusStr) {
        this.maritalStatusStr = maritalStatusStr;
    }

    public Byte getEmployStatus() {
        return employStatus;
    }

    public void setEmployStatus(Byte employStatus) {
        this.employStatus = employStatus;
    }

    public String getEmployStatusStr() {
        return employStatusStr;
    }

    public void setEmployStatusStr(String employStatusStr) {
        this.employStatusStr = employStatusStr;
    }

    public List<EducationExperience> getEducationExperienceList() {
        return educationExperienceList;
    }

    public void setEducationExperienceList(List<EducationExperience> educationExperienceList) {
        this.educationExperienceList = educationExperienceList;
    }

    public List<WorkExperience> getWorkExperienceList() {
        return workExperienceList;
    }

    public void setWorkExperienceList(List<WorkExperience> workExperienceList) {
        this.workExperienceList = workExperienceList;
    }

    public List<HonorWall> getHonorWallList() {
        return honorWallList;
    }

    public void setHonorWallList(List<HonorWall> honorWallList) {
        this.honorWallList = honorWallList;
    }

    public String getSexStr() {
        return sexStr;
    }

    public void setSexStr(String sexStr) {
        this.sexStr = sexStr;
    }

    public Integer getWorkingAge() {
        return workingAge;
    }

    public void setWorkingAge(Integer workingAge) {
        this.workingAge = workingAge;
    }

    public Integer getAnnualLeave() {
        return annualLeave;
    }

    public void setAnnualLeave(Integer annualLeave) {
        this.annualLeave = annualLeave;
    }

    public DirectlyLeader getDirectlyLeader() {
        return directlyLeader;
    }

    public void setDirectlyLeader(DirectlyLeader directlyLeader) {
        this.directlyLeader = directlyLeader;
    }

    public SocialSecurity getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(SocialSecurity socialSecurity) {
        this.socialSecurity = socialSecurity;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public String toString() {
        return "EmployeeBasicInfo{" +
                "id='" + id + '\'' +
                ", employeePortrait='" + employeePortrait + '\'' +
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
                ", postId='" + postId + '\'' +
                ", postName='" + postName + '\'' +
                ", jobNumber='" + jobNumber + '\'' +
                ", contractId='" + contractId + '\'' +
                ", contractName='" + contractName + '\'' +
                ", employeeType='" + employeeType + '\'' +
                ", employeeTypeStr='" + employeeTypeStr + '\'' +
                ", entryDate=" + entryDate +
                ", entryDateStr='" + entryDateStr + '\'' +
                ", birthDate=" + birthDate +
                ", birthDateStr='" + birthDateStr + '\'' +
                ", nationalityId='" + nationalityId + '\'' +
                ", nationalityName='" + nationalityName + '\'' +
                ", workAddress='" + workAddress + '\'' +
                ", contactAddress='" + contactAddress + '\'' +
                ", certificateName='" + certificateName + '\'' +
                ", nation='" + nation + '\'' +
                ", registeredType='" + registeredType + '\'' +
                ", registeredTypeStr='" + registeredTypeStr + '\'' +
                ", registeredResidence='" + registeredResidence + '\'' +
                ", nativePlace='" + nativePlace + '\'' +
                ", residentialAddress='" + residentialAddress + '\'' +
                ", highestAcademic='" + highestAcademic + '\'' +
                ", politicalOutlook='" + politicalOutlook + '\'' +
                ", politicalOutlookStr='" + politicalOutlookStr + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", maritalStatusStr='" + maritalStatusStr + '\'' +
                ", emergencyContactName='" + emergencyContactName + '\'' +
                ", emergencyContactPhone='" + emergencyContactPhone + '\'' +
                ", qq='" + qq + '\'' +
                ", wechat='" + wechat + '\'' +
                ", startCurrent=" + startCurrent +
                ", startCurrentStr='" + startCurrentStr + '\'' +
                ", endCurrent=" + endCurrent +
                ", endCurrentStr='" + endCurrentStr + '\'' +
                ", workMailbox='" + workMailbox + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", expirationDate=" + expirationDate +
                ", expirationDateStr='" + expirationDateStr + '\'' +
                ", probationPeriod='" + probationPeriod + '\'' +
                ", recordStatus=" + recordStatus +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", createdTime=" + createdTime +
                ", createdTimeStr='" + createdTimeStr + '\'' +
                ", modifierAccount='" + modifierAccount + '\'' +
                ", modifiedTime=" + modifiedTime +
                ", employStatus=" + employStatus +
                ", employStatusStr='" + employStatusStr + '\'' +
                ", educationExperienceList=" + educationExperienceList +
                ", workExperienceList=" + workExperienceList +
                ", honorWallList=" + honorWallList +
                ", workingAge=" + workingAge +
                ", annualLeave=" + annualLeave +
                "} " + super.toString();
    }
}
