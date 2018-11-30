package com.jn.common.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 缓存异常
 *
 * @author： fengxh
 * @date： Created on 2018/11/23 17:03
 * @version： v1.0
 * @modified By:
 */
public enum CommonCacheExceptionEnum implements CodeAndMsg {


    CACHE_GET("1000601","获取缓存失败"),
    CACHE_PUT("1000602","保存缓存失败"),
    CACHE_DELETE("1000603","保存删除失败");
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

    CommonCacheExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
