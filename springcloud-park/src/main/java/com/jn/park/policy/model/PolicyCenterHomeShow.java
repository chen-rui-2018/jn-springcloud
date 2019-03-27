package com.jn.park.policy.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/27 17:17
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "PolicyClassShow",description = "政策中心首页出参")
public class PolicyCenterHomeShow implements Serializable {
    @ApiModelProperty(value = "政策id")
    private String policyId;
    @ApiModelProperty(value = "政策编码")
    private String policyCode;
    @ApiModelProperty(value = "政策级别编码")
    private String policyLevelCode;
    @ApiModelProperty(value = "政策级别名称")
    private String policyLevelName;
    @ApiModelProperty(value = "政策分类编码")
    private String policyClassCode;
    @ApiModelProperty(value = "政策分类名称")
    private String policyClassName;
    @ApiModelProperty(value = "政策类型(0：普通政策  1：图解政策)")
    private String policyType;
    @ApiModelProperty(value = "政策标题")
    private String policyTitle;
    @ApiModelProperty(value = "阅读次数")
    private Integer readNum;
    @ApiModelProperty(value = "发布日期")
    private String releaseDate;
    @ApiModelProperty(value = "状态(0：无效  1：有效)")
    private String status;
    @ApiModelProperty(value = "支持方式(1：奖励  2：其他)")
    private String supportMethod;
    @ApiModelProperty(value = "支持产业(1：所有产业  2：其他)")
    private String supportIndustry;
    @ApiModelProperty(value = "发文单位")
    private String issueUnit;
}
