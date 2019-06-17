package com.jn.enterprise.propaganda.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 审批状态枚举 审批状态 (-1：未付款  0：未审批  1：审批中   2：审批通过/已发布   3：审批不通过)
 * @Author: yangph
 * @Date: 2019/4/22 9:30
 * @Version v1.0
 * @modified By:
 */
public enum ApprovalStatusEnum implements CodeAndMsg {
    UNPAID("unpaid","-1","未付款"),
    NOT_APPROVED("notApproved","0","未审批"),
    APPROVAL("approval","1","审批中"),
    APPROVED("approved","2","审批通过"),
    APPROVAL_NOT_PASSED("approvalNotPassed","3","审批不通过"),
    LIFTED("lifted","4","已解除"),
    REFUSED("refused","-1","已拒绝"),
    NETWORK_ANOMALY("network_anomaly","-1","网络异常，请稍后重试。"),
    ;

    ApprovalStatusEnum(String code, String value, String message) {
        this.code = code;
        this.value = value;
        this.message = message;
    }

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


    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
