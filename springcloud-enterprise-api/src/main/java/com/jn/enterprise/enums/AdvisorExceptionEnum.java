package com.jn.enterprise.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 服务顾问异常枚举
 * @Author: yangph
 * @Date: 2019/02/14 10:02
 * @Version v1.0
 * @modified By:
 */
public enum AdvisorExceptionEnum implements CodeAndMsg {
    NETWORK_ANOMALY("5020901", "网络异常，请稍后重试。"),
    ADVISOR_INFO_NOT_EXIST("5020501","专员信息不存在"),
    ADVISOR_ACCOUNT_NOT_NULL("5020502","专员账号不能为空"),
    REGISTER_ACCOUNT("5020503","注册账号不能为空"),
    SERVICE_ORG_NOT_EXIST("5020504","当前账号信息在系统中不存在"),
    GET_ADVISOR_INFO_FAIL("5020505","获取专员信息失败"),
    APPROVAL_STATUS_NOT_EXIST("5020506","专员管理审批状态在系统中不存在"),
    APPROVAL_STATUS_NOT_NULL("5020507","专员管理审批状态不能为空"),
    ADVISOR_IS_EXIT("5020508","专员已经被邀请，请不要重复邀请!!!"),
    PENDING_ADVISOR_NOT_EXIT("5020509","当前专员在系统中不存在或状态非“待审批”"),
    APPROVAL_DESC_NOT_NULL("5020510","审批不通过，审批说明不能为空"),
    APPROVAL_STATUS_NOT_MATCH_SYSTEM("5020511","审批状态值与系统不符"),
    CREDENTIALS_TYPE_ENUM_NOT_EXIST("5020512","证件类型在系统中不存在"),
    HONOR_INFO_NOT_EXIST("5020513","当前荣誉资质信息在系统中已失效或已删除"),
    EXPERIENCE_INFO_NOT_EXIST("5020514","当前服务经历在系统中已失效或已删除"),
    PROJECT_EXPERIENCE_INFO_NOT_EXIST("5020515","当前项目经验在系统中已失效或已删除"),
    START_MORE_THEN_END("5020515","提交开始时间晚于提交结束时间"),
    ORG_INFO_NOT_NULL("5020516","机构id或机构名称不能为空"),
    TIME_CHANGE_ERROR("5020517","时间转换出错，请核对参数"),
    CERTIFICATE_TYPE_NOT_EXIST("5020518","系统中没有证书类型"),
    ORG_NAME_NOT_NULL("5020519","机构名称不能为空"),
    EVALUATION_ID_NOT_NULL("5020520","机构id,产品id,专员账号不能都为空"),
    BUSINESS_AREA_NOT_EXIT("5020521","业务领域在系统中不存"),
    ORG_ID_NOT_EXIT("5020522","机构id在系统中不存在"),
    ACCOUNT_NOT_ORG_MANAGE("5020523","当前登录用户账号不是机构管理员"),
    ACCOUNT_STATUS_NOT_REJECTED("5020524","再次邀请专员审批状态不是“已拒绝”，不能再次邀请"),
    ADVISOR_HAS_EXIST("5020525","当前用户是审批中或审批通过的机构专员，不允许编辑专员信息"),
    ADVISOR_HAS_INVITE("5020526","当请专员已被其他机构邀请"),
    ISSUING_AGENCY_LENGTH_TOO_LONG("5020527","荣誉资质颁发机构长度过长"),
    GET_TIME_FORMAT_ERROR("5020528","荣誉资质颁发时间格式不正确"),
    WORK_TIME_FORMAT_ERROR("5020529","服务经历工作开始时间格式错误"),
    WORK_END_TIME_FORMAT_ERROR("5020530","服务经历工作结束时间格式错误"),
    WORK_TIME_MORE_THAN_END_TIME("5020531","服务经历工作开始时间晚于结束时间"),
    CURRENT_ACCOUNT_NOT_ORG_GROUP("5020532","当前登录用户不是机构用户"),
    CURRENT_ACCOUNT_NOT_COMMENT_PERSON("5020533","当前用户非普通用户,不能被邀请"),
    ADVISOR_BASE_INFO_NOT_EXIST("5020534","前用户基本信息在系统中不存在，请添加专员基本信息"),
    ;

    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    AdvisorExceptionEnum(String code, String message) {
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
