package com.jn.enterprise.servicemarket.org.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 服务机构认证基本信息
 * @author： jiangyl
 * @date： Created on 2019/2/15 16:10
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OrgBasicData",description = "服务机构认证基本信息")
public class OrgBasicData implements Serializable {

    @ApiModelProperty(value = "机构ID[新增id传空，修改不能为空]")
    private String orgId;

    @ApiModelProperty(value = "机构名称")
    @NotNull(message = "机构名称不能为空")
    private String orgName;

    @ApiModelProperty(value = "统一社会信用代码/组织机构代码")
    @NotNull(message = "统一社会信用代码/组织机构代码不能为空")
    private String orgCode;

    @ApiModelProperty(value = "注册时间 yyyy-MM-dd")
    @NotNull(message = "注册时间不能为空")
    private String orgRegisterTime;

    @ApiModelProperty(value = "机构简介")
    @NotNull(message = "机构简介不能为空")
    private String orgSynopsis;

    @ApiModelProperty(value = "主营业务")
    @NotNull(message = "主营业务不能为空")
    private String orgBusiness;

    @ApiModelProperty(value = "业务擅长[数组]")
    @NotNull(message = "业务擅长不能为空")
    private String[] orgSpeciality;

    @ApiModelProperty(value = "机构LOGO")
    @NotNull(message = "机构LOGO不能为空")
    private String orgLogo;

    @ApiModelProperty(value = "行业领域[数组]")
    private String[] industrySector;

    @ApiModelProperty(value = "发展阶段[数组]")
    private String[] developmentStage;

    @ApiModelProperty(value = "企业性质[数组]")
    private String[] companyNature;

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

    public String[] getOrgSpeciality() {
        return orgSpeciality;
    }

    public void setOrgSpeciality(String[] orgSpeciality) {
        this.orgSpeciality = orgSpeciality;
    }

    public String getOrgLogo() {
        return orgLogo;
    }

    public void setOrgLogo(String orgLogo) {
        this.orgLogo = orgLogo;
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
}
