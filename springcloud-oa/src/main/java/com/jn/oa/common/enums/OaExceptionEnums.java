package com.jn.oa.common.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * OA管理异常枚举
 * @author： shaobao
 * @date： Created on 2018/11/21 16:56
 * @version： v1.0
 * @modified By:
 **/
public enum OaExceptionEnums implements CodeAndMsg {

    ADDERR_NAME_EXIST("6000501","添加失败,名称已存在"),
    UPDATEERR_NAME_EXIST("6000502", "修改失败,名称已存在"),
    UPDATEDATA_NOT_EXIST("6000503","修改失败,修改信息不存在"),
    ID_NOT_NULL("6000504","ID不能为空"),
    TIMING_FAILURE("6000510","定时设置失败,请稍后再试"),
    CALL_SERVICE_ERROR("6000101", "调用内部服务出现未知错误");
    ;

    private String code;
    private String message;

    OaExceptionEnums(String code, String message) {
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
