package com.jn.enterprise.common.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 公共异常枚举
 * @Author: huxw
 * @Date: 2019-4-3 15:19:28
 * @Version v1.0
 * @modified By:
 */
public enum CommonExceptionEnum implements CodeAndMsg {

    CODE_GROUP_ID_IS_NULL("5000201","分组ID不能为空"),
    UPGRADE_COMMON("5000202","角色认证公共返回"),
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    CommonExceptionEnum(String code, String message) {
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
