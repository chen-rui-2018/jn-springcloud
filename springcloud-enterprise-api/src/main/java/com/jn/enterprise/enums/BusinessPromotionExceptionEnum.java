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
    PROPAGANDA_TYPE_NOT_EXIST("5020545","系统中不存在宣传类型"),
    ACCOUNT_CAN_NOT_ALLOW_PROPAGANDA("5020546","当前用户没有企业宣传相关权限"),
    CURRENT_PROPAGANDA_TYPE_NOT_EXIST("5020547","当前宣传类型在系统中不存在"),
    CURRENT_PROPAGANDA_TYPE_IS_EXIST("5020548","当前宣传类型在系统中已存在，系统中最多允许一个有效的当前宣传分类"),
    PROPAGANDA_INFO_NOT_EXIST("5020548","系统中不存在当前宣传信息或信息不允许当前操作"),
    PROPAGANDA_ID_NOT_NULL("5020549","宣传id不能为空"),
    UPDATE_NOT_ALLOWED("5020550","当前宣传信息审批状态不允许修改"),
    STATUS_NOT_SUPPORT("5020551","当前状态值不是系统支持的"),
    ORDER_NUM_NOT_NULL("5020552","订单号不能为空"),
    SUBMIT_AUDIT_NOT_ALLOW("5020553","当前宣传信息不存在或不允许当前操作"),
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
