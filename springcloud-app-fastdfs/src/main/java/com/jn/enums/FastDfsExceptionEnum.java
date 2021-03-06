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

    FAST_DFS_NOT_SUPPORT("1200101", "解析文件路径错误"),
    FAST_DFS_NOT_FILE("1200102", "文件无权限或不存在"),
    CALL_SERVICE_ERROR("1200103", "调用内部服务出现未知错误");

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
