package com.jn.pay.model;/**
 * @author： huangbq
 * @date： Created on 2019/5/22 14:08
 * @version： v1.0
 * @modified By:
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

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
@ApiModel(value = "CreatePayReqModel",description ="发起支付请求参数对象" )
public class CreatePayReqModel  extends CreatePayReqBaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单ID",example = "2019050811515490657",required = true)
    private String orderId;

    @JsonIgnore
    private String userAccount;
    @JsonIgnore
    private String userIp;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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
        return "CreatePayReqModel{" +
                "orderId='" + orderId + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", userIp='" + userIp + '\'' +
                '}';
    }
}
