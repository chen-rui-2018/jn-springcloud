package com.jn.park.finance.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 预算录入异常枚举类
 * @author： huangbq
 * @date： Created on 2019/3/5 1:30
 * @version： v1.0
 * @modified By:
 */
public enum FinanceTypeExceptionEnums implements CodeAndMsg {
    UN_KNOW("5000500","业务提醒"),
    TYPE_NAME_EXIST("5000301","名称已经存在"),
    TYPE_NAME_NOT_NULL("5000302","名称不能为空"),
    TYPE_DEPT_NOT_EXIST("5000303","部门不存在");

    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;
    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    FinanceTypeExceptionEnums(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
