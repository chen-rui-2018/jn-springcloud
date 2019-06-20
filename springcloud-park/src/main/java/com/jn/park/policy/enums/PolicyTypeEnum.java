package com.jn.park.policy.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 政策类型枚举
 * @Author: yangph
 * @Date: 2019/4/2 14:58
 * @Version v1.0
 * @modified By:
 */
public enum PolicyTypeEnum implements CodeAndMsg {
    GENERAL_POLICY("generalPolicy","0","普通政策"),
    DIAGRAM_POLICY("diagramPolicy","1","图解政策")
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 类型值
     */
    private String value;

    /**
     * 信息
     */
    private String message;


    PolicyTypeEnum(String code, String value, String message) {
        this.code = code;
        this.value = value;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
