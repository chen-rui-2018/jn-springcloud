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
public enum WorkPlanTemplateEnums implements CodeAndMsg {

    REMIND_TEMPLATE("oaWorkPlanRemindTemplate", "工作计划邮件提醒模板"),
    BATCH_REMIND_TEMPLATE("oaWorkPlanBatchRemindTemplate", "工作计划批量提醒模板")
    ;

    private String code;

    private String message;

    WorkPlanTemplateEnums(String key, String message) {
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
