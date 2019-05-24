package com.jn.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 账本明细详情查询
 *
 * @author： wzy
 * @date： Created on 2019/5/21 16:17
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayAccountBookMoneyRecordParam" ,description = "账单明细记录实体类")
public class PayAccountBookMoneyRecordParam implements Serializable {

    @ApiModelProperty(value="日志流水ID")
    private String deductionId;

    @ApiModelProperty(value="当前用户账号")
    private String userAccount;

    public String getDeductionId() {
        return deductionId;
    }

    public void setDeductionId(String deductionId) {
        this.deductionId = deductionId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }
}
