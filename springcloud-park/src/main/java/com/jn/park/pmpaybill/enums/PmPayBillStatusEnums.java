package com.jn.park.pmpaybill.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 物业缴费状态枚举
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum PmPayBillStatusEnums implements CodeAndMsg {
    EFFECTIVE("1", "有效"),
    DISABLED("0", "无效");

    private String code;

    private String message;

    PmPayBillStatusEnums(String key, String message) {
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
