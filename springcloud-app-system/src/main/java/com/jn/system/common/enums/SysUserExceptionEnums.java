package com.jn.system.common.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 用户管理接口异常枚举
 * @author： shaobao
 * @date： Created on 2018/11/22 14:56
 * @version： v1.0
 * @modified By:
 **/
public enum SysUserExceptionEnums implements CodeAndMsg {

    NOT_MODIFY_ACCOUNT("1110501","用户账号不允许修改"),
    DEPARTMENTPOST_DEFAULE_NOTUNIQUE("1110502","用户默认部门岗位信息不唯一");

    private String code;
    private String message;

    SysUserExceptionEnums(String code, String message) {
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
