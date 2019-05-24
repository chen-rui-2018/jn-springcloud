package com.jn.park.customer.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 操作状态枚举
 * @Author: yangph
 * @Date: 2019/5/18 15:33
 * @Version v1.0
 * @modified By:
 */
public enum IBPSOptionsStatusEnum implements CodeAndMsg {
    SUBMIT("submit","提交"),
    AGREE("agree","同意"),
    OPPOSE("oppose","反对"),
    PENDING("pending","待处理"),
    REJECT_TO_PREVIOUS("rejectToPrevious","驳回"),
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    IBPSOptionsStatusEnum(String code, String message) {
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
