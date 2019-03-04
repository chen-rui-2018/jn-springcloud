package com.jn.enterprise.servicemarket.org.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 服务机构详情
 * @author： jiangyl
 * @date： Created on 2019/2/14 10:12
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OrgDetailParameter",description = "服务机构详情入参")
public class OrgDetailParameter implements Serializable {
    @ApiModelProperty(value = "服务机构id[新增传空，修改ID必传]")
    private String orgId;

    @ApiModelProperty("机构名称")
    @NotNull(message = "机构名称不能为空")
    private String orgName;

    @ApiModelProperty("主营业务")
    @NotNull(message = "主营业务不能为空")
    private String orgBusiness;

    @ApiModelProperty("机构简介")
    @NotNull(message = "机构简介不能为空")
    private String orgSynopsis;

    @ApiModelProperty(value = "机构LOGO")
    @NotNull(message = "机构LOGO不能为空")
    private String orgLogo;

    @ApiModelProperty(value = "机构注册时间yyyy-MM-dd")
    @NotNull(message = "机构注册时间不能为空")
    private String orgRegisterTime;

    @ApiModelProperty(value = "组织机构代码")
    @NotNull(message = "组织机构代码不能为空")
    private String orgCode;

    @ApiModelProperty(value = "业务擅长[数组]")
    @NotNull(message = "业务擅长不能为空")
    private String[] orgSpeciality;

    @ApiModelProperty(value = "行业领域[数组]")
    private String[] industrySector;

    @ApiModelProperty(value = "发展阶段[数组]")
    private String[] developmentStage;

    @ApiModelProperty(value = "企业性质[数组]")
    private String[] companyNature;

    @ApiModelProperty(value = "荣誉证书列表")
    @NotNull(message = "荣誉证书列表不能为空")
    private List<OrgLicense> honorLicense;

    @ApiModelProperty("业务领域")
    @NotNull(message = "业务领域不能为空")
    private String businessType;

    @ApiModelProperty(value = "员工总人数")
    @NotNull(message = "员工总人数不能为空")
    private Integer staffCount;

    @ApiModelProperty(value = "执业人员人数")
    @NotNull(message = "执业人员人数不能为空")
    private Integer professionNum;

    @ApiModelProperty(value = "本科学历人数")
    @NotNull(message = "本科学历人数不能为空")
    private Integer bachelorNum;

    @ApiModelProperty(value = "硕士学历人数")
    @NotNull(message = "硕士学历人数不能为空")
    private Integer masterNum;

    @ApiModelProperty(value = "博士学历人数")
    @NotNull(message = "博士学历人数不能为空")
    private Integer doctorNum;

    @ApiModelProperty(value = "海归员工人数")
    @NotNull(message = "海归员工人数不能为空")
    private Integer returneeNum;

    @ApiModelProperty(value = "机构人员列表")
    private List<OrgTeam> orgTeams;

    @ApiModelProperty(value = "法人/负责人")
    private String orgPrincipal;

    @ApiModelProperty(value = "机构咨询电话")
    @NotNull(message = "机构咨询电话不能为空")
    private String orgPhone;

    @ApiModelProperty(value = "省")
    @NotNull(message = "省不能为空")
    private String orgProvince;
    @ApiModelProperty(value = "市")
    @NotNull(message = "市不能为空")
    private String orgCity;
    @ApiModelProperty(value = "区县")
    @NotNull(message = "区县不能为空")
    private String orgArea;
    @ApiModelProperty(value = "详细地址")
    @NotNull(message = "详细地址不能为空")
    private String orgAddress;
    @ApiModelProperty(value = "联系人姓名")
    @NotNull(message = "联系人姓名不能为空")
    private String conName;

    @ApiModelProperty(value = "联系人电话")
    @NotNull(message = "联系人电话不能为空")
    private String conPhone;

    @ApiModelProperty(value = "联系人邮箱")
    @NotNull(message = "联系人邮箱不能为空")
    private String conEmail;

    @ApiModelProperty(value = "公司网网址")
    private String orgWeb;

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

    public String[] getOrgSpeciality() {
        return orgSpeciality;
    }

    public void setOrgSpeciality(String[] orgSpeciality) {
        this.orgSpeciality = orgSpeciality;
    }

    public String[] getIndustrySector() {
        return industrySector;
    }

    public void setIndustrySector(String[] industrySector) {
        this.industrySector = industrySector;
    }

    public String[] getDevelopmentStage() {
        return developmentStage;
    }

    public void setDevelopmentStage(String[] developmentStage) {
        this.developmentStage = developmentStage;
    }

    public String[] getCompanyNature() {
        return companyNature;
    }

    public void setCompanyNature(String[] companyNature) {
        this.companyNature = companyNature;
    }

    public List<OrgLicense> getHonorLicense() {
        return honorLicense;
    }

    public void setHonorLicense(List<OrgLicense> honorLicense) {
        this.honorLicense = honorLicense;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
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

    public List<OrgTeam> getOrgTeams() {
        return orgTeams;
    }

    public void setOrgTeams(List<OrgTeam> orgTeams) {
        this.orgTeams = orgTeams;
    }

    public String getOrgPrincipal() {
        return orgPrincipal;
    }

    public void setOrgPrincipal(String orgPrincipal) {
        this.orgPrincipal = orgPrincipal;
    }

    public String getOrgPhone() {
        return orgPhone;
    }

    public void setOrgPhone(String orgPhone) {
        this.orgPhone = orgPhone;
    }

    public String getOrgProvince() {
        return orgProvince;
    }

    public void setOrgProvince(String orgProvince) {
        this.orgProvince = orgProvince;
    }

    public String getOrgCity() {
        return orgCity;
    }

    public void setOrgCity(String orgCity) {
        this.orgCity = orgCity;
    }

    public String getOrgArea() {
        return orgArea;
    }

    public void setOrgArea(String orgArea) {
        this.orgArea = orgArea;
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress;
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

    public String getOrgWeb() {
        return orgWeb;
    }

    public void setOrgWeb(String orgWeb) {
        this.orgWeb = orgWeb;
    }
}
