package com.jn.park.pmpaybill.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 物业缴费计费方式枚举
 *
 * @author： shaobao
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum CalcmodeEnums implements CodeAndMsg {
    COMMON("1", "普通单价"),
    LADDER("2", "阶梯单价"),
    TIME_SHARE("3", "分时单价"),
    ;

    private String code;

    private String message;

    CalcmodeEnums(String key, String message) {
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
