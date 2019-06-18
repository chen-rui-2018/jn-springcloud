package com.jn.enterprise.servicemarket.advisor.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/6/17 15:22
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "OrgNameIsExistParam",description = "查询机构名称是否存在入参")
public class OrgNameIsExistParam implements Serializable {
    @ApiModelProperty(value = "查询类型：add:机构认证（新增页面传值），update:机构认证（修改页面传值）",required = true,example = "add")
    @NotNull(message = "查询类型不能为空")
    private String searchType;
    @ApiModelProperty(value = "机构名称",required = true,example = "xxx机构")
    @NotNull(message = "机构名称不能为空")
    private String orgName;

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Override
    public String toString() {
        return "OrgNameIsExistParam{" +
                "searchType='" + searchType + '\'' +
                ", orgName='" + orgName + '\'' +
                '}';
    }
}
