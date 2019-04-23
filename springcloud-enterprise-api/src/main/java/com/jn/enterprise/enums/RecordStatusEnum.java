package com.jn.enterprise.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 是否删除枚举（公共枚举）
 * @Author: yangph
 * @Date: 2019/4/18 14:06
 * @Version v1.0
 * @modified By:
 */
public enum RecordStatusEnum implements CodeAndMsg {
    EFFECTIVE("1",(byte)1,"有效"),
    DELETE("0",(byte)0, "已删除"),
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;
    /**
     * 值
     */
    private byte value;

    RecordStatusEnum(String code,byte value, String message) {
        this.code = code;
        this.value=value;
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

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }
}
