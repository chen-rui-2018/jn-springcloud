package com.jn.hardware.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @author： chenr
 * @date： Created on 2019/4/25 11:05
 * @version： v1.0
 * @modified By:
 */
public enum ElectricMeterEnum  implements CodeAndMsg {
    ELECTRIC_METER_TYPE_ELECTRIC("1","电表"),
    ELECTRIC_METER_TYPE_WATER("2","水表"),
    ELECTRIC_METER_TYPE_AIR("3","空调表")
    ;
    private String code;
    private String message;
    ElectricMeterEnum(String code, String message){
        this.code = code;
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
