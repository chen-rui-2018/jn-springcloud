package com.jn.park.asset.enums;

import com.jn.common.api.CodeAndMsg;

/**
* 房间状态(0空闲,1租借申请中,2租借中,3退租申请中,4已到期)
* @author： zhuyz
* @date： Created on 2019/5/8 9:35
* @version： v1.0
* @modified By:
*/
public enum RoomLeaseStatusEnums implements CodeAndMsg {

    UNUSED("unused","0","空闲"),
    APPLY("apply","1","租借申请中"),
    DELIVERY("delivery","2","租借中"),
    QUIT("quit","3","退租申请中"),
    DEADLINE("deadline","4","已到期");

    /**
     * 编码
     */
    private String code;

    /**
     * 状态值
     */
    private String value;
    /**
     * 信息
     */
    private String message;

    RoomLeaseStatusEnums(String code, String value, String message) {
        this.code = code;
        this.value = value;
        this.message = message;
    }


    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
