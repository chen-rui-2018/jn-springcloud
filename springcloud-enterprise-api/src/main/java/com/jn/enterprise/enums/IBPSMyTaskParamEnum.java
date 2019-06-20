package com.jn.enterprise.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 客服中心查询工作流我的待办入参封装处理枚举
 * @Author: yangph
 * @Date: 2019/5/19 17:55
 * @Version v1.0
 * @modified By:
 */
public enum IBPSMyTaskParamEnum implements CodeAndMsg {
    PROC_INST_ID("Q^PROC_INST_ID_^S","流程实例id"),
    TASK_ID("Q^TASK_ID_^S","任务id"),
    PROC_DEF_ID("Q^PROC_DEF_ID_^S","流程id"),
    PROC_DEF_KEY("Q^PROC_DEF_KEY_^S","流程主键key"),
    PROC_DEF_NAME("Q^procDefName^S","流程名称"),
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    IBPSMyTaskParamEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
