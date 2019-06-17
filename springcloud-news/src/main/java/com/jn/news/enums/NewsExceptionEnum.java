package com.jn.news.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @author： huxw
 * @date： Created on 2019-5-17 15:26:36
 * @version： v1.0
 * @modified By:
 */
public enum NewsExceptionEnum implements CodeAndMsg  {

    JPUSH_ERROR("1300401","极光推送消息异常"),
    WX_SWITCH_NOTNULL_TOUSER("1300402","微信模板消息推送关闭状态下配置中心springcloud-news文件jn.news.switch.touser参数不能为空."),
    ;
    private String code;
    private String message;

    NewsExceptionEnum(String code, String message){
        this.code= code;
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
