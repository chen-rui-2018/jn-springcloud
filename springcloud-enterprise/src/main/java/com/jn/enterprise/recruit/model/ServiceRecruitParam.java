package com.jn.enterprise.recruit.model;

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
@ApiModel(value = "ServiceRecruitParam", description = "查询企业招聘入参")
public class ServiceRecruitParam extends Page implements Serializable {
    @ApiModelProperty(value = "企业ID", example = "2220112212")
    private String comId;
    @ApiModelProperty(value = "招聘岗位/企业名称[模糊搜索]", example = "Java程序员/君南")
    private String searchFiled;
    @ApiModelProperty(value = "招聘类型[码表]（full_time:全职 part_time:兼职 ...）", example = "full_time")
    private String type;
    @ApiModelProperty(value = "状态（1：已上架 0：已下架）", example = "1")
    private String status;
    @ApiModelProperty(value = "排序类型（time:时间[默认] hot:热度）", example = "hot")
    private String sortTypes;
    @ApiModelProperty(value = "数据筛选[不区分大小写]（w:最近一周 m:最近一月 ）", example = "m")
    private String whereTypes;

    public String getSearchFiled() {
        return searchFiled;
    }

    public void setSearchFiled(String searchFiled) {
        this.searchFiled = searchFiled;
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
