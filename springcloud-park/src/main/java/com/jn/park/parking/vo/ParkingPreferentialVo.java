package com.jn.park.parking.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 优惠政策
 * @author： jiangyl
 * @date： Created on 2019/4/19 9:31
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingPreferentialVo",description = "优惠政策")
public class ParkingPreferentialVo implements Serializable {

    @ApiModelProperty(value = "优惠政策标识",example = "e2ew3***")
    private String policyId;

    @ApiModelProperty(value = "优惠政策编码",example = "year")
    private String policyCode;

    @ApiModelProperty(value = "优惠政策内容",example = "企业高新人才享受减免")
    private String policyComments;

    @ApiModelProperty(value = "优惠金额[空/0标识不设置优惠金额]",example = "100")
    private Double offerPrice;

    @ApiModelProperty(value = "优惠折扣[抵扣百分比][如已设置优惠金额，则优惠比例不生效]",example = "5")
    private Double offerRatio;

    @ApiModelProperty(value = "租满多少天可用(加上之前租赁天数)",example = "365")
    private Integer dayConditions;

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getPolicyCode() {
        return policyCode;
    }

    public void setPolicyCode(String policyCode) {
        this.policyCode = policyCode;
    }

    public String getPolicyComments() {
        return policyComments;
    }

    public void setPolicyComments(String policyComments) {
        this.policyComments = policyComments;
    }

    public Double getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(Double offerPrice) {
        this.offerPrice = offerPrice;
    }

    public Double getOfferRatio() {
        return offerRatio;
    }

    public void setOfferRatio(Double offerRatio) {
        this.offerRatio = offerRatio;
    }

    public Integer getDayConditions() {
        return dayConditions;
    }

    public void setDayConditions(Integer dayConditions) {
        this.dayConditions = dayConditions;
    }
}
