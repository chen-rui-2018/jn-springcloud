package com.jn.oa.common.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 状态枚举
 * @author： yuanyy
 * @date： Created on 2019/6/25 17:03
 * @version： v1.0
 * @modified By:
 */
public enum OaDingTalkEnums implements CodeAndMsg {
    OFFSET("0", "初始化分页偏移量"),
    SIZE("20", "查询条数"),
    DATE_FORMATTER("yyyy-MM-dd HH:mm:ss","格式化时间"),
    PAGE("1","初始化页码"),
    ROWS("30","总条数"),
    DEFAULT("1","默认部门"),
    PERCENT_DAY("percent_day","请假单位：天"),
    PERCENT_HOUR("percent_hour","请假单位：小时"),
    JOB_STATUS_ON_JOB("1","在职"),
    JOB_STATUS_LEAVE("0","离职")
    ;

    private String code;

    private String message;

    OaDingTalkEnums(String key, String message) {
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
