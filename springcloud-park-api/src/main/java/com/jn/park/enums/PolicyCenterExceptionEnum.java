package com.jn.park.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @Author: yangph
 * @Date: 2019/3/27 15:11
 * @Version v1.0
 * @modified By:
 */
public enum PolicyCenterExceptionEnum implements CodeAndMsg {
    NETWORK_ANOMALY("4020901", "网络异常，请稍后重试。"),
    POLICY_LEVEL_NOT_EXIST("4020501", "系统中没有政策级别数据"),
    POLICY_CLASS_NOT_EXIST("4020502", "系统中没有政策分类数据"),
    POLICY_TYPE_NOT_NULL("4020503","政策类型不能为空"),
    POLICY_ID_NOT_NULL("4020504","政策id不能为空"),
    POLICY_DETAILS_NOT_EXIST("4020505","政策在系统中不存在或当前政策类型不是普通政策"),
    POLICY_DIAGRAM_DETAILS_NOT_EXIST("4020506","政策在系统中不存在或当前政策类型不是图解政策"),
    TABLE_TYPE_IS_NOT_EXIST("4020507","table类型在系统中不存在"),
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    PolicyCenterExceptionEnum(String code, String message) {
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
