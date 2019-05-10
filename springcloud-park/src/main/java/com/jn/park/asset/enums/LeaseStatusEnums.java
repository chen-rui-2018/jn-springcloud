package com.jn.park.asset.enums;

import com.jn.common.api.CodeAndMsg;
/**
* 租借状态枚举(0标记为空闲,1申请中,2交付中,3租借中,4归还中,5已归还)
* @author： zhuyz
* @date： Created on 2019/4/29 20:57
* @version： v1.0
* @modified By:
*/
public enum LeaseStatusEnums implements CodeAndMsg {

    UNUSED("unused","0","空闲"),
    APPLY("apply","1","申请中"),
    DELIVERY("delivery","2","交付中"),
    LEASE("lease","3","租借中"),
    RETURN_ING("returnIng","4","归还中"),
    RETURN("return","5","已归还");


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

    LeaseStatusEnums(String code, String value, String message) {
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
