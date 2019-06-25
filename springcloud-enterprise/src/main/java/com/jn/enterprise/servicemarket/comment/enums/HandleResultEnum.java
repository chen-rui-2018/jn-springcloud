package com.jn.enterprise.servicemarket.comment.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 需求对接结果枚举
 * @Author: yangph
 * @Date: 2019/6/21 15:02
 * @Version v1.0
 * @modified By:
 */
public enum HandleResultEnum implements CodeAndMsg {
    //对接结果(1:对接成功  2:对接失败  3:企业需求撤销 4:未对接)
    DOCKING_SUCCESS("1","对接成功"),
    DOCKING_FAILURE("2","对接失败"),
    COMPANY_REQUIRE_DEMAND("3","企业需求撤销"),
    NOT_DOCKED("4","未对接"),
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    HandleResultEnum(String code, String message) {
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
