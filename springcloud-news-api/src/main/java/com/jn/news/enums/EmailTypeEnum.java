package com.jn.news.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 邮件类型枚举
 *
 * @author： chenm
 * @date： Created on 2018/11/17 11:17
 * @version： v1.0
 * @modified By:
 */
public enum EmailTypeEnum implements CodeAndMsg{

    /**
     * 发送普通邮件（支持包括有附件、内嵌图片）
     */
    EMAIL_COMMON_TYPE("1","普通邮件"),
    /**
     * 发送模板邮件
     */
    EMAIL_TEMPLATE_TYPE("1","模板邮件");

    private String code;
    private String message;

    EmailTypeEnum(String code, String message) {
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
