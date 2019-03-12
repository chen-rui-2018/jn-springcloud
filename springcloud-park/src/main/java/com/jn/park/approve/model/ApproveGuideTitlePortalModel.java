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
@ApiModel("指南标题（门户显示）")
public class ApproveGuideTitlePortalModel {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("审批指南名称")
    private String name;

    @ApiModelProperty("是否为内容页（0分类页，代表还有下级内容；1内容页，为叶子节点，没有下级内容了）")
    private Byte isPage;

    @ApiModelProperty("最新更新时间")
    private String modifiedTime;

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

    public Byte getIsPage() {
        return isPage;
    }

    public void setIsPage(Byte isPage) {
        this.isPage = isPage;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}
