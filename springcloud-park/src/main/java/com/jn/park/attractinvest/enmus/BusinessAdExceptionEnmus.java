package com.jn.park.attractinvest.enmus;

import com.jn.common.api.CodeAndMsg;

/**
 * @author： shaobao
 * @date： Created on 2019/2/28 10:03
 * @version： v1.0
 * @modified By:
 **/
public enum BusinessAdExceptionEnmus implements CodeAndMsg {
    BUSSINESS_AD_NOT_EXIST("4021501", "您查询的信息已下架或已删除"),
    ;
    private String code;

    private String message;

    BusinessAdExceptionEnmus(String key, String message) {
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
