package com.jn.park.electricmeter.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @author： yangh
 * @date： Created on 2019/5/17 16:08
 * @version： v1.0
 * @modified By:
 */

public enum MeterExceptionEnums implements CodeAndMsg {
    COLLECTION_DATA_DEAL_FAIL("4010201","采集数据处理失败"),
    COLLECTION_DATA_DEAL_SUCCESS("4010202","采集数据处理成功"),
    COLLECTION_DATA_ISNOT_EXIST("4010203","采集数据不存在"),
    FAIL_LOG_ISNOT_EXIST("4010204","错误日志不存在"),
    NOTICE_TIME_PARSE_DEFAULT("4010205","日期解析错误")
            ;


    private String  code;
    private String message;

    MeterExceptionEnums(String code,String message){
        this.code = code;
        this.message = message;
    }
    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
