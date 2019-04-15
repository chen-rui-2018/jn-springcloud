package com.jn.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 订单积分抵扣
 * @author： jiangyl
 * @date： Created on 2019/4/10 10:37
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PointDeductionVO",description = "订单积分抵扣")
public class PointDeductionVO implements Serializable {

    @ApiModelProperty(value = "抵扣金额",example = "10.0")
    private Double deductionTotalAmount;

    @ApiModelProperty(value = "抵扣积分",example = "100")
    private Double pointTotalNum;

    @ApiModelProperty(value = "用户总积分",example = "1000")
    private Double userPointNum;

    @ApiModelProperty(value = "抵扣后积分余额",example = "900")
    private Double userPointRemainderNum;

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

    public List<PointDeductionDetail> getDeductionDetails() {
        return deductionDetails;
    }

    public void setDeductionDetails(List<PointDeductionDetail> deductionDetails) {
        this.deductionDetails = deductionDetails;
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

    @Override
    public String toString() {
        return "PointDeductionVO{" +
                "deductionTotalAmount=" + deductionTotalAmount +
                ", pointTotalNum=" + pointTotalNum +
                ", userPointNum=" + userPointNum +
                ", userPointRemainderNum=" + userPointRemainderNum +
                ", deductionDetails=" + deductionDetails +
                '}';
    }
}
