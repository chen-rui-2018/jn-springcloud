package com.jn.enterprise.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 服务评价类型
 * @Author: yangph
 * @Date: 2019/2/15 17:33
 * @Version v1.0
 * @modified By:
 */
public enum  ServiceRatingTypeEnum implements CodeAndMsg {
    PRAISE("praise","好评"),
    AVERAGE("average","中评"),
    BAD_REVIEW("badReview","差评"),
    ;


    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    ServiceRatingTypeEnum(String code, String message) {
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
