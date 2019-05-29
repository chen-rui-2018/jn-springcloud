package com.jn.park.pmpaybill.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 物业缴费费用类型枚举
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum PayTypeEnums implements CodeAndMsg {
    ELECTRICITY_BILL("1", "电费管理"),
    WATER_BILL("2", "水费管理"),
    PM_BILL("3", "物业费管理"),
    ;

    private String code;

    private String message;

    PayTypeEnums(String key, String message) {
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
