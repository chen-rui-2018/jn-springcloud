package com.jn.system.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 菜单页面用来判断是菜单是否是目录菜单
 * @author： shaobao
 * @date： Created on 2018/11/22 16:16
 * @version： v1.0
 * @modified By:
 **/
public enum  SysMenuIsDirEnums implements CodeAndMsg {
    MENU_ISDIR("1","菜单是目录菜单"),
    MENU_ISNOTDIR("0","菜单不是目录菜单");

    private String code;
    private String message;

    SysMenuIsDirEnums(String code, String message) {
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
