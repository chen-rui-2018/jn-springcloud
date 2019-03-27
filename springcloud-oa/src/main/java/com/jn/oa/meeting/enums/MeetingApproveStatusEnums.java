package com.jn.oa.meeting.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 状态枚举
 * @author： yuanyy
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum MeetingApproveStatusEnums implements CodeAndMsg {
    //审批状态（0:已取消、1:审批中、2:审批通过、3:审批不通过、4:已作废）
    CANCELLED("0", "已取消"),
    APPROVAL("1", "审批中"),
    APPROVAL_PASS("2", "审批通过"),
    APPROVAL_NOT_PASS("3", "审批不通过"),
    INVALID("4","已作废");

    private String code;

    private String message;

    MeetingApproveStatusEnums(String key, String message) {
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
