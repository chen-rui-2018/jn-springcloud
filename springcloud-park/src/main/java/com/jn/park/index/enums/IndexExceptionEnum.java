package com.jn.park.index.enums;

import com.jn.common.api.CodeAndMsg;

public enum IndexExceptionEnum implements CodeAndMsg {
    PARAM_IS_NULL("4090501","入参不能为空"),
    POLICY_TYPE_NOT_VALID("4090520","政策类型传参无效"),
    ;

    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    IndexExceptionEnum(String code, String message) {
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
