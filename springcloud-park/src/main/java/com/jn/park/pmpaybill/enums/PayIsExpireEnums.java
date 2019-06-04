package com.jn.park.pmpaybill.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 物业缴费是否延期状态枚举
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum PayIsExpireEnums implements CodeAndMsg {
    NOT_EXPIRE("1", "未逾期"),
    EXPIRED("0", "已逾期");

    private String code;

    private String message;

    PayIsExpireEnums(String key, String message) {
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
