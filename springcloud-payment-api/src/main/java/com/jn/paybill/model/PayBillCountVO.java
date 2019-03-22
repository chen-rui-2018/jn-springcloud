package com.jn.paybill.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 缴费统计响应实体
 * @author： jiangyl
 * @date： Created on 2019/3/13 10:24
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayBillCountVO", description = "缴费统计")
public class PayBillCountVO implements Serializable {
    @ApiModelProperty(value = "总金额[查询条件下总金额]")
    private Double totleAmount;
    @ApiModelProperty(value = "账期未支付金额")
    private Double totleUnpayAmountDaily;
    @ApiModelProperty(value = "账期已支付金额")
    private Double totlePayAmountDaily;
    @ApiModelProperty(value = "分类金额")
    private List<PayBillSubCount> subCounts;

    public Double getTotleAmount() {
        return totleAmount;
    }

    public void setTotleAmount(Double totleAmount) {
        this.totleAmount = totleAmount;
    }

    public Double getTotleUnpayAmountDaily() {
        return totleUnpayAmountDaily;
    }

    public void setTotleUnpayAmountDaily(Double totleUnpayAmountDaily) {
        this.totleUnpayAmountDaily = totleUnpayAmountDaily;
    }

    public Double getTotlePayAmountDaily() {
        return totlePayAmountDaily;
    }

    public void setTotlePayAmountDaily(Double totlePayAmountDaily) {
        this.totlePayAmountDaily = totlePayAmountDaily;
    }

    public List<PayBillSubCount> getSubCounts() {
        return subCounts;
    }

    public void setSubCounts(List<PayBillSubCount> subCounts) {
        this.subCounts = subCounts;
    }
}
