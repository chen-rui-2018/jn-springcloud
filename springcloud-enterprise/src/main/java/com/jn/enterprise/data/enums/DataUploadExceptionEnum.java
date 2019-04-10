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
    MODEL_IS_BLANK("5030203","模板ID不存在"),
    MODEL_IS_NOT_EXIST("5030204","模板不存在")
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
