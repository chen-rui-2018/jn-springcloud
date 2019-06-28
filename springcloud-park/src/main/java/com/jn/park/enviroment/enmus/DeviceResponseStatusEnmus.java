package com.jn.park.enviroment.enmus;

import com.jn.common.api.CodeAndMsg;

/**
 * 环境监测异常枚举
 *
 * @author： shaobao
 * @date： Created on 2019/2/28 10:03
 * @version： v1.0
 * @modified By:
 **/
public enum DeviceResponseStatusEnmus implements CodeAndMsg {
    SUCCESS("true", "响应成功"),
    FAIL("false","响应失败"),
    ;
    private String code;

    private String message;

    DeviceResponseStatusEnmus(String key, String message) {
        this.code = key;
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
