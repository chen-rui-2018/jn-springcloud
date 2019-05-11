package com.jn.user.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @Author: jiangyl
 * @Date: 2019/3/26 14:41
 * @Version v1.0
 * @modified By:
 */
public enum UserAddressExceptionEnum implements CodeAndMsg {
    NETWORK_ANOMALY("3020901", "网络异常，请稍后重试。"),
    USER_ADDRESS_IS_NOT_EXIST("3020501","无收货地址"),
    ADDRESS_IS_NOT_EXIST("3020502","收货地址不存在，请刷新页面重试"),
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    UserAddressExceptionEnum(String code, String message) {
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
