package com.jn.system.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 权限管理接口异常枚举
 * @author： shaobao
 * @date： Created on 2018/11/21 16:56
 * @version： v1.0
 * @modified By:
 **/
public enum SysExceptionEnums implements CodeAndMsg {

    ADDERR_NAME_EXIST("1111301","添加失败,名称已存在"),
    UPDATEERR_NAME_EXIST("1111302", "修改信息失败,名称已存在"),
    NOT_MODIFY_ACCOUNT("1111303","账号不允许修改"),
    DEPARTMENTPOST_DEFAULE_NOTUNIQUE("1111304","用户默认部门岗位信息不唯一");

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
