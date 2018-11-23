package com.jn.system.common.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 后台权限管理异常枚举
 * @author： shaobao
 * @date： Created on 2018/11/21 16:56
 * @version： v1.0
 * @modified By:
 **/
public enum SysExceptionEnums implements CodeAndMsg {

    ADDERR_NAME_EXIST("1100501","添加失败,名称已存在"),
    UPDATEERR_NAME_EXIST("1100502", "修改信息失败,名称已存在");

    private String code;
    private String message;

    SysExceptionEnums(String code, String message) {
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
