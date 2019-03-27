package com.jn.park.policy.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 政策中心table页类型
 * @Author: yangph
 * @Date: 2019/3/27 20:38
 * @Version v1.0
 * @modified By:
 */
public enum PolicyTableTypeEnum implements CodeAndMsg {
    ALL_POLICY("allPolicy","政策一览"),
    DIAGRAM_POLICY("diagramPolicy","图解政策"),
    FIRST_TOPIC("firstTopic","一号专题"),
    PRIVATE_TOPIC("privateTopic","民营专题")
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    PolicyTableTypeEnum(String code, String message) {
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
