package com.jn.park.sp.enums;

import com.jn.common.api.CodeAndMsg;

/**
 *
 * @author： zhuyz
 * @date： Created on 2019/3/28 11:17
 * @version： v1.0
 * @modified By:
 */
public enum  SpPageExceptionEnums implements CodeAndMsg {
    PAGE_NOT_NULL("4000201","分页不能为空");

    private String code;

    private String message;

    SpPageExceptionEnums(String code, String message) {
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
