package com.jn.enterprise.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 需求管理异常枚举
 * @author： yangph
 * @date： Created on 2019/3/04 11:38
 * @version： v1.0
 * @modified By:
 */
public enum RequireExceptionEnum implements CodeAndMsg {
    NETWORK_ANOMALY("5020901", "网络异常，请稍后重试。"),
    PRODUCT_ID_NOT_EXIST("5020531","当前产品在系统中不存在或产品已失效"),
    ORG_ID_NOT_EXIST("5020532","当前产品所对应机构在系统中不存在或产品已失效"),
    REQUIRE_NUM_NOT_NULL("5020533","需求单号不能为空"),
    REQUIRE_INFO_NOT_EXIST("5020534","当前需求在系统中不存在或已失效"),
    REQUIRE_REPEATED_SUBMIT("5020535","系统已存在当前需求，请勿重复提需求"),
    START_MORE_THEN_END("5020536","提交开始时间晚于提交结束时间"),
    DATA_NOT_ALLOW_OPERATING("5020537","当前需求编号对应数据不允许对接操作"),
    IS_NOT_TECHNOLOGY_NOT_MATCH("5020538","当前需求的为非科技金融类型，与传递的是科技金融不匹配"),
    IS_TECHNOLOGY_NOT_MATCH("5020539","当前需求的为科技金融类型，与传递的是非科技金融不匹配"),
    FINANCING_PERIOD("5020540","融资期限不能为空"),
    ;

    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    RequireExceptionEnum(String code, String message) {
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
