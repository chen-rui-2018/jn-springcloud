package com.jn.enterprise.propaganda.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 宣传类型枚举
 * @Author: yangph
 * @Date: 2019/4/19 11:31
 * @Version v1.0
 * @modified By:
 */
public enum  PropagandaTypeEnum implements CodeAndMsg {
    PROPAGANDA_TYPE("propagandaType","宣传类型"),
    ;

    PropagandaTypeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

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
