package com.jn.enterprise.technologyfinancial.investors.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/15 11:31
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "InvestorMainRound", description = "科技金融投资人主投轮次信息")
public class InvestorMainRound implements Serializable {
    @ApiModelProperty(value = "主投轮次编码")
    private String mainRoundCode;
    @ApiModelProperty(value = "主投轮次名称")
    private String mainRoundName;

    public String getMainRoundCode() {
        return mainRoundCode;
    }

    public void setMainRoundCode(String mainRoundCode) {
        this.mainRoundCode = mainRoundCode;
    }

    public String getMainRoundName() {
        return mainRoundName;
    }

    public void setMainRoundName(String mainRoundName) {
        this.mainRoundName = mainRoundName;
    }
}
