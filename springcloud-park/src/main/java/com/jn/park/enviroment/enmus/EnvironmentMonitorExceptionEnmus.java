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
public enum EnvironmentMonitorExceptionEnmus implements CodeAndMsg {
    GET_ENVIRONMENT_INFO_FAIL("4023001", "获取环境监测数据失败"),
    ;
    private String code;

    private String message;

    EnvironmentMonitorExceptionEnmus(String key, String message) {
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
