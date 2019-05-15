package com.jn.park.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 客服中心异常枚举
 * @Author: yangph
 * @Date: 2019/5/14 9:39
 * @Version v1.0
 * @modified By:
 */
public enum CustomerCenterExceptionEnum implements CodeAndMsg {
    NETWORK_ANOMALY("4020901", "网络异常，请稍后重试。"),
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    CustomerCenterExceptionEnum(String code, String message) {
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
