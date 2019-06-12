package com.jn.enterprise.servicemarket.org.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 服务机构认证基本信息选择性修改
 * @author： jiangyl
 * @date： Created on 2019/2/15 16:10
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OrgBasicDataServlet",description = "服务机构认证基本信息选择性修改")
public class OrgBasicDataServlet implements Serializable {

    @ApiModelProperty(value = "机构ID",required = true,example = "25b7b14a39ff4982b358ca63eb77cc97")
    @NotNull(message = "机构ID不能为空")
    private String orgId;

    @ApiModelProperty(value = "机构名称",example = "***事务所")
    private String orgName;

    @ApiModelProperty(value = "统一社会信用代码/组织机构代码",example = "8831212412h21")
    private String orgCode;

    @ApiModelProperty(value = "注册时间 yyyy-MM-dd",example = "2017-05-12")
    private String orgRegisterTime;

    @ApiModelProperty(value = "机构简介",example = "机构成立于****")
    private String orgSynopsis;

    @ApiModelProperty(value = "主营业务",example = "商业纠纷，劳动纠纷" )
    private String orgBusiness;

    @ApiModelProperty(value = "业务擅长[数组][企业字典表type=0的，即业务领域类型。数据从【服务超市-机构字典】接口获取(id)]",
            notes = "企业字典表type=0的，即业务领域类型。数据从【服务超市-机构字典】接口获取(id)"
            ,example = "['ogistics','technology_finance']")
    private String[] orgSpeciality;

    @ApiModelProperty(value = "机构LOGO",example = "***/***/**.jpg")
    private String orgLogo;

    @ApiModelProperty(value = "客户偏好-行业领域[数组][企业字典表type=1的，即行业领域类型。数据从【服务超市-机构字典】接口获取(id)]",example = "['shengwuyiyao','xinnengyuan']"
            ,notes = "企业字典表type=1的，即行业领域类型。数据从【服务超市-机构字典】接口获取(id)")
    private String[] industrySector;

    @ApiModelProperty(value = "客户偏好-发展阶段[数组][企业字典表type=2的，即发展阶段领域类型。数据从【服务超市-机构字典】接口获取(id)]",example = "['gufenqiye','fazhanqi']"
            ,notes = "企业字典表type=2的，即发展阶段领域类型。数据从【服务超市-机构字典】接口获取(id)")
    private String[] developmentStage;


    @ApiModelProperty(value = "法人/负责人",example = "王松")
    private String orgPrincipal;

    @ApiModelProperty(value = "企业工商类型",example = "民营企业/有限责任公司")
    private String orgBusinType;

    @ApiModelProperty(value = "企业工商经营场所",example = "湖南长沙略略略略略")
    private String orgBusinAddresse;

    @ApiModelProperty(value = "企业工商经营范围",example = "计算机销售、软件开发及出售、计算机....")
    private String orgBusinScope;

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
}
