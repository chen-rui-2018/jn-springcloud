package com.jn.enterprise.propaganda.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 宣传区域枚举
 * @Author: yangph
 * @Date: 2019/4/18 17:21
 * @Version v1.0
 * @modified By:
 */
public enum PromotionAreaEnum implements CodeAndMsg {
    AREA_TOP("top","顶部"),
    AREA_CENTRAL("central","中部"),
    AREA_BOTTOM("bottom","底部"),
    ;

    PromotionAreaEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

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
