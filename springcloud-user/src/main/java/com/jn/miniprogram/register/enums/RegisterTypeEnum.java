package com.jn.miniprogram.register.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 微信注册枚举
 * @Author: yangph
 * @Date: 2019/6/17 9:49
 * @Version v1.0
 * @modified By:
 */
public enum RegisterTypeEnum implements CodeAndMsg {
    SMALL_PROGRAM("smallProgram","1","微信小程序"),
    PUBLIC_NUMBER("publicNumber","2","微信公众号"),
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 状态值
     */
    private String value;
    /**
     * 信息
     */
    private String message;


    RegisterTypeEnum(String code, String value, String message) {
        this.code = code;
        this.value = value;
        this.message = message;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
