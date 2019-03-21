package com.jn.system.user.enmus;

import com.jn.common.api.CodeAndMsg;

/**
 * 用户管理接口异常枚举
 *
 * @author： shaobao
 * @date： Created on 2018/11/22 14:56
 * @version： v1.0
 * @modified By:
 **/
public enum SysUserExceptionEnums implements CodeAndMsg {

    NOT_MODIFY_ACCOUNT("1110501", "用户账号不允许修改"),
    DEPARTMENTPOST_DEFAULE_NOTUNIQUE("1110502", "添加失败,部门岗位信息需要且只能有一个默认值"),
    ADD_DEPRTMENTPOST_ERROR("1110503", "添加失败,部门岗位必须同时添加"),
    ADDERR_NAME_EXIST("1110504", "添加失败,用户账号已存在"),
    ADD_DEPARTMENT_POST_REPEAT("1110505", "添加失败,部门岗位信息不能重复添加"),
    NOT_ALLOWED_DELETE_GROUP("1110506", "用户组正在被使用,不允许删除");


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
