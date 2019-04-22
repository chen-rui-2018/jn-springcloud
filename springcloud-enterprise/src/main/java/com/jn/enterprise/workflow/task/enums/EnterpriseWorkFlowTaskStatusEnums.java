package com.jn.enterprise.workflow.task.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 事项任务状态枚举
 * @author： yuanyy
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum EnterpriseWorkFlowTaskStatusEnums implements CodeAndMsg {
    TASK_TO_DO("1", "待办事项"),
    TASK_COMPLETED("2", "已办事项");

    private String code;

    private String message;

    EnterpriseWorkFlowTaskStatusEnums(String key, String message) {
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
