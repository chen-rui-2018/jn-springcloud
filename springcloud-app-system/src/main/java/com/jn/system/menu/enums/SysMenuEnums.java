package com.jn.system.menu.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 菜单接口目录属性及层级属性枚举
 * @author： shaobao
 * @date： Created on 2018/11/22 16:16
 * @version： v1.0
 * @modified By:
 **/
public enum SysMenuEnums implements CodeAndMsg {

    MENU_ISDIR("1","菜单是目录菜单"),
    MENU_ISNOTDIR("0","菜单不是目录菜单"),

    MENU_DIR_ICON("fa fa-folder-o","菜单是目录菜单时对应图标"),
    MENU_NOTDIR_ICON("fa fa-file-text-o","菜单是子菜单是对应图标"),

    MENU_ISDIR_SORT("0","菜单是目录菜单时,排序默认为0"),
    FIRST_SORT("1","一级排序");

    private String code;
    private String message;

    SysMenuEnums(String code, String message) {
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
