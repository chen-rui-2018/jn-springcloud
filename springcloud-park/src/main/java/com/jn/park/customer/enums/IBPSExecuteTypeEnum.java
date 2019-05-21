package com.jn.park.customer.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 我的事项类型枚举
 * @Author: yangph
 * @Date: 2019/5/20 21:39
 * @Version v1.0
 * @modified By:
 */
public enum IBPSExecuteTypeEnum implements CodeAndMsg {
    TASKS("task","待办事项"),
    HANDLED("handled","已办事项"),
   ;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    IBPSExecuteTypeEnum(String code, String message) {
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
