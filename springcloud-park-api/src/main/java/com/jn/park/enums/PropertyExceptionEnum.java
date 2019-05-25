package com.jn.park.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @author： yuanyy
 * @date： Created on 2019/5/24 11:13
 * @version： v1.0
 * @modified By:
 */
public enum PropertyExceptionEnum implements CodeAndMsg {
    COMPLETE_TASK_NUMBER_IS_NOT_UNIQUE("4021200","待办任务不唯一"),
    NO_TO_DO_TASKS("4021201","没有待办任务"),
    GET_PAY_BILL_DETAIL_FAIL("4021203","查询缴费单失败"),
    BILL_ORDER_IS_NOT_PAY("4021204","该缴费单未支付，不能修改报修单状态")



   ;

    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    PropertyExceptionEnum(String code, String message){
        this.code = code;
        this.message = message;
    }
    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
