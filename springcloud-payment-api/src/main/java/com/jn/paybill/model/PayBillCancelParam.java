package com.jn.paybill.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 缴费统计查询入参
 * @author： jiangyl
 * @date： Created on 2019/3/13 10:57
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayBillCountParam", description = "账单取消入参")
public class PayBillCancelParam {
    @ApiModelProperty(value = "账单ID",example = "2we23**")
    private String billId;
    @ApiModelProperty(value = "用户账号",example = "wangsong")
    private String account;

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
