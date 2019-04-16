package com.jn.enterprise.servicemarket.org.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 服务超市统计数据
 * @author： jiangyl
 * @date： Created on 2019/2/13 15:08
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ServiceStatisticalNumVO", description = "服务超市统计数据")
public class ServiceStatisticalNumVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "注册买家数")
    private String companyNum;

    @ApiModelProperty(value = "入驻机构数")
    private String orgNum;

    @ApiModelProperty(value = "活动场数")
    private String activityNum;

    @ApiModelProperty(value = "入驻顾问数")
    private String advisorNum;

    @ApiModelProperty(value = "入驻投资人数 ")
    private String investorNum;

    public String getCompanyNum() {
        return companyNum;
    }

    public void setCompanyNum(String companyNum) {
        this.companyNum = companyNum;
    }

    public String getOrgNum() {
        return orgNum;
    }

    public void setOrgNum(String orgNum) {
        this.orgNum = orgNum;
    }

    public String getActivityNum() {
        return activityNum;
    }

    public void setActivityNum(String activityNum) {
        this.activityNum = activityNum;
    }

    public String getAdvisorNum() {
        return advisorNum;
    }

    public void setAdvisorNum(String advisorNum) {
        this.advisorNum = advisorNum;
    }

    public String getInvestorNum() {
        return investorNum;
    }

    public void setInvestorNum(String investorNum) {
        this.investorNum = investorNum;
    }
}
