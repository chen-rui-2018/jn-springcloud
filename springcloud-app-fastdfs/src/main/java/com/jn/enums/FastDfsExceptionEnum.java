package com.jn.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 文件服务器异常
 *
 * @author： fengxh
 * @date： Created on 2018/12/6 15:28
 * @version： v1.0
 * @modified By:
 */
public enum FastDfsExceptionEnum implements CodeAndMsg {

    FAST_DFS_NOT_SUPPORT("1200101", "解析文件路径错误");

    private String code;
    private String message;

    FastDfsExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
