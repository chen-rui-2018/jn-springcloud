package com.jn.hr.employee.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author dt
 * @create 2019-04-19 上午 9:24
 */
@ApiModel(value = "EmployeeBasicInfoAdd", description = "员工基础信息添加实体")
public class EmployeeBasicInfoAdd implements Serializable {
    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "员工头像")
    private String employeePortrait;
    @ApiModelProperty(value = "姓名")
    @NotNull(message = "姓名不能为空")
    private String name;
    @ApiModelProperty(value = "（1:男 2:女）")
    @NotNull(message = "性别不能为空")
    private String sex;
    @ApiModelProperty(value = "手机号码")
    @NotNull(message = "手机号码不能为空")
    @Pattern(regexp="^1[34578]\\d{9}$",message="请正确输入手机号")
    private String phone;
    @ApiModelProperty(value = "个人邮箱")
    @NotNull(message = "个人邮箱不能为空")
    @Pattern(regexp="^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$",message="请正确输入邮箱")
    private String mailbox;
    @ApiModelProperty(value = "部门ID")
    @NotNull(message = "部门ID不能为空")
    private String departmentId;
    @ApiModelProperty(value = "部门名称")
    @NotNull(message = "部门名称不能为空")
    private String departmentName;
    @ApiModelProperty(value = "职位ID")
    @NotNull(message = "职位ID不能为空")
    private String jobId;
    @ApiModelProperty(value = "职位名称")
    @NotNull(message = "职位名称不能为空")
    private String jobName;
    @ApiModelProperty(value = "证件ID")
    @NotNull(message = "证件ID不能为空")
    private String certificateId;
    @ApiModelProperty(value = "证件类型")
    @NotNull(message = "证件类型不能为空")
    private String certificateType;
    @ApiModelProperty(value = "证件号码")
    @NotNull(message = "证件号码不能为空")
    private String certificateNumber;
    @ApiModelProperty(value = "职务ID")
    @NotNull(message = "职务ID不能为空")
    private String postId;
    @ApiModelProperty(value = "职务名称")
    @NotNull(message = "职务名称不能为空")
    private String postName;
    @ApiModelProperty(value = "工号")
    private String jobNumber;
    @ApiModelProperty(value = "合同类型ID")
    @NotNull(message = "合同类型不能为空")
    private String contractId;
    @ApiModelProperty(value = "合同类型名称")
    @NotNull(message = "合同类型名称不能为空")
    private String contractName;
    @ApiModelProperty(value = "员工类型（1：正式，2：实习生）")
    @NotNull(message = "员工类型不能为空")
    private String employeeType;
    @ApiModelProperty(value = "入职日期")
    @NotNull(message = "入职日期不能为空")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date entryDate;
    @ApiModelProperty(value = "出生日期")
    @NotNull(message = "出生日期不能为空")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthDate;
    @ApiModelProperty(value = "国籍编号")
    @NotNull(message = "国籍编号不能为空")
    private String nationalityId;
    @ApiModelProperty(value = "国籍名称")
    @NotNull(message = "国籍名称不能为空")
    private String nationalityName;
    @ApiModelProperty(value = "工作地址")
    @NotNull(message = "工作地址不能为空")
    private String workAddress;
    @ApiModelProperty(value = "联系地址")
    @NotNull(message = "联系地址不能为空")
    private String contactAddress;
    @ApiModelProperty(value = "证件姓名")
    private String certificateName;
    @ApiModelProperty(value = "民族")
    private String nation;
    @ApiModelProperty(value = "户口类型（1：城市，2：农村）")
    private String registeredType;
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
    @ApiModelProperty(value = "婚姻状态（1：未婚，2：已婚）")
    private String maritalStatus;
    @ApiModelProperty(value = "紧急联系人姓名")
    private String emergencyContactName;
    @ApiModelProperty(value = "紧急联系人电话")
    private String emergencyContactPhone;
    @ApiModelProperty(value = "QQ")
    private String qq;
    @ApiModelProperty(value = "微信")
    private String wechat;
    @ApiModelProperty(value = "当前合同起始日")
    @NotNull(message = "当前合同起始日不能为空")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startCurrent;
    @ApiModelProperty(value = "当前合同终止日")
    @NotNull(message = "当前合同终止日不能为空")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endCurrent;
    @ApiModelProperty(value = "工作邮箱")
    private String workMailbox;
    @ApiModelProperty(value = "工作电话")
    private String workPhone;
    @ApiModelProperty(value = "试用期到期日")
    @NotNull(message = "试用期到期日不能为空")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expirationDate;
    @ApiModelProperty(value = "试用期")
    private String probationPeriod;
    @ApiModelProperty(value = "是否删除（0标记删除，1正常）")
    private Byte recordStatus;

    @ApiModelProperty(value = "员工状态(1在职，2医疗期)")
    @NotNull(message = "员工状态不能为空")
    private Byte employStatus;
    @ApiModelProperty(value = "用户Id")
    private String userId;
    @ApiModelProperty(value = "用户账号")
    private String userAccount;


    @ApiModelProperty(value = "教育经历")
    private List<EducationExperienceAdd> educationExperienceList;
    @ApiModelProperty(value = "工作经历")
    private List<WorkExperienceAdd> workExperienceList;
    @ApiModelProperty(value = "荣誉墙")
    private List<HonorWallAdd> honorWallList;

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

    public List<EducationExperienceAdd> getEducationExperienceList() {
        return educationExperienceList;
    }

    public void setEducationExperienceList(List<EducationExperienceAdd> educationExperienceList) {
        this.educationExperienceList = educationExperienceList;
    }

    public List<WorkExperienceAdd> getWorkExperienceList() {
        return workExperienceList;
    }

    public void setWorkExperienceList(List<WorkExperienceAdd> workExperienceList) {
        this.workExperienceList = workExperienceList;
    }

    public List<HonorWallAdd> getHonorWallList() {
        return honorWallList;
    }

    public void setHonorWallList(List<HonorWallAdd> honorWallList) {
        this.honorWallList = honorWallList;
    }

    public Byte getEmployStatus() {
        return employStatus;
    }

    public void setEmployStatus(Byte employStatus) {
        this.employStatus = employStatus;
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

    /*public static void main(String[] args) {
        EmployeeBasicInfoAdd add=new EmployeeBasicInfoAdd();
        add.setEmployeePortrait("111");
        add.setName("小张");
        add.setSex("1");
        add.setPhone("18409878900");
        add.setMailbox("32@qq.com");
        add.setDepartmentId("1");
        add.setDepartmentName("开发部");
        add.setJobId("1");
        add.setJobName("java开发工程师");
        add.setCertificateId("1");
        add.setCertificateType("身份证");
        add.setCertificateNumber("223456778899000008");
        add.setPostId("1");
        add.setPostName("部门经理");
        add.setJobNumber("NJ1");
        add.setContractId("1");
        add.setContractName("合同1");
        add.setEmployeeType("正式");
        add.setEntryDate(new Date());
        add.setBirthDate(new Date());
        add.setNationalityId("1");
        add.setNationalityName("中国");
        add.setWorkAddress("广州珠江新城");
        add.setContactAddress("建滔广场");
        add.setCertificateName("小张");
        add.setNation("汉");
        add.setRegisteredType("1");
        add.setRegisteredResidence("城市");
        add.setNativePlace("广东广州");
        add.setResidentialAddress("广州天河区");
        add.setHighestAcademic("本科");
        add.setPoliticalOutlook("1");
        add.setMaritalStatus("1");
        add.setEmergencyContactName("小刘");
        add.setEmergencyContactPhone("18675681234");
        add.setQq("54323456");
        add.setWechat("12344");
        add.setStartCurrent(new Date());
        add.setEndCurrent(new Date());
        add.setWorkMailbox("qq@tydic.com");
        add.setWorkPhone("16543567866");
        add.setExpirationDate(new Date());
        add.setProbationPeriod("3");
        add.setRecordStatus((byte)1);

        List<EducationExperienceAdd> educationExperienceList=new ArrayList<EducationExperienceAdd>();
        EducationExperienceAdd addeducation=new EducationExperienceAdd();
        addeducation.setSchool("广州工业");
        addeducation.setMajor("计算机");
        addeducation.setAdmissionTime(new Date());
        addeducation.setCompletionTime(new Date());
        addeducation.setEducationCode("44003");
        addeducation.setEducationName("本科");
        addeducation.setIsAcademicDegree((byte)1);
        addeducation.setCertificateEducaUrlOne("www.baidu.com/3");
        addeducation.setCertificateEducaUrlTwo("www.baidu.com/4");
        addeducation.setJobNumber("NJ1");
        educationExperienceList.add(addeducation);

        EducationExperienceAdd addeducation2=new EducationExperienceAdd();
        addeducation2.setSchool("广州工业2");
        addeducation2.setMajor("计算机2");
        addeducation2.setAdmissionTime(new Date());
        addeducation2.setCompletionTime(new Date());
        addeducation2.setEducationCode("440032");
        addeducation2.setEducationName("本科2");
        addeducation2.setIsAcademicDegree((byte)1);
        addeducation2.setCertificateEducaUrlOne("www.baidu.com/3");
        addeducation2.setCertificateEducaUrlTwo("www.baidu.com/4");
        addeducation2.setJobNumber("NJ1");
        educationExperienceList.add(addeducation2);

        List<WorkExperienceAdd> workExperienceList=new ArrayList<WorkExperienceAdd>();
        WorkExperienceAdd workExperienceAdd=new WorkExperienceAdd();
        workExperienceAdd.setJobNumber("NJ1");
        workExperienceAdd.setCorporateName("迪科");
        workExperienceAdd.setAssumeOffice("开发经理");
        workExperienceAdd.setEntryDate(new Date());
        workExperienceAdd.setLeavedate(new Date());
        workExperienceAdd.setJobDescription("软件开发相关");
        workExperienceAdd.setWorkType((byte)2);
        workExperienceList.add(workExperienceAdd);

        WorkExperienceAdd workExperienceAdd2=new WorkExperienceAdd();
        workExperienceAdd2.setJobNumber("NJ1");
        workExperienceAdd2.setCorporateName("迪科2");
        workExperienceAdd2.setAssumeOffice("开发经理2");
        workExperienceAdd2.setEntryDate(new Date());
        workExperienceAdd2.setLeavedate(new Date());
        workExperienceAdd2.setJobDescription("软件开发相关2");
        workExperienceAdd2.setWorkType((byte)2);
        workExperienceList.add(workExperienceAdd2);


        List<HonorWallAdd> honorWallList=new ArrayList<HonorWallAdd>();
        HonorWallAdd honorWallAdd=new HonorWallAdd();
        honorWallAdd.setJobNumber("NJ1");
        honorWallAdd.setHonoraryPictures("www.baidu.com/1");
        honorWallAdd.setHonoraryFile("www.baidu.com/2");
        honorWallList.add(honorWallAdd);

        HonorWallAdd honorWallAdd2=new HonorWallAdd();
        honorWallAdd2.setJobNumber("NJ1");
        honorWallAdd2.setHonoraryPictures("www.baidu.com/3");
        honorWallAdd2.setHonoraryFile("www.baidu.com/4");
        honorWallList.add(honorWallAdd2);

        add.setEducationExperienceList(educationExperienceList);
        add.setWorkExperienceList(workExperienceList);
        add.setHonorWallList(honorWallList);
        System.out.println(JSON.toJSONString(add));


    }*/
}
