package com.jn.enterprise.propaganda.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 是否支付枚举
 * @Author: yangph
 * @Date: 2019/5/27 16:14
 * @Version v1.0
 * @modified By:
 */
public enum IsPayEnum  implements CodeAndMsg {
    NOT_PAID("0","未支付"),
    HAVE_PAID("1","已支付"),
    ;

    IsPayEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

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
