package com.jn.park.parking.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 停车场统计数据
 *
 * @Author: jiangyl
 * @Date: 2019/5/23 11:15
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingCount", description = "停车场统计数据")
public class ParkingCount implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "当天收费总数")
    private String chargeAmount;
    @ApiModelProperty(value = "停车总次数")
    private String parkingSum;
    @ApiModelProperty(value = "各停车场利用率")
    private List<ParkingAreaUseRate> useRate;

    public String getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(String chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public String getParkingSum() {
        return parkingSum;
    }

    public void setParkingSum(String parkingSum) {
        this.parkingSum = parkingSum;
    }

    public List<ParkingAreaUseRate> getUseRate() {
        return useRate;
    }

    public void setUseRate(List<ParkingAreaUseRate> useRate) {
        this.useRate = useRate;
    }
}