package com.jn.user.userjoin.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 加入园区接口异常枚举
 *
 * @author： lijun
 * @date： Created on 2019/2/28 21:08
 * @version： v1.0
 * @modified By:
 */
public enum UserJoinExceptionEnum implements CodeAndMsg {

    MESSAGE_CODE_IS_WRONG("3020510","短信验证码错误"),
    PHONE_NUMBER_CANNOT_EMPTY("3020511","手机号不能为空"),
    MESSAGE_CODE_CANNOT_EMPTY("3020512","短信验证码不能为空"),
    PASSWORD_CANNOT_EMPTY("3020513","密码不能为空")
    ;
    private String code;
    private String message;

    UserJoinExceptionEnum(String code, String message) {
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
