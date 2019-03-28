package com.jn.park.policy.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/28 10:07
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "PolicyDetailsShow",description = "政策指南详情出参")
public class PolicyDetailsShow implements Serializable {
    @ApiModelProperty(value = "政策id")
    private String policyId;
    @ApiModelProperty(value = "政策级别名称")
    private String policyLevelName;
    @ApiModelProperty(value = "政策分类名称")
    private String policyClassName;
    @ApiModelProperty(value = "政策标题")
    private String policyTitle;
    @ApiModelProperty(value = "阅读次数")
    private Integer readNum;
    @ApiModelProperty(value = "发布日期")
    private String releaseDate;
    @ApiModelProperty(value = "支持方式(1:奖励  2:其他)")
    private String supportMethod;
    @ApiModelProperty(value = "支持产业(1:所有产业  2:其他)")
    private String supportIndustry;
    @ApiModelProperty(value = "发文单位")
    private String issueUnit;
    @ApiModelProperty(value = "政策内容")
    private String policyContent;

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getPolicyLevelName() {
        return policyLevelName;
    }

    public void setPolicyLevelName(String policyLevelName) {
        this.policyLevelName = policyLevelName;
    }

    public String getPolicyClassName() {
        return policyClassName;
    }

    public void setPolicyClassName(String policyClassName) {
        this.policyClassName = policyClassName;
    }

    public String getPolicyTitle() {
        return policyTitle;
    }

    public void setPolicyTitle(String policyTitle) {
        this.policyTitle = policyTitle;
    }

    public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getSupportMethod() {
        return supportMethod;
    }

    public void setSupportMethod(String supportMethod) {
        this.supportMethod = supportMethod;
    }

    public String getSupportIndustry() {
        return supportIndustry;
    }

    public void setSupportIndustry(String supportIndustry) {
        this.supportIndustry = supportIndustry;
    }

    public String getIssueUnit() {
        return issueUnit;
    }

    public void setIssueUnit(String issueUnit) {
        this.issueUnit = issueUnit;
    }

    public String getPolicyContent() {
        return policyContent;
    }

    public void setPolicyContent(String policyContent) {
        this.policyContent = policyContent;
    }

    @Override
    public String toString() {
        return "PolicyDetailsShow{" +
                "policyId='" + policyId + '\'' +
                ", policyLevelName='" + policyLevelName + '\'' +
                ", policyClassName='" + policyClassName + '\'' +
                ", policyTitle='" + policyTitle + '\'' +
                ", readNum=" + readNum +
                ", releaseDate='" + releaseDate + '\'' +
                ", supportMethod='" + supportMethod + '\'' +
                ", supportIndustry='" + supportIndustry + '\'' +
                ", issueUnit='" + issueUnit + '\'' +
                ", policyContent='" + policyContent + '\'' +
                '}';
    }
}
