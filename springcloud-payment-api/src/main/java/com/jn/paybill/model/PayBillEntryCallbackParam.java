package com.jn.paybill.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * 缴费账单录入审核回调Bean
 * @author： jiangyl
 * @date： Created on 2019/3/19 09:43
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayBillEntryCallbackParam", description = "缴费账单录入审核回调Bean")
public class PayBillEntryCallbackParam implements Serializable {
    @ApiModelProperty(value = "账单编号")
    @NotBlank(message = "账单编号不能为空")
    private String billId;
    @ApiModelProperty(value = "账单类型id")
    @NotBlank(message = "账单对象ID不能为空")
    private String billStatus;

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }
}
