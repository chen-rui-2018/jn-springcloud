package com.jn.user.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 积分
 * @Author: jiangyl
 * @Date: 2019/3/26 14:41
 * @Version v1.0
 * @modified By:
 */
public enum UserPointExceptionEnum implements CodeAndMsg {
    NETWORK_ANOMALY("3020901", "网络异常，请稍后重试。"),
    POINT_RULE_IS_NOT_EXIST("3020501","积分规则不存在"),
    USER_POINT_IS_NOT_EXIST("3020502","用户积分不存在"),
    USER_POINT_EXIST_TOO_DATA("3020503","用户积分存在多条数据"),
    POINT_RULE_RULE_CODE_IS_NOT_NULL("3020504","操作标识不能为空"),
    POINT_RULE_RULE_ID_IS_NOT_NULL("3020505","积分规则ID不能为空"),
    POINT_RULE_NO_REMAINING_TIMES("3020506","获取积分次数已达周期最大值，无法再次获取"),
    POINT_RULE_IS_INVALID("3020507","该积分规则已过期，不能获取积分"),
    POINT_RULE_IS_NOT_INCOME("3020508","积分规则不为积分收入规则"),
    USER_POINT_NUM_CHANGE_ERROR("3020509","用户积分余额处理失败"),
    PAY_BILLS_IS_NOT_NULL("3020510","支付账单不能为空"),
    PAY_BILLS_IS_NOT_EXIST("3020511","未查询到有效支付账单"),
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    UserPointExceptionEnum(String code, String message) {
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
