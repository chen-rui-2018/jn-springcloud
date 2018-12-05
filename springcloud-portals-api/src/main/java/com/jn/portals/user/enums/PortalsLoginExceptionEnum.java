package com.jn.portals.user.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 登录异常枚举
 *
 * @Author: yangph
 * @Date: 2018/11/28 19:02
 * @Version v1.0
 * @modified By:
 */
public enum PortalsLoginExceptionEnum implements CodeAndMsg {
    NETWORK_ANOMALY("11100301", "网络异常，请稍后重试。"),
    NO_USER_EXTENSION("11100501", "用户扩展信息没有或已失效"),
    ACCOUNT_CANNOT_EMPTY("11100502", "用户账号不能为空"),
    LOGIN_TYPE_CANNOT_EMPTY("11100503", "登录模式不能为空"),
    LOGIN_TYPE_CANNOT_SUPPORT("11100504", "当前登录模式系统不支持"),
    SIDE_VALIDATION_MSG("11100505", "滑动校验不通过"),
    SIDE_VALTIDATION_PARAM_ERROR("11110201", "滑动验证参数错误"),
    PHONE_SMSCODE_CANNOT_EMPTY("11110202", "手机号或短信验证码不能为空"),
    PHONE_ISERROR("11110203", "手机号码不正确"),
    SMS_CODE_ISERROR("11110204", "验证码不正确或已失效");

    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    PortalsLoginExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

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
}
