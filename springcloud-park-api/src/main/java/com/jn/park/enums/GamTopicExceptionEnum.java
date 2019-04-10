package com.jn.park.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @Author: jiangyl
 * @Date: 2019/03/27 15:14
 * @Version v1.0
 * @modified By:
 */
public enum GamTopicExceptionEnum implements CodeAndMsg {
    NETWORK_ANOMALY("4020901", "网络异常，请稍后重试。"),
    USER_GAM_TOPIC_IS_NOT_EXIST("4020501","话题数据不存在"),
    GAM_TOPIC_IS_NOT_NOW_USER("4020502","不能删除非本人话题"),
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    GamTopicExceptionEnum(String code, String message) {
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
