package com.jn.enterprise.technologyfinancial.investors.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/4/9 16:57
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "InvestorEducationExperienceParam", description = "科技金融投资人教育经历入参")
public class InvestorEducationExperienceParam implements Serializable {
    @ApiModelProperty(value = "开始时间",example = "201903")
    @Pattern(regexp = "((19[2-9][0-9])|(20[0-3][0-9]))((0?[1-9])|(1[0-2]))",
            message = "{startTime:'开始时间格式错误'}")
    private String startTime;
    @ApiModelProperty(value = "结束时间",example = "201904")
    @Pattern(regexp = "((19[2-9][0-9])|(20[0-3][0-9]))((0?[1-9])|(1[0-2]))",
            message = "{endTime:'结束时间格式错误'}")
    private String endTime;
    @ApiModelProperty(value = "学校名称",example = "xxx大学")
    private String schoolName;
    @ApiModelProperty(value = "专业名称",example = "xxx专业")
    private String professionTitle;

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

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getProfessionTitle() {
        return professionTitle;
    }

    public void setProfessionTitle(String professionTitle) {
        this.professionTitle = professionTitle;
    }
}
