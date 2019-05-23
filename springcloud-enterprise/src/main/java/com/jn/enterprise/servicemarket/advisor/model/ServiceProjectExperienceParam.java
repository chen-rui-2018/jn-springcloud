package com.jn.enterprise.servicemarket.advisor.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/2/14 16:45
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ServiceProjectExperienceParam",description = "顾问项目经验入参")
public class ServiceProjectExperienceParam  implements Serializable {
    @ApiModelProperty(value = "主键id(新增时为空，修改时必传)")
    private String id;
    @ApiModelProperty(value = "顾问账号",required = true,example = "wangsong")
    @NotNull(message="顾问账号不能为空")
    private String advisorAccount;
    @ApiModelProperty(value = "公司名称",required = true,example = "xxx公司")
    @NotNull(message="公司名称不能为空")
    private String companyName;
    @ApiModelProperty(value = "项目名称",required = true,example = "xxx项目")
    @NotNull(message="项目名称不能为空")
    private String projectName;
    @ApiModelProperty(value = "项目开始时间",example = "201903")
    @Pattern(regexp = "((19[2-9][0-9])|(20[0-3][0-9]))((0[1-9])|(1[0-2]))",
            message = "{projectTime:'项目开始时间格式错误'}")
    private String projectTime;
    @ApiModelProperty(value = "项目结束时间",example = "201904")
    @Pattern(regexp = "((19[2-9][0-9])|(20[0-3][0-9]))((0[1-9])|(1[0-2]))",
            message = "{projectEndTime:'项目结束时间格式错误'}")
    private String projectEndTime;
    @ApiModelProperty(value = "个人职责",example = "主要从事xxx...")
    @Size(max = 500, message = "个人职责描述不能超过500字")
    private String personalDuties;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdvisorAccount() {
        return advisorAccount;
    }

    public void setAdvisorAccount(String advisorAccount) {
        this.advisorAccount = advisorAccount;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectTime() {
        return projectTime;
    }

    public void setProjectTime(String projectTime) {
        this.projectTime = projectTime;
    }

    public String getProjectEndTime() {
        return projectEndTime;
    }

    public void setProjectEndTime(String projectEndTime) {
        this.projectEndTime = projectEndTime;
    }

    public String getPersonalDuties() {
        return personalDuties;
    }

    public void setPersonalDuties(String personalDuties) {
        this.personalDuties = personalDuties;
    }

    @Override
    public String toString() {
        return "ServiceProjectExperienceParam{" +
                "id='" + id + '\'' +
                ", advisorAccount='" + advisorAccount + '\'' +
                ", companyName='" + companyName + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectTime='" + projectTime + '\'' +
                ", projectEndTime='" + projectEndTime + '\'' +
                ", personalDuties='" + personalDuties + '\'' +
                '}';
    }
}
