package com.jn.pay.model;/**
 * @author： huangbq
 * @date： Created on 2019/5/22 14:08
 * @version： v1.0
 * @modified By:
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ApiModelProperty(value = "缴费类型（1电费，2物业费，3维修费，4房租，5物品租赁，6停车费，7车位费，8水费，9宣传费，10体检费，11预缴充值电费）",example = "4",required = true)
    @NotBlank
    private String payType;

    @ApiModelProperty(value = "用户账号",hidden = true)
    private String userAccount;

    @ApiModelProperty(value = "用户IP地址",hidden = true)
    private String userIp;



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

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
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

    @Override
    public String toString() {
        return "CreatePayReqBaseModel{" +
                "channelId='" + channelId + '\'' +
                ", paySum=" + paySum +
                ", payType='" + payType + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", userIp='" + userIp + '\'' +
                '}';
    }
}
