package com.jn.system.file.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 文件信息异常枚举
 *
 * @author： yuanyy
 * @date： Created on 2018/4/23 16:10
 * @version： v1.0
 * @modified By:
 **/
public enum SysFileExceptionEnums implements CodeAndMsg {
    AUTHENTICATION_FAIL("1120501","该用户没有权限操作该用户组");

    private String code;
    private String message;

    SysFileExceptionEnums(String code, String message) {
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
