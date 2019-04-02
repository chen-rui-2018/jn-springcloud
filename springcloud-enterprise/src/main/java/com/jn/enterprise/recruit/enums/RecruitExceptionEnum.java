package com.jn.enterprise.recruit.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @Author: huxw
 * @Date: 2019-4-1 11:06:16
 * @Version v1.0
 * @modified By:
 */
public enum RecruitExceptionEnum implements CodeAndMsg {
    RECRUIT_COMPANY_ID_IS_NULL("5011201","企业ID不能为空"),
    RECRUIT_COMPANY_IS_NOT_EXIST("5011202","查询的企业不存在"),
    RECRUIT_USER_NOT_ENTERPRISE_ADMIN("5011203","该用户不是本次查询企业的管理员"),
    RECRUIT_INFO_IS_NOT_EXIST("5011204","招聘信息不存在"),
    RECRUIT_ID_IS_NULL("5011205","招聘信息ID不能为空"),
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    RecruitExceptionEnum(String code, String message) {
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
