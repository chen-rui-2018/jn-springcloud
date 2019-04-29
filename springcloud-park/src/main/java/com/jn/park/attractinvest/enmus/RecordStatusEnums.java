package com.jn.park.attractinvest.enmus;

import com.jn.common.api.CodeAndMsg;

/**
 * 展示状态枚举
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum RecordStatusEnums implements CodeAndMsg {
    DISPLAY("1", "展示中"),
    STOP_DISPLAY("0", "已下架");

    private String code;

    private String message;

    RecordStatusEnums(String key, String message) {
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
