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
    ELECTRIC_METER_TYPE_AIR("3","空调表"),
    ELECTRIC_GET_TOKEN_TRUE("true","可以进行token的获取"),
    ELECTRIC_GET_TOKEN_FALSE("false","不能进行token的获取"),
    ELECTRIC_GET_TOKEN_TIMES("10","获取指定次数还是没有获取到则提示获取失败!"),
    ELECTRIC_GET_TOKEN_TIME("100","access_token的获取间隔时间"),
    ELECTRIC_GET_TOKEN_DEFEAT("100","仪表平台access_token获取失败! 网络异常")
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
