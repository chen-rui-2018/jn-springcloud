package com.jn.enums;

/**
 * 过滤类型枚举
 *
 * @author： fengxh
 * @date： Created on 2018/9/19 15:58
 * @version： v1.0
 * @modified By:
 */
public enum FilterTypeEnum {
    /**
     * 预路由过滤
     */
    PRE("pre"),
    /**
     * 路由到原点
     */
    ROUTE("route"),
    /**
     *后路由过滤
     */
    POST("post"),
    /**
     * 错误处理
     */
    ERROR("error");

    private String  code;


    public String getCode() {
        return code;
    }

    FilterTypeEnum(String code) {
        this.code = code;
    }



}
