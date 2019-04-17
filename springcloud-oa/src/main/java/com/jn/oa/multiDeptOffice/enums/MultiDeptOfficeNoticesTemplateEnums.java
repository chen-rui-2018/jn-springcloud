package com.jn.oa.multiDeptOffice.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 状态枚举
 * @author： yuanyy
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum MultiDeptOfficeNoticesTemplateEnums implements CodeAndMsg {

    MESSAGE_TEMPLATE("1003", "多部门协同事项提醒模板");


    private String code;

    private String message;

    MultiDeptOfficeNoticesTemplateEnums(String key, String message) {
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
