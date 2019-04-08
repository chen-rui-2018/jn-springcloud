package com.jn.park.policy.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/29 11:17
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "PolicyManagementShow",description = "政策管理出参")
public class PolicyManagementShow implements Serializable {
    @ApiModelProperty(value = "政策标题")
    private String policyTitle;
    @ApiModelProperty(value = "阅读次数")
    private Integer readNum;
    @ApiModelProperty(value = "政策级别名称")
    private String policyLevelName;
    @ApiModelProperty(value = "政策分类名称")
    private String policyClassName;
    @ApiModelProperty(value = "发布时间")
    private String releaseDate;
    @ApiModelProperty(value = "支持方式(1:奖励  2:其他)")
    private String supportMethod;
    @ApiModelProperty(value = "支持产业(1:所有产业  2:其他)")
    private String supportIndustry;
    @ApiModelProperty(value = "发文单位")
    private String issueUnit;

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

    @Override
    public String toString() {
        return "PolicyManagementShow{" +
                "policyTitle='" + policyTitle + '\'' +
                ", readNum=" + readNum +
                ", policyLevelName='" + policyLevelName + '\'' +
                ", policyClassName='" + policyClassName + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", supportMethod='" + supportMethod + '\'' +
                ", supportIndustry='" + supportIndustry + '\'' +
                ", issueUnit='" + issueUnit + '\'' +
                '}';
    }
}
