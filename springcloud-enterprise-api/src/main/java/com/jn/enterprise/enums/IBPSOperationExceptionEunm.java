package com.jn.enterprise.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @Author: yangph
 * @Date: 2019/5/13 23:23
 * @Version v1.0
 * @modified By:
 */
public enum IBPSOperationExceptionEunm implements CodeAndMsg {
    NETWORK_ANOMALY("5020901", "网络异常，请稍后重试。"),
    COMPLETE_PARAM_NOT_NULL("5020551","IBPS处理任务入参不能为空"),
    MY_TASKS_PARAM_NOT_NULL("5020552","IBPS我的待办事项入参不能为空"),
    MY_HANDLED_PARAM_NOT_NULL("5020552","IBPS我的已办事项入参不能为空"),
    OPINIONS_PARAM_NOT_ALL_NULL("5020553","IBPS获取审批历史的流程实例ID和任务id不能都为空，至少一个要有值"),
    PROCESS_INS_ID_NOT_NULL("5020554","流程实例id不能为空"),
    UPLOAD_FILE_URL_IS_NULL("5020555","文件路径不能为空"),
    UPLOAD_FILE_FORMAT_ERROR("5020556","文件路径格式错误"),
    UPLOAD_FILE_NOT_EXIST("5020557","文件不存在"),
    UPLOAD_FILE_ERROR("5020558","上传文件失败"),
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    IBPSOperationExceptionEunm(String code, String message) {
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
