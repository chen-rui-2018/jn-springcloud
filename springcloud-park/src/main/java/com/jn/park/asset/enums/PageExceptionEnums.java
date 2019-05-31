package com.jn.park.asset.enums;

import com.jn.common.api.CodeAndMsg;

/**
* 分页枚举
* @author： zhuyz
* @date： Created on 2019/4/30 10:21
* @version： v1.0
* @modified By:
*/
public enum PageExceptionEnums implements CodeAndMsg {
    PAGE_NOT_NULL("4000201","分页不能为空");

    private String code;

    private String message;

    PageExceptionEnums(String code, String message) {
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
