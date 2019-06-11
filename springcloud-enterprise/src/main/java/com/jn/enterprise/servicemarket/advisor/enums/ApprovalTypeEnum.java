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
    PENDING("pending","1","待审批"),
    APPROVAL_NOT_PASSED("approvalNotPassed","3","审批不通过"),
    NO_FEEDBACK("noFeedBack","0","未反馈"),
    REJECTED("rejected","-1","已拒绝"),
    APPROVED("approved","2","审批通过"),
    HAS_BEEN_LIFTED("hasBeenLifted","4","已解除"),
    ;

    /**
     * 编码
     */
    private String code;
    /**
     * 状态值
     */
    private String value;
    /**
     * 信息
     */
    private String message;


    ApprovalTypeEnum(String code, String value, String message) {
        this.code = code;
        this.value = value;
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
