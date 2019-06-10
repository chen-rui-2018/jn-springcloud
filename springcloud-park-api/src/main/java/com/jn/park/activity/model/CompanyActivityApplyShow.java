package com.jn.park.activity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/5/30 14:23
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "CompanyActivityApplyShow", description = "企业报名活动信息出参（返回数据是报名成功并且已签到的数据）")
public class CompanyActivityApplyShow implements Serializable {
    @ApiModelProperty(value = "企业（团队）Id")
    private String companyId;
    @ApiModelProperty(value = "企业（团队）名称")
    private String companyName;
    @ApiModelProperty(value = "报名人账号")
    private String applyAccount;
    @ApiModelProperty(value = "报名人姓名")
    private String applyName;
    @ApiModelProperty(value = "活动标题")
    private String activityTitle;
    @ApiModelProperty(value = "报名时间")
    private String applyTime;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getApplyAccount() {
        return applyAccount;
    }

    public void setApplyAccount(String applyAccount) {
        this.applyAccount = applyAccount;
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    @Override
    public String toString() {
        return "CompanyActivityApplyShow{" +
                "companyId='" + companyId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", applyAccount='" + applyAccount + '\'' +
                ", applyName='" + applyName + '\'' +
                ", activityTitle='" + activityTitle + '\'' +
                ", applyTime='" + applyTime + '\'' +
                '}';
    }
}
