package com.jn.enterprise.usercenterindex.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 需求管理异常枚举
 * @author： yangph
 * @date： Created on 2019/3/04 11:38
 * @version： v1.0
 * @modified By:
 */
public enum UserCenterExceptionEnum implements CodeAndMsg {
    NETWORK_ANOMALY("5020901", "网络异常，请稍后重试。"),
    ENTERPRISE_USER_NOT_LOOK("5020531","企业用户不能查看企业邀请消息"),
    IS_ENTERPRISE_OR_ORGANIZATION_USER_NOT_LOOK("5020531","非企业或机构用户不能查看员工申请"),
    IS_ENTERPRISE_OR_ORGANIZATION_USER_NOT_LOOK_1("5020532","非企业或机构用户不能查看需求管理"),
    ;

    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    UserCenterExceptionEnum(String code, String message) {
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
