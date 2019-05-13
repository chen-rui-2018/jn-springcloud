package com.jn.news.app.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @author： chenr
 * @date： Created on 2019/4/29 17:01
 * @version： v1.0
 * @modified By:
 */
public enum JPushEnum implements CodeAndMsg  {
    J_PUSH_APP_KEY("appKey","7b20e6375099fe80ff706dca"),
    J_PUSH_MASTER_SECRET("Master_Secret","2a35e0e5980a109b10814468"),
    J_PUSH_MASTER_ANDROID("1","ANDROID"),
    J_PUSH_MASTER_IOS("2","IOS"),
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
