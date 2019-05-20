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

    @ApiModelProperty(value = "支付渠道ID（WX_APP：微信APP支付，ALIPAY_MOBILE：支付宝移动支付）",required = true,example = "ALIPAY_MOBILE")
    @NotBlank(message = "支付渠道ID不能为空")
    private String channelId;

    public String[] getBillIds() {
        return billIds;
    }

    public void setBillIds(String[] billIds) {
        this.billIds = billIds;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}
