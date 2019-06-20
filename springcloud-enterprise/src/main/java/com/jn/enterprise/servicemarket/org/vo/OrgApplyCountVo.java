package com.jn.enterprise.servicemarket.org.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 服务机构审核统计
 * @author： jiangyl
 * @date： Created on 2019/2/21 17:40
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OrgApplyCountVo",description = "服务机构审核统计")
public class OrgApplyCountVo implements Serializable {
    @ApiModelProperty(value = "待审核机构数")
    private String waitApplyCount;
    @ApiModelProperty(value = "已入住机构数")
    private String orgCount;
    @ApiModelProperty(value = "本月入驻机构数")
    private String monthJoinOrgCount;
    @ApiModelProperty(value = "上月入驻机构数")
    private String lastMonthJoinOrgCount;
    @ApiModelProperty(value = "本月入驻环比")
    private String monthJoinOrgRatio;

    public String getWaitApplyCount() {
        return waitApplyCount;
    }

    public void setWaitApplyCount(String waitApplyCount) {
        this.waitApplyCount = waitApplyCount;
    }

    public String getOrgCount() {
        return orgCount;
    }

    public void setOrgCount(String orgCount) {
        this.orgCount = orgCount;
    }

    public String getMonthJoinOrgCount() {
        return monthJoinOrgCount;
    }

    public void setMonthJoinOrgCount(String monthJoinOrgCount) {
        this.monthJoinOrgCount = monthJoinOrgCount;
    }

    public String getLastMonthJoinOrgCount() {
        return lastMonthJoinOrgCount;
    }

    public void setLastMonthJoinOrgCount(String lastMonthJoinOrgCount) {
        this.lastMonthJoinOrgCount = lastMonthJoinOrgCount;
    }

    public String getMonthJoinOrgRatio() {
        return monthJoinOrgRatio;
    }

    public void setMonthJoinOrgRatio(String monthJoinOrgRatio) {
        this.monthJoinOrgRatio = monthJoinOrgRatio;
    }
}
