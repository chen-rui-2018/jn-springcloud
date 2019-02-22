package com.jn.enterprise.servicemarket.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.checkerframework.checker.units.qual.A;

/**
 * 服务机构认证基本信息
 * @author： jiangyl
 * @date： Created on 2019/2/15 16:10
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OrgBasicData",description = "服务机构认证基本信息")
public class OrgBasicData {

    @ApiModelProperty(value = "机构ID")
    private String orgId;

    @ApiModelProperty(value = "服务商名称")
    private String orgName;

    @ApiModelProperty(value = "统一社会信用代码/组织机构代码")
    private String orgCode;

    @ApiModelProperty(value = "注册时间")
    private String orgRegisterTime;

    @ApiModelProperty(value = "服务商简介")
    private String orgSynopsis;

    @ApiModelProperty(value = "主营业务")
    private String orgBusiness;

    @ApiModelProperty(value = "业务擅长(多个用,分隔)")
    private String orgSpeciality;

    @ApiModelProperty(value = "机构LOGO")
    private String orgLogo;

    @ApiModelProperty(value = "行业领域(多个用,分隔)")
    private String industrySector;

    @ApiModelProperty(value = "发展阶段(多个用,分隔)")
    private String developmentStage;

    @ApiModelProperty(value = "企业性质(多个用,分隔)")
    private String companyNature;

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

    public String getOrgSpeciality() {
        return orgSpeciality;
    }

    public void setOrgSpeciality(String orgSpeciality) {
        this.orgSpeciality = orgSpeciality;
    }

    public String getOrgLogo() {
        return orgLogo;
    }

    public void setOrgLogo(String orgLogo) {
        this.orgLogo = orgLogo;
    }

    public String getIndustrySector() {
        return industrySector;
    }

    public void setIndustrySector(String industrySector) {
        this.industrySector = industrySector;
    }

    public String getDevelopmentStage() {
        return developmentStage;
    }

    public void setDevelopmentStage(String developmentStage) {
        this.developmentStage = developmentStage;
    }

    public String getCompanyNature() {
        return companyNature;
    }

    public void setCompanyNature(String companyNature) {
        this.companyNature = companyNature;
    }
}
