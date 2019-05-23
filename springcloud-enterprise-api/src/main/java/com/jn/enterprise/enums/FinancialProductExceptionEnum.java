package com.jn.enterprise.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 金融产品异常
 * @Author: yangph
 * @Date: 2019/3/19 16:13
 * @Version v1.0
 * @modified By:
 */
public enum FinancialProductExceptionEnum implements CodeAndMsg {
    NETWORK_ANOMALY("5020901", "网络异常，请稍后重试。"),
    PRODUCT_ID_NOT_NULL("5020501","产品id不能为空"),
    PRODUCT_NOT_EXIST("5020502","当前产品在系统中不存在"),
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    FinancialProductExceptionEnum(String code, String message) {
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
