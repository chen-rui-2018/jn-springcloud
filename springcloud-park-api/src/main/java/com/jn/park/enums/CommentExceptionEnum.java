package com.jn.park.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @Author: yangph
 * @Date: 2018/12/11 15:14
 * @Version v1.0
 * @modified By:
 */
public enum CommentExceptionEnum  implements CodeAndMsg {
    NETWORK_ANOMALY("4020901", "网络异常，请稍后重试。"),
    SENSITIVE_WORDS_IN_COMMENT("4020513","评论中有敏感词，请修改后重新提交"),
    APPLY_P_ID_NOT_NULL("4020239","活动/点评id不能为空"),
    APPLY_CONTENT_NOT_EMPTY("4020240","评论内容不能为空"),
    APPLY_ROOT_ID_NOT_NULL("4020241","活动id/服务id不能为空"),
    CURRENT_ACCOUNT_HAVE_LIKE("4020242","当前用户已点赞，请勿重复操作"),
    CURRENT_ACCOUNT_HAVE_CANCEL_LIKE("4020243","当前用户已取消点赞，请勿重复操作"),
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
