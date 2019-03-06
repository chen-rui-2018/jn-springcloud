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
    FOUND_TIME_IS_ERROR("3020511","公司注册时间格式错误[yyyy-MM-dd]"),
    RUN_TIME_IS_ERROR("3020511","公司落地时间格式错误[yyyy-MM-dd]"),
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
