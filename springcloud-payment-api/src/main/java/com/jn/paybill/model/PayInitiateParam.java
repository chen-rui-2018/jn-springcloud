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

    @ApiModelProperty(value = "账单ID[数组][可多个订单同时支付]",required = true,example = "['3054fa6cd4ba4063a447db3e14530496']")
    @NotBlank(message = "账单ID[数组]不能为空")
    private String[] billIds;

    @NotBlank(message = "支付方式不能为空")
    @ApiModelProperty(value = "支付方式[请参照接口说明]",required = true,example = "WX_JSAPI")
    private String payMenthed;

    @NotBlank(message = "是否使用积分不能为空")
    @Pattern(regexp = "^[0,1]$", message = "{usePoints:'是否使用积分只能为[0、1]'}")
    @ApiModelProperty(value = "是否使用积分[0不使用1使用]",required = true,example = "1")
    private String usePoints;

    @ApiModelProperty(value = "客户端IP(公网IP)")
    private String clientIp;

    @NotBlank(message = "设备不能为空")
    @ApiModelProperty(value = "设备[web/pc]",required = true,example = "web")
    private String device;

    @ApiModelProperty(value = "特定渠道发起时额外参数")
    private String extra;

    @ApiModelProperty("买家付款完成以后进行自动跳转 ")
    private String aliPayReturnUrl;

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

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getAliPayReturnUrl() {
        return aliPayReturnUrl;
    }

    public void setAliPayReturnUrl(String aliPayReturnUrl) {
        this.aliPayReturnUrl = aliPayReturnUrl;
    }
}
