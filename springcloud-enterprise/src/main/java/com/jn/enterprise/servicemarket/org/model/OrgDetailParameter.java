package com.jn.enterprise.servicemarket.org.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
@ApiModel(value = "OrgDetailParameter",description = "服务机构详情入参")
public class OrgDetailParameter implements Serializable {
    @ApiModelProperty(value = "服务机构id",notes = "[新增传空，修改ID必传]",example = "e2ia03****")
    private String orgId;
    @ApiModelProperty(value = "机构名称",required = true,example = "张氏律师事务所")
    @NotNull(message = "机构名称不能为空")
    private String orgName;
    @ApiModelProperty(value = "机构注册时间yyyy-MM-dd",required = true,example = "2019-03-01")
    @Pattern(regexp = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-" +
            "(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})" +
            "(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)",
            message = "{orgRegisterTime:'资机构注册时间格式错误'}")
    @NotNull(message = "机构注册时间不能为空")
    private String orgRegisterTime;
    @ApiModelProperty(value = "组织机构代码(统一社会信用代码)",required = true,example = "65151****")
    @NotNull(message = "组织机构代码不能为空")
    private String orgCode;
    @ApiModelProperty(value = "法人/负责人",example = "王松")
    private String orgPrincipal;
    @ApiModelProperty(value = "企业工商类型",example = "民营企业/有限责任公司")
    private String orgBusinType;
    @ApiModelProperty(value = "企业工商经营场所",example = "湖南长沙略略略略略")
    private String orgBusinAddresse;
    @ApiModelProperty(value = "企业工商经营范围",example = "计算机销售、软件开发及出售、计算机....")
    private String orgBusinScope;
    @ApiModelProperty(value = "机构简介",required = true,example = "机构成立于****")
    @NotNull(message = "机构简介不能为空")
    @Size(max=1000,message = "机构简介不能超过1000字")
    private String orgSynopsis;
    @ApiModelProperty(value = "主营业务",required = true,example = "商业纠纷，劳动纠纷")
    @NotNull(message = "主营业务不能为空")
    @Size(max=500,message = "主营业务不能超过500字")
    private String orgBusiness;
    @ApiModelProperty(value = "业务擅长",  required = true,example = "金融投资,代理记账...")
    @NotNull(message = "业务擅长不能为空")
    private String  orgSpeciality;
    @ApiModelProperty(value = "机构LOGO",required = true,example = "**/**/**.png")
    @NotNull(message = "机构LOGO不能为空")
    private String orgLogo;
    @ApiModelProperty(value = "机构业务领域(单选，app为多选，需修改为单选)[机构的一级业务领域。取企业字典表type=0的，即业务领域类型。数据从【服务超市-机构字典】接口获取(id)]",required = true,example = "ogistics"
            ,notes = "机构的一级业务领域。取企业字典表type=0的，即业务领域类型。数据从【服务超市-机构字典】接口获取(id)")
    @NotNull(message = "业务领域不能为空")
    private String businessType;


    @NotNull(message = "行业领域不能为空")
    @ApiModelProperty(value = "客户偏好-行业领域[数组][企业字典表type=1的，即行业领域类型。数据从【服务超市-机构字典】接口获取(id)]"
            ,notes = "企业字典表type=1的，即行业领域类型。数据从【服务超市-机构字典】接口获取(id)"
            ,required = true,example = "['shengwuyiyao','xinnengyuan']")
    private String[] industrySector;
    @NotNull(message = "发展阶段不能为空")
    @ApiModelProperty(value = "客户偏好-发展阶段[数组][企业字典表type=2的，即发展阶段领域类型。数据从【服务超市-机构字典】接口获取(id)]"
            ,notes = "企业字典表type=2的，即发展阶段领域类型。数据从【服务超市-机构字典】接口获取(id)"
            ,required = true,example = "['gufenqiye','fazhanqi']")
    private String[] developmentStage;


    @ApiModelProperty(value = "机构资质集合",required = true)
    @NotNull(message = "机构资质列表不能为空")
    private List<OrgLicense> licenses;


    @ApiModelProperty(value = "员工总人数",required = true,example = "100")
    @NotNull(message = "员工总人数不能为空")
    private Integer staffCount;
    @ApiModelProperty(value = "执业人员人数",required = true,example = "20")
    @NotNull(message = "执业人员人数不能为空")
    private Integer professionNum;
    @ApiModelProperty(value = "本科学历人数",required = true,example = "20")
    @NotNull(message = "本科学历人数不能为空")
    private Integer bachelorNum;
    @ApiModelProperty(value = "硕士学历人数",required = true,example = "20")
    @NotNull(message = "硕士学历人数不能为空")
    private Integer masterNum;
    @ApiModelProperty(value = "博士学历人数",required = true,example = "20")
    @NotNull(message = "博士学历人数不能为空")
    private Integer doctorNum;
    @ApiModelProperty(value = "海归员工人数",example = "20")
    private Integer returneeNum;


    @ApiModelProperty(value = "机构人员列表")
    private List<OrgTeam> orgTeams;

    @ApiModelProperty(value = "省",required = true,example = "江苏")
    @NotNull(message = "省不能为空")
    private String orgProvince;
    @ApiModelProperty(value = "市",required = true,example = "南京")
    @NotNull(message = "市不能为空")
    private String orgCity;
    @ApiModelProperty(value = "区县",required = true,example = "白下区")
    @NotNull(message = "区县不能为空")
    private String orgArea;
    @ApiModelProperty(value = "详细地址",required = true,example = "白下高新区")
    @NotNull(message = "详细地址不能为空")
    private String orgAddress;
    @ApiModelProperty(value = "机构咨询电话",required = true,example = "025-68225612")
    @NotNull(message = "机构咨询电话不能为空")
    private String orgPhone;
    @ApiModelProperty(value = "联系人姓名",required = true,example = "张三")
    @NotNull(message = "联系人姓名不能为空")
    private String conName;
    @ApiModelProperty(value = "公司网网址",example = "www.baidu.com")
    private String orgWeb;
    @ApiModelProperty(value = "联系人电话",required = true,example = "18155552222")
    @NotNull(message = "联系人电话不能为空")
    @Pattern(regexp = "(^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$)",
            message = "联系人电话格式不正确")
    private String conPhone;
    @ApiModelProperty(value = "联系人邮箱",required = true,example = "123@163.com")
    @NotNull(message = "联系人邮箱不能为空")
    private String conEmail;


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

    public String getOrgSpeciality() {
        return orgSpeciality;
    }

    public void setOrgSpeciality(String orgSpeciality) {
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

    @Override
    public String toString() {
        return "OrgDetailParameter{" +
                "orgId='" + orgId + '\'' +
                ", orgName='" + orgName + '\'' +
                ", orgRegisterTime='" + orgRegisterTime + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", orgPrincipal='" + orgPrincipal + '\'' +
                ", orgBusinType='" + orgBusinType + '\'' +
                ", orgBusinAddresse='" + orgBusinAddresse + '\'' +
                ", orgBusinScope='" + orgBusinScope + '\'' +
                ", orgSynopsis='" + orgSynopsis + '\'' +
                ", orgBusiness='" + orgBusiness + '\'' +
                ", orgSpeciality='" + orgSpeciality + '\'' +
                ", orgLogo='" + orgLogo + '\'' +
                ", businessType='" + businessType + '\'' +
                ", industrySector=" + Arrays.toString(industrySector) +
                ", developmentStage=" + Arrays.toString(developmentStage) +
                ", licenses=" + licenses +
                ", staffCount=" + staffCount +
                ", professionNum=" + professionNum +
                ", bachelorNum=" + bachelorNum +
                ", masterNum=" + masterNum +
                ", doctorNum=" + doctorNum +
                ", returneeNum=" + returneeNum +
                ", orgTeams=" + orgTeams +
                ", orgProvince='" + orgProvince + '\'' +
                ", orgCity='" + orgCity + '\'' +
                ", orgArea='" + orgArea + '\'' +
                ", orgAddress='" + orgAddress + '\'' +
                ", orgPhone='" + orgPhone + '\'' +
                ", conName='" + conName + '\'' +
                ", orgWeb='" + orgWeb + '\'' +
                ", conPhone='" + conPhone + '\'' +
                ", conEmail='" + conEmail + '\'' +
                '}';
    }
}
