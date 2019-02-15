package com.jn.system.dept.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 岗位信息异常枚举
 *
 * @author： shaobao
 * @date： Created on 2018/12/10 16:10
 * @version： v1.0
 * @modified By:
 **/
public enum SysPostExceptionEnums implements CodeAndMsg {
    DELETE_ERR_POSTTYPE("1112501","删除失败,岗位类型正在被使用"),
    UPDATE_STATUS_ERR("1112502","修改失败,岗位类型正在被使用,不能修改为无效");

    private String code;
    private String message;

    SysPostExceptionEnums(String code, String message) {
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
