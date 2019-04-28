package com.jn.enterprise.data.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @author： yangh
 * @date： Created on 2019/4/10 14:09
 * @version： v1.0
 * @modified By:
 */
public enum DataUploadExceptionEnum implements CodeAndMsg {
    TARGET_IS_BLANK("5030201","指标id不能为空！"),
    TARGET_IS_NOT_EXIST("5030202","指标不存在"),
    TARGET_ISMUILTROW_IS_NOT_EXIST("5030202","指标的是否可以多行不存在"),
    TARGET_TYPE_IS_NOT_EXIST("5030202","指标类型是空的"),
    TARGET_RECORDSTATUS_IS_NOT_EXIST("5030202","指标状态不存在"),

    MODEL_IS_BLANK("5030203","模板ID不存在"),
    MODEL_IS_NOT_EXIST("5030204","模板不存在"),

    TASK_IS_NOT_EXIST("5030205","任务不存在"),
    TAB_IS_NOT_EXIST("5030207","表单不存在"),
    USER_PHONE_IS_NOT_EXIST("5030208","用户手机号不存在"),
    VALUE_NOT_EXIST("5030209","填报值不存在"),
    VALUE_IS_NUMBER("5030210","填报值需要数值类型"),
    TASK_IS_ERROR("5030211","任务信息错误"),
    INPUT_IS_ERROR("5030212","填报信息错误")
    ;
    private String  code;

    private String message;

    DataUploadExceptionEnum(String code,String message){
        this.code = code;
        this.message = message;
    }
    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
