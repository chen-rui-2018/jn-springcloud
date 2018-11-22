package com.jn.system.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 返回成功或失败字符串
 *
 * @author： yuanyy
 * @date： Created on 2018/11/22 14:55
 * @version： v1.0
 * @modified By:
 */
public enum SysReturnMessageEnum implements CodeAndMsg {
    //成功
    SUCCESS("1", "success"),
    //失败
    FAIL("0","fail");

    private String code;

    private String message;

    SysReturnMessageEnum(String key, String message) {
        this.code = key;
        this.message = message;
    }
    /**
     * 获取code
     *
     * @return
     */
    @Override
    public String getCode() {
        return code;
    }

    /**
     * 获取信息
     *
     * @return
     */
    @Override
    public String getMessage() {
        return message;
    }
}
