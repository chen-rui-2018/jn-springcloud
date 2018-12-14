package com.jn.system.menu.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 菜单异常枚举
 * @author： shaobao
 * @date： Created on 2018/12/11 15:28
 * @version： v1.0
 * @modified By:
 **/
public enum SysMenuExceptionEnums implements CodeAndMsg {
    MENU_NAME_REPEAAT("1114501","添加失败,菜单名称重复");

    private String code;
    private String message;

    SysMenuExceptionEnums(String code, String message) {
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
