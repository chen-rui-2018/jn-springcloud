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
    ADVISOR_INFO_NOT_EXIST("5020501","顾问信息不存在"),
    ADVISOR_ACCOUNT_NOT_NULL("5020502","顾问账号不能为空"),
    REGISTER_ACCOUNT("5020503","注册账号不能为空"),
    SERVICE_ORG_NOT_EXIST("5020504","当前账号信息在系统中不存在"),
    GET_ADVISOR_INFO_FAIL("5020505","获取顾问信息失败"),
    APPROVAL_STATUS_NOT_EXIST("5020506","顾问管理审批状态在系统中不存在"),
    APPROVAL_STATUS_NOT_NULL("5020507","顾问管理审批状态不能为空"),
    ADVISOR_IS_EXIT("5020508","顾问已经被邀请，请不要重复邀请!!!"),
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
