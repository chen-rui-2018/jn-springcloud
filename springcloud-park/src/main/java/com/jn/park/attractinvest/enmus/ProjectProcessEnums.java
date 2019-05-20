package com.jn.park.attractinvest.enmus;

import com.jn.common.api.CodeAndMsg;

/**
 * 项目管理拟制合同状态枚举
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum ProjectProcessEnums implements CodeAndMsg {
    PROJECT_INFO("1", "项目简介"),
    TALKING("2", "项目洽谈"),
    COMPACT("3", "拟制合同"),
    ;

    private String code;

    private String message;

    ProjectProcessEnums(String key, String message) {
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
