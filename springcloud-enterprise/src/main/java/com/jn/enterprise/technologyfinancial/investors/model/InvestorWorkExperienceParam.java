package com.jn.enterprise.technologyfinancial.investors.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/15 11:36
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "InvestorWorkExperienceParam", description = "科技金融投资人工作经历入参")
public class InvestorWorkExperienceParam implements Serializable {
    @ApiModelProperty(value = "开始时间",example = "2019-03-22")
    @Pattern(regexp = "((19[2-9][0-9])|(20[0-3][0-9]))((0?[1-9])|(1[0-2]))",
            message = "{startTime:'开始时间格式错误'}")
    private String startTime;
    @ApiModelProperty(value = "结束时间",example = "2019-04-22")
    @Pattern(regexp = "((19[2-9][0-9])|(20[0-3][0-9]))((0?[1-9])|(1[0-2]))",
            message = "{endTime:'结束时间格式错误'}")
    private String endTime;
    @ApiModelProperty(value = "单位名称",example = "xxx单位")
    private String companyName;
    @ApiModelProperty(value = "职务",example = "xxx职务")
    private String position;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
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
}
