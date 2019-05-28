package com.jn.park.pmpaybill.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 物业缴费账单是否已经发送给企业状态枚举
 *
 * @author： shaobao
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum SendPayBillEnums implements CodeAndMsg {
    SENTED("1", "已发送"),
    NO_SEND("0", "未发送")
    ;

    private String code;

    private String message;

    SendPayBillEnums(String key, String message) {
        this.code = key;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }


    @Override
    public String getMessage() {
        return message;
    }

}
