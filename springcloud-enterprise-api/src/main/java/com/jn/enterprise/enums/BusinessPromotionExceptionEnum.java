package com.jn.enterprise.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 企业宣传异常枚举
 * @Author: yangph
 * @Date: 2019/02/14 10:02
 * @Version v1.0
 * @modified By:
 */
public enum BusinessPromotionExceptionEnum implements CodeAndMsg {
    NETWORK_ANOMALY("5020901", "网络异常，请稍后重试。"),
    EFFECTIVE_MORE_THAN_INVALID("5020541","生效日期不能晚于失效日期"),
    PROMOTION_AREA_ERROR("5020542","宣传区域的值与系统中的值不匹配"),
    PROMOTION_FEE_RULES_NOT_EXIST("5020543","系统中不存在宣传费用规则"),
    PROMOTION_FEE_RULES_ERROR("5020544","当前宣传费用规则编码在系统中不存在"),
    PROPAGANDA_TYPE_NOT_EXIT("5020545","系统中不存在宣传类型"),
    ;

    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    BusinessPromotionExceptionEnum(String code, String message) {
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
