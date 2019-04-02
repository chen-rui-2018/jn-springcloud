package com.jn.oa.item.enmus;

import com.jn.common.api.CodeAndMsg;

/**
 * @author： shaobao
 * @date： Created on 2019/3/5 11:33
 * @version： v1.0
 * @modified By:
 **/
public enum WorkPlanOperateEnmus implements CodeAndMsg {
    CREATE("0", "创建"),
    START("1", "启动"),
    PAUSED("2","暂停"),
    FINISH("3", "完成"),
    CANCELLED("4", "取消"),
    ADD_REMARK("5", "添加备注"),
    RESTART("6","继续"),
    UPDATE("7","编辑"),
    ADD_RECORD("8","记录工时"),
    UPDATE_RECODE("9","编辑工作记录"),
    DELETE_RECODE("9","删除工作记录"),
    ;

    private String code;

    private String message;

    WorkPlanOperateEnmus(String key, String message) {
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
