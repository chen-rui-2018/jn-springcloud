package com.jn.system.permission.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @author： shaobao
 * @date： Created on 2019/2/18 11:19
 * @version： v1.0
 * @modified By:
 **/
public enum SysPermissionExceptionEnums implements CodeAndMsg {
    NOT_ALLOWED_DELETE_ROLE("1116501","删除失败,当前角色正在被使用"),
    NOT_ALLOWED_DELETE_PERMISSION("1116502","删除失败,当前权限正在被使用");

    private String code;
    private String message;

    SysPermissionExceptionEnums(String code, String message) {
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
