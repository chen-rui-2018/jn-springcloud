package com.jn.pay.model;/**
 * @author： huangbq
 * @date： Created on 2019/5/22 14:08
 * @version： v1.0
 * @modified By:
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jn.pay.enums.PayTypeEnums;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import org.hibernate.validator.constraints.NotBlank;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 *<pre> 
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：2019/5/22
 *</pre>
 */

public class CreatePayReqBaseModel implements Serializable {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "支付渠道ID（WX_APP：微信APP支付，ALIPAY_MOBILE：支付宝移动支付）",example = "ALIPAY_MOBILE",required = true)
    @NotBlank
    private String channelId;

    @ApiModelProperty(value = "总支付金额",example = "1.02",required = true)
    @NotNull
    private BigDecimal paySum;

    @ApiModelProperty("费用类型（ELECTRIC:电费，PROPERTY:物业费，REPAIR:维修费，ROOM_LEASE:房租费，GOODS_LEASE:物品租赁费，TEMPORARY_PARKING:停车费，PARKING_LEASE:车位费，WATER:水费，PROMOTION:宣传费，HEALTH:体检费，ELECTRIC_RECHARGE:预缴充值电费）")
    @NotNull
    private PayTypeEnums payType;

    @ApiModelProperty(value = "用户账号",hidden = true)
    private String userAccount;

    @ApiModelProperty(value = "用户IP地址",hidden = true)
    private String userIp;

    @ApiModelProperty(value = "特定渠道发起时额外参数：当请求参数channelId = WX_JSAPI 或者 WX_PROGRAM（微信公众号 和小程序支付 ）时，openId(用户标识)参数必填  如：{\"openId\":\"o2RvowBf7sOVJf8kJksUEMceaDqo\"}")
    private String extra;


    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public BigDecimal getPaySum() {
        return paySum;
    }

    public void setPaySum(BigDecimal paySum) {
        this.paySum = paySum;
    }

    public PayTypeEnums getPayType() {
        return payType;
    }

    public void setPayType(PayTypeEnums payType) {
        this.payType = payType;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @Override
    public String toString() {
        return "CreatePayReqBaseModel{" +
                "channelId='" + channelId + '\'' +
                ", paySum=" + paySum +
                ", payType=" + payType +
                ", userAccount='" + userAccount + '\'' +
                ", userIp='" + userIp + '\'' +
                ", extra='" + extra + '\'' +
                '}';
    }
}
