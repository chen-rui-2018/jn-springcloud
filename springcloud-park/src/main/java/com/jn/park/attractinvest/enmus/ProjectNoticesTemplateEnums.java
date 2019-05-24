package com.jn.park.attractinvest.enmus;

import com.jn.common.api.CodeAndMsg;

/**
 * 状态枚举
 * @author： yuanyy
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum ProjectNoticesTemplateEnums implements CodeAndMsg {

    MESSAGE_TEMPLATE("1006", "项目管理拟制合同状态异常短信提醒模板");


    private String code;

    private String message;

    ProjectNoticesTemplateEnums(String key, String message) {
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
