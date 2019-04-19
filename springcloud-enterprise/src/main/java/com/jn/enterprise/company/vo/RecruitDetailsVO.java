package com.jn.enterprise.company.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RecruitDetailsVO", description = "招聘详情出参")
public class RecruitDetailsVO extends RecruitVO {
    @ApiModelProperty(value = "详情")
    private String details;

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}