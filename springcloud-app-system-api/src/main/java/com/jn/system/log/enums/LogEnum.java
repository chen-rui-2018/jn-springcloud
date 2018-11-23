package com.jn.system.log.enums;


import com.jn.common.api.CodeAndMsg;

/**
 * 日志操作
 *
 * @author： fengxh
 * @date： Created on 2018/9/20 16:21
 * @version： v1.0
 * @modified By:
 */
public enum LogEnum  {

    SELECT("查询"),
    INSERT("插入"),
    DELETE("删除"),
    UPDATE("更新"),
    BUSINESS("业务");

    private String name;

    public String getName() {
        return name;
    }

    LogEnum(String name) {
        this.name = name;
    }
}
