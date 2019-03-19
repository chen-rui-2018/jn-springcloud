package com.jn.park.finance.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： tangry
 * @date： Created on 2019/3/18
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinanceWorkbenchMonitoringVo",description = "财务监控")
public class FinanceWorkbenchMonitoringVo implements Serializable {


    private static final long serialVersionUID = 7265483946819201892L;

    @ApiModelProperty("全年支出")
    private String sumcost;
    @ApiModelProperty("全年预算")
    private String sumbudgetnumber;
    @ApiModelProperty("当前使用比例")
    private String ratio;
    @ApiModelProperty("当年累计收入")
    private String sumincome;
    @ApiModelProperty("同期增长")
    private String lastyearpercent;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSumcost() {
        return sumcost;
    }

    public void setSumcost(String sumcost) {
        this.sumcost = sumcost;
    }

    public String getSumbudgetnumber() {
        return sumbudgetnumber;
    }

    public void setSumbudgetnumber(String sumbudgetnumber) {
        this.sumbudgetnumber = sumbudgetnumber;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    public String getSumincome() {
        return sumincome;
    }

    public void setSumincome(String sumincome) {
        this.sumincome = sumincome;
    }

    public String getLastyearpercent() {
        return lastyearpercent;
    }

    public void setLastyearpercent(String lastyearpercent) {
        this.lastyearpercent = lastyearpercent;
    }

    @Override
    public String toString() {
        return "FinanceWorkbenchMonitoringVo{" +
                "sumcost='" + sumcost + '\'' +
                ", sumbudgetnumber='" + sumbudgetnumber + '\'' +
                ", ratio='" + ratio + '\'' +
                ", sumincome='" + sumincome + '\'' +
                ", lastyearpercent='" + lastyearpercent + '\'' +
                '}';
    }
}
