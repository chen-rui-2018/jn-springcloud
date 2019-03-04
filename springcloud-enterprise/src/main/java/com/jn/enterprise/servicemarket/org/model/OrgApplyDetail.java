package com.jn.enterprise.servicemarket.org.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 服务机构申请详细信息
 * @author： jiangyl
 * @date： Created on 2019/2/21 15:48
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OrgApplyDetail",description = "服务机构申请详细信息")
public class OrgApplyDetail {
    @ApiModelProperty(value = "机构ID")
    private String orgId;
    @ApiModelProperty(value = "机构名称")
    private String orgName;
    @ApiModelProperty(value = "机构社会信用代码")
    private String orgCode;
    @ApiModelProperty(value = "机构注册时间")
    private String orgRegisterTime;
    @ApiModelProperty(value = "机构简介")
    private String orgSynopsis;
    @ApiModelProperty(value = "主营业务")
    private String orgBusiness;
    @ApiModelProperty(value = "业务领域")
    private String businessType;
    @ApiModelProperty(value = "员工总人数")
    private String staffCount;
    @ApiModelProperty(value = "执业人员人数")
    private String professionNum;
    @ApiModelProperty(value = "本科学历人数")
    private String bachelorNum;
    @ApiModelProperty(value = "硕士学历人数")
    private String masterNum;
    @ApiModelProperty(value = "博士学历人数")
    private String doctorNum;
    @ApiModelProperty(value = "海归员工人数")
    private String returneeNum;
    @ApiModelProperty(value = "咨询电话")
    private String orgPhone;
    @ApiModelProperty(value = "机构网址")
    private String orgWeb;
    @ApiModelProperty(value = "联系人姓名")
    private String conName;
    @ApiModelProperty(value = "联系人手机")
    private String conPhone;
    @ApiModelProperty(value = "联系人邮件")
    private String conEmail;
    @ApiModelProperty(value = "办公地址")
    private String orgAddress;
    @ApiModelProperty(value = "业务擅长/客户偏好")
    private List<OrgTrait> orgTraits;
    @ApiModelProperty(value = "机构资质")
    private List<OrgLicense> orgLicenses;
    @ApiModelProperty(value = "核心服务团队")
    private List<OrgTeam> orgTeams;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgRegisterTime() {
        return orgRegisterTime;
    }

    public void setOrgRegisterTime(String orgRegisterTime) {
        this.orgRegisterTime = orgRegisterTime;
    }

    public String getOrgSynopsis() {
        return orgSynopsis;
    }

    public void setOrgSynopsis(String orgSynopsis) {
        this.orgSynopsis = orgSynopsis;
    }

    public String getOrgBusiness() {
        return orgBusiness;
    }

    public void setOrgBusiness(String orgBusiness) {
        this.orgBusiness = orgBusiness;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getStaffCount() {
        return staffCount;
    }

    public void setStaffCount(String staffCount) {
        this.staffCount = staffCount;
    }

    public String getProfessionNum() {
        return professionNum;
    }

    public void setProfessionNum(String professionNum) {
        this.professionNum = professionNum;
    }

    public String getBachelorNum() {
        return bachelorNum;
    }

    public void setBachelorNum(String bachelorNum) {
        this.bachelorNum = bachelorNum;
    }

    public String getMasterNum() {
        return masterNum;
    }

    public void setMasterNum(String masterNum) {
        this.masterNum = masterNum;
    }

    public String getDoctorNum() {
        return doctorNum;
    }

    public void setDoctorNum(String doctorNum) {
        this.doctorNum = doctorNum;
    }

    public String getReturneeNum() {
        return returneeNum;
    }

    public void setReturneeNum(String returneeNum) {
        this.returneeNum = returneeNum;
    }

    public String getOrgPhone() {
        return orgPhone;
    }

    public void setOrgPhone(String orgPhone) {
        this.orgPhone = orgPhone;
    }

    public String getOrgWeb() {
        return orgWeb;
    }

    public void setOrgWeb(String orgWeb) {
        this.orgWeb = orgWeb;
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

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress;
    }

    public List<OrgTrait> getOrgTraits() {
        return orgTraits;
    }

    public void setOrgTraits(List<OrgTrait> orgTraits) {
        this.orgTraits = orgTraits;
    }

    public List<OrgLicense> getOrgLicenses() {
        return orgLicenses;
    }

    public void setOrgLicenses(List<OrgLicense> orgLicenses) {
        this.orgLicenses = orgLicenses;
    }

    public List<OrgTeam> getOrgTeams() {
        return orgTeams;
    }

    public void setOrgTeams(List<OrgTeam> orgTeams) {
        this.orgTeams = orgTeams;
    }
}
