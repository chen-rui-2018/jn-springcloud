package com.jn.park.approve.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author： huangbq
 * @date： Created on 2019/3/12 16:58
 * @version： v1.0
 * @modified By:
 */
@ApiModel("指南分类发布")
public class ApproveGuideTypeAddModel {
    @ApiModelProperty(value = "主键",notes = "不为空时代表修改分类内容")
    private Integer id;

    @ApiModelProperty("审批指南名称")
    private String name;

    @ApiModelProperty("父分类ID")
    private Integer parentId;

    @ApiModelProperty("权力名称（冗余字段，保存根节点的名称）")
    private String rootName;

    @ApiModelProperty("分类树的层级，0代表根节点（权力分类）")
    private Byte level;


    @ApiModelProperty("默认排序(asc)")
    private Integer defaultSort;

    @ApiModelProperty("分类图片地址（一级分类才有）")
    private String typeImageUrl;

    @ApiModelProperty("首页排序(在门户首页的顺序asc)")
    private Integer homeSort;

    @ApiModelProperty("置顶顺序(在行政审批中心首页的顺序asc）")
    private Integer topSort;

    @ApiModelProperty("显示状态（草稿，已发布，下线）")
    private String showStatus;

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getRootName() {
        return rootName;
    }

    public void setRootName(String rootName) {
        this.rootName = rootName;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Integer getDefaultSort() {
        return defaultSort;
    }

    public void setDefaultSort(Integer defaultSort) {
        this.defaultSort = defaultSort;
    }

    public String getTypeImageUrl() {
        return typeImageUrl;
    }

    public void setTypeImageUrl(String typeImageUrl) {
        this.typeImageUrl = typeImageUrl;
    }

    public Integer getHomeSort() {
        return homeSort;
    }

    public void setHomeSort(Integer homeSort) {
        this.homeSort = homeSort;
    }

    public Integer getTopSort() {
        return topSort;
    }

    public void setTopSort(Integer topSort) {
        this.topSort = topSort;
    }

    public String getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(String showStatus) {
        this.showStatus = showStatus;
    }
}
