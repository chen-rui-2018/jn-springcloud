package com.jn.enterprise.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @author： jiangyl
 * @date： Created on 2019/2/15 11:38
 * @version： v1.0
 * @modified By:
 */
public enum JoinParkExceptionEnum implements CodeAndMsg {
    MESSAGE_CODE_IS_WRONG("3020510","短信验证码错误"),
    COMPANY_IS_EXIST("3020511","企业已存在，不能再次认证。"),
    FOUND_TIME_IS_ERROR("3020512","公司注册时间格式错误[yyyy-MM-dd]"),
    RUN_TIME_IS_ERROR("3020513","公司落地时间格式错误[yyyy-MM-dd]"),
    USER_IS_COMPANY_EXIST("3020514","您已是员工账号，不能再次申请"),
    UPGRADE_SUBMIT_IBPS_ERROR("3020515","升级企业提交审核出错，请检查提交数据"),
    USER_UPGRADE_COMPANY_READY("3020516","该账号已升级企业，请勿升级员工"),
    USER_UPGRADE_STAFF_READY("3020517","该账号已升级员工，请勿升级企业"),
    COMPANY_NOT_EXIST("3020518","企业信息不存在"),
    ;

    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    JoinParkExceptionEnum(String code, String message) {
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
