package com.jn.activity.enums;

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
    ACTIVITY_ID_CANNOT_EMPTY("11110201","活动id不能为空"),
    ACTIVITY_NOT_EXIST("11110202","活动未发布在或已被删除"),
    ACTIVITY_CANNOT_EMPTY("11110203","活动报名截止时间不能为空"),
    ACTIVITY_CUTOFF("11110501","报名已截止，不能报名或取消报名"),
    ACTIVITY_TYPE_NAME_EMPTY("11110201","活动类型名称不能为空"),
    ACTIVITY_TYPE_STATUS_EMPTY("11110201","活动类型状态不能为空"),
    ACTIVITY_TYPE_NAME_REPEAT("1111201","活动类型名称不能重复")
    ;

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
