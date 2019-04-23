package com.jn.user.point.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户积分明细
 * @author： jiangyl
 * @date： Created on 2019/4/3 19:08
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "UserPointDetailVO",description = "用户积分明细")
public class UserPointDetailVO implements Serializable {
    @ApiModelProperty(value = "积分明细标识",example = "aea8167ff8c24b28a24c900dcfad334b")
    private String id;
    @ApiModelProperty(value = "用户账号",notes = "该值从用户扩展表中查询",example = "wangsong")
    private String userAccount;
    @ApiModelProperty(value = "积分抵扣规则名称",example = "实名认证")
    private String ruleTypeName;
    @ApiModelProperty(value = "积分抵扣规则代码",example = "real_name")
    private String ruleTypeId;
    @ApiModelProperty(value = "积分类型（1收入2支出）",example = "1")
    private String pointType;
    @ApiModelProperty(value = "积分数",example = "10.00")
    private Double pointNum;
    @ApiModelProperty(value = "积分余额",example = "200.00")
    private Double pointBalance;
    @ApiModelProperty(value = "创建时间[yyyy-MM-dd HH:mm:ss]",example = "2019-01-01 11:00:00")
    private String createdTime;
    @ApiModelProperty(value = "创建人",example = "wangsong")
    private String creatorAccount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getRuleTypeName() {
        return ruleTypeName;
    }

    public void setRuleTypeName(String ruleTypeName) {
        this.ruleTypeName = ruleTypeName;
    }

    public String getRuleTypeId() {
        return ruleTypeId;
    }

    public void setRuleTypeId(String ruleTypeId) {
        this.ruleTypeId = ruleTypeId;
    }

    public String getPointType() {
        return pointType;
    }

    public void setPointType(String pointType) {
        this.pointType = pointType;
    }

    public Double getPointNum() {
        return pointNum;
    }

    public void setPointNum(Double pointNum) {
        this.pointNum = pointNum;
    }

    public Double getPointBalance() {
        return pointBalance;
    }

    public void setPointBalance(Double pointBalance) {
        this.pointBalance = pointBalance;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }
}