package com.jn.enterprise.servicemarket.index.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 服务超市数据统计出参
 * @author： huxw
 * @date： Created on 2019-6-10 16:01:35
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "DataStatisticsVO",description = "服务超市数据统计出参")
public class DataStatisticsVO implements Serializable {

    @ApiModelProperty(value = "入驻企业数")
    private String comNum;

    @ApiModelProperty(value = "入驻机构数")
    private String orgNum;

    @ApiModelProperty(value = "服务专员数")
    private String advisorNum;


    @ApiModelProperty(value = "累计举办活动数")
    private String activityNum;

    public DataStatisticsVO() {
        this.activityNum = "0";
    }

    public String getComNum() {
        return comNum;
    }

    public void setComNum(String comNum) {
        this.comNum = comNum;
    }

    public String getOrgNum() {
        return orgNum;
    }

    public void setOrgNum(String orgNum) {
        this.orgNum = orgNum;
    }

    public String getAdvisorNum() {
        return advisorNum;
    }

    public void setAdvisorNum(String advisorNum) {
        this.advisorNum = advisorNum;
    }

    public String getActivityNum() {
        return activityNum;
    }

    public void setActivityNum(String activityNum) {
        this.activityNum = activityNum;
    }

    @Override
    public String toString() {
        return "DataStatisticsVO{" +
                "comNum='" + comNum + '\'' +
                ", orgNum='" + orgNum + '\'' +
                ", advisorNum='" + advisorNum + '\'' +
                ", activityNum='" + activityNum + '\'' +
                '}';
    }
}
