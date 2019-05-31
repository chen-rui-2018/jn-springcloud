package com.jn.park.asset.enums;

import com.jn.common.api.CodeAndMsg;

/**
* 支付状态枚举(0未支付,1已支付)
* @author： zhuyz
* @date： Created on 2019/5/8 11:08
* @version： v1.0
* @modified By:
*/
public enum PayStatusEnums implements CodeAndMsg {
    NONPAYMENT("0","未付款"),
    PAYMENT("1","已付款"),
    CANCEL("2","订单已取消");
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;
    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    PayStatusEnums(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
