package com.jn.hardware.model.parking.door;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/4/19 11:32
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "DoorMonthlyRentCardRateInfo" ,description = "月租信息获取(含费率)出参实体")
public class DoorMonthlyRentCardRateInfo implements Serializable {
    private static final long serialVersionUID = 3577829508004388030L;
    @ApiModelProperty(value = "车牌号码")
    private String  carNo;
    @ApiModelProperty(value = "卡号")
    private String cardNo;
    @ApiModelProperty(value = "卡编号")
    private String cardId;
    @ApiModelProperty(value = "有效开始 格式 YYYY-MM-DD")
    private String startDate;
    @ApiModelProperty(value = "有效结束日期 格式 yyyy-MM-dd")
    private String endDate;
    @ApiModelProperty(value = "卡类型编号")
    private String cardTypeId;
    @ApiModelProperty(value = "卡类型名称")
    private String cardTypeName;
    private List<MonthlyFeeRule> monthlyFeeRule;

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCardTypeId() {
        return cardTypeId;
    }

    public void setCardTypeId(String cardTypeId) {
        this.cardTypeId = cardTypeId;
    }

    public String getCardTypeName() {
        return cardTypeName;
    }

    public void setCardTypeName(String cardTypeName) {
        this.cardTypeName = cardTypeName;
    }

    public List<MonthlyFeeRule> getMonthlyFeeRule() {
        return monthlyFeeRule;
    }

    public void setMonthlyFeeRule(List<MonthlyFeeRule> monthlyFeeRule) {
        this.monthlyFeeRule = monthlyFeeRule;
    }

    @Override
    public String toString() {
        return "DoorMonthlyRentCardRateInfo{" +
                "carNo='" + carNo + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", cardId='" + cardId + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", cardTypeId='" + cardTypeId + '\'' +
                ", cardTypeName='" + cardTypeName + '\'' +
                ", monthlyFeeRuleList=" + monthlyFeeRule +
                '}';
    }
}
