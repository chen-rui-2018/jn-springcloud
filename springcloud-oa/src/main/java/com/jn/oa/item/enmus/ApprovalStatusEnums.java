package com.jn.oa.item.enmus;

import com.jn.common.api.CodeAndMsg;

/**
 * 工作计划状态枚举
 *
 * @author： shaobao
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum ApprovalStatusEnums implements CodeAndMsg {

    NO_APPROVAL("0", "未审批"),
    APPROVALING("1", "审批中"),
    APPROVALED("2", "审批通过"),
    NOT_PASS("3", "审批不通过"),
    ;

    private String code;

    private String message;

    ApprovalStatusEnums(String key, String message) {
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
