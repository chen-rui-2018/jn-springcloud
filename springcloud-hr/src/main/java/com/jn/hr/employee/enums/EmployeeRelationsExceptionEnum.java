package com.jn.hr.employee.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 员工关系异常枚举类
 *
 * @author： wzy
 * @date： Created on 2019/6/11 21:04
 * @version： v1.0
 * @modified By:
 */
public enum EmployeeRelationsExceptionEnum implements CodeAndMsg {
    EMPLOYEE_NOT_EXISTS("7010001", "员工不存在"),
    EMPLOYEE_DATA_NOT_EXISTS("7010002", "查询数据异常【应只有1条，实际查询出来多条】"),
    EMPLOYEE_DATA_ADD_USER_ERROR("7010003", "调用新增用户接口失败【systemClient.addSysUser】"),
    EMPLOYEE_DATA_STATUS_ERROR("7010004", "更新状态失败标识"),

    ;
    private String code;

    private String message;

    EmployeeRelationsExceptionEnum(String code, String message) {
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
