package com.jn.news.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @author： huxw
 * @date： Created on 2019-5-17 15:26:36
 * @version： v1.0
 * @modified By:
 */
public enum JPushExceptionEnum implements CodeAndMsg  {

    JPUSH_NOTNULL_TITLE("1399501","消息标题不能为空"),
    JPUSH_NOTNULL_CONTENT("1399502","消息内容不能为空"),
    JPUSH_NOTNULL_PUSH_TYPE("1399503","消息推送方式传参错误或传参为空"),
    JPUSH_NOTNULL_NOTICE_TYPE("1399504","消息推送通知传参错误或传参为空"),
    JPUSH_SWITCH_NOTNULL_IDS("1399505","APP消息推送关闭状态,配置中心springcloud-news文件jn.news.switch.ids参数不能为空."),
    JPUSH_PLATFROMTYPE_NOT_EXIST("1399506","APP平台类型传参只支持空、IOS、ANDROID，其它为非法参数.")
    ;
    private String code;
    private String message;

    JPushExceptionEnum(String code, String message){
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
