package com.jn.park.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @Author: yangph
 * @Date: 2018/12/11 15:14
 * @Version v1.0
 * @modified By:
 */
public enum CommentExceptionEnum  implements CodeAndMsg {
    NETWORK_ANOMALY("11110301", "网络异常，请稍后重试。"),
    SENSITIVE_WORDS_IN_COMMENT("11110501","评论中有敏感词，请修改后重新提交")
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    CommentExceptionEnum(String code, String message) {
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
