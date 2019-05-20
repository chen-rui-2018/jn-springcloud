package com.jn.park.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 客服中心异常枚举
 * @Author: yangph
 * @Date: 2019/5/14 9:39
 * @Version v1.0
 * @modified By:
 */
public enum CustomerCenterExceptionEnum implements CodeAndMsg {
    NETWORK_ANOMALY("4020901", "网络异常，请稍后重试。"),
    QUES_PICTURE_NUM_MORE_THAN_MAX("4020551","问题描述图片不能超过3张"),
    CURRENT_ROLE_NAME_INFO_NOT_EXIST("4020552","当前角色名称信息在系统中不存在"),
    PROCESS_INS_ID_NOT_NULL("5020554","流程实例id不能为空"),
    ACTION_NAME_NOT_SUPPORT("5020555","当前操作名称不是系统所支持的"),
    PICTURE_URL_MORE_THAN_ALLOW("5020556","处理问题时，问题描述最多允许上传3张图片"),
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    CustomerCenterExceptionEnum(String code, String message) {
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
