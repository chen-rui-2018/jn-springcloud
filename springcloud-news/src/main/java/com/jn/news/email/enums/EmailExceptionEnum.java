package com.jn.news.email.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 后台权限管理异常枚举
 * @author： shaobao
 * @date： Created on 2018/11/21 16:56
 * @version： v1.0
 * @modified By:
 **/
public enum EmailExceptionEnum implements CodeAndMsg {

    EMAIL_INFO_CREATE_FAIL("1311301","构建邮件信息失败")
    ;

    private String code;
    private String message;

    EmailExceptionEnum(String code, String message) {
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
