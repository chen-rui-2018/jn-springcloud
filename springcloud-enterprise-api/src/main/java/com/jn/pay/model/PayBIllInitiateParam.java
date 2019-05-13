package com.jn.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author： wzy
 * @date： Created on 2019/5/8 9:51
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayBIllInitiateParam", description = "支付发起参数")
public class PayBIllInitiateParam implements Serializable {

    @ApiModelProperty(value = "账单ID[数组]",required = true,example = "['2019050600025','2019050600026']")
    @NotBlank(message = "账单ID[数组]不能为空")
    private String[] billIds;

    @NotBlank(message = "支付方式不能为空")
    @Pattern(regexp = "^[1,2,3,4]$", message = "{payMenthed:'支付方式只能为[1、2、3、4]'}")
    @ApiModelProperty(value = "支付方式[暂定：1:钱包 2::微信  3:支付宝  4:银行卡 ]",required = true,example = "3")
    private String payMenthed;

    public String[] getBillIds() {
        return billIds;
    }

    public void setBillIds(String[] billIds) {
        this.billIds = billIds;
    }

    public String getPayMenthed() {
        return payMenthed;
    }

    public void setPayMenthed(String payMenthed) {
        this.payMenthed = payMenthed;
    }

}
