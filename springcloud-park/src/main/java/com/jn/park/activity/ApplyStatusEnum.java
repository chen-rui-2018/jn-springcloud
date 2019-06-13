package com.jn.park.activity;

import com.jn.common.api.CodeAndMsg;

/**
 * @Author: yangph
 * @Date: 2019/6/13 10:07
 * @Version v1.0
 * @modified By:
 */
public enum ApplyStatusEnum implements CodeAndMsg {
    //(0:取消报名1:报名成功2:报名待审核)
    CANCEL_APPLY("cancelApply","0","取消报名"),
    APPLY_SUCCESS("applySuccess","1","报名成功"),
    APPLY_PENDING("applyPending","2","报名待审核"),
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 状态值
     */
    private String value;
    /**
     * 信息
     */
    private String message;


    ApplyStatusEnum(String code, String value, String message) {
        this.code = code;
        this.value = value;
        this.message = message;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
