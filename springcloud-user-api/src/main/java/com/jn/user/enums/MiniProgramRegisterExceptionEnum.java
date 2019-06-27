package com.jn.user.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @Author: yangph
 * @Date: 2019/3/13 16:01
 * @Version v1.0
 * @modified By:
 */
public enum MiniProgramRegisterExceptionEnum implements CodeAndMsg {
    NETWORK_ANOMALY("3020501", "网络异常，请稍后重试。"),
    MESSAGE_CODE_IS_WRONG("3020510","短信验证码错误"),
    PHONE_NUMBER_CANNOT_EMPTY("3020511","手机号不能为空"),
    MESSAGE_CODE_CANNOT_EMPTY("3020512","短信验证码不能为空"),
    PASSWORD_CANNOT_EMPTY("3020513","密码不能为空"),
    USER_PHONE_IS_NOT_EXIST("3020514","用户手机号不存在"),
    WE_CHAT_OPENID_NOT_NULL("3020515","微信用户OpenId不能为空"),
    CODE_IS_ERROR("3020516","短信验证码错误或验证码已失效"),
    OPEN_ID_FORMAT_ERROR("3020517","openId格式不正确,openId长度为28位"),
    UNION_ID_FORMAT_ERROR("3020518","unionId格式不正确,unionId长度为29位"),
    REGISTER_OR_BIDING_ERROR("3020518","注册并绑定异常，跨服务获取用户信息失败"),
    OPEN_ID_IS_NOT_NULL("3020519","openId不能为空"),
    SUBSCRIBE_TIME_NOT_NULL("3020520","关注时间不能为空"),
    IS_CONCERN_NOT_NULL("3020521","是否关注标志不能为空"),
    ;
    private String code;
    private String message;

    MiniProgramRegisterExceptionEnum(String code, String message) {
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
