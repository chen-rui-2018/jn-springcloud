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
