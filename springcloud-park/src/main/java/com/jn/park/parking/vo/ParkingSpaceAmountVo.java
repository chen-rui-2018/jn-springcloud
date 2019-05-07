package com.jn.park.parking.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/18 17:37
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingSpaceAmountVo",description = "租车位价格")
public class ParkingSpaceAmountVo implements Serializable {
    @ApiModelProperty(value = "停车场ID",example = "82uew3***")
    private String areaId;

    @ApiModelProperty(value = "优惠标识",example = "82uew3***")
    private String policyId;

    @ApiModelProperty(value = "租赁开始时间[yyyy-MM-dd]",example = "2019-01-01")
    private String startTime;

    @ApiModelProperty(value = "租赁结束时间[yyyy-MM-dd]",example = "2020-01-01")
    private String endTime;

    @ApiModelProperty(value = "租车位价格(单位:元/年)",example = "2400")
    private String rentPrice;

    @ApiModelProperty(value = "应缴金额[优惠前金额]",example = "2400")
    private Double dueMoney;

    @ApiModelProperty(value = "减免金额",example = "200")
    private Double deductionMoney;

    @ApiModelProperty(value = "实缴金额[优惠后金额]",example = "2200")
    private Double actualMoney;

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

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

    public String getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(String rentPrice) {
        this.rentPrice = rentPrice;
    }

    public Double getDueMoney() {
        return dueMoney;
    }

    public void setDueMoney(Double dueMoney) {
        this.dueMoney = dueMoney;
    }

    public Double getDeductionMoney() {
        return deductionMoney;
    }

    public void setDeductionMoney(Double deductionMoney) {
        this.deductionMoney = deductionMoney;
    }

    public Double getActualMoney() {
        return actualMoney;
    }

    public void setActualMoney(Double actualMoney) {
        this.actualMoney = actualMoney;
    }
}
