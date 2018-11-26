package com.jn.common.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 断言异常枚举
 *
 * @author： fengxh
 * @date： Created on 2018/11/23 17:03
 * @version： v1.0
 * @modified By:
 */
public enum CommonAssertExceptionEnum implements CodeAndMsg {


    ASSERT_STATE("1000501","状态必须为TRUE"),
    ASSERT_NULL("1000502","数据必须为空"),
    ASSERT_NOT_NULL("1000503","数据必须不为空"),
    ASSERT_HAS_LENGTH("1000504","字符串不能为null、empty"),
    ASSERT_HAS_TEXT("1000505","字符串不能为null、empty、blank"),
    ASSERT_NOT_CONTAINS_DATA("1000506","不能与规定的字符串相同:"),
    ASSERT_ARRAY_NOT_EMPTY("1000506","数组最小要有1个值"),
    ASSERT_ARRAY_NOT_ANY_EMPTY("1000506","数组里面不能有null值"),
    ASSERT_COLLECTION_NOT_EMPTY("1000506","集合最小要有1个值"),
    ASSERT_MAP_NOT_EMPTY("1000506","MAP最小要有1个值"),
    ASSERT_INSTANCE("1000506","class类必须instance:");

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

    @Override
    public String getMessage() {
        return message;
    }

    CommonAssertExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
