package com.jn.enums;

import com.jn.config.CodeAndMsg;

/**
 * 网关异常控制
 *
 * @author： fengxh
 * @date： Created on 2018/11/26 15:32
 * @version： v1.0
 * @modified By:
 */
public enum ZuulExceptionEnum implements CodeAndMsg {

    COMMON_EXCEPTION("0000001","服务暂时不可用，请稍等再尝试"),

    TIME_OUT_EXCEPTION("0000002","服务已提交，但由于网络原因，请确认最终情况");

    private String code;

    private String message;

    ZuulExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }


    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }


}
