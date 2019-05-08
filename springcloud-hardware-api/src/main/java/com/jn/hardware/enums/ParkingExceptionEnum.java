package com.jn.hardware.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 智慧停车异常枚举
 *
 * @Author： cm
 * @Date： Created on 2019/4/17 16:19
 * @Version： v1.0
 * @Modified By:
 */
public enum ParkingExceptionEnum implements CodeAndMsg {
    MISSING_PARK_ID("1712201", "缺少车场唯一标识。"),
    DOOR_COMPANY_EXCEPTION("1712201", "调用道尔接口，发生未知异常。"),
    DOOR_CAR_IN_PARKING("1712202", "道尔入场消息推送,发生未知异常"),
    DOOR_CAR_OUT_PARKING("1712203", "道尔出场消息推送,发生未知异常。"),
    DOOR_CAR_PARKING_SIGNNATURE("1712204", "动态签名验证失败")
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    ParkingExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
