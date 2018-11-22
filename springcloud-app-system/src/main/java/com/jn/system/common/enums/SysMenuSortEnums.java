package com.jn.system.common.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 菜单界面,用于菜单排序
 * @author： shaobao
 * @date： Created on 2018/11/22 16:21
 * @version： v1.0
 * @modified By:
 **/
public enum  SysMenuSortEnums implements CodeAndMsg {

    MENU_ISDIR_SORT("0","菜单是目录菜单时,排序默认为0"),
    FIRST_SORT("1","一级排序");

    private String code;
    private String message;

    SysMenuSortEnums(String code, String message) {
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
