package com.jn.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 订单积分抵扣明细
 *
 * @author： jiangyl
 * @date： Created on 2019/4/10 10:37
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PointDeductionDetail",description = "订单积分抵扣")
public class PointDeductionDetail implements Serializable {
    @ApiModelProperty(value = "抵扣类型名称",example = "停车抵扣")
    private String ruleTypeName;
    @ApiModelProperty(value = "抵扣类型标识",example = "park")
    private String ruleTypeId;
    @ApiModelProperty(value = "抵扣金额",example = "10.0")
    private Double deductionAmount;
    @ApiModelProperty(value = "抵扣积分",example = "100")
    private Double pointNum;
    @ApiModelProperty(value = "积分余额",example = "200")
    private Double pointRemainderNum;

    public String getRuleTypeName() {
        return ruleTypeName;
    }

    public void setRuleTypeName(String ruleTypeName) {
        this.ruleTypeName = ruleTypeName;
    }

    public String getRuleTypeId() {
        return ruleTypeId;
    }

    public void setRuleTypeId(String ruleTypeId) {
        this.ruleTypeId = ruleTypeId;
    }

    public Double getDeductionAmount() {
        return deductionAmount;
    }

    public void setDeductionAmount(Double deductionAmount) {
        this.deductionAmount = deductionAmount;
    }

    public Double getPointNum() {
        return pointNum;
    }

    public void setPointNum(Double pointNum) {
        this.pointNum = pointNum;
    }

    public Double getPointRemainderNum() {
        return pointRemainderNum;
    }

    public void setPointRemainderNum(Double pointRemainderNum) {
        this.pointRemainderNum = pointRemainderNum;
    }

    @Override
    public String toString() {
        return "PointDeductionDetail{" +
                "ruleTypeName='" + ruleTypeName + '\'' +
                ", ruleTypeId='" + ruleTypeId + '\'' +
                ", deductionAmount='" + deductionAmount + '\'' +
                ", pointNum='" + pointNum + '\'' +
                ", pointRemainderNum='" + pointRemainderNum + '\'' +
                '}';
    }
}
