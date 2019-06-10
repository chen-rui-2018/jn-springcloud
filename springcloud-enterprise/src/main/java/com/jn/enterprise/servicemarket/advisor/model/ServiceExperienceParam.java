package com.jn.enterprise.servicemarket.advisor.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/2/14 16:55
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ServiceExperienceParam",description = "顾问服务经历入参")
public class ServiceExperienceParam  implements Serializable {
    @ApiModelProperty(value = "主键id（新增时为空，修改时必传）")
    private String id;
    @ApiModelProperty(value = "顾问账号",required = true,example = "wangsong")
    @NotNull(message="顾问账号不能为空")
    private String advisorAccount;
    @ApiModelProperty(value = "公司名称",required = true,example = "xxx公司")
    @NotNull(message="公司名称不能为空")
    private String companyName;
    @ApiModelProperty(value = "职务",required = true,example = "高级律师")
    @NotNull(message="职务不能为空")
    private String position;
    @ApiModelProperty(value = "工作开始时间",example = "201903")
    @Pattern(regexp = "((19[2-9][0-9])|(20[0-3][0-9]))((0[1-9])|(1[0-2]))",
            message = "{workTime:'工作开始时间格式错误'}")
    private String workTime;
    @ApiModelProperty(value = "工作结束时间",example = "201904")
    @Pattern(regexp = "((19[2-9][0-9])|(20[0-3][0-9]))((0[1-9])|(1[0-2]))",
            message = "{workEndTime:'工作结束时间格式错误'}")
    private String workEndTime;


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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(String workEndTime) {
        this.workEndTime = workEndTime;
    }

    @Override
    public String toString() {
        return "ServiceExperienceParam{" +
                "id='" + id + '\'' +
                ", advisorAccount='" + advisorAccount + '\'' +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", workTime='" + workTime + '\'' +
                ", workEndTime='" + workEndTime + '\'' +
                '}';
    }
}
