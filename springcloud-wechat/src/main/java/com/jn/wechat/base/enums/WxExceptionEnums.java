package com.jn.wechat.base.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 微信公众号异常枚举
 *
 * @Author： cm
 * @Date： Created on 2019/1/23 10:50
 * @Version： v1.0
 * @Modified By:
 */
public enum WxExceptionEnums implements CodeAndMsg {

    GET_WX_USER_FAIL("150041000","获取微信用户信息失败"),
    NOT_ALLOW_ACCESS_TOKEN("150031301","微信接口url参数中不允许有access_token"),
    JSON_PROCESS_FAL("150031300","post接口请求，对象参数转换json字符串失败"),
    NOT_FINDE_WX_MSG_HANDLE("150031201","无法找到微信消息的处理类")
    ;

    private String code;
    private String message;

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    WxExceptionEnums(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
