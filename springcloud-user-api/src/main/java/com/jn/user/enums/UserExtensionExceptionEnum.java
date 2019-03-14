package com.jn.user.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @Author: yangph
 * @Date: 2019/2/26 14:41
 * @Version v1.0
 * @modified By:
 */
public enum UserExtensionExceptionEnum implements CodeAndMsg {
    NETWORK_ANOMALY("3020901", "网络异常，请稍后重试。"),
    USER_ACCOUNT_NOT_NULL("3020501","用户账号不能为空"),
    AFFILIATE_PARAM_NOT_NULL("3020502","所属机构编码不能为空"),
    COMPANY_PARAM_NOT_NULL("3020503","所属企业编码不能为空"),
    USER_EXTENSION_NOT_EXISTS("3020504","当前账号对应用户信息不存在"),
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    UserExtensionExceptionEnum(String code, String message) {
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
