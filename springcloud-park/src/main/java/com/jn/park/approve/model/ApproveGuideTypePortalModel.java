package com.jn.park.approve.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 *
 * @author： huangbq
 * @date： Created on 2019/3/12 16:38
 * @version： v1.0
 * @modified By:
 */
@ApiModel("指南分类")
public class ApproveGuideTypePortalModel {
    @ApiModelProperty(value = "主键",example = "10")
    private Integer id;

    @ApiModelProperty(value = "分类名称",example = "直接审批")
    private String name;

    @ApiModelProperty("分类图片地址（一级分类才有）")
    private String typeImageUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeImageUrl() {
        return typeImageUrl;
    }

    public void setTypeImageUrl(String typeImageUrl) {
        this.typeImageUrl = typeImageUrl;
    }
}
