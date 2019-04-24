package com.jn.enterprise.company.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： huxw
 * @date： Created on 2019-3-29 15:35:41
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ServiceRecruitParam", description = "企业招聘入参（前台）")
public class ServiceWebRecruitParam extends Page implements Serializable {
    @ApiModelProperty(value = "招聘岗位/企业名称[模糊搜索]", example = "Java程序员/君南")
    private String searchFiled;
    @ApiModelProperty(value = "招聘类型（请调用[企业服务-公共：码表-数据列表]获取数据，传值为groupId=recruitType）", example = "full_time")
    private String type;
    @ApiModelProperty(value = "排序类型（time:时间[默认] hot:热度）", example = "hot")
    private String sortTypes;
    @ApiModelProperty(value = "数据筛选[不区分大小写]（week:最近一周 month:最近一月 ）", example = "week")
    private String whereTypes;

    public String getSearchFiled() {
        return searchFiled;
    }

    public void setSearchFiled(String searchFiled) {
        this.searchFiled = searchFiled;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSortTypes() {
        return sortTypes;
    }

    public void setSortTypes(String sortTypes) {
        this.sortTypes = sortTypes;
    }

    public String getWhereTypes() {
        return whereTypes;
    }

    public void setWhereTypes(String whereTypes) {
        this.whereTypes = whereTypes;
    }
}
