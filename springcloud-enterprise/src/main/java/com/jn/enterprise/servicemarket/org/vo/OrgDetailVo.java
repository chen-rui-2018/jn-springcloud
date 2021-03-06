package com.jn.enterprise.servicemarket.org.vo;

import com.jn.enterprise.servicemarket.org.entity.TbServiceOrgTrait;
import com.jn.enterprise.servicemarket.org.model.IndustryTypeShow;
import com.jn.enterprise.servicemarket.org.model.OrgLicense;
import com.jn.enterprise.servicemarket.org.model.OrgTeam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
@ApiModel(value = "OrgDetailVo",description = "服务机构详情")
public class OrgDetailVo implements Serializable {
    @ApiModelProperty(value = "服务机构id")
    private String orgId;
    @ApiModelProperty(value = "机构名称")
    private String orgName;
    @ApiModelProperty("主营业务")
    private String orgBusiness;
    @ApiModelProperty("机构简介")
    private String orgSynopsis;
    @ApiModelProperty(value = "机构管理员账号")
    private String orgAccount;
    @ApiModelProperty(value = "机构LOGO")
    private String orgLogo;
    @ApiModelProperty(value = "机构注册时间yyyy-MM-dd")
    private String orgRegisterTime;
    @ApiModelProperty(value = "统一社会信用代码/组织机构代码")
    private String orgCode;
    @ApiModelProperty("业务领域")
    private String businessType;
    @ApiModelProperty("业务领域名称")
    private String businessTypeName;
    @ApiModelProperty(value = "业务擅长")
    private String  orgSpeciality;
    @ApiModelProperty(value = "客户偏好-行业领域")
    private List<IndustryTypeShow> industrySector;
    @ApiModelProperty(value = "客户偏好-发展阶段")
    private List<IndustryTypeShow> developmentStage;
    @ApiModelProperty(value = "浏览量")
    private String orgShow;
    @ApiModelProperty(value = "交易次数")
    private String transactionCount;
    @ApiModelProperty(value = "机构服务评分")
    private String orgServiceScore;
    @ApiModelProperty(value = "营业执照url")
    private String orgLicensesUrl;
    @ApiModelProperty("机构状态(0未审核[审核中]1审核通过2审核不通过3已删除) ")
    private String orgStatus;
    @ApiModelProperty(value = "经营状态[0冻结 1正常户]")
    private String operateStatus;
    @ApiModelProperty(value = "法人/负责人")
    private String orgPrincipal;
    @ApiModelProperty(value = "企业工商类型",example = "民营企业/有限责任公司")
    private String orgBusinType;
    @ApiModelProperty(value = "企业工商经营场所",example = "江苏南京xxx")
    private String orgBusinAddresse;
    @ApiModelProperty(value = "企业工商经营范围",example = "计算机销售、软件开发及出售、计算机....")
    private String orgBusinScope;
    @ApiModelProperty(value = "机构咨询电话")
    private String orgPhone;
    @ApiModelProperty(value = "公司地址[拼接好的详细地址]")
    private String orgAddressDetail;
    @ApiModelProperty(value = "办公地省")
    private String orgProvince;
    @ApiModelProperty(value = "办公地市")
    private String orgCity;
    @ApiModelProperty(value = "办公地区县")
    private String orgArea;
    @ApiModelProperty(value = "办公地地址")
    private String orgAddress;
    @ApiModelProperty(value = "公司网网址")
    private String orgWeb;
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
    @ApiModelProperty(value = "评价次数")
    private Integer evaluationNum;
    @ApiModelProperty(value = "职务")
    private String position;

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

    public String getOrgAccount() {
        return orgAccount;
    }

    public void setOrgAccount(String orgAccount) {
        this.orgAccount = orgAccount;
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

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessTypeName() {
        return businessTypeName;
    }

    public void setBusinessTypeName(String businessTypeName) {
        this.businessTypeName = businessTypeName;
    }

    public String getOrgSpeciality() {
        return orgSpeciality;
    }

    public void setOrgSpeciality(String orgSpeciality) {
        this.orgSpeciality = orgSpeciality;
    }

    public List<IndustryTypeShow> getIndustrySector() {
        return industrySector;
    }

    public void setIndustrySector(List<IndustryTypeShow> industrySector) {
        this.industrySector = industrySector;
    }

    public List<IndustryTypeShow> getDevelopmentStage() {
        return developmentStage;
    }

    public void setDevelopmentStage(List<IndustryTypeShow> developmentStage) {
        this.developmentStage = developmentStage;
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


    public String getOrgLicensesUrl() {
        return orgLicensesUrl;
    }

    public void setOrgLicensesUrl(String orgLicensesUrl) {
        this.orgLicensesUrl = orgLicensesUrl;
    }

    public String getOrgStatus() {
        return orgStatus;
    }

    public void setOrgStatus(String orgStatus) {
        this.orgStatus = orgStatus;
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

    public String getOrgAddressDetail() {
        return orgAddressDetail;
    }

    public void setOrgAddressDetail(String orgAddressDetail) {
        this.orgAddressDetail = orgAddressDetail;
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

    public Integer getEvaluationNum() {
        return evaluationNum;
    }

    public void setEvaluationNum(Integer evaluationNum) {
        this.evaluationNum = evaluationNum;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "OrgDetailVo{" +
                "orgId='" + orgId + '\'' +
                ", orgName='" + orgName + '\'' +
                ", orgBusiness='" + orgBusiness + '\'' +
                ", orgSynopsis='" + orgSynopsis + '\'' +
                ", orgAccount='" + orgAccount + '\'' +
                ", orgLogo='" + orgLogo + '\'' +
                ", orgRegisterTime='" + orgRegisterTime + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", businessType='" + businessType + '\'' +
                ", businessTypeName='" + businessTypeName + '\'' +
                ", orgSpeciality='" + orgSpeciality + '\'' +
                ", industrySector=" + industrySector +
                ", developmentStage=" + developmentStage +
                ", orgShow='" + orgShow + '\'' +
                ", transactionCount='" + transactionCount + '\'' +
                ", orgServiceScore='" + orgServiceScore + '\'' +
                ", orgLicensesUrl='" + orgLicensesUrl + '\'' +
                ", orgStatus='" + orgStatus + '\'' +
                ", operateStatus='" + operateStatus + '\'' +
                ", orgPrincipal='" + orgPrincipal + '\'' +
                ", orgBusinType='" + orgBusinType + '\'' +
                ", orgBusinAddresse='" + orgBusinAddresse + '\'' +
                ", orgBusinScope='" + orgBusinScope + '\'' +
                ", orgPhone='" + orgPhone + '\'' +
                ", orgAddressDetail='" + orgAddressDetail + '\'' +
                ", orgProvince='" + orgProvince + '\'' +
                ", orgCity='" + orgCity + '\'' +
                ", orgArea='" + orgArea + '\'' +
                ", orgAddress='" + orgAddress + '\'' +
                ", orgWeb='" + orgWeb + '\'' +
                ", conName='" + conName + '\'' +
                ", conPhone='" + conPhone + '\'' +
                ", conEmail='" + conEmail + '\'' +
                ", staffCount=" + staffCount +
                ", professionNum=" + professionNum +
                ", bachelorNum=" + bachelorNum +
                ", masterNum=" + masterNum +
                ", doctorNum=" + doctorNum +
                ", returneeNum=" + returneeNum +
                ", honorLicense=" + honorLicense +
                ", orgTeams=" + orgTeams +
                ", evaluationNum=" + evaluationNum +
                ", position='" + position + '\'' +
                '}';
    }
}
