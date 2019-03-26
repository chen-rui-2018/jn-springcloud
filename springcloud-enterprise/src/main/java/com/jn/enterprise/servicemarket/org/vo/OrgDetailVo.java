package com.jn.enterprise.servicemarket.org.vo;

import com.jn.enterprise.servicemarket.org.model.OrgLicense;
import com.jn.enterprise.servicemarket.org.model.OrgTeam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 服务机构详情
 * @author： jiangyl
 * @date： Created on 2019/2/14 10:12
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OrgDetailVo",description = "服务机构详情")
public class OrgDetailVo implements Serializable {
    @ApiModelProperty(value = "服务机构id")
    private String orgId;

    @ApiModelProperty("一级业务领域")
    private String businessType;

    @ApiModelProperty("二级业务领域")
    private String businessSType;

    @ApiModelProperty("机构名称")
    private String orgName;

    @ApiModelProperty("主营业务")
    private String orgBusiness;

    @ApiModelProperty("机构简介")
    private String orgSynopsis;

    @ApiModelProperty(value = "浏览量")
    private String orgShow;

    @ApiModelProperty(value = "交易次数")
    private String transactionCount;

    @ApiModelProperty(value = "机构服务评分")
    private String orgServiceScore;

    @ApiModelProperty(value = "机构服务资质标签")
    private List<OrgLicense> orgLicenses;

    @ApiModelProperty("客户偏好")
    private String orgHobby;

    @ApiModelProperty("业务擅长")
    private String orgSpeciality;

    @ApiModelProperty("机构状态(0未审核[审核中]1审核通过2审核不通过3已删除) ")
    private String orgStatus;

    @ApiModelProperty(value = "经营状态[0冻结 1正常户]")
    private String operateStatus;

    @ApiModelProperty(value = "组织机构代码")
    private String orgCode;

    @ApiModelProperty(value = "法人/负责人")
    private String orgPrincipal;


    @ApiModelProperty(value = "机构咨询电话")
    private String orgPhone;

    @ApiModelProperty(value = "公司地址")
    private String orgAddress;

    @ApiModelProperty(value = "机构LOGO")
    private String orgLogo;

    @ApiModelProperty(value = "公司网网址")
    private String orgWeb;

    @ApiModelProperty(value = "机构成立时间yyyy-MM-dd")
    private String orgRegisterTime;

    @ApiModelProperty(value = "联系人姓名")
    private String conName;

    @ApiModelProperty(value = "联系人电话")
    private String conPhone;

    @ApiModelProperty(value = "联系人邮箱")
    private String conEmail;

    @ApiModelProperty(value = "员工总人数")
    private Integer staffCount;

    @ApiModelProperty(value = "执业人员人数")
    private Integer professionNum;

    @ApiModelProperty(value = "本科学历人数")
    private Integer bachelorNum;

    @ApiModelProperty(value = "硕士学历人数")
    private Integer masterNum;

    @ApiModelProperty(value = "博士学历人数")
    private Integer doctorNum;

    @ApiModelProperty(value = "海归员工人数")
    private Integer returneeNum;

    @ApiModelProperty(value = "荣誉证书列表")
    private List<OrgLicense> honorLicense;

    @ApiModelProperty(value = "机构人员列表")
    private List<OrgTeam> orgTeams;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessSType() {
        return businessSType;
    }

    public void setBusinessSType(String businessSType) {
        this.businessSType = businessSType;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgBusiness() {
        return orgBusiness;
    }

    public void setOrgBusiness(String orgBusiness) {
        this.orgBusiness = orgBusiness;
    }

    public String getOrgSynopsis() {
        return orgSynopsis;
    }

    public void setOrgSynopsis(String orgSynopsis) {
        this.orgSynopsis = orgSynopsis;
    }

    public String getOrgShow() {
        return orgShow;
    }

    public void setOrgShow(String orgShow) {
        this.orgShow = orgShow;
    }

    public String getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(String transactionCount) {
        this.transactionCount = transactionCount;
    }

    public String getOrgServiceScore() {
        return orgServiceScore;
    }

    public void setOrgServiceScore(String orgServiceScore) {
        this.orgServiceScore = orgServiceScore;
    }

    public String getOrgHobby() {
        return orgHobby;
    }

    public void setOrgHobby(String orgHobby) {
        this.orgHobby = orgHobby;
    }

    public String getOrgSpeciality() {
        return orgSpeciality;
    }

    public void setOrgSpeciality(String orgSpeciality) {
        this.orgSpeciality = orgSpeciality;
    }

    public String getOrgPhone() {
        return orgPhone;
    }

    public void setOrgPhone(String orgPhone) {
        this.orgPhone = orgPhone;
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress;
    }

    public String getOrgLogo() {
        return orgLogo;
    }

    public void setOrgLogo(String orgLogo) {
        this.orgLogo = orgLogo;
    }

    public String getOrgRegisterTime() {
        return orgRegisterTime;
    }

    public void setOrgRegisterTime(String orgRegisterTime) {
        this.orgRegisterTime = orgRegisterTime;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOperateStatus() {
        return operateStatus;
    }

    public void setOperateStatus(String operateStatus) {
        this.operateStatus = operateStatus;
    }

    public String getOrgPrincipal() {
        return orgPrincipal;
    }

    public void setOrgPrincipal(String orgPrincipal) {
        this.orgPrincipal = orgPrincipal;
    }

    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName;
    }

    public String getConPhone() {
        return conPhone;
    }

    public void setConPhone(String conPhone) {
        this.conPhone = conPhone;
    }

    public String getConEmail() {
        return conEmail;
    }

    public void setConEmail(String conEmail) {
        this.conEmail = conEmail;
    }

    public Integer getStaffCount() {
        return staffCount;
    }

    public void setStaffCount(Integer staffCount) {
        this.staffCount = staffCount;
    }

    public Integer getProfessionNum() {
        return professionNum;
    }

    public void setProfessionNum(Integer professionNum) {
        this.professionNum = professionNum;
    }

    public Integer getBachelorNum() {
        return bachelorNum;
    }

    public void setBachelorNum(Integer bachelorNum) {
        this.bachelorNum = bachelorNum;
    }

    public Integer getMasterNum() {
        return masterNum;
    }

    public void setMasterNum(Integer masterNum) {
        this.masterNum = masterNum;
    }

    public Integer getDoctorNum() {
        return doctorNum;
    }

    public void setDoctorNum(Integer doctorNum) {
        this.doctorNum = doctorNum;
    }

    public Integer getReturneeNum() {
        return returneeNum;
    }

    public void setReturneeNum(Integer returneeNum) {
        this.returneeNum = returneeNum;
    }

    public List<OrgLicense> getOrgLicenses() {
        return orgLicenses;
    }

    public void setOrgLicenses(List<OrgLicense> orgLicenses) {
        this.orgLicenses = orgLicenses;
    }

    public List<OrgLicense> getHonorLicense() {
        return honorLicense;
    }

    public void setHonorLicense(List<OrgLicense> honorLicense) {
        this.honorLicense = honorLicense;
    }

    public List<OrgTeam> getOrgTeams() {
        return orgTeams;
    }

    public void setOrgTeams(List<OrgTeam> orgTeams) {
        this.orgTeams = orgTeams;
    }

    public String getOrgWeb() {
        return orgWeb;
    }

    public void setOrgWeb(String orgWeb) {
        this.orgWeb = orgWeb;
    }

    public String getOrgStatus() {
        return orgStatus;
    }

    public void setOrgStatus(String orgStatus) {
        this.orgStatus = orgStatus;
    }
}
