package com.jn.enterprise.servicemarket.org.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/6/5 14:05
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "OrgListParam",description = "服务机构机构列表查询入参")
public class OrgListParam extends Page implements Serializable {
    @ApiModelProperty(value = "业务领域[企业字典表type=0的，即业务领域。数据从【服务超市-机构字典】接口获取(id)]",example = "ogistics")
    private String[] businessType;
    @ApiModelProperty(value = "二级业务领域[目前二级领域已废弃]")
    private String[] businessSType;
    @ApiModelProperty(value = "机构名称",example = "机构1")
    private String orgName;
    @ApiModelProperty(value = "服务产品标识[常规产品]",example = "568d595476164c92b3d715629bf9ffcc")
    private String templateId;
    @ApiModelProperty(value = "主营业务",example = "商业纠纷")
    private String orgBusiness;
    @ApiModelProperty(value = "排序字段[attitudeScore：好评，popularity:人气排序，serviceNum：服务量排序，为空或integrate：综合排序]",example = "integrate")
    private String sortTypes;
    @ApiModelProperty(value = "客户偏好-行业领域[数组][企业字典表type=1的，即行业领域类型。数据从【服务超市-机构字典】接口获取(id)]")
    private String[] industrySector;
    @ApiModelProperty(value = "客户偏好-发展阶段[数组][企业字典表type=2的，即发展阶段领域类型。数据从【服务超市-机构字典】接口获取(id)]")
    private String[] developmentStage;
    @ApiModelProperty(value = "客户偏好-企业性质[数组][企业字典表type=3的，即企业性质类型。数据从【服务超市-机构字典】接口获取(id)]")
    private String[] companyNature;
    @ApiModelProperty(value = "参数集合[前端无需理会该字段]")
    private List<String> companyList;
    @ApiModelProperty(value = "人气权重")
    private Float popularityWeight=0.01f;
    @ApiModelProperty(value = "好评权重")
    private Float praiseWeight=1.0f;
    @ApiModelProperty(value = "服务量权重")
    private Float serviceWeight=0.1f;
    @ApiModelProperty(value = "其他因素分值")
    private Float otherFactorScore=0.0f;

    public String[] getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String[] businessType) {
        this.businessType = businessType;
    }

    public String[] getBusinessSType() {
        return businessSType;
    }

    public void setBusinessSType(String[] businessSType) {
        this.businessSType = businessSType;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getOrgBusiness() {
        return orgBusiness;
    }

    public void setOrgBusiness(String orgBusiness) {
        this.orgBusiness = orgBusiness;
    }

    public String getSortTypes() {
        return sortTypes;
    }

    public void setSortTypes(String sortTypes) {
        this.sortTypes = sortTypes;
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

    public List<String> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<String> companyList) {
        this.companyList = companyList;
    }

    public Float getPopularityWeight() {
        return popularityWeight;
    }

    public void setPopularityWeight(Float popularityWeight) {
        this.popularityWeight = popularityWeight;
    }

    public Float getPraiseWeight() {
        return praiseWeight;
    }

    public void setPraiseWeight(Float praiseWeight) {
        this.praiseWeight = praiseWeight;
    }

    public Float getServiceWeight() {
        return serviceWeight;
    }

    public void setServiceWeight(Float serviceWeight) {
        this.serviceWeight = serviceWeight;
    }

    public Float getOtherFactorScore() {
        return otherFactorScore;
    }

    public void setOtherFactorScore(Float otherFactorScore) {
        this.otherFactorScore = otherFactorScore;
    }

    @Override
    public String toString() {
        return "OrgListParam{" +
                "businessType=" + Arrays.toString(businessType) +
                ", businessSType=" + Arrays.toString(businessSType) +
                ", orgName='" + orgName + '\'' +
                ", templateId='" + templateId + '\'' +
                ", orgBusiness='" + orgBusiness + '\'' +
                ", sortTypes='" + sortTypes + '\'' +
                ", industrySector=" + Arrays.toString(industrySector) +
                ", developmentStage=" + Arrays.toString(developmentStage) +
                ", companyNature=" + Arrays.toString(companyNature) +
                ", companyList=" + companyList +
                ", popularityWeight=" + popularityWeight +
                ", praiseWeight=" + praiseWeight +
                ", serviceWeight=" + serviceWeight +
                ", otherFactorScore=" + otherFactorScore +
                '}';
    }
}
