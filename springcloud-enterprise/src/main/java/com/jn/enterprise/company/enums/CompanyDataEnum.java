package com.jn.enterprise.company.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 企业服务数据类型枚举
 * @Author: huxw
 * @Date: 2019-4-9 11:22:18
 * @Version v1.0
 * @modified By:
 */
public enum CompanyDataEnum implements CodeAndMsg {

    // 数据状态
    RECORD_STATUS_VALID("1","有效"),
    RECORD_STATUS_NOT_VALID("0","无效"),

    // 企业-审核状态
    COMPANY_CHECK_STATUS_NOT_PASS("-1","审核未通过"),
    COMPANY_CHECK_STATUS_PASS("1","审核通过"),
    COMPANY_CHECK_STATUS_WAIT("0","审核中"),

    // 机构-审核状态
    ORG_APPROVAL_STATUS("1","审核通过"),

    // 服务专员-审核状态
    ADVISOR_APPROVAL_STATUS("2","审核通过"),

    // 企业人员-邀请状态
    STAFF_INVITE_STATUS_SEND("5","已邀请"),
    STAFF_INVITE_STATUS_AGREE("6","已同意"),
    STAFF_INVITE_STATUS_REFUSE("7","已拒绝"),

    // 企业人员-审核状态
    STAFF_CHECK_STATUS_WAIT("0","未审核"),
    STAFF_CHECK_STATUS_PASS("1","通过审核"),
    STAFF_CHECK_STATUS_NOT_PASS("-1","未通过审核"),

    // 企业角色
    COMPANY_ADMIN("企业管理员","企业管理员"),
    COMPANY_CONTACTS("企业联系人","企业联系人"),
    COMPANY_STAFF("企业员工","企业员工"),

    // 企业员工加入方式
    COMPANY_STAFF_JOIN_PATTERN_INVITE("1","企业邀请"),
    COMPANY_STAFF_JOIN_PATTERN_UPGRADE("0","升级员工"),
    ;

    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    CompanyDataEnum(String code, String message) {
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
