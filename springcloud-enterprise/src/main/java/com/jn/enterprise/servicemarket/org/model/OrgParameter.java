package com.jn.enterprise.servicemarket.org.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 机构查询入参Bean
 * @author： jiangyl
 * @date： Created on 2019/2/13 14:42
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OrgParameter",description = "机构查询入参")
public class OrgParameter extends Page implements Serializable {

    @ApiModelProperty(value = "业务领域[企业字典表type=0的，即业务领域。数据从【服务超市-机构字典】接口获取(id)]",example = "ogistics")
    private String[] businessType;

    @ApiModelProperty(value = "二级业务领域[目前二级领域已废弃]")
    private String[] businessSType;

    @ApiModelProperty(value = "机构名称",example = "机构1")
    private String orgName;

    @ApiModelProperty(value = "主营业务",example = "商业纠纷")
    private String orgBusiness;

    @ApiModelProperty(value = "排序字段[popularity:人气排序，serviceNum：服务量排序，为空或integrate：综合排序]",example = "integrate")
    private String sortTypes;

    @ApiModelProperty(value = "客户偏好-行业领域[数组][企业字典表type=1的，即行业领域类型。数据从【服务超市-机构字典】接口获取(id)]"
            ,notes = "企业字典表type=1的，即行业领域类型。数据从【服务超市-机构字典】接口获取(id)"
            ,example = "['shengwuyiyao','xinnengyuan']")
    private String[] industrySector;

    @ApiModelProperty(value = "客户偏好-发展阶段[数组][企业字典表type=2的，即发展阶段领域类型。数据从【服务超市-机构字典】接口获取(id)]"
            ,notes = "企业字典表type=2的，即发展阶段领域类型。数据从【服务超市-机构字典】接口获取(id)"
            ,example = "['gufenqiye','fazhanqi']")
    private String[] developmentStage;

    @ApiModelProperty(value = "客户偏好-企业性质[数组][企业字典表type=3的，即企业性质类型。数据从【服务超市-机构字典】接口获取(id)]"
            ,notes = "企业字典表type=3的，即企业性质类型。数据从【服务超市-机构字典】接口获取(id)"
            ,example = "['guoyouqiye','minyingqiye']")
    private String[] companyNature;

    @ApiModelProperty(value = "参数集合[前端无需理会该字段]")
    private List<String> companyList;

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
}
