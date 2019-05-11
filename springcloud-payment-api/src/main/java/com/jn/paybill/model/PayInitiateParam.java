package com.jn.paybill.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author： jiangyl
 * @date： Created on 2019/3/14 10:26
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayInitiateParam", description = "支付发起参数")
public class PayInitiateParam implements Serializable {

    @ApiModelProperty(value = "账单ID[数组]",required = true,example = "['ZJ-201899512510','TC-2019031910124']")
    @NotBlank(message = "账单ID[数组]不能为空")
    private String[] billIds;

    @NotBlank(message = "支付方式不能为空")
    @Pattern(regexp = "^[0,1,2]$", message = "{payMenthed:'支付方式只能为[0、1、2]'}")
    @ApiModelProperty(value = "支付方式[暂定：0微信1支付宝2银联]",required = true,example = "0")
    private String payMenthed;

    @NotBlank(message = "是否使用积分不能为空")
    @Pattern(regexp = "^[0,1]$", message = "{usePoints:'是否使用积分只能为[0、1]'}")
    @ApiModelProperty(value = "是否使用积分[0不使用1使用]",required = true,example = "1")
    private String usePoints;

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

    public String getUsePoints() {
        return usePoints;
    }

    public void setUsePoints(String usePoints) {
        this.usePoints = usePoints;
    }
}
