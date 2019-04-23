package com.jn.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 订单积分抵扣
 * @author： jiangyl
 * @date： Created on 2019/4/10 10:37
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PointOrderPayParam",description = "订单积分抵扣参数")
public class PointOrderPayParam implements Serializable {

    @ApiModelProperty(value = "抵扣金额",example = "10.0",required = true)
    private Double deductionTotalAmount;

    @ApiModelProperty(value = "抵扣积分",example = "100",required = true)
    private Double pointTotalNum;

    @ApiModelProperty(value = "用户总积分",example = "1000",required = true)
    private Double userPointNum;

    @ApiModelProperty(value = "抵扣后积分余额",example = "900",required = true)
    private Double userPointRemainderNum;

    @ApiModelProperty(value = "订单ID",example = "54b1b946e081458ca22c496918e7f9b9",required = true)
    private String orderId;

    @ApiModelProperty(value = "用户账号",example = "wangsong",required = true)
    private String account;

    @ApiModelProperty(value = "抵扣明细")
    private List<PointDeductionDetail> deductionDetails;

    public Double getDeductionTotalAmount() {
        return deductionTotalAmount;
    }

    public void setDeductionTotalAmount(Double deductionTotalAmount) {
        this.deductionTotalAmount = deductionTotalAmount;
    }

    public Double getPointTotalNum() {
        return pointTotalNum;
    }

    public void setPointTotalNum(Double pointTotalNum) {
        this.pointTotalNum = pointTotalNum;
    }

    public Double getUserPointNum() {
        return userPointNum;
    }

    public void setUserPointNum(Double userPointNum) {
        this.userPointNum = userPointNum;
    }

    public Double getUserPointRemainderNum() {
        return userPointRemainderNum;
    }

    public void setUserPointRemainderNum(Double userPointRemainderNum) {
        this.userPointRemainderNum = userPointRemainderNum;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<PointDeductionDetail> getDeductionDetails() {
        return deductionDetails;
    }

    public void setDeductionDetails(List<PointDeductionDetail> deductionDetails) {
        this.deductionDetails = deductionDetails;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "PointOrderPayParam{" +
                "deductionTotalAmount=" + deductionTotalAmount +
                ", pointTotalNum=" + pointTotalNum +
                ", userPointNum=" + userPointNum +
                ", userPointRemainderNum=" + userPointRemainderNum +
                ", orderId='" + orderId + '\'' +
                ", deductionDetails=" + deductionDetails +
                ", account=" + account +
                '}';
    }
}
