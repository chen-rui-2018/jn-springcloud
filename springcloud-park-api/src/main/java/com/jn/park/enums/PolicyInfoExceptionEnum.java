package com.jn.park.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @Author: yangph
 * @Date: 2019/3/27 15:11
 * @Version v1.0
 * @modified By:
 */
public enum PolicyInfoExceptionEnum implements CodeAndMsg {
    NETWORK_ANOMALY("4020901", "网络异常，请稍后重试。"),
    POLICY_LEVEL_NOT_EXIST("4020501", "系统中没有政策级别数据"),
    POLICY_CLASS_NOT_EXIST("4020502", "系统中没有政策分类数据"),
    POLICY_TYPE_NOT_NULL("4020503","政策类型不能为空"),
    POLICY_ID_NOT_NULL("4020504","政策id不能为空"),
    POLICY_DETAILS_NOT_EXIST("4020505","政策在系统中不存在或当前政策类型不是普通政策"),
    POLICY_DIAGRAM_DETAILS_NOT_EXIST("4020506","政策在系统中不存在或当前政策类型不是图解政策"),
    TABLE_TYPE_IS_NOT_EXIST("4020507","table类型在系统中不存在"),
    POLICY_INFO_LEVEL_NOT_EXIST("4020508","当前政策级别编码或政策级别名称在系统中不存在"),
    POLICY_INFO_CLASS_NOT_EXIST("4020509","当前政策分类编码或政策分类名称在系统中不存在"),
    POLICY_DIAGRAM_ID_NOT_NULL("4020510","有关联政策图解，政策图解id不能为空"),
    POLICY_DIAGRAM_ID_MUST_NULL("4020511","没有关联政策图解，政策图解id必须为空"),
    POLICY_ID_NOT_EXIST("4020512","当前政策id在系统中不存在"),
    POLICY_DIAGRAM_ID_NOT_EXIST("4020513","有关联政策图解，政策图解id在系统中不存在"),
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    PolicyInfoExceptionEnum(String code, String message) {
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
