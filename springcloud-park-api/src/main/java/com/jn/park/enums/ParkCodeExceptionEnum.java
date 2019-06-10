package com.jn.park.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 园区字典异常枚举
 *
 * @author： jiangyl
 * @date： Created on 2018/12/17 10:29
 * @version： v1.0
 * @modified By:
 */
public enum ParkCodeExceptionEnum implements CodeAndMsg {
    CODE_TYPE_NOT_NULL("4020201", "字典类型不能为空");

    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    ParkCodeExceptionEnum(String code, String message) {
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
