package com.jn.park.pmpaybill.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 物业缴费缴费账单生成状态枚举
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum GenerateStatusEnums implements CodeAndMsg {
    EXPIRED("1", "已生成"),
    NOT_GENERATE("0", "未生成");

    private String code;

    private String message;

    GenerateStatusEnums(String key, String message) {
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
