package com.jn.park.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @author： chenr
 * @date： Created on 2019/5/30 15:50
 * @version： v1.0
 * @modified By:
 */
public enum ActivityEnum implements CodeAndMsg {
    ACTIVITY_IS_APPLY("1","已报名"),
    ACTIVITY_NOT_APPLY("0","未报名"),
    ACTIVITY_ORDER_VIEWS("acti_views","按照查看数排序"),
    ACTIVITY_ORDER_LIKE("acti_like","按照点赞数排序"),
    ACTIVITY_ORDER_APPLY("apply_num","按照报名数排序"),
    ACTIVITY_ORDER_PARTIC("partic_num","活动参加人数"),
    ACTIVITY_ORDER_START_TIME("acti_start_time","按照活动开始时间排序"),

    ACTIVITY_STATUS_END("3","活动结束"),
    ;


    private String code;
    private String message;

    ActivityEnum(String code , String  message ){
        this.code = code;
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
