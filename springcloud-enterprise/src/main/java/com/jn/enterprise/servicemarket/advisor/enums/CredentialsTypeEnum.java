package com.jn.enterprise.servicemarket.advisor.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 证件类型
 * @Author: yangph
 * @Date: 2019/2/27 11:35
 * @Version v1.0
 * @modified By:
 */
public enum CredentialsTypeEnum implements CodeAndMsg {
    LAWYER_LICENSE("lawyerLicense","律师执业证"),
    PROFESSIONAL_AGENT_LICENSE("professionalAgentLicense","专业代理人执业证"),
    CPA("cap","注册会计师"),
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    CredentialsTypeEnum(String code, String message) {
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
