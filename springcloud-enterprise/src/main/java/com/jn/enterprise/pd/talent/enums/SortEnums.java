package com.jn.enterprise.pd.talent.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 排序枚举
 * @author： wzy
 * @date： Created on 2019/4/10 17:50
 * @version： v1.0
 * @modified By:
 */
public enum SortEnums implements CodeAndMsg {
    RELEASETIME_SORT("1", "发布时间排序"),
    TIMENODE_SORT("2", "时间节点排序"),
    HEAT_SORT("3","热度排序");

    private String code;

    private String message;

    SortEnums(String key, String message) {
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
