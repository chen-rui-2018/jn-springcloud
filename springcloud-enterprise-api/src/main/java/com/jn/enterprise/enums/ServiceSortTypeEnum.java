package com.jn.enterprise.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 服务排序类型枚举
 * @Author: yangph
 * @Date: 2019/2/14 10:19
 * @Version v1.0
 * @modified By:
 */
public enum ServiceSortTypeEnum implements CodeAndMsg {
    INTEGRATE("integrate","综合排序"),
    POPULARITY("popularity","人气排序"),
    PRAISE("praise","好评排序"),
    SERVICE_NUM("serviceNum","服务量排序"),
    ;

    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    ServiceSortTypeEnum(String code, String message) {
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
