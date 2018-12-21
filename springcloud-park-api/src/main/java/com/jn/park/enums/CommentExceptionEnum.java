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
    SENSITIVE_WORDS_IN_COMMENT("11110501","评论中有敏感词，请修改后重新提交"),
    APPLY_P_ID_NOT_NULL("11110201","活动/点评id不能为空"),
    APPLY_CONTENT_NOT_EMPTY("11110202","评论内容不能为空"),
    APPLY_ROOT_ID_NOT_NULL("11110203","活动id/服务id不能为空")
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
