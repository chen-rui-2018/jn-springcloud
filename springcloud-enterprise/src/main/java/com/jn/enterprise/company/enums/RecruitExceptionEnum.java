package com.jn.enterprise.company.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @Author: huxw
 * @Date: 2019-4-1 11:06:16
 * @Version v1.0
 * @modified By:
 */
public enum RecruitExceptionEnum implements CodeAndMsg {
    RECRUIT_COMPANY_ID_IS_NULL("5011201","企业ID不能为空"),
    RECRUIT_NO_IS_NULL("5011202","招聘编号不能为空"),
    RECRUIT_USER_NOT_ENTERPRISE_ADMIN("5011203","该用户不是本次查询企业的管理员"),
    RECRUIT_INFO_IS_NOT_EXIST("5011204","招聘信息不存在"),
    RECRUIT_ID_IS_NULL("5011205","招聘信息ID不能为空"),
    RECRUIT_COMPANY_IS_NOT_EXIST("5011206","查询的企业不存在"),
    RECRUIT_STATUS_IS_NULL("5011207","招聘状态不能为空"),
    RECRUIT_USER_NOT_COMPANY_USER("5011208","该用户不是企业用户"),

    RECRUIT_WHERE_TYPE_ERROR("5011220","查询字段传值错误"),
    RECRUIT_SORT_TYPE_ERROR("5011221","排序字段传值错误"),
    RECRUIT_STATUS_ERROR("5011222","招聘信息状态传值错误"),
    RECRUIT_SEARCH_DATE_FORMAT_ERROR("5011223","发布日期格式错误"),
    RECRUIT_PUBLISH_IBPS_ERROR("5011224","企业招聘提交审核出错，请检查提交数据"),
    RECRUIT_APPROVAL_STATUS_NOT_PASS("5011225","招聘信息未通过审核或正在审批中"),

    CALL_SERVICE_ERROR("5011299","调用其他内部服务错误"),
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
