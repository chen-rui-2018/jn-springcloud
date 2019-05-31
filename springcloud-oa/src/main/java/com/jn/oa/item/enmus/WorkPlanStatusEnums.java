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
public enum WorkPlanStatusEnums implements CodeAndMsg {

    TO_BEGIN("0", "未开始"),
    DOING("1", "进行中"),
    PAUSED("2", "已挂起"),
    COMPLETED("3", "已完成"),
    OVERDUE("4", "已延期"),
    ADD_REMARK("5","添加备注"),
    RESTART("6","继续"),
    ;

    private String code;

    private String message;

    WorkPlanStatusEnums(String key, String message) {
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
