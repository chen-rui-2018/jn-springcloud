package com.jn.news.app.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @author： chenr
 * @date： Created on 2019/4/29 17:01
 * @version： v1.0
 * @modified By:
 */
public enum JPushEnum implements CodeAndMsg  {
    
    J_PUSH_MASTER_ANDROID("ANDROID","安卓"),
    J_PUSH_MASTER_IOS("IOS","IOS"),

    J_PUSH_TYPE_DEVICE("DEVICE","设备"),
    J_PUSH_TYPE_TAG("TAG","标签"),

    J_PUSH_NOTICE_TYPE_ALL("ALL","全部"),
    J_PUSH_NOTICE_TYPE_NOTICE("NOTICE","通知"),
    J_PUSH_NOTICE_TYPE_MESSAGE("MESSAGE","透传消息"),
    ;
    private String code;
    private String message;

    JPushEnum(String code,String message){
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
