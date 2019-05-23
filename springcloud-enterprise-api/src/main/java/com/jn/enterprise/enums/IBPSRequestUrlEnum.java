package com.jn.enterprise.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @Author: yangph
 * @Date: 2019/5/13 22:10
 * @Version v1.0
 * @modified By:
 */
public enum IBPSRequestUrlEnum  implements CodeAndMsg {
    START_WORK_FLOW("/api/webapi/bpmService/start","启动流程"),
    MY_TASKS("/api/webapi/bpmService/myTasks","我的待办事项"),
    MY_HANDLED("/api/webapi/bpmService/myHandled","我的已办事项"),
    COMPLETE("/api/webapi/bpmService/complete","处理任务"),
    GET_FORM_DATA("/api/webapi/bpmService/getFormData","任务详情页"),
    OPINIONS("/api/webapi/bpmService/opinions","获取审批历史"),
    GET_INST_FORM("/api/webapi/bpmService/getInstForm","获取流程表单"),
    UPLOAD_FILE("/api/webapi/uploadService/saveFileAttachment","上传文件"),
    ;
    /**
     * 编码
     */
    private String code;
    /**
     *
     */
    private String requestUrl;
    /**
     * 信息
     */
    private String message;

    IBPSRequestUrlEnum(String requestUrl, String message) {
        this.requestUrl = requestUrl;
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

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
}
