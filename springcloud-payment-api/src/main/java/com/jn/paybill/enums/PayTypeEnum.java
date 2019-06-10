package com.jn.paybill.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 统一支付类型枚举值
 * @Author: jiangyl
 * @Date: 2019/2/15 17:33
 * @Version v1.0
 * @modified By:
 */
public enum PayTypeEnum implements CodeAndMsg {
    PAYMENT_ORDER_TYPE_PARKING_FEE("parking_fee","临时停车费用"),
    PAYMENT_ORDER_TYPE_PARKING_MONTH("parking_month","车位月卡费用"),
    PAYMENT_ORDER_TYPE_AD_FREE("ad_free","宣传费"),

    ;


    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    PayTypeEnum(String code, String message) {
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
