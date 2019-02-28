package com.jn.news.sms.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 后台权限管理异常枚举
 * @author： shaobao
 * @date： Created on 2018/11/21 16:56
 * @version： v1.0
 * @modified By:
 **/
public enum SmsExceptionEnum implements CodeAndMsg {

    SMS_NOT_TEMPLATE_ID("1311301","根据短信模板ID找不到短信模板信息."),
    SMS_MISSING_FORMAT_ARGUMENT("1311302","短信模板缺少格式参数.")
    ;

    private String code;
    private String message;

    SmsExceptionEnum(String code, String message) {
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
