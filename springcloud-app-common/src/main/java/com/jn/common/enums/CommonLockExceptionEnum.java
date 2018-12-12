package com.jn.common.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * LOCK异常
 *
 * @author： fengxh
 * @date： Created on 2018/11/23 17:03
 * @version： v1.0
 * @modified By:
 */
public enum CommonLockExceptionEnum implements CodeAndMsg {

    LOCK_INTO_ERROR("1000701","锁的方法体注入失败"),
    LOCK_FAIL("1000702","获取锁失败");
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;
    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    CommonLockExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
