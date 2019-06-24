package com.jn.park.pmpaybill.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 物业缴费异常枚举
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum PmPayBillExcetionEnums implements CodeAndMsg {
    GENERATOR_ERROR("5010301", "生成缴费单失败"),
    GET_PM_PRICE_FAIL("5010302", "获取物业信息失败"),
    GET_COMPANY_INFO_FAIL("5010303", "获取企业信息失败"),
    ;

    private String code;

    private String message;

    PmPayBillExcetionEnums(String key, String message) {
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
