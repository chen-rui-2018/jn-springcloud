package com.jn.park.approve.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 *
 *
 * @author： huangbq
 * @date： Created on 2019/3/12 16:38
 * @version： v1.0
 * @modified By:
 */
@ApiModel("指南分类树")
public class ApproveGuideTypeTreeVo {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("父分类ID")
    private Integer parentId;

    @ApiModelProperty("权力名称（冗余字段，保存根节点的名称）")
    private String rootName;

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


}
