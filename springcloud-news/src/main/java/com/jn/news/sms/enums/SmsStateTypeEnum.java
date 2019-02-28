package com.jn.news.sms.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 定义短信错误类型
 *
 * @Author： cm
 * @Date： Created on 2019/2/26 14:55
 * @Version： v1.0
 * @Modified By:
 */
public enum SmsStateTypeEnum implements CodeAndMsg {

    SMS_SEND_SUCCESS("0","提交成功"),
    SMS_SEND_ACCOUNT_ERROR("1","帐号信息错误，请核对"),
    SMS_SEND_IP_ERROR("2","IP地址错误"),
    SMS_SEND_PARAMETER_ERROR("3","参数请不带空数据，比如内容，号码等")
    ;

    private String code;

    private String message;

    SmsStateTypeEnum(String key, String message) {
        this.code = key;
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
