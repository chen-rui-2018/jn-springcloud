package com.jn.enterprise.technologyfinancial.investors.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: yangph
 * @Date: 2019/3/25 10:40
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "InvestorWorkExperienceShow", description = "科技金融投资人工作经历出参")
public class InvestorWorkExperienceShow implements Serializable {
    @ApiModelProperty(value = "主键id")
    private String id;
    @ApiModelProperty(value = "投资人账号")
    private String investorAccount;
    @ApiModelProperty(value = "开始时间")
    private Date startTime;
    @ApiModelProperty(value = "结束时间")
    private Date endTime;
    @ApiModelProperty(value = "单位名称")
    private String companyName;
    @ApiModelProperty(value = "职务")
    private String position;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInvestorAccount() {
        return investorAccount;
    }

    public void setInvestorAccount(String investorAccount) {
        this.investorAccount = investorAccount;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "InvestorWorkExperienceShow{" +
                "id='" + id + '\'' +
                ", investorAccount='" + investorAccount + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
