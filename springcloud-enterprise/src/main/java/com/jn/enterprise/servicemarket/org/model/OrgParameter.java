package com.jn.enterprise.servicemarket.org.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 机构查询入参Bean
 * @author： jiangyl
 * @date： Created on 2019/2/13 14:42
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OrgParameter",description = "机构查询入参")
public class OrgParameter extends Page implements Serializable {

    @ApiModelProperty(value = "业务领域",notes = "企业字典表type=0的，即业务领域。数据从【机构字典】接口获取",example = "ogistics")
    private String businessType;

    @ApiModelProperty(value = "二级业务领域",notes = "目前二级领域已废弃")
    private String businessSType;

    @ApiModelProperty(value = "机构名称",example = "机构1")
    private String orgName;

    @ApiModelProperty(value = "主营业务",example = "商业纠纷")
    private String orgBusiness;

    @ApiModelProperty(value = "排序字段",notes = "popularity:人气排序，serviceNum：服务量排序，为空或integrate：综合排序",example = "integrate")
    private String sortTypes;



    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessSType() {
        return businessSType;
    }

    public void setBusinessSType(String businessSType) {
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

}
