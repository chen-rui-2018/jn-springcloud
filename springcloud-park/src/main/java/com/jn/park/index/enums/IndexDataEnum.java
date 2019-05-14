package com.jn.park.index.enums;

import com.jn.common.api.CodeAndMsg;

public enum IndexDataEnum implements CodeAndMsg {

    // 服务搜索-政策服务-政策类型
    ALL_POLICY("0","allPolicy"),
    DIAGRAM_POLICY("1","diagramPolicy"),
    FIRST_TOPIC("2","firstTopic"),
    PRIVATE_TOPIC("3","privateTopic"),

    // 服务搜索
    SERVICE_TYPE_ACTIVITY("0","活动"),
    SERVICE_TYPE_POLICY("1","政策服务"),
    SERVICE_TYPE_BUSINESS("2","商务服务"),

    IMPORTANT_NEWS_STATUS_VALID("1", "有效"),
    IMPORTANT_NEWS_PLATFORM_TYPE_ALL("0", "全部"),
    IMPORTANT_NEWS_PLATFORM_TYPE_APP("1", "APP"),
    IMPORTANT_NEWS_PLATFORM_TYPE_PC("2", "门户"),
    ;

    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    IndexDataEnum(String code, String message) {
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
