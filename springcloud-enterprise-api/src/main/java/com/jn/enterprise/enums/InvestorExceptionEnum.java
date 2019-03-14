package com.jn.enterprise.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 投资人异常枚举
 * @Author: yangph
 * @Date: 2019/02/14 10:02
 * @Version v1.0
 * @modified By:
 */
public enum InvestorExceptionEnum implements CodeAndMsg {
    NETWORK_ANOMALY("5020901", "网络异常，请稍后重试。"),
    INVESTOR_ACCOUNT_NOT_NULL("5020521","投资人账号不能为空"),
    INVESTOR_INFO_NOT_EXIST("5020522","当前投资人信息不存在"),
    ;

    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    InvestorExceptionEnum(String code, String message) {
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
