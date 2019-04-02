package com.jn.enterprise.technologyfinancial.investors.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/15 11:24
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "InvestorMainArea", description = "科技金融投资人主投领域信息")
public class InvestorMainArea implements Serializable {
    @ApiModelProperty(value = "主投领域编码",example = "biomedicine")
    private String mainCode;
    @ApiModelProperty(value = "主投领域名称",example = "生物医药")
    private String mainName;

    public String getMainCode() {
        return mainCode;
    }

    public void setMainCode(String mainCode) {
        this.mainCode = mainCode;
    }

    public String getMainName() {
        return mainName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    @Override
    public String toString() {
        return "InvestorMainArea{" +
                "mainCode='" + mainCode + '\'' +
                ", mainName='" + mainName + '\'' +
                '}';
    }
}
