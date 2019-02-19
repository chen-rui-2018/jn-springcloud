package com.jn.enterprise.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 服务顾问异常枚举
 * @Author: yangph
 * @Date: 2019/02/14 10:02
 * @Version v1.0
 * @modified By:
 */
public enum AdvisorExceptionEnum implements CodeAndMsg {
    NETWORK_ANOMALY("5020901", "网络异常，请稍后重试。"),
    ADVISOR_INFO_NOT_EXIST("5020501","顾问信息不存在"),
    ADVISOR_ACCOUNT_NOT_NULL("5020502","顾问账号不能为空"),
    REGISTER_ACCOUNT("5020503","注册账号不能为空"),
    ;

    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    AdvisorExceptionEnum(String code, String message) {
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
