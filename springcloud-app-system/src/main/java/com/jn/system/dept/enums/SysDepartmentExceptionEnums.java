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
public enum SysDepartmentExceptionEnums implements CodeAndMsg {
    DEPARTMENT_NAME_REPEAAT("1113501","添加失败,部门名称重复");

    private String code;
    private String message;

    SysDepartmentExceptionEnums(String code, String message) {
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
