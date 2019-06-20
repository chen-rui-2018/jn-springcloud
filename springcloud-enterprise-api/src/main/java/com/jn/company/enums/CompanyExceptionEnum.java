package com.jn.company.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 企业服务异常枚举
 * @Author: yangph
 * @Date: 2019/02/14 10:02
 * @Version v1.0
 * @modified By:
 */
public enum CompanyExceptionEnum implements CodeAndMsg {
    NETWORK_ANOMALY("5020901", "网络异常，请稍后重试。"),
    COMPANY_INFO_NOT_EXIST("5020501","企业信息不存在"),
    COMPANY_ID_INFO_NOT_NULL("5020502","企业ID或用户账号不能为空"),
    USER_LOGIN_IS_INVALID("5020503","登录已失效，请重新登录"),

    ;

    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    CompanyExceptionEnum(String code, String message) {
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
