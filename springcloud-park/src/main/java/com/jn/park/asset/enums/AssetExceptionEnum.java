package com.jn.park.asset.enums;

import com.jn.common.api.CodeAndMsg;


public enum  AssetExceptionEnum implements CodeAndMsg {

    TIME_NOT_AFTER_LEASE_TIME("4020501","时间不能小于最低租借时间");

    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    AssetExceptionEnum(String code, String message) {
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
