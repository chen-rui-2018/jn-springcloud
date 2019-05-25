package com.jn.park.attractinvest.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
/**
 * 项目管理实体
 *
 * @author： shaobao
 * @date： Created on 2019/4/24 16:38
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "ProjectInfo", description = "项目管理实体")
public class ProjectInfo implements Serializable {

    private static final long serialVersionUID = 7309279744536983243L;
    @ApiModelProperty(value = "项目名称")
    private String projectName;
    @ApiModelProperty(value = "录入人")
    private String creatorAccount;
    @ApiModelProperty(value = "拟制合同开始时间")
    private String compactStartTime;

    public ProjectInfo() {
    }

    public ProjectInfo(String projectName, String creatorAccount, String compactStartTime) {
        this.projectName = projectName;
        this.creatorAccount = creatorAccount;
        this.compactStartTime = compactStartTime;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public String getCompactStartTime() {
        return compactStartTime;
    }

    public void setCompactStartTime(String compactStartTime) {
        this.compactStartTime = compactStartTime;
    }

    @Override
    public String toString() {
        return "ProjectInfo{" +
                "projectName='" + projectName + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", compactStartTime='" + compactStartTime + '\'' +
                '}';
    }
}