package com.jn.portals.activity.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 登录异常枚举
 *
 * @Author: yangph
 * @Date: 2018/11/28 19:02
 * @Version v1.0
 * @modified By:
 */
public enum ActivityExceptionEnum implements CodeAndMsg {
    NETWORK_ANOMALY("11110301", "网络异常，请稍后重试。"),
    ACTIVITY_ID_CANNOT_EMPTY("11110201","活动id不能为空");

    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    ActivityExceptionEnum(String code, String message) {
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
