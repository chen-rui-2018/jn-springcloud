package com.jn.system.dict.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @author： shaobao
 * @date： Created on 2019/1/25 9:45
 * @version： v1.0
 * @modified By:
 **/
public enum SysDictExceptionEnums implements CodeAndMsg {
    ADDERR_KEY_REPEAAT("1115501","添加失败,数据字典键在分组中已存在"),
    UPDATEERR_KEY_REPEAAT("1115502","修改失败,数据字典键在分组中已存在"),
    MODULE_KEY_REPEAAT("1115503","添加失败,模块编码已存在"),
    NOT_MODIFY_MODULE_KEY("1115504","修改失败,模块编码不允许修改"),
    NOT_ALLOWED_DELETE_MODULE("1115505","删除失败,当前模块数据字典正在使用,不允许删除");

    private String code;
    private String message;

    SysDictExceptionEnums(String code, String message) {
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
