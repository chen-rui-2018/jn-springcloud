package com.jn.enterprise.servicemarket.org.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * 服务机构详情
 * @author： jiangyl
 * @date： Created on 2019/2/14 10:12
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OrgDetailUpdateParameter",description = "选择性修改机构信息入参")
public class OrgDetailUpdateParameter implements Serializable {
    @ApiModelProperty(value = "服务机构id",required = true,example = "e2ia03****")
    private String orgId;

    @ApiModelProperty(value = "机构名称",example = "张氏律师事务所")
    @NotNull(message = "机构名称不能为空")
    private String orgName;

    @ApiModelProperty(value = "机构LOGO",example = "**/**/**.png")
    @NotNull(message = "机构LOGO不能为空")
    private String orgLogo;

    @ApiModelProperty(value = "主营业务",example = "商业纠纷，劳动纠纷")
    @NotNull(message = "主营业务不能为空")
    private String orgBusiness;
    @ApiModelProperty(value = "联系人姓名",example = "张三")
    @NotNull(message = "联系人姓名不能为空")
    private String conName;

    @ApiModelProperty(value = "联系人电话",example = "18155552222")
    @NotNull(message = "联系人电话不能为空")
    private String conPhone;

    @ApiModelProperty(value = "联系人邮箱",example = "123@163.com")
    @NotNull(message = "联系人邮箱不能为空")
    private String conEmail;

    @ApiModelProperty(value = "公司网网址",example = "www.baidu.com")
    private String orgWeb;

    @ApiModelProperty(value = "机构简介",example = "机构成立于****")
    @NotNull(message = "机构简介不能为空")
    @Size(max=500,message = "机构简介不能超过500字")
    private String orgSynopsis;


    @ApiModelProperty(value = "机构注册时间yyyy-MM-dd",example = "2019-03-01")
    @NotNull(message = "机构注册时间不能为空")
    private String orgRegisterTime;

    @ApiModelProperty(value = "组织机构代码(统一社会信用代码)",example = "65151****")
    @NotNull(message = "组织机构代码不能为空")
    private String orgCode;

    @ApiModelProperty(value = "业务擅长[数组][企业字典表type=0的，即业务领域类型。数据从【服务超市-机构字典】接口获取(id)]",
            notes = "企业字典表type=0的，即业务领域类型。数据从【服务超市-机构字典】接口获取(id)",
            example = "['ogistics','technology_finance']")
    @NotNull(message = "业务擅长不能为空")
    private String[] orgSpeciality;

    @NotNull(message = "行业领域不能为空")
    @ApiModelProperty(value = "客户偏好-行业领域[数组][企业字典表type=1的，即行业领域类型。数据从【服务超市-机构字典】接口获取(id)]"
            ,notes = "企业字典表type=1的，即行业领域类型。数据从【服务超市-机构字典】接口获取(id)"
            ,example = "['shengwuyiyao','xinnengyuan']")
    private String[] industrySector;

    @NotNull(message = "发展阶段不能为空")
    @ApiModelProperty(value = "客户偏好-发展阶段[数组][企业字典表type=2的，即发展阶段领域类型。数据从【服务超市-机构字典】接口获取(id)]"
            ,notes = "企业字典表type=2的，即发展阶段领域类型。数据从【服务超市-机构字典】接口获取(id)"
            ,example = "['gufenqiye','fazhanqi']")
    private String[] developmentStage;

    @ApiModelProperty(value = "机构资质集合")
    @NotNull(message = "机构资质列表不能为空")
    private List<OrgLicense> licenses;

    @ApiModelProperty(value = "机构业务领域(单选，app为多选，需修改为单选)[机构的一级业务领域。取企业字典表type=0的，即业务领域类型。数据从【服务超市-机构字典】接口获取(id)]",required = true,example = "ogistics"
            ,notes = "机构的一级业务领域。取企业字典表type=0的，即业务领域类型。数据从【服务超市-机构字典】接口获取(id)")
    @NotNull(message = "业务领域不能为空")
    private String businessType;

    @ApiModelProperty(value = "员工总人数",example = "100")
    @NotNull(message = "员工总人数不能为空")
    private Integer staffCount;

    @ApiModelProperty(value = "执业人员人数",example = "20")
    @NotNull(message = "执业人员人数不能为空")
    private Integer professionNum;

    @ApiModelProperty(value = "本科学历人数",example = "20")
    @NotNull(message = "本科学历人数不能为空")
    private Integer bachelorNum;

    @ApiModelProperty(value = "硕士学历人数",example = "20")
    @NotNull(message = "硕士学历人数不能为空")
    private Integer masterNum;

    @ApiModelProperty(value = "博士学历人数",example = "20")
    @NotNull(message = "博士学历人数不能为空")
    private Integer doctorNum;

    @ApiModelProperty(value = "海归员工人数",example = "20")
    private Integer returneeNum;

    @ApiModelProperty(value = "机构人员列表")
    private List<OrgTeam> orgTeams;

    @ApiModelProperty(value = "法人/负责人",example = "王松")
    private String orgPrincipal;

    @ApiModelProperty(value = "企业工商类型",example = "民营企业/有限责任公司")
    private String orgBusinType;

    @ApiModelProperty(value = "企业工商经营场所",example = "湖南长沙略略略略略")
    private String orgBusinAddresse;

    @ApiModelProperty(value = "企业工商经营范围",example = "计算机销售、软件开发及出售、计算机....")
    private String orgBusinScope;

    @ApiModelProperty(value = "机构咨询电话",example = "800888555")
    @NotNull(message = "机构咨询电话不能为空")
    private String orgPhone;

    @ApiModelProperty(value = "省",example = "湖南")
    @NotNull(message = "省不能为空")
    private String orgProvince;
    @ApiModelProperty(value = "市",example = "长沙")
    @NotNull(message = "市不能为空")
    private String orgCity;
    @ApiModelProperty(value = "区县",example = "岳麓区")
    @NotNull(message = "区县不能为空")
    private String orgArea;
    @ApiModelProperty(value = "详细地址",example = "文轩路麓谷企业广场")
    @NotNull(message = "详细地址不能为空")
    private String orgAddress;

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

    public String getOrgLogo() {
        return orgLogo;
    }

    public void setOrgLogo(String orgLogo) {
        this.orgLogo = orgLogo;
    }

    public String getOrgBusiness() {
        return orgBusiness;
    }

    public void setOrgBusiness(String orgBusiness) {
        this.orgBusiness = orgBusiness;
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

    public String getOrgSynopsis() {
        return orgSynopsis;
    }

    public void setOrgSynopsis(String orgSynopsis) {
        this.orgSynopsis = orgSynopsis;
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

    public List<OrgLicense> getLicenses() {
        return licenses;
    }

    public void setLicenses(List<OrgLicense> licenses) {
        this.licenses = licenses;
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

    public String getOrgBusinType() {
        return orgBusinType;
    }

    public void setOrgBusinType(String orgBusinType) {
        this.orgBusinType = orgBusinType;
    }

    public String getOrgBusinAddresse() {
        return orgBusinAddresse;
    }

    public void setOrgBusinAddresse(String orgBusinAddresse) {
        this.orgBusinAddresse = orgBusinAddresse;
    }

    public String getOrgBusinScope() {
        return orgBusinScope;
    }

    public void setOrgBusinScope(String orgBusinScope) {
        this.orgBusinScope = orgBusinScope;
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

    @Override
    public String toString() {
        return "OrgDetailUpdateParameter{" +
                "orgId='" + orgId + '\'' +
                ", orgName='" + orgName + '\'' +
                ", orgLogo='" + orgLogo + '\'' +
                ", orgBusiness='" + orgBusiness + '\'' +
                ", conName='" + conName + '\'' +
                ", conPhone='" + conPhone + '\'' +
                ", conEmail='" + conEmail + '\'' +
                ", orgWeb='" + orgWeb + '\'' +
                ", orgSynopsis='" + orgSynopsis + '\'' +
                ", orgRegisterTime='" + orgRegisterTime + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", orgSpeciality=" + Arrays.toString(orgSpeciality) +
                ", industrySector=" + Arrays.toString(industrySector) +
                ", developmentStage=" + Arrays.toString(developmentStage) +
                ", licenses=" + licenses +
                ", businessType='" + businessType + '\'' +
                ", staffCount=" + staffCount +
                ", professionNum=" + professionNum +
                ", bachelorNum=" + bachelorNum +
                ", masterNum=" + masterNum +
                ", doctorNum=" + doctorNum +
                ", returneeNum=" + returneeNum +
                ", orgTeams=" + orgTeams +
                ", orgPrincipal='" + orgPrincipal + '\'' +
                ", orgBusinType='" + orgBusinType + '\'' +
                ", orgBusinAddresse='" + orgBusinAddresse + '\'' +
                ", orgBusinScope='" + orgBusinScope + '\'' +
                ", orgPhone='" + orgPhone + '\'' +
                ", orgProvince='" + orgProvince + '\'' +
                ", orgCity='" + orgCity + '\'' +
                ", orgArea='" + orgArea + '\'' +
                ", orgAddress='" + orgAddress + '\'' +
                '}';
    }
}
