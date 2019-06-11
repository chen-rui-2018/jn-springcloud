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

    GET_WX_USER_FAIL("1500401","获取微信用户信息失败"),
    NOT_ALLOW_ACCESS_TOKEN("1500302","微信接口url参数中不允许有access_token"),
    JSON_PROCESS_FAL("1500303","对象参数转换json字符串失败"),
    NOT_FINDE_WX_MSG_HANDLE("1500304","无法找到微信消息的处理类"),
    SEND_TEMPLATE_MSG_FAIL("1500305","发送模板信息异常"),
    GET_ACCESS_TOKEN_FAIL("1500306","获取access_token失败.")
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
