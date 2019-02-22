package com.jn.enterprise.servicemarket.advisor.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 审批状态
 * @Author: yangph
 * @Date: 2019/2/22 14:59
 * @Version v1.0
 * @modified By:
 */
public enum ApprovalTypeEnum implements CodeAndMsg {
    PENDING("pending","待审批"),
    APPROVAL_NOT_PASSED("approvalNotPassed","审批不通过"),
    NO_FEEDBACK("noFeedBack","未反馈"),
    REJECTED("rejected","已拒绝"),
    ;

    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    ApprovalTypeEnum(String code, String message) {
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
