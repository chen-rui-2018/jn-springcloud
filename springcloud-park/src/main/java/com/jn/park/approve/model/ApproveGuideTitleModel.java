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
@ApiModel("指南标题（后台显示）")
public class ApproveGuideTitleModel {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("审批指南名称")
    private String name;

    @ApiModelProperty("父分类ID")
    private Integer parentId;

    @ApiModelProperty("默认排序(asc)")
    private Integer defaultSort;

    @ApiModelProperty("首页排序(在门户首页的顺序asc)")
    private Integer homeSort;

    @ApiModelProperty("置顶顺序(在行政审批中心首页的顺序asc）")
    private Integer topSort;

    @ApiModelProperty("显示状态（草稿，已发布，下线）")
    private String showStatus;

    @ApiModelProperty("创建者账号")
    private String creatorAccount;

    @ApiModelProperty("创建时间")
    private String createdTime;

    @ApiModelProperty("排序字段")
    private String orderByClause;

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

    public Integer getDefaultSort() {
        return defaultSort;
    }

    public void setDefaultSort(Integer defaultSort) {
        this.defaultSort = defaultSort;
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

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }
}
